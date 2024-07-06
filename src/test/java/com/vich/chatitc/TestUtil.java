package com.vich.chatitc;

import com.vich.chatitc.user.User;

public class TestUtil {
    public static User createValidUser(){
        User user = new User();
        //user.setId(1);
        user.setUsername("test-user");
        user.setDisplayName("test-display");
        user.setPassword("P4ssword");
        user.setImage("profile-image.png");
        //user.getAuthorities();
        return user;
    }
    public static User createValidUser(String username){
        User user = createValidUser();
        user.setUsername(username);
        return user;
    }
}
