package com.maks.durov.spring.intro.controllers;

import com.maks.durov.spring.intro.dto.UserResponseDto;
import com.maks.durov.spring.intro.model.User;
import com.maks.durov.spring.intro.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/inject")
    public ModelAndView injectUsers() {
        User userMarge = new User();
        userMarge.setName("Marge");
        userMarge.setEmail("marge@fakemail.com");
        userService.add(userMarge);
        User userBart = new User();
        userBart.setName("Bart");
        userBart.setEmail("bart@fakemail.com");
        userService.add(userBart);
        User userLisa = new User();
        userLisa.setName("Lisa");
        userLisa.setEmail("lisa@fakemail.com");
        userService.add(userLisa);
        User userHomer = new User();
        userHomer.setName("Homer");
        userHomer.setEmail("homer@fakemail.com");
        userService.add(userHomer);
        return new ModelAndView("redirect:/user/");
    }

    @GetMapping(value = "/")
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        userService.listUsers().forEach(user -> {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setName(user.getName());
            userResponseDtoList.add(userResponseDto);
        });
        return userResponseDtoList;
    }

    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET)
    public UserResponseDto getUser(@PathVariable Long userId) {
        User user = userService.getById(userId);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getName());
        return userResponseDto;
    }
}
