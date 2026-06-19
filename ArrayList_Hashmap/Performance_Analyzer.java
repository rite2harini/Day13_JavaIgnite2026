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
import java.util.Scanner;

class Student {
    String name;
    String course;
    int marks;

    public Student(String name, String course, int marks) {
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
}

public class CoursePerformanceManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        try {
            int numberOfStudents = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numberOfStudents; i++) {
                String name = scanner.nextLine();
                String course = scanner.nextLine();
                int marks = Integer.parseInt(scanner.nextLine());
                list.add(new Student(name, course, marks));
            }

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
            double highestAverage = -1.0;

            for (String course : map.keySet()) {
                ArrayList<Integer> marksList = map.get(course);
                int sum = 0;
                
                for (int i =
