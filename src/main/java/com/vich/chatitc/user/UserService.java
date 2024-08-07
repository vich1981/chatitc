package com.vich.chatitc.user;

import com.vich.chatitc.error.NotFoundException;
import com.vich.chatitc.file.FileService;
import com.vich.chatitc.user.vm.UserUpdateVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    FileService fileService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, FileService fileService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.fileService = fileService;
    }

    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
//    public Page<User> getUsers() {
//        Pageable pageable = PageRequest.of(0, 10);
//        return userRepository.findAll(pageable);//getAllUsersProjection(pageable);
//    }
    public Page<User> getUsers(User loggedInUser, Pageable pageable){
        if(loggedInUser != null){
            return userRepository.findByUsernameNot(loggedInUser.getUsername(), pageable);
        }
        return userRepository.findAll(pageable);
    }

    public User getByUsername(String username) {
        User inDB = userRepository.findByUsername(username);
        if(inDB == null) {
            throw new NotFoundException(username + " not found");
        }
        return inDB;
    }

    public User update(long id, UserUpdateVM userUpdate){
        User inDB = userRepository.getReferenceById(id);
        inDB.setDisplayName(userUpdate.getDisplayName());
        if(userUpdate.getImage() != null){
            String savedImageName;
            try {
                savedImageName = fileService.saveProfileImage(userUpdate.getImage());
                fileService.deleteProfileImage(inDB.getImage());
                inDB.setImage(savedImageName);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return userRepository.save(inDB);
    }
}
