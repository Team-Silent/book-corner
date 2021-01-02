package bookcorner.finder;

import bookcorner.models.Book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FinderTester {
    @Test
    public void testBookFinder(){
        BookFinder bookFinder = new BookFinder();
        printBooks(bookFinder.findAll());
    }

    private void printBooks(List<Book> books) {
        for (Book book: books) {
            System.out.println(book.getId() + " " + book.getTitle()+" " + book.getAuthor()+" " + book.getQuantity());
        }
    }
}
