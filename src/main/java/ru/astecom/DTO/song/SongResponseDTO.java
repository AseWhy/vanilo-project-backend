package ru.astecom.DTO.song;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.Song;

@Getter
@Setter
@ToString
@ResponseDTO
public class SongResponseDTO extends ConversionResponse<Song> {
    private Long id;
    private Long authorId;
    private Long collectionId;
    private Long diskId;
    private String name;
    private Long order;
}
