package com.oycbest.demo.springautowired;

import org.springframework.stereotype.Component;

/**
 * @author: oyc
 * @date: 2020/8/20 14:33
 */
@Component
public class Address {
    private String city;

    public Address() {
        this.city = "chongqing";
    }

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
