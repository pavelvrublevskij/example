package lt.asprogramuoju.sessionhiber.repository;

import lt.asprogramuoju.sessionhiber.domain.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
