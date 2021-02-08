package uz.loyiha.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.loyiha.entity.Book;

import java.util.UUID;

@RepositoryRestResource(path = "book")
public interface BookRepository extends JpaRepository<Book, UUID> {
}
