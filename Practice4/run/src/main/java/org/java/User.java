package org.java;

@GenerateHelper
public class User {
    private String name;
    private int age;
    private String email;

    public User() {}

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @LogExecution
    public void sayHello() {
        System.out.println("Hello from user!");
    }

    public void sayBye() {
        System.out.println("Bye from user!");
    }
}