package ar.com.pablocaamano.blogapi.repository;

import ar.com.pablocaamano.blogapi.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
    List<Author> findAll();
    Optional<Author> findById(Integer id);


}
