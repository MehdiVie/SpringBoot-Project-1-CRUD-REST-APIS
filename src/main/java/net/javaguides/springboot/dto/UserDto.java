package net.javaguides.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    // firstName should not be null or empty
    @NotEmpty(message = "firstName should not be null or empty")
    private String firstName;
    // lastName should not be null or empty
    @NotEmpty(message = "lastName should not be null or empty")
    private String lastName;
    // email should not be null or empty
    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "email should be valid")
    private String email;
}
