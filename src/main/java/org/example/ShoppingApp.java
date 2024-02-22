package org.example;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ShoppingApp {
    private final List<Product> products = new ArrayList<>();
    private final Cart cart = new Cart();
    private final List<Order> orders = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public void removeFromCart(Product product) {
        cart.removeProduct(product);
    }

    public void viewCart() {
        for (Product product : cart.getProducts()) {
            System.out.println(product);
        }
    }

    public void createOrder() {
        if (cart.getProducts().isEmpty()) {
            System.out.println("Ваш кошик порожній. Не вдається створити замовлення.");
            return;
        }
        Order order = new Order(cart.getProducts());
        orders.add(order);
        cart.getProducts().clear();
        System.out.println("Замовлення успішно створено!");
    }

    public void viewOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }


    public void searchProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Не знайдено товарів з такою назвою: " + name);
    }

    public void searchCategory(String categoryName) {
        for (Product product : products) {
            if (product.getCategory().getName().equalsIgnoreCase(categoryName)) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingApp app = new ShoppingApp();
        Category electronics = new Category(1, "Електроніка");
        Category clothing = new Category(2, "Одяг");

        app.addProduct(new Product(1, "iPhone 13", 999.99, "Apple iPhone 13", electronics));
        app.addProduct(new Product(2, "Samsung Galaxy S21", 799.99, "Samsung Galaxy S21", electronics));
        app.addProduct(new Product(3, "Біла футболка", 19.99, "Біла футболка з принтом", clothing));
        app.addProduct(new Product(4, "Чорні джинси", 49.99, "Джинси Slim Fit чорного кольору", clothing));
        app.addProduct(new Product(5, "Ноутбук Dell", 1299.99, "Dell XPS 13", electronics));
        app.addProduct(new Product(6, "Чорна куртка", 149.99, "Чорна куртка з принтом", clothing));
        app.addProduct(new Product(7, "Sony WH-1000XM4", 349.99, "Навушники Sony WH-1000XM4", electronics));
        app.addProduct(new Product(8, "Чорні штани", 79.99, "Чорні штани", clothing));
        app.addProduct(new Product(9, "iPad Pro", 1099.99, "Apple iPad Pro 12.9", electronics));
        app.addProduct(new Product(10, "Блакитне пальто", 199.99, "Блакитне пальто", clothing));


        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            try{
                System.out.println("\n1. Переглянути продукти");
                System.out.println("2. Додати в кошик");
                System.out.println("3. Видалити з кошика");
                System.out.println("4. Переглянути кошик");
                System.out.println("5. Створити замовлення");
                System.out.println("6. Переглянути замовлення");
                System.out.println("7. Пошук продукту");
                System.out.println("8. Категорія пошуку");
                System.out.println("9. Вихід");
                System.out.print("Введіть свій вибір: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        for (Product product : app.products) {
                            System.out.println(product);
                        }
                        break;
                    case 2:
                        System.out.print("Введіть ID для додавання в кошик: ");
                        int productId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left-over
                        try {
                            app.addToCart(app.products.get(productId - 1));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Помилка: Товару з таким ID не існує.");
                        }
                        break;
                    case 3:
                        System.out.print("\"Введіть ID для видалення з кошика: ");
                        productId = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            app.removeFromCart(app.products.get(productId - 1));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Помилка: Товару з таким ID не існує.");
                        }
                        break;
                    case 4:
                        app.viewCart();
                        break;
                    case 5:
                        app.createOrder();
                        break;
                    case 6:
                        app.viewOrders();
                        break;
                    case 7:
                        System.out.print("Введіть назву продукту для пошуку: ");
                        String productName = scanner.nextLine();
                        app.searchProduct(productName);
                        break;
                    case 8:
                        System.out.print("Введіть назву категорії для пошуку: ");
                        String categoryName = scanner.nextLine();
                        app.searchCategory(categoryName);
                        break;
                    case 9:
                        System.out.println("Вихід із програми...");
                        break;
                    default:
                        System.out.println("Невірний вибір. Будь ласка спробуйте ще раз.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: Введіть числове значення.");
                scanner.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Помилка: Товару з таким ID не існує.");
            } catch (NoSuchElementException e) {
                System.out.println("Помилка: Товару з таким іменем не існує.");}

        } while (choice != 9);

        scanner.close();
    }
}
