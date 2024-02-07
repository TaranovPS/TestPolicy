package com.example.policy;

import com.example.policy.policyStatus.PolicyStatus;

import java.util.List;

public class Policy {

    private final String UNIQUE_NUMBER;
    private PolicyStatus policyStatus;
    private List<PolicyObject> policyObjects;

    public Policy(String UNIQUE_NUMBER, PolicyStatus policyStatus, List<PolicyObject> policyObjects) {
        this.UNIQUE_NUMBER = UNIQUE_NUMBER;
        this.policyStatus = policyStatus;
        this.policyObjects = policyObjects;
    }

    public String getUNIQUE_NUMBER() {
        return UNIQUE_NUMBER;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(PolicyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }

    public List<PolicyObject> getPolicyObjects() {
        return policyObjects;
    }

    public void setPolicyObject(List<PolicyObject> policyObject) {
        this.policyObjects = policyObject;
    }
}
