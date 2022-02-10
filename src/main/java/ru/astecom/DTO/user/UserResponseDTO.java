package ru.astecom.DTO.user;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String phone;
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
}
