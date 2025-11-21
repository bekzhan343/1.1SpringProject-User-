package com.example1._SpringProjects.Controller;

import com.example1._SpringProjects.Repository.UserRepository;
import com.example1._SpringProjects.Response.IamResponse;
import com.example1._SpringProjects.Service.UserService;
import com.example1._SpringProjects.constants.ApiLogMessages;
import com.example1._SpringProjects.dto.user.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("${end.point.users}")
public class UserController {

    private final UserService userService;

    @GetMapping("${end.point.id}")
    public ResponseEntity<IamResponse<UserDTO>> getUserById(
            @PathVariable(name = "id") Integer userId) {

        log.info(ApiLogMessages.USER_INFO_BY_ID.getMessage(userId));

        IamResponse<UserDTO> response = userService.getByID(userId);

        return ResponseEntity.ok(response);
    }
}
