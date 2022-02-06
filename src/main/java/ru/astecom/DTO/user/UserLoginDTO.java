package ru.astecom.DTO.user;

import io.github.asewhy.conversions.ConversionMutator;
import io.github.asewhy.conversions.support.annotations.MutatorDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.User;

@Getter
@Setter
@ToString
@MutatorDTO
public class UserLoginDTO extends ConversionMutator<User> {
    private String login;
    private String password;
}
