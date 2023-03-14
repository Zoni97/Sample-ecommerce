package it.sonia.ecommerce.service;

import it.sonia.ecommerce.model.User;
import it.sonia.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public void deleteByEmail(String mail){
        repository.delete(repository.findUserByEmail(mail));
    }

    public User findUserByEmail(String email){
        return repository.findUserByEmail(email);
    }
}
