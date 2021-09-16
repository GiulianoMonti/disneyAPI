package challenge.disney.utils.service;

import challenge.disney.utils.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.mail.MessagingException;


public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user) throws MessagingException;
    UserDto getUser(String email);



}
