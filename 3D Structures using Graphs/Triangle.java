

public class Triangle implements TriangleInterface, Comparable<Triangle> {

	Node a,b,c;
	int id;
	boolean vis;
	Triangle(Node a, Node b, Node c)
	{vis=false;
		this.a = a;
		this.b =b;
		this.c = c;
	}
	
	public boolean isVisited()
	{
		return vis;
	}
	@Override
	public PointInterface[] triangle_coord() {
		// TODO Auto-generated method stub
		PointInterface[] arr = {a, b, c};
		return arr;
	}
	
	public int compareTo(Triangle T)
	{
		return id - T.id;
	}
	public String toString()
	{
		return "[ "+a.toString()+", "+b.toString()+", "+c.toString()+" ]";
	}

}
