package com.vich.chatitc.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findByUserNameContaining(String userName);
//    User findByUserNameAndDisplayName(String userName, String displayName);
    User findByUsername(String username);

    Page<User> findByUsernameNot(String username, Pageable page);

//    @Query(value="Select u from User u")
//    Page<UserProjection> getAllUsersProjection(Pageable pageable);
}
