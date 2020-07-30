package com.oycbest.demo;

/**
 * @author: oyc
 * @date: 2020/7/30 15:33
 */
public class ReflectDemo {
    public static void main(String[] args) {
        System.out.println("reflect demo");

        try {
            //创建Class对象的方式一：(对象.getClass())，获取person类中的字节码文件
            Person personClass1 = new Person();
            Person person1 = personClass1.getClass().newInstance();

            //创建Class对象的方式二：(类.class:需要输入一个明确的类，任意一个类型都有一个静态的class属性)
            Class<Person> personClass2 = Person.class;
            Person person2 = personClass2.newInstance();
            personClass2.getMethods();

            //创建Class对象的方式三：(forName():传入时只需要以字符串的方式传入即可)
            //通过Class类的一个forName（String className)静态方法返回一个Class对象，className必须是全路径名称；
            //Class.forName()有异常：ClassNotFoundException
            Class<?> personClass3 = Class.forName("com.oycbest.demo.Person");
            Object person3 = personClass3.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
