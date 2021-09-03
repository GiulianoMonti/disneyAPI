package challenge.disney.security.service;

import challenge.disney.security.Role;
import challenge.disney.security.User;
import challenge.disney.security.repositories.RoleRepository;
import challenge.disney.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


//di
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("saving user{} db",user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role{} db",role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding role{} to user{}",roleName,username);

        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        // take user get rules of user and add this role in addition to everything that user has
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {

        log.info("Fetching user{}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");

        return userRepository.findAll();
    }
}
