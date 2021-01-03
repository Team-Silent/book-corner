package bookcorner.finder;

import bookcorner.models.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FinderTester {
    @Test
    public void testBookFinder(){
        BookFinder bookFinder = new BookFinder();
        printBooks(bookFinder.findAll());
        Book book = new Book("a_title","an_author",1000,1200,3);
        book.saveToDatabase();
        Book foundBook = bookFinder.findByID("a_titlean_author");
        Assertions.assertEquals(book.getId(),foundBook.getId());
        Assertions.assertEquals(book.getTitle(),foundBook.getTitle());
        Assertions.assertEquals(book.getPurchasingPrice(),foundBook.getPurchasingPrice());
    }

    private void printBooks(List<Book> books) {
        for (Book book: books) {
            System.out.println(book.getId() + " " + book.getTitle()+" " + book.getAuthor()+" " + book.getQuantity());
        }
    }

}
