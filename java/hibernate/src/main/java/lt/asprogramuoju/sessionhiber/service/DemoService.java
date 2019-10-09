package lt.asprogramuoju.sessionhiber.service;

import lt.asprogramuoju.sessionhiber.domain.Customer;
import lt.asprogramuoju.sessionhiber.domain.CustomerType;
import lt.asprogramuoju.sessionhiber.domain.enums.CustomerTypeEnum;
import lt.asprogramuoju.sessionhiber.repository.CustomerRepository;
import lt.asprogramuoju.sessionhiber.repository.CustomerTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class DemoService {

    private final static Logger logger = LoggerFactory.getLogger(DemoService.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void getCustomerTypes(){

        logger.info("Get of customer type");
        Query q = entityManager.createQuery("SELECT name FROM CustomerType");
        List<Object[]> list = q.getResultList();

        for (Object value: list) {
            System.out.println("CustomerType " + value);
        }
    }

    /*
        This method is tagged with @Transactional,
        meaning that any failure causes the entire operation to roll back to its previous state,
        and to re-throw the original exception
     */
    @Transactional
    public void init() {
        logger.info("Set customer types and one customer in transactional mode");
        customerTypeRepository.save(new CustomerType(CustomerTypeEnum.SIMPLE));
        customerTypeRepository.save(new CustomerType(CustomerTypeEnum.LOYAL));
        this.getCustomerTypes();

        LocalDate birthDate = LocalDate.of(2014, Month.JANUARY, 1);
        customerRepository.save(new Customer(
                "Petras", "Petraitis", birthDate,
                "64010101", new CustomerType(CustomerTypeEnum.SIMPLE))
        );
    }
}
