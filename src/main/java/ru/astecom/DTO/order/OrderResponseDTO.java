package ru.astecom.DTO.order;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.Order;

@Getter
@Setter
@ToString
@ResponseDTO
public class OrderResponseDTO extends ConversionResponse<Order> {
    private Long id;
    private Long userId;
}
