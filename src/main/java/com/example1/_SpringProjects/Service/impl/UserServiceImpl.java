package com.example1._SpringProjects.Service.impl;

import com.example1._SpringProjects.Entity.User;
import com.example1._SpringProjects.Exception.NotFoundException;
import com.example1._SpringProjects.Repository.UserRepository;
import com.example1._SpringProjects.Response.IamResponse;
import com.example1._SpringProjects.Service.UserService;
import com.example1._SpringProjects.constants.ApiErrorMessage;
import com.example1._SpringProjects.dto.user.UserDTO;
import com.example1._SpringProjects.map.UserDTOMapping;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDTOMapping mapping;

    @Override
    public IamResponse<UserDTO> getByID(@NotNull Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.USER_INFO_NOT_FOUND.getErrorMessage(userId)));

        UserDTO userDTO = mapping.toDTO(user);

        return IamResponse.createSuccessfully(userDTO);
    }


    public IamResponse<UserDTO> createUser(UserDTO userDTO){
        User user = new User(userDTO.getId(),userDTO.getName(),userDTO.getPhoneNumber());

        userRepository.save(user);

        return IamResponse.createSuccessfully(userDTO);
    }


}
