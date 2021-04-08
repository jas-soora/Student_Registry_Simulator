//Jastejpal Soora - 500964180

public class Course 
{
	private String code;
	private String name;
	private String description;
	private String format;
	   
	public Course()
	{
	  this.code        = "";
	  this.name        = "";
	  this.description = "";
	  this.format      = "";
	}
	   
	public Course(String name, String code, String descr, String fmt)
	{
	  this.code        = code;
	  this.name        = name;
	  this.description = descr;
	  this.format      = fmt;
	}
	   
	public String getCode()
	{
	   return code;
	}
	   
	public String getName()
	{
	  return name;
	}
	   
	public String getFormat()
	{
	  return format;
	}
	   
	public String getDescription()
	{
	  return code + " - " + name + "\n" + description;
	}
	
	public String getInfo()
	{
		return code + " - " + name;
	}
	 
	 // static method to convert numeric score to letter grade string 
	 // e.g. 91 --> "A+"
	public static String convertNumericGrade(double score)
	{
		// fill in code
		if(score >= 91)
		{
			return "A+";
		}
		else if(score >= 81)
		{
			return "A";
		}
		else if(score >= 71)
		{
			return "B";
		}
		else if(score >= 61)
		{
			return "C";
		}
		else if(score >= 51)
		{
			return "D";
		}
		return "F";
	}
	 
}
