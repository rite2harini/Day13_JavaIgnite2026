package JAVA_DAY_13;
import java.util.ArrayList;
import java.util.HashMap;

class Employees {
    int id;
    String department;
    double salary;

    Employees(int id, String department, double salary) {
        this.id = id;
        this.department = department;
        this.salary = salary;
    }
}
public class EMPLOYEE_DATA_ANALYZER {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        ArrayList<Employees> employees = new ArrayList<>();

        employees.add(new Employees(101, "IT", 40000));
        employees.add(new Employees(102, "HR", 50000));
        employees.add(new Employees(103, "IT", 30000));
        employees.add(new Employees(104, "Sales", 70000));
        employees.add(new Employees(105, "HR", 20000));
        employees.add(new Employees(106, "HR", 30000));
        employees.add(new Employees(107, "Sales", 50000));

        HashMap<String, Double> departmentSalary = new HashMap<>();

        for (Employees emp : employees) {

            String dept = emp.department;
            double salary = emp.salary;

            if (departmentSalary.containsKey(dept)) {
                departmentSalary.put(
                        dept,
                        departmentSalary.get(dept) + salary
                );
            } else {
                departmentSalary.put(dept, salary);
            }
        }
        System.out.println("Department Salary Totals:");

        for (String dept : departmentSalary.keySet()) {
            System.out.println(dept + " -> Rs." + departmentSalary.get(dept));
        }
        String highestDepartment = "";
        double highestSalary = 0;

        for (String dept : departmentSalary.keySet()) {

            if (departmentSalary.get(dept) > highestSalary) {
                highestSalary = departmentSalary.get(dept);
                highestDepartment = dept;
            }
        }

        System.out.println("\nDepartment with Highest Total Salary:");
        System.out.println(highestDepartment + " -> Rs." + highestSalary);
    }
}
