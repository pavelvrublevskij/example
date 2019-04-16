package lt.asprogramuoju.sessionhiber.repository;

import lt.asprogramuoju.sessionhiber.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
