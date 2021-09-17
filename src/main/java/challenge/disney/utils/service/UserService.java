package challenge.disney.utils.service;

import challenge.disney.utils.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);
    UserDto getUser(String email);

}
