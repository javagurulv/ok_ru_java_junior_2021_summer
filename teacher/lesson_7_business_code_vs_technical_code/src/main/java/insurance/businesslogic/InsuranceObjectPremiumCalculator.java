package insurance.businesslogic;

import java.math.BigDecimal;

import insurance.domain.InsuranceObject;
import insurance.domain.InsuranceRisk;

class InsuranceObjectPremiumCalculator {

	private SubInsuranceObjectsPremiumCalculator subInsuranceObjectsPremiumCalculator;

	InsuranceObjectPremiumCalculator(SubInsuranceObjectsPremiumCalculator subInsuranceObjectsPremiumCalculator) {
		this.subInsuranceObjectsPremiumCalculator = subInsuranceObjectsPremiumCalculator;
	}

	public BigDecimal calculate(InsuranceObject insuranceObject) {
		BigDecimal insuranceObjectRiskPremium = calculatePremiumForInsuranceObjectItself(insuranceObject);
		BigDecimal subInsuranceObjectRiskPremium = subInsuranceObjectsPremiumCalculator.calculate(insuranceObject);
		return insuranceObjectRiskPremium.add(subInsuranceObjectRiskPremium);
	}

	private BigDecimal calculatePremiumForInsuranceObjectItself(InsuranceObject insuranceObject) {
		BigDecimal insuranceObjectRiskPremium = BigDecimal.ZERO;
		for (InsuranceRisk insuranceRisk : insuranceObject.getInsuranceRisks()) {
			BigDecimal premium = calculateInsuranceObjectRiskPremium(insuranceObject, insuranceRisk);
			insuranceObjectRiskPremium = insuranceObjectRiskPremium.add(premium);
		}
		return insuranceObjectRiskPremium;
	}

	private BigDecimal calculateInsuranceObjectRiskPremium(InsuranceObject insuranceObject,
														   InsuranceRisk insuranceRisk) {
		BigDecimal coefficient = insuranceObject.getRiskCoefficient(insuranceRisk);
		return insuranceObject.getCadastralValue().multiply(coefficient);
	}

}