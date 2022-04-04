package com.example.java_group_11_homework_56.enums;

public enum TaskStatusEnum {
    NEW("new"),
    IN_WORK("in_work"),
    COMPLETED("completed");
    private String value;

    TaskStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
