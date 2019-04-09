package lt.asprogramuoju.example.camel.repository;

import lt.asprogramuoju.example.camel.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
