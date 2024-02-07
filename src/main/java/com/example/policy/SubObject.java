package com.example.policy;

import com.example.policy.riskType.RiskType;

import java.math.BigDecimal;

public class SubObject {

    private final String OBJECT_NAME;
    private RiskType riskType;

    private BigDecimal sumInjures;

    public SubObject(String OBJECT_NAME, RiskType riskType, BigDecimal sumInjures) {
        this.OBJECT_NAME = OBJECT_NAME;
        this.riskType = riskType;
        this.sumInjures = sumInjures;
    }

    public String getOBJECT_NAME() {
        return OBJECT_NAME;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    public BigDecimal getSumInjures() {
        return sumInjures;
    }

    public void setSumInjures(BigDecimal sumInjures) {
        this.sumInjures = sumInjures;
    }
}
