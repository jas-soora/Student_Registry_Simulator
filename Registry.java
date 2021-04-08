//Jastejpal Soora - 500964180

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

public class Registry
{	/*
   private ArrayList<Student> students = new ArrayList<Student>();
   private ArrayList<ActiveCourse> courses  = new ArrayList<ActiveCourse>();
   */
	private TreeMap<String, Student> students = new TreeMap<String, Student>();
	private TreeMap<String, ActiveCourse> courses = new TreeMap<String, ActiveCourse>();
   
   public Registry()
   {
	// Add some students
	   // in A2 we will read from a file
	   File newfile = new File("students.txt");
	   readFile(newfile);
		
	   /*
	   Student s1 = students.get("34562");
	   Student s2 = students.get("38467");
	   Student s3 = students.get("98345");
	   Student s4 = students.get("57643");
	   Student s5 = students.get("25347");
	   Student s6 = students.get("46532");
	   
	   students.add(s1);
	   students.add(s2);
	   students.add(s3);
	   students.add(s4);
	   students.add(s5);
	   students.add(s6);
	   */

	   // sort the students alphabetically - see class Student
	   
	   ArrayList<Student> list = new ArrayList<Student>();
	   
	   // Add some active courses with students

	   //CPS209
	   String courseName = "Computer Science II";
	   String courseCode = "CPS209";
	   String descr = "Learn how to write complex programs!";
	   String format = "3Lec 2Lab";
	   //list.add(s2); list.add(s3); list.add(s4);
	   //courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   // Add course to student list of courses
	   //s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   //s3.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   //s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	  
	   // CPS511
	   list.clear();
	   courseName = "Computer Graphics";
	   courseCode = "CPS511";
	   descr = "Learn how to write cool graphics programs";
	   format = "3Lec";
	   //list.add(s1); list.add(s5); list.add(s6);
	   //courses.add(new ActiveCourse(courseName,courseCode,descr,format,"F2020",list));
	   courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"F2020",list));
	   /*
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s5.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0);
	   */
	   
	   // CPS643
	   list.clear();
	   courseName = "Virtual Reality";
	   courseCode = "CPS643";
	   descr = "Learn how to write extremely cool virtual reality programs";
	   format = "3Lec 2Lab";
	   //list.add(s1); list.add(s2); list.add(s4); list.add(s6);
	   //courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   /*
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   */

		// CPS706
		list.clear();
		courseName = "Computer Networks";
		courseCode = "CPS706";
		descr = "Learn about Computer Networking";
		format = "3Lec 1Lab";
		courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
		
		// CPS616
		list.clear();
		courseName = "Algorithms";
		courseCode = "CPS616";
		descr = "Learn about Algorithms";
		format = "3Lec 1Lab";
		courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   
   }

   //returns treemap of courses
   public TreeMap<String, ActiveCourse> returnCourse()
   {
	   return courses;
   }

   //reads from file and adds student objects to students
   public void readFile(File file)
   {
	   try
	   {
			Scanner sf = new Scanner(file);
		   while(sf.hasNextLine())
		   {
			   String name = sf.next();
			   String id = sf.next();
			   if(StudentRegistrySimulator.isNumeric(id) && StudentRegistrySimulator.isStringOnlyAlphabet(name))
			   {
				   students.put(id, new Student(name, id));
			   }
			   else if(!StudentRegistrySimulator.isNumeric(id) || !StudentRegistrySimulator.isStringOnlyAlphabet(name))
			   {
				   System.out.println("Invalid name or ID in file");
			   }
		   }
		   sf.close();
	   }
	   catch(FileNotFoundException exception)
	   {
		   System.out.println("students.txt File Not Found");
	   }
	   catch(NoSuchElementException exception)
	   {
		   System.out.println("Bad File Format in file students.txt");
	   }
   }

   //Checks if student is registered - added
   public boolean registered(String ID)
   {
		boolean r = false;
		if(StudentRegistrySimulator.isNumeric(ID))
		{
			Set<String> studentIDs = students.keySet();
			for(String studentID : studentIDs)
			{
				if(students.get(studentID).getId().equals(ID))
				{
					r = true;
				}
			}
		}
		else
		{
			System.out.println("Invalid characters in ID " + ID);
			return r;
		}

		if(r == false)
		{
			System.out.println("Student not in registry.");
		}
		return r;

		/*
	   if(StudentRegistrySimulator.isNumeric(ID))
	   {
			for(int i = 0; i<students.size(); i++)
			{
				if(students.get(i).getId().equals(ID))
				{
					r = true;
				}
			}
	   }
	   else
	   {
		   System.out.println("Invalid characters in ID " + ID);
		   return r;
	   }

	   if(r == false)
	   {
		   System.out.println("Student not in registry.");
	   }
	   return r;
	   */
   }

   //Checks if course is registered - added
   public boolean checkCourse(String Code)
   {
	   boolean b = false;

	   Set<String> courseMap = courses.keySet();
	   for(String code : courseMap)
	   {
		   if(courses.get(code).getCode().equalsIgnoreCase(Code))
		   {
			   b = true;
		   }
	   }
	   if(!b)
	   {
		   System.out.println("Course does not exist in registry.");
	   }
	   return b;

	   /*
	   for(int i = 0; i<courses.size(); i++)
	   {
		   if(courses.get(i).getCode().equalsIgnoreCase(Code))
		   {
				b = true;
		   }
	   }
	   if(!b)
	   {
		   System.out.println("Course does not exist in registry.");
	   }
	   return b;
	   */
   }
   
   // Add new student to the registry (students arraylist above) 
   public boolean addNewStudent(String Name, String ID)
   {
	   // Create a new student object
	   // check to ensure student is not already in registry
	   // if not, add them and return true, otherwise return false
	   // make use of equals method in class Student
	   /*
	   Student newStudent = new Student(Name, ID);

	   for(int i = 0; i < students.size(); i++)
	   {
		   if(students.get(i).getName().equals(Name) && students.get(i).getId().equals(ID))
		   {
			   System.out.println("Student " + Name + " already registered");
				return false;
		   }
		   if(students.get(i).getId().equals(ID))
		   {
			   System.out.println("ID " + ID + " already exists in registry");
			   return false;
		   }
	   }
		students.add(newStudent);
		return true;
		*/

		Set<String> IDs = students.keySet();
		for(String studentID : IDs)
		{
			if(studentID.equals(ID))
			{
				System.out.println("Student " + ID + " already exists in registry");
				return false;
			}
		}
		students.put(ID, new Student(Name, ID));
		return true;
   }

   // Remove student from registry 
   public boolean removeStudent(String studentId)
   {
	   // Find student in students arraylist
	   // If found, remove this student and return true
	   /*
	   for(int i = 0; i<students.size(); i++)
	   {
			if(students.get(i).getId().equals(studentId))
			{
				students.remove(i);
				return true;
			}
	   }
	   return false;
	   */
	   
	   Set<String> IDs = students.keySet();
	   for(String ID : IDs)
	   {
		   if(ID.equals(studentId))
		   {
			   students.remove(ID);
			   return true;
		   }
	   }
	   return false;
   }
   
   // Print all registered students
   public void printAllStudents()
   {
	   /*
	   for (int i = 0; i < students.size(); i++)
	   {
		   System.out.println("ID: " + students.get(i).getId() + " Name: " + students.get(i).getName());   
	   }
	   */
	  
	   Set<String> IDs = students.keySet();
	   for(String ID : IDs)
	   {
		   System.out.println("ID: " + students.get(ID).getId() + " Name: " + students.get(ID).getName());
	   }
   }
   
   // Given a studentId and a course code, add student to the active course
   public void addCourse(String studentId, String courseCode)
   {
	   // Find student object in registry (i.e. students arraylist)
	   // Check if student has already taken this course in the past Hint: look at their credit course list
	   // If not, then find the active course in courses array list using course code
	   // If active course found then check to see if student already enrolled in this course
	   // If not already enrolled
	   //   add student to the active course
	   //   add course to student list of credit courses with initial grade of 0
	   
	   boolean tookCourse = false;
	   boolean enrolled = false;
	   String studentName = "";

	   Set<String> IDs = students.keySet();
	   for(String ID : IDs)
	   {
		   if(students.get(ID).getId().equals(studentId));
		   {
			   studentName = students.get(ID).getName();

			   for(int i = 0; i < students.get(ID).getCourses().size(); i++)
			   {
				   if(students.get(ID).getCourses().get(i).getCode().equalsIgnoreCase(courseCode));
				   {
					   tookCourse = true;
				   }
			   } 
		   }
	   }

	   if(tookCourse == false)
	   {
		   Set<String> courseMap = courses.keySet();
		   for(String code : courseMap)
		   {
			   if(courses.get(code).getCode().equalsIgnoreCase(courseCode))
			   {
				   CreditCourse cc = new CreditCourse(courses.get(code).getName(), courses.get(code).getCode(), courses.get(code).getDescription(), courses.get(code).getFormat(), courses.get(code).getSemester(), 0);
				   for(int i = 0; i < courses.get(code).getStudents().size(); i++)
				   {
					   if(courses.get(code).getStudents().get(i).getId().equals(studentId))
					   {
						   enrolled = true;
					   }
				   }

				   if(!enrolled)
				   {
					   Student s = new Student(studentName, studentId);
					   courses.get(code).getStudents().add(s);
					   s.getCourses().add(cc);
				   }
			   }
		   }
	   }

	   /*
	   for(int i = 0; i < students.size(); i++)
	   {
		   if(students.get(i).getId().equals(studentId)) //checks if student is in registry
		   {
				studentName = students.get(i).getName();

			   for(int j = 0; j < students.get(i).getCourses().size(); j++)
			   {
					if(students.get(i).getCourses().get(j).getCode().equalsIgnoreCase(courseCode)) //checks if course was taken in the past by checking list of courses from class Student
					{
						tookCourse = true;
					}
			   }
		   }
	   }

	   if(tookCourse == false)
	   {
			for(int i = 0; i<courses.size(); i++)
			{
				if(courses.get(i).getCode().equalsIgnoreCase(courseCode)) //checks if course is active
				{
					CreditCourse cc = new CreditCourse(courses.get(i).getName(), courses.get(i).getCode(), courses.get(i).getDescription(), courses.get(i).getFormat(), courses.get(i).getSemester(), 0);
					for(int j = 0; j<courses.get(i).getStudents().size(); j++)
					{
						if(courses.get(i).getStudents().get(j).getId().equals(studentId)) //checks if student is enrolled in the active course
						{
							enrolled = true;
						}
					}
					//adds student to course if not enrolled already
					if(!enrolled)
					{
						Student s = new Student(studentName, studentId);
						courses.get(i).getStudents().add(s);
						s.getCourses().add(cc);
					}
				}
			}
	   }
	   */
   }
   
   // Given a studentId and a course code, drop student from the active course
   public void dropCourse(String studentId, String courseCode)
   {
	   // Find the active course
	   // Find the student in the list of students for this course
	   // If student found:
	   //   remove the student from the active course
	   //   remove the credit course from the student's list of credit courses
	   /*
	   for(int i = 0; i<courses.size(); i++)
	   {
		   if(courses.get(i).getCode().equalsIgnoreCase(courseCode)) //checks if course is in list of courses
		   {
			   for(int j = 0; j<courses.get(i).getStudents().size(); j++)
			   {
				   if(courses.get(i).getStudents().get(j).getId().equals(studentId)) //checks if student is in list of students of the course
				   {
					   for(int k = 0; k<courses.get(i).getStudents().get(j).getCourses().size(); k++)
					   {
							if(courses.get(i).getStudents().get(j).getCourses().get(k).getCode().equalsIgnoreCase(courseCode)) //finds the index of where the course is located so it can be removed from list of credit courses
							{
								courses.get(i).getStudents().get(j).getCourses().remove(k);
							}
					   }
					   courses.get(i).getStudents().remove(j); //removes student from active course
				   }
			   }
		   }
	   }
	   */

	   Set<String> courseMap = courses.keySet();
	   for(String code : courseMap)
	   {
		   if(courses.get(code).getCode().equalsIgnoreCase(courseCode))
		   {
			   for(int i = 0; i < courses.get(code).getStudents().size(); i++)
			   {
				   if(courses.get(code).getStudents().get(i).getId().equals(studentId))
				   {
					   for(int j = 0; j < courses.get(code).getStudents().get(i).getCourses().size(); j++)
					   {
						   if(courses.get(code).getStudents().get(i).getCourses().get(j).getCode().equalsIgnoreCase(courseCode))
						   {
							   courses.get(code).getStudents().get(i).getCourses().remove(j);
						   }
					   }
				   }
			   }
		   }
	   }
   }
   
   // Print all active courses
   public void printActiveCourses()
   {
	   /*
	   for (int i = 0; i < courses.size(); i++)
	   {
		   ActiveCourse ac = courses.get(i);
		   System.out.println(ac.getDescription() + "\n");
	   }
	   */

	   Set<String> courseMap = courses.keySet();
	   for(String code : courseMap)
	   {
		   ActiveCourse ac = courses.get(code);
		   System.out.println(ac.getDescription() + "\n");
	   }
   }
   
   // Print the list of students in an active course
   public void printClassList(String courseCode)
   {
	   /*
	  for(int i = 0; i < courses.size(); i++)
	  {
		  if(courses.get(i).getCode().equalsIgnoreCase(courseCode))
		  {
			  	ArrayList<Student> getKids = courses.get(i).getStudents();
				for(int j = 0; j < getKids.size(); j++)
				{
					System.out.println(getKids.get(j));
				}
		  }
	  }
	  */

	  Set<String> courseMap = courses.keySet();
	  for(String code : courseMap)
	  {
		  if(courses.get(code).getCode().equalsIgnoreCase(courseCode))
		  {
			  ArrayList<Student> getKids = courses.get(code).getStudents();
			  for(int i = 0; i<getKids.size(); i++)
			  {
				  System.out.println(getKids.get(i));
			  }
		  }
	  }
   }
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseByName(String courseCode)
   {
	   /*
	   for(int i = 0; i<courses.size(); i++)
	   {
		   if(courses.get(i).getCode().equalsIgnoreCase(courseCode))
		   {
			   courses.get(i).sortByName();
		   }
	   }
	   */

	   Set<String> courseMap = courses.keySet();
	   for(String code : courseMap)
	   {
		   if(courses.get(code).getCode().equalsIgnoreCase(courseCode))
		   {
			   courses.get(code).sortByName();
		   }
	   }
   }
   
   // Given a course code, find course and sort class list by student ID
   public void sortCourseById(String courseCode)
   {
	   /*
		for(int i = 0; i<courses.size(); i++)
		{
			if(courses.get(i).getCode().equalsIgnoreCase(courseCode))
			{
				courses.get(i).sortById();
			}
		}
		*/

		Set<String> courseMap = courses.keySet();
		for(String code : courseMap)
		{
			if(courses.get(code).getCode().equalsIgnoreCase(courseCode))
			{
				courses.get(code).sortById();
			}
		}
   }
   
   // Given a course code, find course and print student names and grades
   public void printGrades(String courseCode)
   {
	   /*
		for(int i = 0; i<courses.size(); i++)
		{
			if(courses.get(i).getCode().equalsIgnoreCase(courseCode))
			{
				courses.get(i).printGrades();
			}
		}
		*/

		Set<String> courseMap = courses.keySet();
		for(String code : courseMap)
		{
			if(courses.get(code).getCode().equalsIgnoreCase(courseCode))
			{
				courses.get(code).printGrades();
			}
		}
   }
   
   // Given a studentId, print all active courses of student
   public void printStudentCourses(String studentId)
   {
	   /*
	   for(int i = 0; i<students.size(); i++)
	   {
		   if(students.get(i).getId().equals(studentId))
		   {
				ArrayList<CreditCourse> ID = students.get(i).getCourses();
				for(int j = 0; j<ID.size(); j++)
				{
					System.out.println(ID.get(j).getCode() + " - " + ID.get(j).getName());
				}
		   }
	   }
	   */

	   Set<String> IDs = students.keySet();
	   for(String ID : IDs)
	   {
		   if(students.get(ID).getId().equals(studentId))
		   {
			   ArrayList<CreditCourse> studentCourses = students.get(ID).getCourses();
			   for(int i = 0; i<studentCourses.size(); i++)
			   {
				   System.out.println(studentCourses.get(i).getCode() + " - " + studentCourses.get(i).getName());
			   }
		   }
	   }
   }
   
   // Given a studentId, print all completed courses and grades of student
   public void printStudentTranscript(String studentId)
   {
	   /*
	   for(int i = 0; i<students.size(); i++)
	   {
		   if(students.get(i).getId().equals(studentId))
		   {
			   students.get(i).printTranscript();
		   }
	   }
	   */

	   Set<String> IDs = students.keySet();
	   for(String ID : IDs)
	   {
		   if(students.get(ID).getId().equals(studentId))
		   {
			   students.get(ID).printTranscript();
		   }
	   }
   }
   
   // Given a course code, student id and numeric grade
   // set the final grade of the student
   public void setFinalGrade(String courseCode, String studentId, double grade)
   {
	   // find the active course
	   // If found, find the student in class list
	   // then search student credit course list in student object and find course
	   // set the grade in credit course and set credit course inactive
	   /*
	   for(int i = 0; i<courses.size(); i++)
	   {
		   if(courses.get(i).getCode().equalsIgnoreCase(courseCode)) //checks if course code is in active courses
		   {
			   for(int j = 0; j<courses.get(i).getStudents().size(); j++)
			   {
				   if(courses.get(i).getStudents().get(j).getId().equals(studentId)) //checks if studentId is enrolled in the course
				   {
					   for(int k = 0; k<courses.get(i).getStudents().get(j).getCourses().size(); k++)
					   {
						   if(courses.get(i).getStudents().get(j).getCourses().get(k).getCode().equalsIgnoreCase(courseCode)) //finds course in student course list
						   {
								courses.get(i).getStudents().get(j).getCourses().get(k).setGrade(grade); //sets grade
								courses.get(i).getStudents().get(j).getCourses().get(k).setInactive(); //sets course inactive
						   }
					   }
				   }
			   }
		   }
	   }
	   */

	   Set<String> courseMap = courses.keySet();
	   for(String code : courseMap)
	   {
		   if(courses.get(code).getCode().equalsIgnoreCase(courseCode))
		   {
			   for(int i = 0; i<courses.get(code).getStudents().size(); i++)
			   {
				   if(courses.get(code).getStudents().get(i).getId().equals(studentId))
				   {
					   for(int j = 0; j<courses.get(code).getStudents().get(i).getCourses().size(); j++)
					   {
						   if(courses.get(code).getStudents().get(i).getCourses().get(j).getCode().equalsIgnoreCase(courseCode))
						   {
							   courses.get(code).getStudents().get(i).getCourses().get(j).setGrade(grade);
							   courses.get(code).getStudents().get(i).getCourses().get(j).setInactive();
						   }
					   }
				   }
			   }
		   }
	   }
   }
  
}