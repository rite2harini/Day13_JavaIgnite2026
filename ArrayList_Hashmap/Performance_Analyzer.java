main
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
main
