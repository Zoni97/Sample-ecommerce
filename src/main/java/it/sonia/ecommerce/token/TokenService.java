package it.sonia.ecommerce.token;

import it.sonia.ecommerce.model.User;
import it.sonia.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {

    @Autowired
    TokenRepository repository;

    @Autowired
    UserRepository userRepository;

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public void deleteByUserId(Integer id){
        repository.deleteByUserId(id);
    }

    public List<Token> findByUserId(Integer id){
        return repository.findByUserId(id);
    }
}
