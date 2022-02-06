package ru.astecom.DTO.cart_item;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.CartItem;

@Getter
@Setter
@ToString
@ResponseDTO
public class CartItemResponseDTO extends ConversionResponse<CartItem> {
    private Long id;
    private Long userId;
    private Long cartId;
    private Long collectionId;
    private Long quantity;
    private Double cost;
}
