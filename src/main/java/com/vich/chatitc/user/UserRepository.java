package com.vich.chatitc.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findByUserNameContaining(String userName);
//    User findByUserNameAndDisplayName(String userName, String displayName);
    User findByUserName(String userName);
}
