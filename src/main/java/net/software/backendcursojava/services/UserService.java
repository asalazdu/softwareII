package net.software.backendcursojava.services;

import org.springframework.stereotype.Service;

import net.software.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService implements UserServiceinterface{

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // TODO logica de la creacion del usuario 
        return null;
    }

    
}
