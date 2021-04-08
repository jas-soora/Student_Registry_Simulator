//Jastejpal Soora - 500964180

import java.util.Set;
import java.util.TreeMap;

public class Scheduler 
{
    // In main() after you create a Registry object, create a Scheduler object and pass in the courses ArrayList/TreeMap
	// If you do not want to try using a Map then uncomment
	// the line below and comment out the TreeMap line
	
	//ArrayList<Student> students;
	private TreeMap<String,ActiveCourse> schedule = new TreeMap<String,ActiveCourse>();
		
	public Scheduler(TreeMap<String,ActiveCourse> courses)
	{
	  schedule = courses;
	}
	
	public void setDayAndTime(String courseCode, String day, int startTime, int duration) throws UnknownCourseException,
			InvalidTimeException, InvalidDayException, InvalidDurationException, LectureTimeCollisionException
	{
		// see assignment doc

		if(!schedule.containsKey(courseCode.toUpperCase()))
		{
			throw new UnknownCourseException("The given course code could not be found: " + courseCode);
		}
		if(!checkDay(day))
		{
			throw new InvalidDayException("The given lecture day is invalid. Check your spelling and ensure that you inputted a weekday.");
		}
		if(startTime < 800 || startTime > 1700 || startTime + (duration*100) > 1700)
		{
			throw new InvalidTimeException("Invalid lecture start time. The start time of the lecture must be between 800 (8AM) and 1700 (5PM).");
		}
		if(duration > 3 || duration < 1)
		{
			throw new InvalidDurationException("Invalid lecture duration. The lecture duration must be either 1, 2 or 3 hours.");
		}
		if(checkCollision(day, startTime, duration))
		{
			throw new LectureTimeCollisionException("Lecture Time Collision. There is already a course scheduled at this given day and time.");
		}
		schedule.get(courseCode.toUpperCase()).dayandtime(startTime, duration, day);
	}
	
	public void clearSchedule(String courseCode)
	{
		// see Assignment doc
		Set<String> codes = schedule.keySet();
		for(String code : codes)
		{
			if(courseCode.equalsIgnoreCase(code))
			{
				schedule.get(courseCode.toUpperCase()).clear();
			}
		}
	}
		
	public void printSchedule()
	{
		// see assignment doc 39

		Set<String> Courses = schedule.keySet();
		String matrix[][] = {
			{" ","Mon","Tue","Wed","Thu","Fri"},
			{"800"," "," "," "," "," "},
			{"900"," "," "," "," "," "},
			{"1000"," "," "," "," "," "},
			{"1100"," "," "," "," "," "},
			{"1200"," "," "," "," "," "},
			{"1300"," "," "," "," "," "},
			{"1400"," "," "," "," "," "},
			{"1500"," "," "," "," "," "},
			{"1600"," "," "," "," "," "},	
		};
		
		for(int i = 0; i<matrix.length; i++)
		{
			for(int j = 0; j<matrix[i].length; j++)
			{	
				for(String code : Courses) //make it so that values are not taken alphabetically from treemap so courses can be overwritten
				{
					if(matrix[i][0].equalsIgnoreCase(String.valueOf(schedule.get(code).getStart())) && matrix[0][j].equalsIgnoreCase(schedule.get(code).getDay()))
					{
						for(int k = 0; k<schedule.get(code).getDuration(); k++)
						{
							matrix[i+k][j] = code;
						}
					}				
				}
				System.out.print(matrix[i][j] +"\t");
				
			}
			System.out.print("\n");
		}

	}

	public boolean checkDay(String weekday)
	{
		String Weekday[] = {"Mon","Tue","Wed","Thu","Fri"};
		for(String Day : Weekday)
		{
			if(Day.equalsIgnoreCase(weekday))
			{
				return true;
			}
		}
		return false;
	}

	public boolean validTime(String code, int time, int Duration)
	{
		if(time < 800 || time > 1700)
		{
			System.out.println("The start time must be between 800 (8AM) and 1700 (5PM)");
			return false;
		}
		else if(time + (Duration*100) > 1700)
		{
			System.out.println("The duration of your lecture cannot exceed 1700 (5PM). Please try a different start time for the lecture or decrease the lecture duration.");
			return false;
		}
		return true;
	}

	public boolean checkCollision(String Day, int time, int Duration)
	{
		Set<String> codes = schedule.keySet();
		for(String code : codes)
		{	
			if(Day.equalsIgnoreCase(schedule.get(code).getDay()))
			{
				ActiveCourse otherCourse = schedule.get(code); //start time of a course
				if(otherCourse.getStart() == time)
				{
					return true;
				}			
				if(time < (otherCourse.getStart() + (otherCourse.getDuration()*100)))
				{
					if(time > otherCourse.getStart())
					{
						return true;
					}
				}
				if(time < otherCourse.getStart())
				{
					if((time + (Duration*100)) > otherCourse.getStart())
					{
						return true;
					}
				}

			}
		}
		return false;
	}
	
}

class UnknownCourseException extends Exception
{
	public UnknownCourseException(String message)
	{
		super(message);
	}
}

class InvalidDayException extends Exception
{
	public InvalidDayException(String message)// (String message)
	{
		super(message);
	}
}

class InvalidTimeException extends Exception
{
	public InvalidTimeException(String message)
	{
		super(message);
	}
}

class InvalidDurationException extends Exception
{
	public InvalidDurationException(String message)
	{
		super(message);
	}
}

class LectureTimeCollisionException extends Exception
{
	public LectureTimeCollisionException(String message)
	{
		super(message);
	}
}

