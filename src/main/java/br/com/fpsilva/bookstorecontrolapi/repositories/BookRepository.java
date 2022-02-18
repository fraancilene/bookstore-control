package br.com.fpsilva.bookstorecontrolapi.repositories;

import br.com.fpsilva.bookstorecontrolapi.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookModel, UUID> {

}
