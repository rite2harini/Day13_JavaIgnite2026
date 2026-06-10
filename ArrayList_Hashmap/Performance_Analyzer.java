import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Student {
    String studentName;
    String courseName;
    int marks;

    Student(String studentName, String courseName, int marks) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.marks = marks;
    }
}

public class CoursePerformance {
	 public static void main(String[] args) {

	        ArrayList<Student> students = new ArrayList<>();

	        students.add(new Student("Rahul", "Java", 85));
	        students.add(new Student("Priya", "Java", 90));
	        students.add(new Student("Amit", "Python", 78));
	        students.add(new Student("Sneha", "Python", 88));
	        students.add(new Student("Riya", "C++", 92));
	        students.add(new Student("Karan", "C++", 86));

	        HashMap<String, List<Integer>> courseMarks = new HashMap<>();

	        for (Student s : students) {
	            courseMarks.putIfAbsent(s.courseName, new ArrayList<>());
	            courseMarks.get(s.courseName).add(s.marks);
	        }

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

	        System.out.println("\nCourse with Highest Average:");
	        System.out.println(highestCourse + " = " + highestAverage);
	    }

}
