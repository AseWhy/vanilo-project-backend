package ru.astecom.DTO.author;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.Author;

@Getter
@Setter
@ToString
@ResponseDTO
public class AuthorResponseDTO extends ConversionResponse<Author> {
    private Long id;
    private String name;
}
