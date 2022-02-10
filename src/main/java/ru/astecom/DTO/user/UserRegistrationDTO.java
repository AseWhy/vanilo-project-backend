package ru.astecom.DTO.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.asewhy.conversions.ConversionMutator;
import io.github.asewhy.conversions.support.annotations.MutatorDTO;
import io.github.asewhy.conversions.support.annotations.MutatorExcludes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import ru.astecom.models.User;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@MutatorDTO
public class UserRegistrationDTO extends ConversionMutator<User> {
    @MutatorExcludes
    @Length(min = 6)
    private String login;

    @MutatorExcludes
    @Length(min = 6, max = 255)
    private String password;

    private String firstName;
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
}
