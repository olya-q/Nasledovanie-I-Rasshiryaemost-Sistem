import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    public void testDeleteWhenProductExist() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Sun", 200, "Ivanov");
        Book book2 = new Book(2, "Bookseller", 800, "Bythell");
        Book book3 = new Book(3, "Slaughterhouse-Five", 200, "Vonnegut");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.deleteId (1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testDeleteTwoProducs() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Sun", 200, "Ivanov");
        Book book2 = new Book(2, "Bookseller", 800, "Bythell");
        Book book3 = new Book(3, "Slaughterhouse-Five", 200, "Vonnegut");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.deleteId (1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
}