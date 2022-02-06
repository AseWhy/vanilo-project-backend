package ru.astecom.DTO.order_item;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.OrderItem;

@Getter
@Setter
@ToString
@ResponseDTO
public class OrderItemResponseDTO extends ConversionResponse<OrderItem> {
    private Long id;
    private Long userId;
    private Long orderId;
    private Long collectionId;
    private Long quantity;
    private Double cost;
}
