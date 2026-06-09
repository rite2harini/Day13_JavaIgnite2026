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
public class PerformanceAnalyzer {
    public static void main(String[] args) {
    	 ArrayList<Student> list = new ArrayList<>();
    	 list.add(new Student("Amit", "Java", 80));
         list.add(new Student("Riya", "Java", 90));
         list.add(new Student("Rahul", "Python", 85));
         list.add(new Student("Sneha", "Python", 95));
         list.add(new Student("Ankit", "C++", 70));
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

         String bestCourse = "";
         double highestAvg = 0;
    }
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
    }
