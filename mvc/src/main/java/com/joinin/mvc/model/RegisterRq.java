package com.joinin.mvc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.joinin.mvc.service.ModelEntityConstants.*;

@NoArgsConstructor
@Getter
@Setter
public class RegisterRq {

    @NotBlank(message = NAME_CAN_NOT_BE_EMPTY)
    @Size(min = 3, max = 30, message = NAME_MUST_BE_BETWEEN_3_AND_30_SYMBOLS)
    private String firstName;

    @NotBlank(message = NAME_CAN_NOT_BE_EMPTY)
    @Size(min = 3, max = 30, message = NAME_MUST_BE_BETWEEN_3_AND_30_SYMBOLS)
    private String lastName;

    @NotBlank(message = EMAIL_CAN_NOT_BE_EMPTY)
    @Pattern(regexp = EMAIL_REG_EX_PATTERN, message = EMAIL_EXAMPLE)
    private String email;

    @NotBlank(message = PASSWORD_CAN_NOT_BE_EMPTY)
    @Size(min = 8, message = PASSWORD_MUST_BE_AT_LEAST_8_SYMBOLS)
    private String password;

}
