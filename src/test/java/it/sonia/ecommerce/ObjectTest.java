package it.sonia.ecommerce;

import it.sonia.ecommerce.auth.AuthenticationRequest;
import it.sonia.ecommerce.auth.RegisterRequest;
import it.sonia.ecommerce.model.Role;
import it.sonia.ecommerce.model.User;
import it.sonia.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class ObjectTest {

    @Autowired
    static
    UserService service;

    public static void deleteUserTest(User user){
        service.delete(user.getId());
    }


    public static RegisterRequest createTestRegisterRequest(){
        return new RegisterRequest(
                "test_name",
                "test_surname",
                "test@test.it",
                "test_password");
    }

    public static AuthenticationRequest createAuthReq(){
        return new AuthenticationRequest(
                "test@test.it",
                "test_password");
    }

    public static User createUser(){
        return User.builder()
                .role(Role.USER)
                .email("test@test.it")
                .firstname("teste_name")
                .lastname("test_surname")
                .password("test_password")
                .build();
    }

    public static User createAdmin(){
        return User.builder()
                .role(Role.ADMIN)
                .email("test@test.it")
                .firstname("teste_name")
                .lastname("test_surname")
                .password("test_password")
                .build();
    }
}
