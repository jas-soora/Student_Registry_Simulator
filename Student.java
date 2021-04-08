//Jastejpal Soora - 500964180

import java.util.ArrayList;

// Make class Student implement the Comparable interface
// Two student objects should be compared by their name
public class Student// implements Comparable<Student>
{
  private String name;
  private String id;
  private ArrayList<CreditCourse> courses = new ArrayList<CreditCourse>();
  
  
  public Student(String name, String id)
  {
	 this.name = name;
   this.id   = id;
  }

  public String getId()
  {
	  return id;
  }
  
  public String getName()
  {
	  return name;
  }

  //returns list of courses - added
  public ArrayList<CreditCourse> getCourses()
  {
    return courses;
  }
  
  // add a credit course to list of courses for this student
  public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
  {
	  // create a CreditCourse object
	  // set course active
    // add to courses array list
    CreditCourse creditCourse = new CreditCourse(courseName, courseCode, descr, format, sem, grade);
    creditCourse.setActive();
    courses.add(creditCourse);
  }
  
  // Prints a student transcript
  // Prints all completed (i.e. non active) courses for this student (course code, course name, 
  // semester, letter grade
  // see class CreditCourse for useful methods
  public void printTranscript()
  {
    for(int i=0; i<courses.size(); i++)
    {
      if(courses.get(i).getActive() == false)
      {
        System.out.println(courses.get(i).getCode() + " " + courses.get(i).getName() + " " + courses.get(i).getSemester() + ", Grade: " + Course.convertNumericGrade(courses.get(i).Grade()));
      }
    }
  }
  
  // Prints all active courses this student is enrolled in
  // see variable active in class CreditCourse
  public void printActiveCourses()
  {
    ArrayList<String> enrolledIn = new ArrayList<String>();
    for(int i=0; i<courses.size(); i++)
    {
      enrolledIn.add(courses.get(i).returnActive());
    }
    System.out.println(enrolledIn);
  }
  
  // Drop a course (given by courseCode)
  // Find the credit course in courses arraylist above and remove it
  // only remove it if it is an active course
  public void removeActiveCourse(String courseCode)
  {
    for(int i=0; i<courses.size(); i++)
    {
      if(courses.get(i).returnActive().equals(courseCode))
      {
        courses.remove(i);
      }
    }
  }
  
  public String toString()
  {
	  return "Student ID: " + id + " Name: " + name;
  }
  
  // override equals method inherited from superclass Object
  // if student names are equal *and* student ids are equal (of "this" student
  // and "other" student) then return true
  // otherwise return false
  // Hint: you will need to cast other parameter to a local Student reference variable
  public boolean equals(Object other) 
  {
	  return false; // unused
  }
  
}
