package co.com.dosman.service.VerboHttp.services.implementations;

import co.com.dosman.service.VerboHttp.dto.UserRequest;
import co.com.dosman.service.VerboHttp.dto.UserResponse;
import co.com.dosman.service.VerboHttp.exceptions.UserException;
import co.com.dosman.service.VerboHttp.mappers.UserMapper;
import co.com.dosman.service.VerboHttp.repositories.UserRepository;
import co.com.dosman.service.VerboHttp.services.IUserService;
import co.com.dosman.service.VerboHttp.utilities.UserValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    private void validateUser(UserRequest userRequest, boolean isUpdate) throws UserException {
        if (userRequest == null) throw new UserException(UserValidate.USER_NOT_NULL);
        if (userRequest.getName() == null) throw new UserException(UserValidate.NAME_NOT_NULL);
        if (userRequest.getName().trim().isEmpty()) throw new UserException(UserValidate.NAME_NOT_EMPTY);
        if (!Pattern.matches(UserValidate.NAME_REGEX, userRequest.getName())) throw new UserException(UserValidate.NAME_NOT_VALID);
        if (userRequest.getLastName() == null) throw new UserException(UserValidate.LAST_NAME_NOT_NULL);
        if (userRequest.getLastName().trim().isEmpty()) throw new UserException(UserValidate.LAST_NAME_NOT_EMPTY);
        if (!Pattern.matches(UserValidate.LAST_NAME_REGEX, userRequest.getLastName())) throw new UserException(UserValidate.LAST_NAME_NOT_VALID);
        if (userRequest.getAge() == null) throw new UserException(UserValidate.AGE_NOT_NULL);
        if (userRequest.getAge() == null) throw new UserException(UserValidate.AGE_NOT_EMPTY);
        if (!Pattern.matches(UserValidate.AGE_REGEX, userRequest.getAge().toString())) throw new UserException(UserValidate.AGE_NOT_VALID);
        if (userRequest.getEmail() == null) throw new UserException(UserValidate.EMAIL_NOT_NULL);
        if (userRequest.getEmail().trim().isEmpty()) throw new UserException(UserValidate.EMAIL_NOT_EMPTY);
        if (!Pattern.matches(UserValidate.EMAIL_REGEX, userRequest.getEmail())) throw new UserException(UserValidate.EMAIL_NOT_VALID);
        if (userRequest.getPassword() == null) throw new UserException(UserValidate.PASSWORD_NOT_NULL);
        if (userRequest.getPassword().trim().isEmpty()) throw new UserException(UserValidate.PASSWORD_NOT_EMPTY);
        if (!Pattern.matches(UserValidate.PASSWORD_REGEX, userRequest.getPassword())) throw new UserException(UserValidate.PASSWORD_NOT_VALID);

        if (isUpdate) {
            if (!userRepository.existsById(userRequest.getId())) throw new UserException(UserValidate.USER_NOT_FOUND);
        }
    }

    @Override
    public String deleteUser(String id) throws UserException {
        if (!userRepository.existsById(id)) throw new UserException(UserValidate.USER_NOT_FOUND);

        userRepository.delete(userRepository.findById(id).get());

        return String.format(UserValidate.USER_ELIMINATED, id);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return UserMapper.domainToRequestList(userRepository.findAll());
    }

    @Override
    public UserResponse getUserById(String id) throws UserException {
        if (!userRepository.existsById(id)) throw new UserException(UserValidate.USER_NOT_FOUND);

        return UserMapper.domainToRequest(userRepository.findById(id).get());
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) throws UserException {
        validateUser(userRequest, false);

        return UserMapper.domainToRequest(userRepository.save(UserMapper.requestToDomain(userRequest)));
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) throws UserException {
        validateUser(userRequest, true);

        return UserMapper.domainToRequest(userRepository.save(UserMapper.requestToDomain(userRequest)));
    }

    @Override
    public UserResponse patchUser(UserRequest userRequest) throws UserException {
        validateUser(userRequest, true);

        return UserMapper.domainToRequest(userRepository.save(UserMapper.requestToDomain(userRequest)));
    }
}
