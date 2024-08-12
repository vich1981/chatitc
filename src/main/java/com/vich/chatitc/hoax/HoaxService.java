package com.vich.chatitc.hoax;

import com.vich.chatitc.user.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HoaxService {

    HoaxRepository hoaxRepository;

    public HoaxService(HoaxRepository hoaxRepository){
        super();
        this.hoaxRepository = hoaxRepository;
    }

    public void save(User user, Hoax hoax){
        hoax.setTimestamp(new Date());
        hoax.setCurrent(user);
        hoaxRepository.save(hoax);
    }

}
