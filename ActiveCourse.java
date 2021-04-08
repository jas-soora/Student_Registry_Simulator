//Jastejpal Soora - 500964180

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Active University Course
 
public class ActiveCourse extends Course
{
	private ArrayList<Student> students; 
   private String             semester;
   private int lectureStart;
   private int lectureDuration;
   private String lectureDay;
	   
   // Add a constructor method with appropriate parameters
   // should call super class constructor to initialize inherited variables
   // make sure to *copy* students array list being passed in into new arraylist of students
   // see class Registry to see how an ActiveCourse object is created and used
   public ActiveCourse(String name, String code, String descr, String fmt, String semester,ArrayList<Student> students)
   {
      super(name, code, descr, fmt);
      this.semester = semester;
      this.students = new ArrayList<>(students);
   }

   //added
   public void dayandtime(int start, int dur, String Day)
   {
      lectureStart = start;
      lectureDuration = dur;
      lectureDay = Day;
   }

   //added
   public void clear()
   {
      lectureStart = 0;
      lectureDuration = 0;
      lectureDay = "";
   }

   //added
   public String getDay()
   {
      return lectureDay;
   }

   //added
   public int getStart()
   {
      return lectureStart;
   }

   //added
   public int getDuration()
   {
      return lectureDuration;
   }

   public String getSemester()
   {
	   return semester;
   }

   //return list of students in active course - added
   public ArrayList<Student> getStudents()
   {
      return students;
   }
   
   // Prints the students in this course  (name and student id)
   public void printClassList()
   {
      for(int i=0; i<students.size(); i++)
      {
         System.out.println("ID: " + students.get(i).getId() + " Name: " + students.get(i).getName());
      }
   }
   
   // Prints the grade of each student in this course (along with name and student id)
   public void printGrades()
   {
      for(int i=0; i<students.size(); i++)
      {                                                                                         //converting double value to string and passing student id as parameters
         System.out.println(students.get(i).getId() + " " + students.get(i).getName() + " " + String.valueOf(getGrade(students.get(i).getId())));
      }
   }
   
   // Returns the numeric grade in this course for this student
   // If student not found in course, return 0 
   public double getGrade(String studentId)
   {
	  // Search the student's list of credit courses to find the course code that matches this active course
	  // see class Student method getGrade() 
     // return the grade stored in the credit course object
     String courseCode = super.getCode();

     for(int i = 0; i<students.size(); i++)
     {
        if(students.get(i).getId().equals(studentId))
        {
           for(int j = 0; j<students.get(i).getCourses().size(); j++)
           {
              if(students.get(i).getCourses().get(j).getCode().equalsIgnoreCase(courseCode))
              {
                  return students.get(i).getCourses().get(j).Grade();
              }
           }
        }
     }
     return 0;
   }
   
   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // must override method in the superclass Course and use super class method getDescription()
   public String getDescription()
   {
	   return super.getDescription() + "\n" + semester + " Enrolment: " + students.size();
   }
   
   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortByName()
   {
      Collections.sort(students, new NameComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student name
   private class NameComparator implements Comparator<Student>
   { 
      public int compare(Student s1, Student s2)
      {
         return s1.getName().compareToIgnoreCase(s2.getName());
      }
   }
   
   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortById()
   {
      Collections.sort(students, new IdComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student id
   private class IdComparator implements Comparator<Student>
   {
      public int compare(Student id1, Student id2)
      {
         return id1.getId().compareTo(id2.getId());
      }
   }
}
