package org.amochamo.fluqmusicmarket.services.roles;

import org.amochamo.fluqmusicmarket.repositories.roles.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
