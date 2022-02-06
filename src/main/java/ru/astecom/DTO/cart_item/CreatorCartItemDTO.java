package ru.astecom.DTO.cart_item;

import io.github.asewhy.conversions.ConversionMutator;
import io.github.asewhy.conversions.support.annotations.MutatorDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.CartItem;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@MutatorDTO
public class CreatorCartItemDTO extends ConversionMutator<CartItem> {
    @NotNull
    private Long collectionId;

    @Min(1)
    private Long quantity;
}
