package challenge.disney.utils.user;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/register")


public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Users> addUsers(@RequestBody final Users users) {
        Users user = userService.addUsers(users);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
