package khims.rodion;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Ivanov Ivan Ivanych", "QA", "email1@domain.com", "+11111111111", 1000.0, 20),
                new Employee("Petrov Petr Petrovych", "QA", "email2@domain.com", "+22222222222", 2000.0, 30),
                new Employee("Sidorov Sidor Sidorych", "SA", "email3@domain.com", "+33333333333", 3000.0, 40),
                new Employee("Kuznetsov Kuznets Kuznetsych", "SA", "email4@domain.com", "+44444444444", 4000.0, 50),
                new Employee("Sergeev Sergey Sergeych", "QA", "email5@domain.com", "+55555555555", 5000.0, 60)
        };

        Arrays.stream(employees).forEach(System.out::println);
    }
}
