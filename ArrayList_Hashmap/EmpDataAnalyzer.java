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

public class EmployeeDataManager {
    public static void main(String[] args) {
        // Store employees using ArrayList
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "IT", 75000));
        employees.add(new Employee(2, "HR", 55000));
        employees.add(new Employee(3, "IT", 82000));
        employees.add(new Employee(4, "Finance", 68000));
        employees.add(new Employee(5, "HR", 58000));
        employees.add(new Employee(6, "IT", 71000));
        employees.add(new Employee(7, "Finance", 72000));
        
        // Create HashMap: Key = Department, Value = Total salary
        HashMap<String, Double> deptSalaryMap = new HashMap<>();
        
        // Grouping & Summation logic
        for (Employee emp : employees) {
            deptSalaryMap.put(emp.department, 
                deptSalaryMap.getOrDefault(emp.department, 0.0) + emp.salary);
        }
        
        // Comparison logic - find department with highest total salary
        String topDept = null;
        double maxSalary = 0;
        
        for (Map.Entry<String, Double> entry : deptSalaryMap.entrySet()) {
            if (entry.getValue() > maxSalary) {
                maxSalary = entry.getValue();
                topDept = entry.getKey();
            }
        }
        
        // Display results
        System.out.println("Department Total Salaries: " + deptSalaryMap);
        System.out.println("Department with highest total salary: " + 
                          topDept + " ($" + String.format("%.2f", maxSalary) + ")");
    }
}
