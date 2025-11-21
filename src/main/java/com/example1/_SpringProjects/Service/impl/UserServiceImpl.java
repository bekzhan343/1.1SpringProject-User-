package com.example1._SpringProjects.Service.impl;

import com.example1._SpringProjects.Entity.User;
import com.example1._SpringProjects.Exception.NotFoundException;
import com.example1._SpringProjects.Repository.UserRepository;
import com.example1._SpringProjects.Response.IamResponse;
import com.example1._SpringProjects.Service.UserService;
import com.example1._SpringProjects.constants.ApiErrorMessage;
import com.example1._SpringProjects.dto.user.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public IamResponse<UserDTO> getByID(@NotNull Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.USER_INFO_NOT_FOUND.getErrorMessage(userId)));

        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .build();

        return IamResponse.createSuccessfully(userDTO);
    }
}
