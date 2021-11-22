package com.example.BackendJab.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {


    @JsonProperty("Active")
    ACTIVE,
    @JsonProperty("Inactive")
    INACTIVE;

    private String status;


    Status() {
    }

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
