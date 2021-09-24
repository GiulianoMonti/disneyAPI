package challenge.disney.utils.service.impl;

import challenge.disney.services.impl.UserServiceImpl;
import challenge.disney.entity.UserEntity;
import challenge.disney.repositories.UserRepository;
import challenge.disney.entity.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("giulian");
        userEntity.setUserId("hhty57ehfy");
        userEntity.setEncryptedPassword("74hghd8474jf");

        when(userRepository.findByEmail(anyString())).thenReturn(userEntity);

        UserDto userDto = userService.getUser("test@test");

        assertEquals("giulian",userEntity.getFirstName());

    }
}