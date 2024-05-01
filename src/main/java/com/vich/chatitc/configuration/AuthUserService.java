package com.vich.chatitc.configuration;

import com.vich.chatitc.user.User;
import com.vich.chatitc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AuthUserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        User user = userRepository.findByUserName(userName);
        user.getAuthorities();
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
