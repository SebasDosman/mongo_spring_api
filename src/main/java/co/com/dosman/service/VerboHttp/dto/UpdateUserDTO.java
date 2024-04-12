package co.com.dosman.service.VerboHttp.dto;

import co.com.dosman.service.VerboHttp.utilities.UserValidate;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@AllArgsConstructor
@Builder
@Data
@ToString
public class UpdateUserDTO {
    @NotNull(message = UserValidate.ID_NOT_NULL)
    @NotBlank(message = UserValidate.ID_NOT_EMPTY)
    private String id;

    @NotNull(message = UserValidate.NAME_NOT_NULL)
    @NotBlank(message = UserValidate.NAME_NOT_EMPTY)
    @Pattern(regexp = UserValidate.NAME_REGEX, message = UserValidate.NAME_NOT_VALID)
    private String name;

    @NotNull(message = UserValidate.LAST_NAME_NOT_NULL)
    @NotBlank(message = UserValidate.LAST_NAME_NOT_EMPTY)
    @Pattern(regexp = UserValidate.LAST_NAME_REGEX, message = UserValidate.LAST_NAME_NOT_VALID)
    private String lastName;

    @NotNull(message = UserValidate.AGE_NOT_NULL)
    @Min(value = 0, message = UserValidate.AGE_TOO_YOUNG)
    @Max(value = 100, message = UserValidate.AGE_TOO_OLD)
    private Integer age;

    @NotNull(message = UserValidate.EMAIL_NOT_NULL)
    @NotBlank(message = UserValidate.EMAIL_NOT_EMPTY)
    @Pattern(regexp = UserValidate.EMAIL_REGEX, message = UserValidate.EMAIL_NOT_VALID)
    private String email;

    @NotNull(message = UserValidate.PASSWORD_NOT_NULL)
    @NotBlank(message = UserValidate.PASSWORD_NOT_EMPTY)
    @Pattern(regexp = UserValidate.PASSWORD_REGEX, message = UserValidate.PASSWORD_NOT_VALID)
    private String password;
}
