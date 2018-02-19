package com.laolang.kmblog.emuns;

public enum InboxTypeEnum {

    USER("user",1),
    SYSTEM("system",2);

    private String name;

    private Integer value;

    private InboxTypeEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
