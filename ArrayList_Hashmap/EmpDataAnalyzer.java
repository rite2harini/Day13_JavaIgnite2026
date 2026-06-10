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

public class DepartmentSalary {
	 public static void main(String[] args) {

	        // Store employees in ArrayList
	        ArrayList<Employee> employees = new ArrayList<>();

	        employees.add(new Employee(101, "IT", 50000));
	        employees.add(new Employee(102, "HR", 30000));
	        employees.add(new Employee(103, "IT", 60000));
	        employees.add(new Employee(104, "Finance", 70000));
	        employees.add(new Employee(105, "HR", 40000));

	        HashMap<String, Double> deptSalary = new HashMap<>();

	        for (Employee emp : employees) {
	            deptSalary.put(
	                emp.department,
	                deptSalary.getOrDefault(emp.department, 0.0) + emp.salary
	            );
	        }

	        System.out.println("Department Wise Total Salary:");
	        for (String dept : deptSalary.keySet()) {
	            System.out.println(dept + " = " + deptSalary.get(dept));
	        }

	        String highestDept = "";
	        double maxSalary = 0;

	        for (String dept : deptSalary.keySet()) {
	            if (deptSalary.get(dept) > maxSalary) {
	                maxSalary = deptSalary.get(dept);
	                highestDept = dept;
	            }
	        }

	        // Result
	        System.out.println("\nDepartment with Highest Total Salary:");
	        System.out.println(highestDept + " = " + maxSalary);
	    }

}
