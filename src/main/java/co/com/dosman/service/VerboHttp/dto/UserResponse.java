package co.com.dosman.service.VerboHttp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@AllArgsConstructor
@Builder
@Data
@ToString
public class UserResponse {
    private String name;
    private String lastName;
    private Integer age;
    private String email;
}
