import java.util.ArrayList;

public class Edge implements EdgeInterface {

	Node a,b;
	ArrayList<Triangle> adjTriangle = new ArrayList<Triangle>();
	public Edge(Node a, Node b)
	{
		this.a = a;
		this.b = b;
	}
	
	@Override
	public PointInterface[] edgeEndPoints() {
		// TODO Auto-generated method stub
		PointInterface[] arr = {a, b};
		return arr;
	}
	
	public String toString()
	{
		return "first node : "+a.toString()+" second node : "+b.toString();
	}

}
