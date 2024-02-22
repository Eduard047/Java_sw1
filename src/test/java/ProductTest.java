import org.example.Category;
import org.example.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ProductTest {
    @Test
    void testProduct() {
        Category category = new Category(1, "Електроніка");
        Product product = new Product(1, "iPhone", 999.99, "Apple iPhone 13", category);

        assertEquals(1, product.getId());
        assertEquals("iPhone", product.getName());
        assertEquals(999.99, product.getPrice(), 0.01);
        assertEquals("Apple iPhone 13", product.getDescription());
        assertEquals(category, product.getCategory());
    }
}