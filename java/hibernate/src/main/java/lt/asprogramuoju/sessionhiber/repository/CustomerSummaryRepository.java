package lt.asprogramuoju.sessionhiber.repository;

import lt.asprogramuoju.sessionhiber.domain.CustomerSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerSummaryRepository extends JpaRepository<CustomerSummary, Long> {

//    Collection<List> getCustomerSummary();
}
