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

        // Store employees in ArrayList
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "HR", 30000));
        employees.add(new Employee(102, "IT", 50000));
        employees.add(new Employee(103, "HR", 40000));
        employees.add(new Employee(104, "IT", 60000));
        employees.add(new Employee(105, "Sales", 45000));

        // HashMap<Department, Total Salary>
        HashMap<String, Double> deptSalary = new HashMap<>();

        // Summation Logic
        for (Employee e : employees) {
            deptSalary.put(
                e.department,
                deptSalary.getOrDefault(e.department, 0.0) + e.salary
            );
        }

        // Display department-wise total salary
        System.out.println("Department Total Salaries:");
        for (Map.Entry<String, Double> entry : deptSalary.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Comparison Logic
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
