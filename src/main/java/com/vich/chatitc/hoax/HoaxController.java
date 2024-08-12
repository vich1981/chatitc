package com.vich.chatitc.hoax;

import com.vich.chatitc.shared.CurrentUser;
import com.vich.chatitc.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0")
public class HoaxController {

    @Autowired
    HoaxService hoaxService;

    @PostMapping("/hoaxes")
    void createHoax(@Valid @RequestBody Hoax hoax, @CurrentUser User user) {
        hoaxService.save(user, hoax);
    }
}
