 public static void main(String[] args) {

	        // Store employees in ArrayList
	        ArrayList<Employee> employees = new ArrayList<>();

	        employees.add(new Employee(101, "IT", 50000));
	        employees.add(new Employee(102, "HR", 30000));
	        employees.add(new Employee(103, "IT", 60000));
	        employees.add(new Employee(104, "Finance", 70000));
	        employees.add(new Employee(105, "HR", 40000));

	        // HashMap: Department -> Total Salary
	        HashMap<String, Double> deptSalary = new HashMap<>();

	        // Summation Logic
	        for (Employee emp : employees) {
	            deptSalary.put(
	                emp.department,
	                deptSalary.getOrDefault(emp.department, 0.0) + emp.salary
	            );
	        }

	        // Display total salary of each department
	        System.out.println("Department Wise Total Salary:");
	        for (String dept : deptSalary.keySet()) {
	            System.out.println(dept + " = " + deptSalary.get(dept));
	        }

	        // Comparison Logic
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



