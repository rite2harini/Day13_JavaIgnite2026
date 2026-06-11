import java.util.ArrayList;
import java.util.HashMap;

class Employee {
    int id;
    String department;
    double salary;

    public Employee(int id, String department, double salary) {
        this.id = id;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeDepartmentSalary {
    public static void main(String[] args) {

        // Store employees in ArrayList
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "IT", 50000));
        employees.add(new Employee(102, "HR", 40000));
        employees.add(new Employee(103, "IT", 60000));
        employees.add(new Employee(104, "Finance", 70000));
        employees.add(new Employee(105, "HR", 45000));
        employees.add(new Employee(106, "Finance", 80000));

        // HashMap to store Department -> Total Salary
        HashMap<String, Double> departmentSalary = new HashMap<>();

        // Grouping and Summation Logic
        for (Employee emp : employees) {
            departmentSalary.put(
                emp.department,
                departmentSalary.getOrDefault(emp.department, 0.0) + emp.salary
            );
        }

        // Display total salary of each department
        System.out.println("Department-wise Total Salary:");
        for (String dept : departmentSalary.keySet()) {
            System.out.println(dept + " -> " + departmentSalary.get(dept));
        }

        // Comparison Logic to find highest total salary
        String highestDept = "";
        double highestSalary = 0;

        for (String dept : departmentSalary.keySet()) {
            if (departmentSalary.get(dept) > highestSalary) {
                highestSalary = departmentSalary.get(dept);
                highestDept = dept;
            }
        }

        // Display department with highest total salary
        System.out.println("\nDepartment with Highest Total Salary:");
        System.out.println(highestDept + " -> " + highestSalary);
    }
}/*
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
