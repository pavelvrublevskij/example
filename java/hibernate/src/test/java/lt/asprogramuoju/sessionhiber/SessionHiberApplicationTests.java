package lt.asprogramuoju.sessionhiber;

import lt.asprogramuoju.sessionhiber.domain.CustomerType;
import lt.asprogramuoju.sessionhiber.domain.enums.CustomerTypeEnum;
import lt.asprogramuoju.sessionhiber.repository.CustomerTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SessionHiberApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CustomerTypeRepository customerTypeRepository;

	@Test
	public void givenCustomerTypeEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
		CustomerType customerType = customerTypeRepository.save(new CustomerType(CustomerTypeEnum.SIMPLE));
		Optional<CustomerType> getCustomerType = customerTypeRepository.findById((long)CustomerTypeEnum.SIMPLE.getId());

		assertNotNull(getCustomerType);
		assertEquals(customerType.getName(), getCustomerType.get().getName());
	}

}
