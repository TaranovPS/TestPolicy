package com.example;

import com.example.policy.Policy;
import com.example.policy.PolicyObject;
import com.example.policy.SubObject;
import com.example.policy.policyStatus.PolicyStatus;
import com.example.policy.riskType.RiskType;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PremiumCalculatorTest {

    @Test
    public void calculateFirstExample() {

        PolicyObject object = new PolicyObject("HOUSE", new ArrayList<SubObject>());
        object.getSubObjects().add(new SubObject("TV", RiskType.FIRE, BigDecimal.valueOf(100)));
        object.getSubObjects().add(new SubObject("SOFA", RiskType.THEFT, BigDecimal.valueOf(8)));

        ArrayList<PolicyObject> lstObjects = new ArrayList<>();
        lstObjects.add(object);

        Policy testPolicy = new Policy("0001", PolicyStatus.APPROVED, lstObjects);

        Assert.assertEquals(0, BigDecimal.valueOf(2.28).compareTo(PremiumCalculator.calculate(testPolicy).setScale(2, RoundingMode.CEILING)));
    }

    @Test
    public void calculateSecondExample() {
        PolicyObject object = new PolicyObject("CAR",new ArrayList<SubObject>());
        object.getSubObjects().add(new SubObject("MusicPlayer", RiskType.FIRE, BigDecimal.valueOf(500)));
        object.getSubObjects().add(new SubObject("Covers", RiskType.THEFT, BigDecimal.valueOf(102.51)));

        ArrayList<PolicyObject> lstObjects = new ArrayList<>();
        lstObjects.add(object);

        Policy testPolicy = new Policy("0002", PolicyStatus.APPROVED, lstObjects);
        Assert.assertEquals(0, BigDecimal.valueOf(17.13).compareTo(PremiumCalculator.calculate(testPolicy).setScale(2, RoundingMode.CEILING)));
    }
}