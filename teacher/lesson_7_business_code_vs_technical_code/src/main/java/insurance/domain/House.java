package insurance.domain;

import java.math.BigDecimal;

public class House extends InsuranceObject {

	public House(BigDecimal cadastralValue) {
		super(cadastralValue);
	}

	@Override
	public BigDecimal getRiskCoefficient(InsuranceRisk insuranceRisk) {
		if (InsuranceRisk.FIRE == insuranceRisk) {
			return new BigDecimal("0.05");
		}
		throw new IllegalArgumentException("Insurance risk not supported! " + insuranceRisk);
	}

}
