//Jastejpal Soora - 500964180

import java.util.ArrayList;

public class CreditCourse extends Course
{
	// add a constructor method with appropriate parameters
	// should call the super class constructor
	private String semester;
	private double grade;
	private boolean active;
	public ArrayList<String> activeCourse = new ArrayList<String>();


	public CreditCourse(String name, String code, String descr, String fmt,String semester, double grade)
	{
		// add code
		super(name, code, descr, fmt);
		this.semester = semester;
		this.grade = grade;
	}

	//get double value of grade - added
	public double Grade()
	{
		return grade;
	}

	//sets grade - added
	public void setGrade(double marks)
	{
		grade = marks;
	}

	//returns semester - added
	public String getSemester()
	{
		return semester;
	}

	//returns active course - added
	public String returnActive()
	{
		if(active)
		{
			return getCode();
		}
		return null;
	}

	public boolean getActive() //unused
	{
		// add code and remove line below
		if(active == false)
		{
			return false;
		}
		return true;
	}
	
	public void setActive()
	{
		// add code
		active = true;
	}
	
	public void setInactive()
	{
		// add code
		active = false;
	}
	
	public String displayGrade()
	{
		// Change line below and print out info about this course plus which semester and the grade achieved
		// make use of inherited method in super class
		return super.getDescription() + semester + grade;
	}
	
}