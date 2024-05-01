package com.vich.chatitc;

import com.vich.chatitc.user.User;

public class TestUtil {
    public static User createValidUser(){
        User user = new User();
        //user.setId(1);
        user.setUserName("test-user");
        user.setDisplayName("test-display");
        user.setPassword("P4ssword");
        user.setImage("profile-image.png");
        //user.getAuthorities();
        return user;
    }
}
