import org.example.Category;
import org.example.Order;
import org.example.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class OrderTest {
    @Test
    void testOrder() {
        Category category = new Category(1, "Електроніка");
        Product product = new Product(1, "iPhone", 999.99, "Apple iPhone 13", category);
        Order order = new Order(List.of(product));

        assertTrue(order.getProducts().contains(product));
    }
}