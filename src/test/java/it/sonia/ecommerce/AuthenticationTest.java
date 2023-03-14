package it.sonia.ecommerce;

import it.sonia.ecommerce.auth.AuthenticationResponse;
import it.sonia.ecommerce.auth.AuthenticationService;
import it.sonia.ecommerce.config.JwtService;
import it.sonia.ecommerce.model.User;
import it.sonia.ecommerce.service.UserService;
import it.sonia.ecommerce.token.Token;
import it.sonia.ecommerce.token.TokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AuthenticationTest {

    @Autowired
    AuthenticationService service;

    @Autowired
    JwtService jwtService;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Test
    public void testRegister() {
        User userU = userService.findUserByEmail("test@test.it");
        List<Token> tokens = tokenService.findByUserId(userU.getId());
        for(Token t: tokens){
            tokenService.delete(t.getId());
        }
        userService.deleteByEmail("test@test.it");
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
