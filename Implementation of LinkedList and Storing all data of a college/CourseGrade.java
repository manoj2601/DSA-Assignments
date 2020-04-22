
public class CourseGrade implements CourseGrade_ {

	String coursetitle;
	String coursenum; 
	String grade;
	
	public CourseGrade(String coursetitle, String coursenum, String grade)
	{
		this.coursetitle = coursetitle;
		this.coursenum = coursenum;
		this.grade = grade;
	}
	
	@Override
	public String coursetitle() {
		// TODO Auto-gen,erated method stub
		return coursetitle;
	}

	@Override
	public String coursenum() {
		// TODO Auto-generated method stub
		return coursenum;
	}

	GradeInfo a = new GradeInfo(grade);
	@Override
	public GradeInfo_ grade() {
		// TODO Auto-generated method stub
		return a;
		
		
	}

}
