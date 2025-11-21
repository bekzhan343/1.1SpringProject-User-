package com.example1._SpringProjects.Service;

import com.example1._SpringProjects.Response.IamResponse;
import com.example1._SpringProjects.dto.user.UserDTO;
import org.antlr.v4.runtime.misc.NotNull;

public interface UserService {

    IamResponse<UserDTO> getByID(@NotNull Integer userId);
}
