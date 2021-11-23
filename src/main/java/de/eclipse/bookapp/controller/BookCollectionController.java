package de.eclipse.bookapp.controller;
 
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
    
import de.eclipse.bookapp.model.Book;
import de.eclipse.bookapp.repository.BookCollectionRepository;
import de.eclipse.bookapp.controller.exception.BookIdMismatchException;
import de.eclipse.bookapp.controller.exception.BookNotFoundException;
    

@RestController
public class BookCollectionController {

    @Autowired
    private BookCollectionRepository repository;
    
    public BookCollectionController(BookCollectionRepository repository){
        this.repository = repository;
    
    }
    @GetMapping
    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    @GetMapping("books/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return repository.findByTitle(bookTitle);
    }

    @GetMapping("books/{id}")
    public Book findOne(@PathVariable long id) {
        return repository.findById(id)
          .orElseThrow(BookNotFoundException::new);
    }


    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(value = "/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book newBook) {
        Book book = repository.save(newBook);
        return book;
    }

    @DeleteMapping("books/{id}")
    public void delete(@PathVariable long id) {
        repository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        repository.deleteById(id);
    }

}
