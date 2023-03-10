import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    public void testFindAll() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Sun", 200, "Ivanov");
        Book book2 = new Book(2, "Bookseller", 800, "Bythell");
        Book book3 = new Book(3, "Slaughterhouse-Five", 200, "Vonnegut");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void TheSameName() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Book", 200, "Ivanov");
        Book book2 = new Book(2, "Bookseller", 800, "Bythell");
        Book book3 = new Book(3, "Slaughterhouse-Five", 200, "Vonnegut");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Book");
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindOneProduct() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Book", 200, "Ivanov");
        Book book2 = new Book(2, "Bookseller", 800, "Bythell");
        Book book3 = new Book(3, "Slaughterhouse-Five", 200, "Vonnegut");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Slaughterhouse-Five");
        Product[] expected = {book3};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void NoOneProductWasFound() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Book", 200, "Ivanov");
        Book book2 = new Book(2, "Bookseller", 800, "Bythell");
        Book book3 = new Book(3, "Slaughterhouse-Five", 200, "Vonnegut");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        boolean actual = manager.matches(book1,"Fo");
        boolean expected = false;

        assertEquals(expected, actual);
    }
    @Test
    public void ProductWasFound() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Book", 200, "Ivanov");
        Book book2 = new Book(2, "Bookseller", 800, "Bythell");
        Book book3 = new Book(3, "Slaughterhouse-Five", 200, "Vonnegut");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        boolean actual = manager.matches(book1,"Book");
        boolean expected = true;

        assertEquals(expected, actual);
    }
    @Test
    public void testFindNoOneProduct() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Book", 200, "Ivanov");
        Book book2 = new Book(2, "Bookseller", 800, "Bythell");
        Book book3 = new Book(3, "Slaughterhouse-Five", 200, "Vonnegut");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Fo");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}