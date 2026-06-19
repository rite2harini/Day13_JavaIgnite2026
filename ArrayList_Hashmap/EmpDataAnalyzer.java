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
import java.util.Map;
import java.util.Scanner;

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

public class DepartmentSalaryAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            int numberOfEmployees = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numberOfEmployees; i++) {
                int id = Integer.parseInt(scanner.nextLine());
                String department = scanner.nextLine();
                double salary = Double.parseDouble(scanner.nextLine());
                employees.add(new Employee(id, department, salary));
            }

            HashMap<String, Double> departmentSalaries = new HashMap<>();
            
            for (Employee emp : employees) {
                departmentSalaries.put(emp.department, departmentSalaries.getOrDefault(emp.department, 0.0) + emp.salary);
            }

            String highestDepartment = "";
            double maxSalary = -1.0;

            for (Map.Entry<String, Double> entry : departmentSalaries.entrySet()) {
                if (entry.getValue() > maxSalary) {
                    maxSalary = entry.getValue();
                    highestDepartment = entry.getKey();
                }
            }

            if (!highestDepartment.isEmpty()) {
                System.out.println("Highest Salary Department: " + highestDepartment + " with total salary " + maxSalary);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input format");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
