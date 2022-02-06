package ru.astecom.DTO.user;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.User;

@Getter
@Setter
@ToString
@ResponseDTO
public class AuthDTO extends ConversionResponse<User> {
    private String token;
    private Long expiresIn;
}
