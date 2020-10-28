package com.oycbest.demo.builder;

import java.util.*;

public class GirlFriend {


    private String name;


    private int age;


    private int bust;


    private int waist;


    private int hips;


    private List<String> hobby;


    private String birthday;


    private String address;


    private String mobile;


    private String email;


    private String hairColor;


    private Map<String, String> gift;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBust() {
        return bust;
    }

    public void setBust(int bust) {
        this.bust = bust;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHips() {
        return hips;
    }

    public void setHips(int hips) {
        this.hips = hips;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public Map<String, String> getGift() {
        return gift;
    }

    public void setGift(Map<String, String> gift) {
        this.gift = gift;
    }
// 省略 getter & setter ...


    public static void main(String[] args) {
        GirlFriend myGirlFriend = new GirlFriend();
        myGirlFriend.setName("小美");
        myGirlFriend.setAge(18);
        myGirlFriend.setBust(33);
        myGirlFriend.setWaist(23);
        myGirlFriend.setHips(33);
        myGirlFriend.setBirthday("2001-10-26");
        myGirlFriend.setAddress("上海浦东");
        myGirlFriend.setMobile("18688888888");
        myGirlFriend.setEmail("pretty-xiaomei@qq.com");
        myGirlFriend.setHairColor("浅棕色带点微卷");


        List<String> hobby = new ArrayList<>();
        hobby.add("逛街");
        hobby.add("购物");
        hobby.add("买东西");
        myGirlFriend.setHobby(hobby);

        Map<String, String> gift = new HashMap<>();
        gift.put("情人节礼物", "LBR 1912女王时代");
        gift.put("生日礼物", "迪奥烈焰蓝金");
        gift.put("纪念日礼物", "阿玛尼红管唇釉");

        myGirlFriend.setGift(gift);

        GirlFriend myGirlFriend1 = Builder.of(GirlFriend::new)
                .with(GirlFriend::setName, "小美")
                .with(GirlFriend::setAge, 18)
                .with(GirlFriend::setVitalStatistics, 33, 23, 33)
                .with(GirlFriend::setBirthday, "2001-10-26")
                .with(GirlFriend::setAddress, "上海浦东")
                .with(GirlFriend::setMobile, "18688888888")
                .with(GirlFriend::setEmail, "pretty-xiaomei@qq.com")
                .with(GirlFriend::setHairColor, "浅棕色带点微卷")
                .with(GirlFriend::addHobby, "逛街")
                .with(GirlFriend::addHobby, "购物")
                .with(GirlFriend::addHobby, "买东西")
                .with(GirlFriend::addGift, "情人节礼物", "LBR 1912女王时代")
                .with(GirlFriend::addGift, "生日礼物", "迪奥烈焰蓝金")
                .with(GirlFriend::addGift, "纪念日礼物", "阿玛尼红管唇釉").build();
    }


    // 为了演示方便，加几个聚合方法
    public void addHobby(String hobby) {
        this.hobby = Optional.ofNullable(this.hobby).orElse(new ArrayList<>());
        this.hobby.add(hobby);
    }

    public void addGift(String day, String gift) {
        this.gift = Optional.ofNullable(this.gift).orElse(new HashMap<>());
        this.gift.put(day, gift);
    }

    public void setVitalStatistics(int bust, int waist, int hips) {
        this.bust = bust;
        this.waist = waist;
        this.hips = hips;
    }

    public static void main1(String[] args) {

    }

}