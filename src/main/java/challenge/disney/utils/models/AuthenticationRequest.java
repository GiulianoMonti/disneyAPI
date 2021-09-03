package challenge.disney.utils.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class AuthenticationRequest {
    // step 1


    public AuthenticationRequest() {
    }

    private String username;
    private String password;

}
