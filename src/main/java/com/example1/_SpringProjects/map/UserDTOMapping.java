package com.example1._SpringProjects.map;

import com.example1._SpringProjects.Entity.User;
import com.example1._SpringProjects.dto.user.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapping {

    public UserDTO toDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
