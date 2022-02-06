package ru.astecom.DTO.collection;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import ru.astecom.models.Attachment;
import ru.astecom.models.Collection;
import ru.astecom.models.support.Lang;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@ResponseDTO
public class CollectionResponseDTO extends ConversionResponse<Collection> {
    private Long id;
    private Lang lang;
    private LocalDate publishDate;
    private Long authorId;
    private Long numberOfRecords;
    private Long sizeOfRecords;
    private boolean availability;
    private String name;
    private String poster;
    private String description;
    private Double cost;
    private String eanupc;
    private String label;
    private String condition;
    private Set<String> attachments;

    @Override
    protected void fillInternal(@NotNull Collection from, Object context) {
        attachments = from.getAttachments().stream().map(Attachment::getPath).collect(Collectors.toSet());
    }
}
