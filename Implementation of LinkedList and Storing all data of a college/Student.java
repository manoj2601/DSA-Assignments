import java.util.Iterator;

public class Student implements Student_ {

	String n;
	String e;
	String h;
	String d;
	int cre;
	double cg1;
	public int gradesearned = 0;
	public double cgpa1;
	LinkedList<CourseGrade> list = new LinkedList<CourseGrade>();
	LinkedList<Integer> list1 = new LinkedList<Integer> (); //completed credits
	LinkedList<Integer> list2 = new LinkedList<Integer> (); // total courses attempted
	public Student(String n, String e, String h, String d, int cre, double cg1)
	{
		this.n = n;
		this.e = e;
		this.h = h;
		this.d = d;
		this.cre = cre;
		this.cg1 = cg1;
	}
	
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public String entryNo() {
		// TODO Auto-generated method stub
		return e;
	}

	@Override
	public String hostel() {
		// TODO Auto-generated method stub
		return h;
	}

	@Override
	public String department() {
		// TODO Auto-generated method stub
		return d;
	}

	@Override
	public String completedCredits() {
		// TODO Auto-generated method stub
		String credits = Integer.toString(list1.count()*3);
		return credits;
	}

	@Override
	public String cgpa() {
		// TODO Auto-generated method stub
		double x6=list2.count();
		double cg;
		if(x6!=0)
		{cg=gradesearned/x6;}
		else
		{cg=0;}
		double finalcg=Math.round(cg*100D)/100D;
//		finalcg=finalcg*10;
		String finalcg1=Double.toString(finalcg);//LOOKBACK
		return finalcg1;
	}

	@Override
	public Iterator<CourseGrade_> courseList() {
		// TODO Auto-generated method stub
		//return 
		return null;//new newI<CourseGrade_> (list.head);
	}

	

}
