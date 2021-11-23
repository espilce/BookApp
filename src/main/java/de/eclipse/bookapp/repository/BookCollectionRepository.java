package de.eclipse.bookapp.repository;

import de.eclipse.bookapp.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BookCollectionRepository extends JpaRepository<Book, Long> {
        public List<Book> findByTitle(String title);
    
}
