package com.vich.chatitc.hoax;

import com.vich.chatitc.user.User;
import com.vich.chatitc.user.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.Date;
import java.util.List;

@Service
public class HoaxService {

    HoaxRepository hoaxRepository;
    UserService userService;

    public HoaxService(HoaxRepository hoaxRepository, UserService userService){
        super();
        this.hoaxRepository = hoaxRepository;
        this.userService = userService;
    }

    public Hoax save(User user, Hoax hoax){
        hoax.setTimestamp(new Date());
        hoax.setCurrentUser(user);
        return hoaxRepository.save(hoax);
    }

    public Page<Hoax> getAllHoaxes(Pageable pageable) {
        return hoaxRepository.findAll(pageable);
    }

    public Page<Hoax> getHoaxesOfUser(String username, Pageable pageable) {
        User inDB = userService.getByUsername(username);
        return hoaxRepository.findByCurrentUser(inDB, pageable);
    }

    public Page<Hoax> getOldHoaxes(long id, String username, Pageable pageable) {
        Specification<Hoax> spec = Specification.where(idLessThan(id));
        if(username != null){
            User inDB = userService.getByUsername(username);
            spec = spec.and(userIs(inDB));
        }
        return hoaxRepository.findAll(spec, pageable);
    }

    public List<Hoax> getNewHoaxes(long id, String username, Pageable pageable) {
        Specification<Hoax> spec = Specification.where(idGreaterThan(id));
        if(username != null){
            User inDB = userService.getByUsername(username);
            spec = spec.and(userIs(inDB));
        }
        return hoaxRepository.findAll(spec, pageable.getSort());
    }

    public long getNewHoaxCount(long id, String username) {
        Specification<Hoax> spec = Specification.where(idGreaterThan(id));
        if(username != null){
            User inDB = userService.getByUsername(username);
            spec = spec.and(userIs(inDB));
        }
        return hoaxRepository.count(spec);
    }

    private Specification<Hoax> userIs(User user){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("currentUser"), user);
        };
    }
    private Specification<Hoax> idLessThan(long id){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.lessThan(root.get("id"), id);
        };
    }
    private Specification<Hoax> idGreaterThan(long id){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.greaterThan(root.get("id"), id);
        };
    }
}
