/*
Create a program that stores employee data in memory:

Each employee has:

id
department
salary
Task:
Store employees using ArrayList
Create a HashMap where:
Key = Department
Value = Total salary of that department
Display department with highest total salary
Hint:

Break into:

Grouping logic
Summation logic
Comparison logic
*/
package java_internship_day_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmpDataAnalyzer {

    static class Employee {
        int id;
        String department;
        double salary;

        Employee(int id, String department, double salary) {
            this.id = id;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Employee " + (i + 1) + " ---");

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Department: ");
            String department = sc.next();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            employeeList.add(new Employee(id, department, salary));
        }

        HashMap<String, Double> deptSalaryMap = new HashMap<>();

        for (Employee emp : employeeList) {
            if (deptSalaryMap.containsKey(emp.department)) {
                deptSalaryMap.put(emp.department,
                    deptSalaryMap.get(emp.department) + emp.salary);
            } else {
                deptSalaryMap.put(emp.department, emp.salary);
            }
        }

        System.out.println("\n--- Department-wise Total Salary ---");
        for (Map.Entry<String, Double> entry : deptSalaryMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        String highestDept = null;
        double highestSalary = 0;

        for (Map.Entry<String, Double> entry : deptSalaryMap.entrySet()) {
            if (entry.getValue() > highestSalary) {
                highestSalary = entry.getValue();
                highestDept = entry.getKey();
            }
        }

        System.out.println("\n--- Result ---");
        System.out.println("Department with Highest Total Salary: " + highestDept);
        System.out.println("Total Salary: " + highestSalary);

        sc.close();
    }
}
