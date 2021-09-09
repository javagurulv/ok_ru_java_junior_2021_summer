package insurance.businesslogic;

import java.math.BigDecimal;

import insurance.domain.InsuranceObject;
import insurance.domain.Policy;

class InsurancePolicyPremiumCalculatorImpl implements InsurancePolicyPremiumCalculator {

	private InsuranceObjectPremiumCalculator insuranceObjectPremiumCalculator;

	InsurancePolicyPremiumCalculatorImpl(InsuranceObjectPremiumCalculator insuranceObjectPremiumCalculator) {
		this.insuranceObjectPremiumCalculator = insuranceObjectPremiumCalculator;
	}

	public BigDecimal calculate(Policy policy) {
		BigDecimal premium = BigDecimal.ZERO;
		for (InsuranceObject insuranceObject : policy.getInsuranceObjects()) {
			BigDecimal insuranceObjectPremium = insuranceObjectPremiumCalculator.calculate(insuranceObject);
			premium = premium.add(insuranceObjectPremium);
		}
		return premium;
	}

}