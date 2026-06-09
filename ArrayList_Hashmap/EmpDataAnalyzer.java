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
import java.util.*;

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

public class EmployeeDemo {
    public static void main(String[] args) {

   
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "HR", 30000));
        employees.add(new Employee(102, "IT", 50000));
        employees.add(new Employee(103, "HR", 40000));
        employees.add(new Employee(104, "IT", 60000));
        employees.add(new Employee(105, "Sales", 45000));


        HashMap<String, Double> deptSalary = new HashMap<>();

        for (Employee e : employees) {
            deptSalary.put(
                e.department,
                deptSalary.getOrDefault(e.department, 0.0) + e.salary
            );
        }

        System.out.println("Department Total Salaries:");
        for (Map.Entry<String, Double> entry : deptSalary.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        String highestDept = "";
        double maxSalary = 0;

        for (Map.Entry<String, Double> entry : deptSalary.entrySet()) {
            if (entry.getValue() > maxSalary) {
                maxSalary = entry.getValue();
                highestDept = entry.getKey();
            }
        }

        System.out.println("\nDepartment with highest total salary:");
        System.out.println(highestDept + " = " + maxSalary);
    }
}
