package com.example1._SpringProjects.Controller;


import com.example1._SpringProjects.Response.IamResponse;
import com.example1._SpringProjects.Service.impl.UserServiceImpl;
import com.example1._SpringProjects.constants.ApiLogMessages;
import com.example1._SpringProjects.dto.user.UserDTO;
import com.example1._SpringProjects.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("${end.point.users}")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("${end.point.id}")
    public ResponseEntity<IamResponse<UserDTO>> getUserById(
            @PathVariable(name = "id") Integer userId) {

        log.trace(ApiLogMessages.GET_CURRENT_METHOD_NAME.getValue(), ApiUtils.getMethodName());

        IamResponse<UserDTO> response = userService.getByID(userId);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<IamResponse<UserDTO>> createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);

        IamResponse<UserDTO> response = userService.getByID(userDTO.getId());

        return ResponseEntity.ok(response);
    }
}
