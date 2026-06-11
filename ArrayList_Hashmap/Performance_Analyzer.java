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

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Aman", "Java", 85));
        list.add(new Student("Rahul", "Java", 90));
        list.add(new Student("Priya", "Python", 95));
        list.add(new Student("Riya", "Python", 80));
        list.add(new Student("Karan", "SQL", 88));

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

        String highestCourse = "";
        double highestAverage = 0;

        for (String course : map.keySet()) {
            ArrayList<Integer> marksList = map.get(course);

            int sum = 0;
            for (int i = 0; i < marksList.size(); i++) {
                sum += marksList.get(i);
            }

            double average = (double) sum / marksList.size();

            System.out.println(course + " Average = " + average);

            if (average > highestAverage) {
                highestAverage = average;
                highestCourse = course;
            }
        }

        System.out.println("Course with Highest Average: " + highestCourse);
        System.out.println("Highest Average: " + highestAverage);
    }
}
