package challenge.disney.utils.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
}
