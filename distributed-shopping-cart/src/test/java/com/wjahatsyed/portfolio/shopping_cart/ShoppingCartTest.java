package com.wjahatsyed.portfolio.shopping_cart;


import com.wjahatsyed.portfolio.shopping_cart.model.Cart;
import com.wjahatsyed.portfolio.shopping_cart.model.CartItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    void testAddItem() {
        // Example test for adding an item to the shopping cart
        Cart cart = new Cart();
        CartItem cartItem = new CartItem();
        cartItem.setPrice(12.5);
        cartItem.setProductId("ABC");
        cartItem.setQuantity(5);
        cart.addItem(cartItem);
        assertEquals(1, cart.getItems().size(), "Item count should be 1 after adding an item.");
    }


}
