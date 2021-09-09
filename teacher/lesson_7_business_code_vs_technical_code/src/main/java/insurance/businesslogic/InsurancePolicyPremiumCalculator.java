package insurance.businesslogic;

import java.math.BigDecimal;

import insurance.domain.Policy;

public interface InsurancePolicyPremiumCalculator {

	BigDecimal calculate(Policy policy);

}
