/*
Create a Java program to manage student course performance.

Task:

You are given multiple students with the following details:

Student Name
Course Name
Marks
Requirements:
Store all student records using ArrayList
Use a HashMap<String, List<Integer>> where:
Key = Course Name
Value = List of marks in that course
Calculate and display:
Average marks for each course
Course with highest average
Hint:

Break the problem into steps:

First store raw data in ArrayList
Then group marks by course using HashMap

for each loop - enhanced for loop 
for(int i=0;i<list.size();i++)
Student s=list.get(i)

for(Student s : list)
String course = s.course 
int marks = s.marks 
if(map.containsKey(course))
ArrayList<Integer> marksList = map.get(course)
marksList.add(marks)

ArrayList<Integer> marksList = map.get(course)
marksList.add(marks)
map.put(course,marksList)


Then iterate HashMap to calculate averages - for(String course:map.keySet())- creating arraylist -int sum =0, 
for(int i=0;i<marksList.size();i++)
sum=sum+marksList(i)
double =(double)sum/marksList.size();


Finally compare averages
  */
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

public class CoursePerformanceManager {
    public static void main(String[] args) {
        // Step 1: Store raw data in ArrayList
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Java", 85));
        students.add(new Student("Bob", "Python", 78));
        students.add(new Student("Charlie", "Java", 92));
        students.add(new Student("David", "Python", 88));
        students.add(new Student("Eve", "Java", 76));
        students.add(new Student("Frank", "Python", 95));
        students.add(new Student("Grace", "DSA", 82));
        students.add(new Student("Hank", "DSA", 89));
        students.add(new Student("Ivy", "Java", 90));
        students.add(new Student("Jack", "DSA", 74));
        
        // Step 2: Group marks by course using HashMap
        HashMap<String, List<Integer>> courseMarksMap = new HashMap<>();
        
        // Enhanced for loop to group marks
        for(Student s : students) {
            String course = s.course;
            int marks = s.marks;
            
            if(courseMarksMap.containsKey(course)) {
                ArrayList<Integer> marksList = (ArrayList<Integer>) courseMarksMap.get(course);
                marksList.add(marks);
            } else {
                ArrayList<Integer> marksList = new ArrayList<>();
                marksList.add(marks);
                courseMarksMap.put(course, marksList);
            }
        }
        
        System.out.println("Course-wise Marks Grouping: " + courseMarksMap);
        System.out.println("\n--- Course Performance Analysis ---");
        
        // Step 3: Calculate averages and find course with highest average
        String bestCourse = "";
        double highestAverage = 0;
        
        for(String course : courseMarksMap.keySet()) {
            ArrayList<Integer> marksList = (ArrayList<Integer>) courseMarksMap.get(course);
            
            // Calculate sum of marks
            int sum = 0;
            for(int i = 0; i < marksList.size(); i++) {
                sum = sum + marksList.get(i);
            }
            
            // Calculate average
            double average = (double) sum / marksList.size();
            
            System.out.printf("%-10s Marks: %-15s Average: %.2f%n", 
                            course, marksList, average);
            
            // Comparison logic
            if(average > highestAverage) {
                highestAverage = average;
                bestCourse = course;
            }
        }
        
        System.out.println("\n--- Result ---");
        System.out.println("Course with highest average: " + bestCourse + 
                          " (Average: " + String.format("%.2f", highestAverage) + ")");
    }
}
