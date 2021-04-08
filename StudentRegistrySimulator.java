//Jastejpal Soora - 500964180

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentRegistrySimulator 
{
  public static void main(String[] args)
  {
	  //try{
	  Registry registry = new Registry();
	  Scheduler scheduler = new Scheduler(registry.returnCourse());
	  
	  Scanner scanner = new Scanner(System.in);
	  System.out.print(">");
	  
	  while (scanner.hasNextLine())
	  {
		  try{
		  String inputLine = scanner.nextLine();
		  if (inputLine == null || inputLine.equals("")) continue;
		  
		  Scanner commandLine = new Scanner(inputLine);
		  String command = commandLine.next();
		  
		  if (command == null || command.equals("")) continue;
		  
		  else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
		  {
			  registry.printAllStudents();
		  }
		  else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
			  return;
		  
		  else if (command.equalsIgnoreCase("REG"))
		  {
			  // register a new student in registry
			  // get name and student id string 
			  // e.g. reg JohnBoy 74345
			  // Checks:
			  //  ensure name is all alphabetic characters
			  //  ensure id string is all numeric characters
			  
			  String name = commandLine.next();
			  if(isStringOnlyAlphabet(name))
			  {
				  if(commandLine.hasNext())
				  {
						String id = commandLine.next();
						if(isNumeric(id))
						{
							registry.addNewStudent(name, id);
						}
						else
						{
							System.out.println("Invalid characters in ID " + id);
						}
				  }

			  }
			  else
			  {
				  System.out.println("Invalid characters in name " + name);
			  }
			  
		  }
		  else if (command.equalsIgnoreCase("DEL"))
		  {
			  // delete a student from registry
			  // get student id
			  // ensure numeric
			  // remove student from registry

			  String id = commandLine.next();
			  registry.registered(id); //isNumeric method is used in method "registered" in class registry
			  registry.removeStudent(id);
		  }
		  
		  else if (command.equalsIgnoreCase("ADDC"))
		  {
			 // add a student to an active course
			 // get student id and course code strings
			 // add student to course (see class Registry)
			  
			 String id = commandLine.next();
			 String code = commandLine.next();
			 registry.registered(id);
			 registry.checkCourse(code);
			 registry.addCourse(id, code);
		  }

		  else if(command.equalsIgnoreCase("PAS"))
		  {
			  registry.printAllStudents();
		  }
		  
		  else if (command.equalsIgnoreCase("DROPC"))
		  {
			  // get student id and course code strings
			  // drop student from course (see class Registry)

			  String id = commandLine.next();
			  String code = commandLine.next();
			  registry.registered(id);
			  registry.checkCourse(code);
			  registry.dropCourse(id, code);
		  }
		  else if (command.equalsIgnoreCase("PAC"))
		  {
			  // print all active courses
			  registry.printActiveCourses();
		  }		  
		  else if (command.equalsIgnoreCase("PCL"))
		  {
			  // get course code string
			  // print class list (i.e. students) for this course
			  
			  String code = commandLine.next();
			  registry.checkCourse(code);
			  registry.printClassList(code);
		  }
		  else if (command.equalsIgnoreCase("PGR"))
		  {
			  // get course code string
			  // print name, id and grade of all students in active course

			  String code = commandLine.next();
			  registry.checkCourse(code);
			  registry.printGrades(code);
		  }
		  else if (command.equalsIgnoreCase("PSC"))
		  {
			  // get student id string
			  // print all credit courses of student
			  
			  String id = commandLine.next();
			  registry.registered(id);
			  registry.printStudentCourses(id);
		  }
		  else if (command.equalsIgnoreCase("PST"))
		  {
			  // get student id string
			  // print student transcript
			  
			  String id = commandLine.next();
			  registry.registered(id);
			  registry.printStudentTranscript(id);
		  }
		  else if (command.equalsIgnoreCase("SFG"))
		  {
			  // set final grade of student
			  // get course code, student id, numeric grade
			  // use registry to set final grade of this student (see class Registry)

			  String code = commandLine.next();
			  String id = commandLine.next();
			  double gr = commandLine.nextDouble();
			  registry.registered(id);
			  registry.checkCourse(code);
			  registry.setFinalGrade(code, id, gr);
		  }
		  else if (command.equalsIgnoreCase("SCN"))
		  {
			  // get course code
			  // sort list of students in course by name (i.e. alphabetically)
			  // see class Registry

			  String code = commandLine.next();
			  registry.checkCourse(code);
			  registry.sortCourseByName(code);
			  
		  }
		  else if (command.equalsIgnoreCase("SCI"))
		  {
			// get course code
			// sort list of students in course by student id
			// see class Registry

			String code = commandLine.next();
			registry.checkCourse(code);
			registry.sortCourseById(code);
		  }
		  else if(command.equalsIgnoreCase("SCH"))
		  {
			  String code = commandLine.next();
			  String day = commandLine.next();
			  int start = commandLine.nextInt();
			  int duration = commandLine.nextInt();
			  registry.checkCourse(code);
			  scheduler.setDayAndTime(code, day, start, duration);
		  }
		  else if(command.equalsIgnoreCase("CSCH"))
		  {
			  String code = commandLine.next();
			  registry.checkCourse(code);
			  scheduler.clearSchedule(code);
		  }
		  else if(command.equalsIgnoreCase("PSCH"))
		  {
			  scheduler.printSchedule();
		  }
		  else
		  {
			  System.out.println("Sorry, the command you just entered was not recognized");
		  }
		  commandLine.close();
		}
		catch(UnknownCourseException e)
		{
			//e.getStackTrace();
			System.out.print(e.getMessage());
		}
		catch(InvalidTimeException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InvalidDayException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InvalidDurationException e)
		{
			System.out.println(e.getMessage());
		}
		catch(LectureTimeCollisionException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Invalid input, please double-check.");
		}
		System.out.print("\n>");
	  }
	  scanner.close();
	}
  
  
  public static boolean isStringOnlyAlphabet(String str) 
  { 
	  // write method to check if string str contains only alphabetic characters
	  str = str.toLowerCase();

	  for(int i = 0; i<str.length(); i++)
	  {
		  char ch = str.charAt(i);
		  if(!(ch >= 'a' && ch <= 'z'))
		  {
			  return false;
		  }
	  }
	  return true;
  } 
  
  public static boolean isNumeric(String str)
  {
	  // write method to check if string str contains only numeric characters
		//String num = "0123456789";
		for(int i = 0; i<str.toCharArray().length; i++)
		{
			if(!Character.isDigit(str.toCharArray()[i]))
			{
				return false;
			}
		}
		return true;
  }
  
  
}