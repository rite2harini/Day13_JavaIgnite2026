package JAVA_DAY_13;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Students {
    String studentName;
    String courseName;
    int marks;

    Students(String studentName, String courseName, int marks) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.marks = marks;
    }
}

public class PERFORMANCES_ANALYZER {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        ArrayList<Students> students = new ArrayList<>();

        students.add(new Students("STWATRA", "Java", 95));
        students.add(new Students("SUBHENDU", "Java", 80));
        students.add(new Students("HRUSHIKESH", "Python", 75));
        students.add(new Students("SREETI", "Python", 65));
        students.add(new Students("BALDEV", "Data Structure", 90));
        students.add(new Students("ARPITA", "Data Structure", 80));

        HashMap<String, List<Integer>> courseMarks = new HashMap<>();

        for (Students s : students) {

            if (!courseMarks.containsKey(s.courseName)) {
                courseMarks.put(s.courseName, new ArrayList<Integer>());
            }

            courseMarks.get(s.courseName).add(s.marks);
        }
        HashMap<String, Double> courseAverage = new HashMap<>();

        System.out.println("Average Marks by Course:");

        for (String course : courseMarks.keySet()) {

            List<Integer> marksList = courseMarks.get(course);

            int sum = 0;

            for (int mark : marksList) {
                sum += mark;
            }

            double average = (double) sum / marksList.size();

            courseAverage.put(course, average);

            System.out.println(course + " -> " + average);
        }
        String highestCourse = "";
        double highestAverage = 0;

        for (String course : courseAverage.keySet()) {

            if (courseAverage.get(course) > highestAverage) {
                highestAverage = courseAverage.get(course);
                highestCourse = course;
            }
        }

        System.out.println("\nCourse with Highest Average:");
        System.out.println(highestCourse + " -> " + highestAverage);
    }
}
