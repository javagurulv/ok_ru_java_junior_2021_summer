package insurance.businesslogic;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import insurance.domain.InsuranceObject;
import insurance.domain.InsuranceRisk;
import insurance.domain.SubInsuranceObject;

class SubInsuranceObjectsPremiumCalculator {

	private static final BigDecimal STANDARD_FIRE_RISK_COEF = new BigDecimal("0.03");
	private static final BigDecimal OVERPRICED_FIRE_RISK_COEF = new BigDecimal("0.04");

	private static final BigDecimal STANDARD_THEFT_RISK_COEF = new BigDecimal("0.01");
	private static final BigDecimal OVERPRICED_THEFT_RISK_COEF = new BigDecimal("0.02");

	private static final BigDecimal PRICE_BORDER = new BigDecimal("2000.00");


	public BigDecimal calculate(InsuranceObject insuranceObject) {
		Set<InsuranceRisk> subObjectRisks = identifyAllRisksForSubObjects(insuranceObject);
		BigDecimal subInsuranceObjectRiskPremium = BigDecimal.ZERO;
		for (InsuranceRisk insuranceRisk : subObjectRisks) {
			BigDecimal subObjectPriceForRisk = calculatePriceSumForSubObjectWithRisk(insuranceObject, insuranceRisk);
			BigDecimal coefficient = getRiskCoefficientForSubInsuranceObject(insuranceRisk, subObjectPriceForRisk);
			subInsuranceObjectRiskPremium = subInsuranceObjectRiskPremium.add(subObjectPriceForRisk.multiply(coefficient));
		}
		return subInsuranceObjectRiskPremium;
	}

	private BigDecimal calculatePriceSumForSubObjectWithRisk(InsuranceObject insuranceObject,
															 InsuranceRisk insuranceRisk) {
		BigDecimal subObjectPriceForRisk = BigDecimal.ZERO;
		for (SubInsuranceObject subInsuranceObject : insuranceObject.getSubInsuranceObjects()) {
			if (subInsuranceObject.getInsuranceRisks().contains(insuranceRisk)) {
				subObjectPriceForRisk.add(subInsuranceObject.getPrice());
			}
		}
		return subObjectPriceForRisk;
	}

	private Set<InsuranceRisk> identifyAllRisksForSubObjects(InsuranceObject insuranceObject) {
		Set<InsuranceRisk> subObjectRisks = new HashSet<>();
		for (SubInsuranceObject subInsuranceObject : insuranceObject.getSubInsuranceObjects()) {
			subObjectRisks.addAll(subInsuranceObject.getInsuranceRisks());
		}
		return subObjectRisks;
	}

	private BigDecimal getRiskCoefficientForSubInsuranceObject(InsuranceRisk insuranceRisk,
															   BigDecimal sum) {
		if (InsuranceRisk.FIRE == insuranceRisk) {
			if (sum.compareTo(PRICE_BORDER) < 0) {
				return STANDARD_FIRE_RISK_COEF;
			} else {
				return OVERPRICED_FIRE_RISK_COEF;
			}
		}
		if (InsuranceRisk.THEFT == insuranceRisk) {
			if (sum.compareTo(PRICE_BORDER) < 0) {
				return STANDARD_THEFT_RISK_COEF;
			} else {
				return OVERPRICED_THEFT_RISK_COEF;
			}
		}
		throw new IllegalArgumentException("Insurance risk not supported! " + insuranceRisk);
	}

}