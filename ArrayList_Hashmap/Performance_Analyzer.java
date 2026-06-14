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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

public class StudentCoursePerformance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<Student>();

        System.out.print("How many students? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for Student " + i + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            System.out.print("Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            list.add(new Student(name, course, marks));
        }

        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        for (Student s : list) {
            String course = s.course;
            int marks = s.marks;

            if (map.containsKey(course)) {
                ArrayList<Integer> marksList = (ArrayList<Integer>) map.get(course);
                marksList.add(marks);
            } else {
                ArrayList<Integer> marksList = new ArrayList<Integer>();
                marksList.add(marks);
                map.put(course, marksList);
            }
        }

        System.out.println("\n===== Average Marks Per Course =====");

        String topCourse = "";
        double topAverage = 0.0;

        for (String course : map.keySet()) {
            List<Integer> marksList = map.get(course);

            int sum = 0;
            for (int i = 0; i < marksList.size(); i++) {
                sum = sum + marksList.get(i);
            }

            double average = (double) sum / marksList.size();

            System.out.println("Course: " + course + " | Average: " + average);

            if (average > topAverage) {
                topAverage = average;
                topCourse = course;
            }
        }

        System.out.println("\n===== Course With Highest Average =====");
        System.out.println("Course: " + topCourse + " | Average: " + topAverage);

        sc.close();
    }
}
