package lt.asprogramuoju.example.camel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
