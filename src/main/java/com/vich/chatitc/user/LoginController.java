package com.vich.chatitc.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.vich.chatitc.error.ApiError;
import com.vich.chatitc.shared.CurrentUser;
import com.vich.chatitc.user.vm.UserVM;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("/api/1.0/login")
    //@JsonView(Views.Base.class)
    UserVM handleLogin(@CurrentUser User loggedInUser){
        //User loggedInUser = (User)authentication.getPrincipal();// альтернатива .SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Map<String, Object> userMap = new HashMap<>();
//        userMap.put("id", loggedInUser.getId());
//        userMap.put("image", loggedInUser.getImage());
//        userMap.put("displayName", loggedInUser.getDisplayName());
        return new UserVM(loggedInUser);
    }
//Не работает так как Spring Security обрабатывает ошибки внутри себя
//    @ExceptionHandler({AccessDeniedException.class})
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    ApiError handleAccessDeniedException(){
//        return new ApiError(401, "Access error", "/api/1.0/login");
//    }

}
