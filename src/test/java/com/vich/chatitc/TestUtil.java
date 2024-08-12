package com.vich.chatitc;

import com.vich.chatitc.hoax.Hoax;
import com.vich.chatitc.user.User;
import com.vich.chatitc.user.vm.UserUpdateVM;

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
    public static UserUpdateVM createValidUserUpdateVM() {
        UserUpdateVM updatedUser = new UserUpdateVM();
        updatedUser.setDisplayName("newDisplayName");
        return updatedUser;
    }
    public static Hoax createValidHoax(){
        Hoax hoax = new Hoax();
        hoax.setContent("test content for the test hoax");
        return hoax;
    }
}
