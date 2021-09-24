package challenge.disney.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 6835192601898364280L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String userId;
    private String firstName;
    @Column(nullable=false, length = 50)
    private String lastName;
    @Column(nullable=false, length = 120)
    private String email;
    @Column(nullable=false)
    private String encryptedPassword;
    private String emailVerificationToken;
    @Column(nullable = false)
    private Boolean emailVerificationStatus = false;
//    @OneToMany(mappedBy="userDetails",cascade=CascadeType.ALL)
//    private List<AddressEntity>addresses;



}
