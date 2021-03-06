package by.gerasimov.spring.repository;

import by.gerasimov.spring.model.Country;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    List<Country> findByNameContaining(String name);
    List<Country> findByNameContainingOrderByName(String name);
    List<Country> findByTagNameContaining(String name);
    List<Country> findAllByOrderByNameAscTagNameAsc();
}
