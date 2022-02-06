package ru.astecom.DTO.cart;

import io.github.asewhy.conversions.ConversionResponse;
import io.github.asewhy.conversions.support.annotations.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.Cart;

@Getter
@Setter
@ToString
@ResponseDTO
public class CartResponseDTO extends ConversionResponse<Cart> {
    private Long id;
    private Long userId;
}
