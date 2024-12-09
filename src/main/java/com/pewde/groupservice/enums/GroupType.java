package com.pewde.groupservice.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum GroupType {

    OPEN;

    @JsonCreator
    public GroupType fromText(String text) {
        return GroupType.valueOf(text);
    }

    @Override
    public String toString(){
        return this.name();
    }

}
