package it.sonia.ecommerce;

import it.sonia.ecommerce.auth.AuthenticationResponse;
import it.sonia.ecommerce.auth.AuthenticationService;
import it.sonia.ecommerce.config.JwtService;
import it.sonia.ecommerce.model.Role;
import it.sonia.ecommerce.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthenticationTest {

    @Autowired
    AuthenticationService service;

    @Autowired
    JwtService jwtService;

    @Test
    public void testRegister() {
        var user = ObjectTest.createUser();
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
        Assertions.assertEquals(response, service.register(ObjectTest.createTestRegisterRequest()));
    }

    @Test
    public void testAuthentication(){
        var user = ObjectTest.createUser();
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
        Assertions.assertEquals(response, service.authenticate(ObjectTest.createAuthReq()));
    }
}
