package challenge.disney.utils.controller;

import challenge.disney.utils.model.request.UserDetailsRequestModel;
import challenge.disney.utils.model.response.UserRest;
import challenge.disney.utils.service.UserService;
import challenge.disney.utils.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserRest createUser(@RequestBody UserDetailsRequestModel requestUserDetails) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(requestUserDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }


    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }

}
