package com.wideside.springvalidation;

import javax.validation.constraints.NotNull;

public class BooleanBody {

    @NotNull
    private Boolean booleanValue;

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }
}
