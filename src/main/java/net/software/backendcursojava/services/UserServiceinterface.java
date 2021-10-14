package net.software.backendcursojava.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.software.backendcursojava.shared.dto.UserDTO;

public interface UserServiceInterface extends UserDetailsService{

  public UserDTO createUser(UserDTO userDTO);
    
}
