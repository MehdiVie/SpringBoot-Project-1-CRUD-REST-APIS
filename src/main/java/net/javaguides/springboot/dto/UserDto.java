package net.javaguides.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @Schema(
            description = "User First Name"
    )
    // firstName should not be null or empty
    @NotEmpty(message = "firstName should not be null or empty")
    private String firstName;

    @Schema(
            description = "User last Name"
    )
    // lastName should not be null or empty
    @NotEmpty(message = "lastName should not be null or empty")
    private String lastName;

    @Schema(
            description = "User Email Address"
    )
    // email should not be null or empty
    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "email should be valid")
    private String email;
}
