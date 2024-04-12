package co.com.dosman.service.VerboHttp.services;

import co.com.dosman.service.VerboHttp.dto.UserRequest;
import co.com.dosman.service.VerboHttp.dto.UserResponse;
import co.com.dosman.service.VerboHttp.exceptions.UserException;
import org.springframework.http.HttpHeaders;

import java.util.List;


public interface IUserService {
    String deleteUser(String id) throws UserException;
    boolean existsUserById(String id);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(String id) throws UserException;
    HttpHeaders optionsUser();
    UserResponse patchUser(String id, UserRequest userRequest) throws UserException;
    UserResponse saveUser(UserRequest userRequest) throws UserException;
    UserResponse updateUser(UserRequest userRequest) throws UserException;
}
