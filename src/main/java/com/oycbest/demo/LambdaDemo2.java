package com.oycbest.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/7/3 10:03 下午
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 185;
        Student student = new Student("oyc", 23, 175);
        System.out.println(
                "oyc的身高高于185吗？：" + predicate.test(student.getStature()));

        Consumer<String> consumer = System.out::println;
        consumer.accept("hello world");

        Function<Student, String> function = Student::getName;
        String name = function.apply(student);
        System.out.println(name);

        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());

        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);

        BinaryOperator<Integer> operator = (x, y) -> x * y;
        Integer integer = operator.apply(2, 3);
        System.out.println(integer);

        test(() -> "我是一个演示的函数式接口");



        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 26, 180));
        students.add(new Student("白胡子", 40, 185));


        List<String> names = students.stream().map(s -> s.getName()).collect(Collectors.toList());
        System.out.println(names);

        List<Integer> statures = students.stream().map( s->s.getStature()).collect(Collectors.toList());
        System.out.println(statures);

        List<Student> studentList = students.stream().filter(s -> s.age<30).collect(Collectors.toList());
        System.out.println(studentList.size());
        studentList.stream().forEach(student1 -> System.out.println(student1.toString()));

        List<Student> students1 = new ArrayList<>(3);
        students1.add(new Student("路飞1", 32, 175));
        students1.add(new Student("红发1", 30, 170));
        students1.add(new Student("白胡子1", 30, 175));
        List<Student> studentList1 = Stream.of(students, students1).flatMap(students2 -> students2.stream()).collect(Collectors.toList());
        System.out.println(studentList1);

    }

    /**
     * 演示自定义函数式接口使用
     *
     * @param worker
     */
    public static void test(Worker worker) {
        String work = worker.work();
        System.out.println(work);
    }

    public interface Worker {
        String work();
    }
    static class Student{
        String name;
        Integer age;
        Integer stature;

        public Student(String name, Integer age, Integer stature) {
            this.name = name;
            this.age = age;
            this.stature = stature;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getStature() {
            return stature;
        }

        public void setStature(Integer stature) {
            this.stature = stature;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", stature=" + stature +
                    '}';
        }
    }
}
