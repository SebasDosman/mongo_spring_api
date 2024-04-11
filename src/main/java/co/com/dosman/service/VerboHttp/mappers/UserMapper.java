package co.com.dosman.service.VerboHttp.mappers;

import co.com.dosman.service.VerboHttp.dto.UserRequest;
import co.com.dosman.service.VerboHttp.dto.UserResponse;
import co.com.dosman.service.VerboHttp.model.User;

import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {
    public static UserResponse domainToRequest(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .email(user.getEmail())
                .build();
    }

    public static List<UserResponse> domainToRequestList(List<User> users) {
        return users.stream().map(UserMapper::domainToRequest).collect(Collectors.toList());
    }

    public static User requestToDomain(UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .lastName(userRequest.getLastName())
                .age(userRequest.getAge())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
    }
}
