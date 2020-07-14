package com.oycbest.demo;

public enum SeaSonEnum {
    SPRING("spring","春天"),SUMMER("summer","夏天"),AUTUMN("autumn","秋天"),WINTER("winter","冬天");

    private String name;
    private String value;

    SeaSonEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static SeaSonEnum getByName(String name) {
        for (SeaSonEnum s : SeaSonEnum.values()) {
            if (s.getName() == name) {
                return s;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}