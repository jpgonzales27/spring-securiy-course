package com.cursos.api.spring_security_course.service.impl;

import com.cursos.api.spring_security_course.dto.SaveUser;
import com.cursos.api.spring_security_course.exception.InvalidPasswordException;
import com.cursos.api.spring_security_course.persistence.entity.User;
import com.cursos.api.spring_security_course.persistence.repository.UserRepository;
import com.cursos.api.spring_security_course.persistence.util.Role;
import com.cursos.api.spring_security_course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerOneCustomer(SaveUser newUser) {
        validatePassword(newUser);

        User user = new User();
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());
        user.setRole(Role.ROLE_CUSTOMER);

        return userRepository.save(user);
    }


    private void validatePassword(SaveUser dto) {

        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

        if(!dto.getPassword().equals(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

    }
}