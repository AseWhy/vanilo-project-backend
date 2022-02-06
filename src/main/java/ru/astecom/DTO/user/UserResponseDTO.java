package ru.astecom.DTO.user;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.User;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@ResponseDTO
public class UserResponseDTO extends ConversionResponse<User> {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
}
