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

public class Performance_Analyzer {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Ritesh", "Math", 85));
        list.add(new Student("Vishwash", "Math", 90));
        list.add(new Student("Biswas", "Science", 70));
        list.add(new Student("Rohit", "Science", 80));
        list.add(new Student("Binayak", "English", 60));
        list.add(new Student("Aryan", "English", 75));
        list.add(new Student("Sachi", "Math", 78));
        HashMap<String, List<Integer>> courseMarks = new HashMap<>();
        for (Student s : list) {
            if (!courseMarks.containsKey(s.course)) {
                courseMarks.put(s.course, new ArrayList<>());
            }
            courseMarks.get(s.course).add(s.marks);
        }
        HashMap<String, Double> avgMap = new HashMap<>();
        for (String course : courseMarks.keySet()) {
            List<Integer> marks = courseMarks.get(course);
            int sum = 0;
            for (int m : marks) {
                sum += m;
            }
            double avg = (double) sum / marks.size();
            avgMap.put(course, avg);
        }
        System.out.println("Course averages:");
        for (String course : avgMap.keySet()) {
            System.out.println(course + " -> " + avgMap.get(course));
        }
        String topCourse = "";
        double max = 0;
        for (String course : avgMap.keySet()) {
            if (avgMap.get(course) > max) {
                max = avgMap.get(course);
                topCourse = course;
            }
        }

        System.out.println("\nTop course: " + topCourse + " (" + max + ")");
    }
}