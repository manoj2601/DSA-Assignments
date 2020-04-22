
public class Student implements Student_ {

	String fname;
	String lname;
	String hostel;
	String department;
	String cgpa;
	
	Student(String fname, String lname, String hostel, String department, String cgpa)
	{
		this.fname = fname;
		this.lname = lname;
		this.hostel = hostel;
		this.department = department;
		this.cgpa = cgpa;
	}
	
	@Override
	public String fname() {
		// TODO Auto-generated method stub
		return fname;
	}

	@Override
	public String lname() {
		// TODO Auto-generated method stub
		return lname;
	}

	@Override
	public String hostel() {
		// TODO Auto-generated method stub
		return hostel;
	}

	@Override
	public String department() {
		// TODO Auto-generated method stub
		return department;
	}

	@Override
	public String cgpa() {
		// TODO Auto-generated method stub
		return cgpa;
	}

}
