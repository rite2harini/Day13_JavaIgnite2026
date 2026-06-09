public class CoursePerformance {
	 public static void main(String[] args) {

	        // Store student records in ArrayList
	        ArrayList<Student> students = new ArrayList<>();

	        students.add(new Student("Rahul", "Java", 85));
	        students.add(new Student("Priya", "Java", 90));
	        students.add(new Student("Amit", "Python", 78));
	        students.add(new Student("Sneha", "Python", 88));
	        students.add(new Student("Riya", "C++", 92));
	        students.add(new Student("Karan", "C++", 86));

	        // HashMap<Course, List of Marks>
	        HashMap<String, List<Integer>> courseMarks = new HashMap<>();

	        // Group marks by course
	        for (Student s : students) {
	            courseMarks.putIfAbsent(s.courseName, new ArrayList<>());
	            courseMarks.get(s.courseName).add(s.marks);
	        }

	        // Calculate averages
	        String highestCourse = "";
	        double highestAverage = 0;

	        System.out.println("Average Marks for Each Course:");

	        for (String course : courseMarks.keySet()) {
	            List<Integer> marksList = courseMarks.get(course);

	            int sum = 0;
	            for (int mark : marksList) {
	                sum += mark;
	            }

	            double average = (double) sum / marksList.size();

	            System.out.println(course + " = " + average);

	            if (average > highestAverage) {
	                highestAverage = average;
	                highestCourse = course;
	            }
	        }

	        // Display course with highest average
	        System.out.println("\nCourse with Highest Average:");
	        System.out.println(highestCourse + " = " + highestAverage);
	    }
	}


