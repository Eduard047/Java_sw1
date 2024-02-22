import org.example.Cart;
import org.example.Category;
import org.example.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CartTest {
    @Test
    void testCart() {
        Category category = new Category(1, "Електроніка");
        Product product = new Product(1, "iPhone", 999.99, "Apple iPhone 13", category);
        Cart cart = new Cart();

        cart.addProduct(product);
        assertTrue(cart.getProducts().contains(product));

        cart.removeProduct(product);
        assertFalse(cart.getProducts().contains(product));
    }
}
