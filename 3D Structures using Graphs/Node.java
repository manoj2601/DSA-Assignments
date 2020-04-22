import java.util.ArrayList;

public class Node implements PointInterface {

	float x,y,z;
	ArrayList<Node> adjecent = new ArrayList<Node>();
	public ArrayList<Triangle> adjtriangles = new ArrayList<Triangle> ();
	public Node (float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public float getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public float[] getXYZcoordinate() {
		// TODO Auto-generated method stub
		float[] arr = {x, y, z};
		return arr;
	}
	public String toString()
	{
		return "["+x+", "+y+", "+z+"]";
	}
	
	public int compareTo(Node n)
	{
		if(x==n.getX() && y==n.getY() && z==n.getZ())
		{
			return 0;
		}
		else return -1;
	}
	public boolean isEqual(Node n)
	{
		if(x == n.getX() && y == n.getY() && z == n.getZ()) {
			return true;
		}
		else return false;
	}

}
