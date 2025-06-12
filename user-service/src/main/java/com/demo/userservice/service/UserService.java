package com.demo.userservice.service;

import com.demo.userservice.entity.User;
import com.demo.userservice.repository.UserRepository;
import com.demo.userservice.request.CreateUserRequest;
import com.demo.userservice.response.CreatedUserResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //create user
    @Transactional
    public CreatedUserResponse createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setFirstName(createUserRequest.firstName());
        user.setLastName(createUserRequest.lastName());
        user.setEmail(createUserRequest.email());
        user.setPassword(bCryptPasswordEncoder.encode(createUserRequest.password()));

        User savedUser = userRepository.save(user);

        return new CreatedUserResponse(savedUser.getFirstName(), savedUser.getLastName(), savedUser.getEmail());
    }

}