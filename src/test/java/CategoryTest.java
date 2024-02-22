import org.example.Category;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CategoryTest {
    @Test
    void testCategory() {
        Category category = new Category(1, "Електроніка");

        assertEquals(1, category.getId());
        assertEquals("Електроніка", category.getName());
    }
}
