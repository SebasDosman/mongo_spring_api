package co.com.dosman.service.VerboHttp.services.implementations;

import co.com.dosman.service.VerboHttp.dto.*;
import co.com.dosman.service.VerboHttp.exceptions.UserException;
import co.com.dosman.service.VerboHttp.mappers.UserMapper;
import co.com.dosman.service.VerboHttp.model.User;
import co.com.dosman.service.VerboHttp.repositories.UserRepository;
import co.com.dosman.service.VerboHttp.services.IUserService;
import co.com.dosman.service.VerboHttp.utilities.UserValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    private void validatePatchUser(String id, UpdateUserDTO updateUserDTO) throws UserException {
        if (!userRepository.existsById(id)) throw new UserException(UserValidate.USER_NOT_FOUND);

        User user = userRepository.findById(id).get();

        if (updateUserDTO.getId().equals(id)) {
            if (updateUserDTO.getName() != null) user.setName(updateUserDTO.getName());
            if (updateUserDTO.getLastName() != null) user.setLastName(updateUserDTO.getLastName());
            if (updateUserDTO.getAge() != null) user.setAge(updateUserDTO.getAge());
            if (updateUserDTO.getEmail() != null) user.setEmail(updateUserDTO.getEmail());
            if (updateUserDTO.getPassword() != null) user.setPassword(updateUserDTO.getPassword());
        }
    }

    @Override
    public String deleteUser(String id) throws UserException {
        if (!userRepository.existsById(id)) throw new UserException(UserValidate.USER_NOT_FOUND);

        userRepository.delete(userRepository.findById(id).get());

        return String.format(UserValidate.USER_ELIMINATED, id);
    }

    @Override
    public HttpHeaders getUserHeaderById(String id) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();

            httpHeaders.add("User-Name", user.getName());
            httpHeaders.add("User-Email", user.getEmail());
        }

        return httpHeaders;
    }

    @Override
    public List<GetUserDTO> getAllUsers() {
        return UserMapper.domainToGetUserDto(userRepository.findAll());
    }

    @Override
    public GetUserDTO getUserById(String id) throws UserException {
        if (!userRepository.existsById(id)) throw new UserException(UserValidate.USER_NOT_FOUND);

        return UserMapper.domainToGetUserDto(userRepository.findById(id).get());
    }

    @Override
    public HttpHeaders optionsUser() {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Allow", "DELETE, GET, HEAD, OPTIONS, PATCH, POST, PUT");
        httpHeaders.add("Access-Control-Allow-Methods", "DELETE, GET, HEAD, OPTIONS, PATCH, POST, PUT");

        return httpHeaders;
    }

    @Override
    public GetUserDTO patchUser(String id, UpdateUserDTO updateUserDTO) throws UserException {
        validatePatchUser(id, updateUserDTO);

        return UserMapper.domainToGetUserDto(userRepository.save(UserMapper.updateUserDtoToDomain(updateUserDTO)));
    }

    @Override
    public GetUserDTO saveUser(CreateUserDTO createUserDTO) throws UserException {
        if (userRepository.existsByEmail(createUserDTO.getEmail())) throw new UserException(UserValidate.EMAIL_ALREADY_EXISTS);

        return UserMapper.domainToGetUserDto(userRepository.save(UserMapper.createUserDtoToDomain(createUserDTO)));
    }

    @Override
    public GetUserDTO updateUser(UpdateUserDTO updateUserDTO) throws UserException {
        if (!userRepository.existsById(updateUserDTO.getId())) throw new UserException(UserValidate.USER_NOT_FOUND);

        return UserMapper.domainToGetUserDto(userRepository.save(UserMapper.updateUserDtoToDomain(updateUserDTO)));
    }
}
