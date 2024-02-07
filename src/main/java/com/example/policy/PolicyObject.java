package com.example.policy;

import java.util.List;

public class PolicyObject {

    private final String OBJECT_NAME;
    private List<SubObject> subObjects;

    public PolicyObject(String OBJECT_NAME, List<SubObject> subObjects) {
        this.OBJECT_NAME = OBJECT_NAME;
        this.subObjects = subObjects;
    }

    public String getOBJECT_NAME() {
        return OBJECT_NAME;
    }

    public List<SubObject> getSubObjects() {
        return subObjects;
    }

    public void setSubObjects(List<SubObject> subObjects) {
        this.subObjects = subObjects;
    }
}
