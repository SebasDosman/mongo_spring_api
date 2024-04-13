package co.com.dosman.service.VerboHttp.services;

import co.com.dosman.service.VerboHttp.dto.*;
import co.com.dosman.service.VerboHttp.exceptions.UserException;
import org.springframework.http.HttpHeaders;

import java.util.List;


public interface IUserService {
    String deleteUser(String id) throws UserException;
    HttpHeaders getUserHeaderById(String id);
    List<GetUserDTO> getAllUsers();
    GetUserDTO getUserById(String id) throws UserException;
    HttpHeaders optionsUser();
    GetUserDTO patchUser(String id, UpdateUserDTO updateUserDTO) throws UserException;
    GetUserDTO saveUser(CreateUserDTO createUserDTO) throws UserException;
    GetUserDTO updateUser(UpdateUserDTO updateUserDTO) throws UserException;
}
