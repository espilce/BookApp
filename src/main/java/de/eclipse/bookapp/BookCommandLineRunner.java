package de.eclipse.bookapp;

import de.eclipse.bookapp.model.Book;
import de.eclipse.bookapp.repository.BookCollectionRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;


@Component
public class BookCommandLineRunner implements CommandLineRunner {
 
    private final BookCollectionRepository repository;

    public BookCommandLineRunner(BookCollectionRepository repository) {
        this.repository = repository;
    }
    


    @Override
    public void run(String... strings) throws Exception {

        Book book1 = new Book(1, "The Hobbit", "J. R. R. Tolkien", "9780044403371", null, "Fantasy");
        Book book2 = new Book(2, "Harry Potter and the Philosopher's Stone", "J. K. Rowling", "9780590353403", null, "Fantasy");
        Book book3 = new Book(3, "The Little Prince", "Antoine de Saint-Exupéry", "9788854412545", null, "Fantasy");
        Book book4 = new Book(4, "Dream of the Red Chamber", "Cao Xueqin", "9781616120351", null, "Family Saga");
        Book book5 = new Book(5, "And Then There Were None", "Agatha Christie", "9780671706081", null, "Mystery");
        
        Stream.of(book1, book2, book3, book4, book5).forEach(book -> repository.save(book));

        repository.findAll().forEach(book -> System.out.println(book.toString()));
    }


}
