package org.java;

public class Main {

    public static void main(String[] args) {
        org.java.User user = new UserBuilder()
                .setName("John Doe")
                .setAge(19)
                .setEmail("john.doe@gmail.com")
                .build();
        MethodLogger.invokeAnnotatedMethods(user);
        user.sayBye();
    }
}