package com.oycbest.demo.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName: ReflectionTest
 * @Description: ReflectionTest
 * @Author oyc
 * @Date 2021/2/23 17:04
 * @Version 1.0
 */
public class ReflectionTest {
    public static void main(String[] args) {
        System.out.println("ReflectionTest");
        try {
            Person person = Person.class.newInstance();

            person.eat();
            person.run();

            Class<Person> personClass = Person.class;
            System.out.println("personClass.getConstructors() = " + personClass.getConstructors().length);

            for (Constructor<?> declaredConstructor : personClass.getDeclaredConstructors()) {
                System.out.println("declaredConstructor = " + declaredConstructor.toString());
            }

            for (Method declaredMethod : personClass.getDeclaredMethods()) {
                System.out.println("declaredMethod.toString() = " + declaredMethod.toString());
            }
            for (Field field : personClass.getFields()) {
                System.out.println("field = " + field.toString());
            }
            Constructor c = personClass.getDeclaredConstructor();
            Person person1 = (Person) c.newInstance();
            person1.run();
            person1.eat();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
