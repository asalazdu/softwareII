package net.software.backendcursojava.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.software.backendcursojava.UserRepository;
import net.software.backendcursojava.entities.UserEntity;
import net.software.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        if(userRepository.findUserByEmail(userDTO.getEmail()) != null)
            throw new RuntimeException("usuario y axiste");
        
        
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString());
       

        UserEntity storedUserDetail = userRepository.save(userEntity);

        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserDetail, userToReturn);
        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    
}
