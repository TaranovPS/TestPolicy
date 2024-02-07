package com.example;

import com.example.policy.Policy;
import com.example.policy.PolicyObject;
import com.example.policy.SubObject;
import com.example.policy.riskType.RiskType;

import java.math.BigDecimal;

public class PremiumCalculator {

    private static final BigDecimal COEFFICIENT_FIRE_DEFAULT = new BigDecimal("0.014");
    private static final BigDecimal COEFFICIENT_FIRE_THRESHOLD = new BigDecimal("0.024");
    private static final BigDecimal SUM_INSURED_FIRE_THRESHOLD = new BigDecimal("100");
    private static final BigDecimal COEFFICIENT_THEFT_DEFAULT = new BigDecimal("0.11");
    private static final BigDecimal COEFFICIENT_THEFT_REDUCED = new BigDecimal("0.05");
    private static final BigDecimal SUM_INSURED_THEFT_THRESHOLD = new BigDecimal("15");


    public static BigDecimal calculate(Policy policy) {

        BigDecimal sumInsuredFire = BigDecimal.ZERO;
        BigDecimal sumInsuredTheft = BigDecimal.ZERO;

        for (PolicyObject policyObject : policy.getPolicyObjects()) {
            for (SubObject subObject : policyObject.getSubObjects()) {

                BigDecimal sumInsured = subObject.getSumInjures();

                if (subObject.getRiskType() == RiskType.FIRE) {
                    sumInsuredFire = sumInsuredFire.add(sumInsured);
                } else if (subObject.getRiskType() == RiskType.THEFT) {
                    sumInsuredTheft = sumInsuredTheft.add(sumInsured);
                }
            }
        }

        BigDecimal coefficientFire = sumInsuredFire.compareTo(SUM_INSURED_FIRE_THRESHOLD) > 0 ?
                COEFFICIENT_FIRE_THRESHOLD : COEFFICIENT_FIRE_DEFAULT;
        BigDecimal coefficientTheft = sumInsuredTheft.compareTo(SUM_INSURED_THEFT_THRESHOLD) >= 0 ?
                COEFFICIENT_THEFT_REDUCED : COEFFICIENT_THEFT_DEFAULT;

        BigDecimal premiumFire = sumInsuredFire.multiply(coefficientFire);
        BigDecimal premiumTheft = sumInsuredTheft.multiply(coefficientTheft);

        return premiumFire.add(premiumTheft);
    }
}