package challenge.disney.utils.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;


    public Users addUsers(Users users){
        return  repo.save(users);
    }



}