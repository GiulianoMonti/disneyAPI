package challenge.disney.security.api;

import challenge.disney.security.User;
import challenge.disney.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor //inject
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        
        //ok
        return ResponseEntity.ok().body(userService.getUsers());
    }

}
