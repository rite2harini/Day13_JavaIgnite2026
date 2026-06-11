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

import java.util.ArrayList;
import java.util.HashMap;

class Employee {
    int id;
    String department;
    double salary;

    Employee(int id, String department, double salary) {
        this.id = id;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeSalaryAnalysis {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "IT", 50000));
        employees.add(new Employee(102, "HR", 30000));
        employees.add(new Employee(103, "IT", 60000));
        employees.add(new Employee(104, "Finance", 45000));
        employees.add(new Employee(105, "HR", 35000));

        HashMap<String, Double> departmentSalary = new HashMap<>();

        for (Employee emp : employees) {
            departmentSalary.put(
                emp.department,
                departmentSalary.getOrDefault(emp.department, 0.0) + emp.salary
            );
        }

        String highestDept = "";
        double highestSalary = 0;

        for (String dept : departmentSalary.keySet()) {
            if (departmentSalary.get(dept) > highestSalary) {
                highestSalary = departmentSalary.get(dept);
                highestDept = dept;
            }
        }

        System.out.println(highestDept + " = " + highestSalary);
    }
}
