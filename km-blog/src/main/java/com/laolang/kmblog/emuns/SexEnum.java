package com.laolang.kmblog.emuns;

public enum SexEnum {

    MAIL("MAIL",1),
    FAMAIL("FAMAIL",2);

    private String name;

    private Integer value;

    private SexEnum(String name, Integer value) {
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
