import java.util.*;

class Student {
    String name;
    String course;
    int marks;

    Student(String name, String course, int marks) {
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
}

public class PerformanceAnalyzer {
    public static void main(String[] args) {

        // Store students in ArrayList
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Amit", "Java", 80));
        list.add(new Student("Riya", "Java", 90));
        list.add(new Student("Rahul", "Python", 85));
        list.add(new Student("Sneha", "Python", 95));
        list.add(new Student("Ankit", "C++", 70));

        // Group marks by course
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for (Student s : list) {
            String course = s.course;
            int marks = s.marks;

            if (map.containsKey(course)) {
                ArrayList<Integer> marksList = map.get(course);
                marksList.add(marks);
            } else {
                ArrayList<Integer> marksList = new ArrayList<>();
                marksList.add(marks);
                map.put(course, marksList);
            }
        }

        // Calculate average and find highest average
        String bestCourse = "";
        double highestAvg = 0;

        System.out.println("Average Marks:");

        for (String course : map.keySet()) {

            ArrayList<Integer> marksList = map.get(course);

            int sum = 0;
            for (int i = 0; i < marksList.size(); i++) {
                sum += marksList.get(i);
            }

            double avg = (double) sum / marksList.size();

            System.out.println(course + " = " + avg);

            if (avg > highestAvg) {
                highestAvg = avg;
                bestCourse = course;
            }
        }

        System.out.println("\nCourse with Highest Average:");
        System.out.println(bestCourse + " = " + highestAvg);
    }
}
