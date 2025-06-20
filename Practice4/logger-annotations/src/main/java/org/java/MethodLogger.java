package org.java;

import java.lang.reflect.Method;

public class MethodLogger {
    public static void invokeAnnotatedMethods(Object obj) {
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecution.class)) {
                try {
                    System.out.println("[LOG] Invoking: " + method.getName());
                    method.invoke(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}