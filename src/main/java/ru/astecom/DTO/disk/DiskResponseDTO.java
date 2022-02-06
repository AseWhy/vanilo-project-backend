package ru.astecom.DTO.disk;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.Disk;

@Getter
@Setter
@ToString
@ResponseDTO
public class DiskResponseDTO extends ConversionResponse<Disk> {
    private Long id;
    private Long authorId;
    private Long collectionId;
}
