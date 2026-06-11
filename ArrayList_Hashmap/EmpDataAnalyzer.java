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
    String dept;
    double salary;
    Employee(int id, String dept, double salary) {
        this.id = id;
        this.dept = dept;
        this.salary = salary;
    }
}
public class EmpDataAnalyzer {
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "HR", 30000));
        list.add(new Employee(2, "IT", 50000));
        list.add(new Employee(3, "IT", 60000));
        list.add(new Employee(4, "HR", 20000));
        list.add(new Employee(5, "Finance", 45000));
        HashMap<String, Double> deptSalary = new HashMap<>();
        for (Employee e : list) {
            if (deptSalary.containsKey(e.dept)) {
                deptSalary.put(e.dept, deptSalary.get(e.dept) + e.salary);
            } else {
                deptSalary.put(e.dept, e.salary);
            }
        }
        String topDept = "";
        double max = 0;
        for (String dept : deptSalary.keySet()) {
            if (deptSalary.get(dept) > max) {
                max = deptSalary.get(dept);
                topDept = dept;
            }
        }
        System.out.println("All departments:");
        for (String dept : deptSalary.keySet()) {
            System.out.println(dept + " -> " + deptSalary.get(dept));
        }
        System.out.println("\nHighest salary dept: " + topDept + " (" + max + ")");
    }
}
