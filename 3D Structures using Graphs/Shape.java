

public class Shape implements ShapeInterface
{
	ArrayList<Node> nodes = new ArrayList<Node>();
	public ArrayList<Edge> edges = new ArrayList<Edge>();
	ArrayList<Triangle> triangles = new ArrayList<Triangle>();
	//ArrayList<ArrayList <Edge> > matrix = new ArrayList < ArrayList<Edge> >();
	 int id=1;
	 
	 private float edgelength(Edge e)
	 {
		 Node n1 = e.a;
		 Node n2 = e.b;
		 return distance(n1, n2);
	 }
	 
	 private float distance(Node n1, Node n2)
	  {
		  float x = (n1.getX()-n2.getX())*(n1.getX()-n2.getX());
		  float y = (n1.getY()-n2.getY())*(n1.getY()-n2.getY());
		  float z = (n1.getZ()-n2.getZ())*(n1.getZ()-n2.getZ());
		return x+y+z;
	  }
	private int indexofNode(float x, float y, float z)
	{
		for(int i=0; i<nodes.size(); i++)
		{
			Node temp = nodes.get(i);
			if(temp.getX() == x && temp.getY() == y && temp.getZ() == z)
			{
				return i;
			}
		}
		return -1;
	}
	
	private int indexofTriangle(Node x, Node y, Node z)
	{
		for(int i=0; i<triangles.size(); i++)
		{
			Triangle temp = triangles.get(i);
			if(temp.a == x && temp.b == y && temp.c == z)
			{
				return i;
			}
			if(temp.a == y && temp.b == x && temp.c == z)
			{
				return i;
			}
			if(temp.a == z && temp.b == y && temp.c == x)
			{
				return i;
			}
			if(temp.a == x && temp.b == z && temp.c == y)
			{
				return i;
			}
			if(temp.a == y && temp.b == z && temp.c == x)
			{
				return i;
			}
			if(temp.a == z && temp.b == x && temp.c == y)
			{
				return i;
			}
		}
		return -1;
	}
	
	private int indexofEdge(Node x, Node y)
	{
		for(int i=0; i<edges.size(); i++)
		{
			Edge temp = edges.get(i);
			if((temp.a.isEqual(x) && temp.b.isEqual(y)) ||(temp.a.isEqual(y) && temp.b.isEqual(x)))
			{
				return i;
			}
		}
		return -1;
	}
	int area(float [] triangle_coord)
	{
		float x1 = triangle_coord[0];
		  float y1 = triangle_coord[1];
		  float z1 = triangle_coord[2];
		  float x2 = triangle_coord[3];
		  float y2 = triangle_coord[4];
		  float z2 = triangle_coord[5];
		  float x3 = triangle_coord[6];
		  float y3 = triangle_coord[7];
		  float z3 = triangle_coord[8];
		  
		  float ABx = x2-x1;
		  float ABy = y2-y1;
		  float ABz = z2-z1;
		  
		  float ACx = x3-x1;
		  float ACy = y3-y1;
		  float ACz = z3-z1;
		  float a1 = ABy*ACz - ABz*ACy;
		  float a2 = ABx*ACz - ABz*ACx;
		  float a3 = ABx*ACy - ABy*ACx;
		  float a = a1*a1 + a2*a2 + a3*a3;
		  if((ABy*ACz == ACy*ABz) && (ABx*ACz == ABz*ACx) && (ABx*ACy == ABy*ACx) || a <= 0.000001)
		  {
			  return 0;
		  }
		  else return 1;
	}
	
	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public boolean ADD_TRIANGLE(float [] triangle_coord)
	{
		if(area(triangle_coord) == 0) {
			System.out.println("first false");
			return false;
		}
		float x1 = triangle_coord[0];
		  float y1 = triangle_coord[1];
		  float z1 = triangle_coord[2];
		  float x2 = triangle_coord[3];
		  float y2 = triangle_coord[4];
		  float z2 = triangle_coord[5];
		  float x3 = triangle_coord[6];
		  float y3 = triangle_coord[7];
		  float z3 = triangle_coord[8];
		  Node n1, n2, n3;
		  int a1 = this.indexofNode(x1, y1, z1);
		  if(a1 == -1)
		  {
			  Node a = new Node(x1, y1, z1);
			  nodes.add(a);
			  n1 = a;
		  } else n1 = nodes.get(a1);
		  int a2 = this.indexofNode(x2, y2, z2);
		  if(a2 == -1)
		  {
			  Node a = new Node(x2, y2, z2);
			  nodes.add(a);
			  n2 = a;
		  } else n2 = nodes.get(a2);
		  int a3 = this.indexofNode(x3, y3, z3);
		  if(a3 == -1)
		  {
			  Node a = new Node(x3, y3, z3);
			  nodes.add(a);
			  n3 = a;
		  } else n3 = nodes.get(a3);
		  
		  if(!n1.adjecent.contains(n2)) n1.adjecent.add(n2);
		  if(!n1.adjecent.contains(n3)) n1.adjecent.add(n3);
		  
		  if(!n2.adjecent.contains(n1)) n2.adjecent.add(n1);
		  if(!n1.adjecent.contains(n3)) n1.adjecent.add(n3);
		  
		  if(!n3.adjecent.contains(n1)) n3.adjecent.add(n1);
		  if(!n3.adjecent.contains(n2)) n3.adjecent.add(n2);
		  
		  if(this.indexofTriangle(n1, n2, n3) != -1)
		  {
			  System.out.println("triangle already exist");
			  return false;
		  }
		  Triangle t = new Triangle(n1, n2, n3);
		  t.id = id;
		  id++;
		  //System.out.println(t);
		  triangles.add(t);
		  
		  n1.adjtriangles.add(t);
		  n2.adjtriangles.add(t);
		  n3.adjtriangles.add(t);
		  
		  Edge ij = new Edge(n1, n2); 
		  Edge jk = new Edge(n1, n3); 
		  Edge ki = new Edge(n3, n2);

		  int m1 = this.indexofEdge(n1, n2);
		  int m2 = this.indexofEdge(n1, n3);
		  int m3 = this.indexofEdge(n2, n3);
		
		  if(m1 != -1){
			  edges.get(m1).adjTriangle.add(t);
		  }
		  else {
			  ij.adjTriangle.add(t);
			  edges.add(ij);
		  }
		  if(m2 != -1)		 
		  {
			  edges.get(m2).adjTriangle.add(t);
		  }
		  else{
			  jk.adjTriangle.add(t);
			  edges.add(jk);
		  }
		  if(m3 != -1)		
		  {
			  edges.get(m3).adjTriangle.add(t);
		  }
			  else{
			  ki.adjTriangle.add(t);
			  edges.add(ki);
		  }
		  System.out.println("true");
		  return true;
	}

	//
	public int TYPE_MESH()
	{
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		for(int i=0; i<edges.size(); i++)
		{
			Edge e = edges.get(i);
			System.out.println(e);
			System.out.println(e.adjTriangle.size());
			if(e.adjTriangle.size() == 2) a1++;
			else if (e.adjTriangle.size() == 1) a2++;
			else if(e.adjTriangle.size() > 2) {
				a3++;
				return 3;
			}
		}
		if(a1 == edges.size()) return 1;
		else if(a2 != 0 && a3 == 0) return 2;
		else return 3;
	}

	//
	public EdgeInterface [] BOUNDARY_EDGES()
	{
		ArrayList<Edge> arr = new ArrayList<Edge> ();
		EdgeInterface[] nullarray = new EdgeInterface[0];
		int a2 =0;
		for(int i=0; i<edges.size(); i++)
		{
			Edge e = edges.get(i);
			if(e.adjTriangle.size() == 1) {
				arr.add(e);
				a2++;
			}
			else if(e.adjTriangle.size() >2) {
				return null;
			}
		}
		if(arr.size()==0) return null;
		for(int i=0; i<a2-1; i++)
		{
			for(int j=0; j<a2-i-1; j++)
			{
				if(edgelength(arr.get(j)) > edgelength(arr.get(j+1)))
				{
					Edge e = arr.get(j);
					arr.set(j, arr.get(j+1));
					arr.set(j+1, e);
				}
			}
		}
		EdgeInterface[] arr1 = new EdgeInterface[a2];
		for(int i=0; i<a2; i++)
		{
			arr1[i] = arr.get(i);
		}
		for(int i=0; i<arr1.length; i++)
		{
			System.out.println(arr1[i]);
		}
		return arr1;
		
		
	}

	//
	
	private void countcompohelper(Node v, boolean[] visited)
	{
		int a = nodes.indexOf(v);
		visited[a] = true; 
		for(int i=0; i<v.adjecent.size(); i++)
		{
			int b = nodes.indexOf(v.adjecent.get(i));
			if(!visited[b])
				countcompohelper(v.adjecent.get(i), visited);
		}
	}
	
 
	public int COUNT_CONNECTED_COMPONENTS()
	{
		
		boolean[] vistriangles1 = new boolean[triangles.size()];
		   vistriangles = vistriangles1;
		   ArrayList<ArrayList<Triangle>> array = new ArrayList<ArrayList<Triangle>>();
		   
		   for(int i=0; i<triangles.size(); i++)
		   {
			   Triangle t = triangles.get(i);
			   if(vistriangles[this.indexofTriangle(t.a, t.b, t.c)] == false) {
			   vistriangles[this.indexofTriangle(t.a, t.b, t.c)] = true;
			   ArrayList<Triangle> arr = new ArrayList<Triangle>();
			   arr.add(t);
			   diahelper(arr, t);
			   array.add(arr);
			   }
		   }
//		   for(int i=0; i<array.size(); i++)
//		   {
//			   for(int j=0; j<array.get(i).size(); j++)
//			   {
//				   System.out.print(array.get(i).get(j));
//			   }
//			   System.out.println("");
//		   }
		
		   return array.size();
//		
//		int countconcomponents = 0;
//		boolean[] visited = new boolean[nodes.size()];
//		for(int v = 0; v < nodes.size(); ++v) { 
//            if(!visited[v]) { 
//            	Node n = nodes.get(v);
//                countcompohelper(n, visited);
//                countconcomponents++;
//                
//            } 
//        } 
//		return countconcomponents;
	}


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	  public TriangleInterface [] NEIGHBORS_OF_TRIANGLE(float [] triangle_coord)
	  {
		  ArrayList<TriangleInterface> arr = new ArrayList<TriangleInterface>();
		  float x1 = triangle_coord[0];
		  float y1 = triangle_coord[1];
		  float z1 = triangle_coord[2];
		  float x2 = triangle_coord[3];
		  float y2 = triangle_coord[4];
		  float z2 = triangle_coord[5];
		  float x3 = triangle_coord[6];
		  float y3 = triangle_coord[7];
		  float z3 = triangle_coord[8];
		  int m1 = indexofNode(x1, y1, z1);
		  int m2 = indexofNode(x2, y2, z2);
		  int m3 = indexofNode(x3, y3, z3);
		  if(m1 ==-1 || m2 == -1 || m3 == -1)
			  return null;
		  Node n1 = nodes.get(m1);
		  Node n2 = nodes.get(m2);
		  Node n3 = nodes.get(m3);
		  int m4 = indexofEdge(n1, n2);
		  int m5 = indexofEdge(n1, n3);
		  int m6 = indexofEdge(n3, n2);
		  int rootindex = this.indexofTriangle(n1, n2, n3);
		  if(rootindex == -1) return null;
		  Triangle root = triangles.get(rootindex);
		  if(m4 == -1|| m5 ==-1 || m6 ==-1)
			  return null;
		  Edge e1 = edges.get(m4);
		  for(int i=0; i<e1.adjTriangle.size(); i++)
		  {
			  Triangle t = e1.adjTriangle.get(i);
			  if(t.compareTo(root) != 0)
			  arr.add(e1.adjTriangle.get(i));
		  }
		  Edge e2 = edges.get(m5);
		  for(int i=0; i<e2.adjTriangle.size(); i++)
		  {
			  Triangle t = e2.adjTriangle.get(i);
			  if(t.compareTo(root) != 0)
			  arr.add(e2.adjTriangle.get(i));
		  }
		  Edge e3 = edges.get(m6);
		  for(int i=0; i<e3.adjTriangle.size(); i++)
		  {
			  Triangle t = e3.adjTriangle.get(i);
			  if(t.compareTo(root) != 0)
			  arr.add(e3.adjTriangle.get(i));
		  }
		  TriangleInterface[] arr1 = new TriangleInterface[arr.size()];
		  for(int i=0; i<arr.size(); i++)
			  arr1[i] = arr.get(i);
		  for(int i=0; i<arr1.length; i++)
		  {
			  System.out.println(arr1[i]);
		  }
		  return arr1;
	  }


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	  public EdgeInterface [] EDGE_NEIGHBOR_TRIANGLE(float [] triangle_coord)  // not confirmed ki kyaa output chahiye
	  {
		  float x1 = triangle_coord[0];
		  float y1 = triangle_coord[1];
		  float z1 = triangle_coord[2];
		  float x2 = triangle_coord[3];
		  float y2 = triangle_coord[4];
		  float z2 = triangle_coord[5];
		  float x3 = triangle_coord[6];
		  float y3 = triangle_coord[7];
		  float z3 = triangle_coord[8];
		  int a = this.indexofNode(x1, y1, z1);
		  int b = this.indexofNode(x2, y2, z2);
		  int c = this.indexofNode(x3, y3, z3);
		  if(a == -1 || b == -1 || c == -1)
			  return null;
		  Node n1 = nodes.get(a);
		  Node n2 = nodes.get(b);
		  Node n3 = nodes.get(c);
		  int d = this.indexofTriangle(n1, n2, n3);
		  if(d == -1) return null;
		  
		  EdgeInterface [] arr = new EdgeInterface[3];
		  arr[0] = edges.get(this.indexofEdge(n1, n2));
		  arr[1] = edges.get(this.indexofEdge(n2, n3));
		  arr[2] = edges.get(this.indexofEdge(n1, n3));
		  for(int i=0; i<arr.length; i++)
		  {
			  PointInterface[] p = arr[i].edgeEndPoints();
			  System.out.println(p[0].getX()+" "+p[0].getY()+" "+p[0].getZ());
			  System.out.println(p[1].getX()+" "+p[1].getY()+" "+p[1].getZ());
			  System.out.println();
		  }
		  return arr;
		  
		  }

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	  public PointInterface [] VERTEX_NEIGHBOR_TRIANGLE(float [] triangle_coord)   //output didn't check yet, method might wrong
	  {
		  //ArrayList<PointInterface> arr = new ArrayList<PointInterface>();
		  float x1 = triangle_coord[0];
		  float y1 = triangle_coord[1];
		  float z1 = triangle_coord[2];
		  float x2 = triangle_coord[3];
		  float y2 = triangle_coord[4];
		  float z2 = triangle_coord[5];
		  float x3 = triangle_coord[6];
		  float y3 = triangle_coord[7];
		  float z3 = triangle_coord[8];
		  int a = indexofNode(x1, y1, z1);
		  int b = indexofNode(x2, y2, z2);
		  int c = indexofNode(x3, y3, z3);
		  if(a == -1 || b == -1 || c == -1)
			  return null;
		  Node n1 = nodes.get(a);
		  Node n2 = nodes.get(b);
		  Node n3 = nodes.get(c);
		  
//		  for(int i=0; i<n1.adjecent.size(); i++)
//		  {
//			  //if(!arr.contains(n1.adjecent.get(i)))
//				  arr.add(n1.adjecent.get(i));
//		  }
//		  for(int i=0; i<n2.adjecent.size(); i++)
//		  {
//			  if(!arr.contains(n2.adjecent.get(i)))
//				  arr.add(n2.adjecent.get(i));
//		  }
//		  for(int i=0; i<n3.adjecent.size(); i++)
//		  {
//			  if(!arr.contains(n3.adjecent.get(i)))
//				  arr.add(n3.adjecent.get(i));
//		  }
//		  
		  PointInterface[] arr1 = new PointInterface[3];
		  arr1[0] = n1;
		  arr1[1] = n2;
		  arr1[2] = n3;
		  for(int i=0; i<arr1.length; i++)
			  System.out.println(arr1[i]);
		  return arr1;
	  }


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	  public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord)
	  {
		  ArrayList<TriangleInterface> arr = new ArrayList<TriangleInterface>();
		  float x1 = triangle_coord[0];
		  float y1 = triangle_coord[1];
		  float z1 = triangle_coord[2];
		  float x2 = triangle_coord[3];
		  float y2 = triangle_coord[4];
		  float z2 = triangle_coord[5];
		  float x3 = triangle_coord[6];
		  float y3 = triangle_coord[7];
		  float z3 = triangle_coord[8];
		  
		  int a = this.indexofNode(x1, y1, z1);
		  int b = this.indexofNode(x2, y2, z2);
		  int c = this.indexofNode(x3, y3, z3);
		  
		  if(a == -1 || b == -1 || c == -1) 
		  {
			  System.out.println("one of nodes doesn't exist");
			  return null;
		  }
		  Node n1 = nodes.get(a);
		  Node n2 = nodes.get(b);
		  Node n3 = nodes.get(c);

		  int d = this.indexofTriangle(n1, n2, n3);
		  if(d == -1)
		  {
			  System.out.println("triangle doesn't exist");
			  return null;
		  }
		  Triangle root = triangles.get(d);
		  for(int i=0; i<n1.adjtriangles.size(); i++)
		  {
			  Triangle t = n1.adjtriangles.get(i);
			  if((!arr.contains(t)) && (t != root))
			  {
				  arr.add(t);
			  }
		  }
		  
		  for(int i=0; i<n2.adjtriangles.size(); i++)
		  {
			  Triangle t = n2.adjtriangles.get(i);
			  if((!arr.contains(t)) && (t != root))
			  {
				  arr.add(t);
			  }
		  }
		  
		  for(int i=0; i<n3.adjtriangles.size(); i++)
		  {
			  Triangle t = n3.adjtriangles.get(i);
			  if((!arr.contains(t)) && (t != root))
			  {
				  arr.add(t);
			  }
		  }
//		  for(int i=0; i<n1.adjecent.size(); i++)
//		  {
//			  if(n1.adjecent.get(i) != n2 && n1.adjecent.get(i) != n3)
//			  {
//				  for(int j=0; j<n1.adjecent.get(i).adjecent.size(); j++)
//				  {
////					  if(n1.adjecent.get(i).adjecent.get(j) != n2 && n1.adjecent.get(i).adjecent.get(j) != n3 &&  n1.adjecent.get(i).adjecent.get(j) != n1)
////					  {
//						  for(int k=0; k<n1.adjecent.get(i).adjecent.get(j).adjecent.size(); k++)
//						  {
//							  if(n1.adjecent.get(i).adjecent.get(j).adjecent.get(k) == n1)
//							  {
//								  Triangle a = new Triangle(n1, n1.adjecent.get(i), n1.adjecent.get(i).adjecent.get(j));
//								  arr.add(a);
//								  break;
//							  }
//						  }
////					  }
//				  }
//			  }
//		  }
//		  for(int i=0; i<n2.adjecent.size(); i++)
//		  {
//			  if(n2.adjecent.get(i) != n1 && n2.adjecent.get(i) != n3)
//			  {
//				  for(int j=0; j<n2.adjecent.get(i).adjecent.size(); j++)
//				  {
//					  if(n2.adjecent.get(i).adjecent.get(j) != n1 && n2.adjecent.get(i).adjecent.get(j) != n3 &&  n2.adjecent.get(i).adjecent.get(j) != n2)
//					  {
//						  for(int k=0; k<n2.adjecent.get(i).adjecent.get(j).adjecent.size(); k++)
//						  {
//							  if(n2.adjecent.get(i).adjecent.get(j).adjecent.get(k) == n1)
//							  {
//								  Triangle a = new Triangle(n2, n2.adjecent.get(i), n2.adjecent.get(i).adjecent.get(j));
//								  arr.add(a);
//								  break;
//							  }
//						  }
//					  }
//				  }
//			  }
//		  }
//		  
//		  for(int i=0; i<n3.adjecent.size(); i++)
//		  {
//			  if(n3.adjecent.get(i) != n2 && n3.adjecent.get(i) != n1)
//			  {
//				  for(int j=0; j<n3.adjecent.get(i).adjecent.size(); j++)
//				  {
//					  if(n3.adjecent.get(i).adjecent.get(j) != n3 && n3.adjecent.get(i).adjecent.get(j) != n1 &&  n3.adjecent.get(i).adjecent.get(j) != n2)
//					  {
//						  for(int k=0; k<n3.adjecent.get(i).adjecent.get(j).adjecent.size(); k++)
//						  {
//							  if(n3.adjecent.get(i).adjecent.get(j).adjecent.get(k) == n1)
//							  {
//								  Triangle a = new Triangle(n3, n3.adjecent.get(i), n3.adjecent.get(i).adjecent.get(j));
//								  arr.add(a);
//								  break;
//							  }
//						  }
//					  }
//				  }
//			  }
//		  }
		  
		  TriangleInterface[] arr1 = new TriangleInterface[arr.size()];
		  for(int i=0; i<arr.size(); i++)
			  arr1[i] = arr.get(i);
		  for(int i=0; i<arr1.length; i++)
			  System.out.println(arr1[i]);
		  return arr1;
	  }


	//INPUT [x,y,z]
	  public TriangleInterface [] INCIDENT_TRIANGLES(float [] point_coordinates)
	  {
		  TriangleInterface[] nullarray = new TriangleInterface[0];
		  ArrayList<TriangleInterface> arr = new ArrayList<TriangleInterface>();
		  MaxHeap<Triangle> maxHeap = new MaxHeap<>(); //stored in such a way that newest triangle is on the top
		  float x = point_coordinates[0];
		  float y = point_coordinates[1];
		  float z = point_coordinates[2];
		  int a1 = indexofNode(x, y, z);
		  if(a1 == -1)
		  {
			  return nullarray;
		  }
		  Node n = nodes.get(a1);

		  
		  TriangleInterface[] arr1 = new TriangleInterface[n.adjtriangles.size()];
		  for(int i=0; i<n.adjtriangles.size(); i++)
			  arr1[i] = n.adjtriangles.get(i);
		  for(int i=0; i<arr1.length; i++)
		  {
			  System.out.println(arr1[i]);
		  }
		  return arr1;
	  }


	// INPUT [x,y,z]
	  public PointInterface [] NEIGHBORS_OF_POINT(float [] point_coordinates)
	  {
		  int i = this.indexofNode(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		  if(i == -1)
			  return null;
		  Node n = nodes.get(i);
		  int j = n.adjecent.size();
		  PointInterface[] manoj = new PointInterface[j];
		  for(int k=0; k<j; k++)
		  {
			  manoj[k] = n.adjecent.get(k);
		  }
		  for(int k=0; k<manoj.length; k++)
		  {
			  System.out.println(manoj[k]);
		  }
		  return manoj;
	  }


	// INPUT[x,y,z]
	  public EdgeInterface [] EDGE_NEIGHBORS_OF_POINT(float [] point_coordinates)
	  {
		  
		  ArrayList<Edge> arr = new ArrayList<Edge>();
		  int i = this.indexofNode(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		  if(i == -1)
			  {
			  	System.out.println("returning null");
			  	return null; 
			  }
		  Node n = nodes.get(i);
		  int j = n.adjecent.size();
		  EdgeInterface[] manoj = new EdgeInterface[j];
		  for(int k=0; k<j; k++)
		  {
			  Edge mk1 = edges.get(this.indexofEdge(n, n.adjecent.get(k)));
			  manoj[k] = mk1;
		  }
		  return manoj;
	  }


	// INPUT[x,y,z]
	  public TriangleInterface [] FACE_NEIGHBORS_OF_POINT(float [] point_coordinates)
	  { 
		  TriangleInterface[] nullarray = new TriangleInterface[0];
		  int a = indexofNode(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		  if(a == -1) {
			  return nullarray;
		  }
		  Node n = nodes.get(a);
		  TriangleInterface[] arr = new TriangleInterface[n.adjtriangles.size()];
		  for(int i=0; i<n.adjtriangles.size(); i++)
			  arr[i] = n.adjtriangles.get(i);
		  return arr;
	  }
	  
	  private int connectedcount = 0;
	  
	  private void connectedhelper(Triangle t1, Triangle t2, ArrayList<Triangle> visitconnected)
	  {
		  if (connectedcount == 1) return;
		  Edge a = edges.get(indexofEdge(t1.a, t1.b));
		  if(a.adjTriangle.contains(t2)) {
			  connectedcount=1;
			  return;
		  }
		  else {
			  for(int i=0; i<a.adjTriangle.size(); i++)
			  {
				  if(connectedcount == 1) return;
				  Triangle t = a.adjTriangle.get(i);
				  if(!visitconnected.contains(t))
				  {
					  visitconnected.add(t);
					  connectedhelper(t, t2, visitconnected);
				  }
			  }
		  }
		  
		  if (connectedcount == 1) return;
		  Edge b = edges.get(indexofEdge(t1.a, t1.c));
		  if(b.adjTriangle.contains(t2)) {
			  connectedcount=1;
			  return;
			  
		  }
		  else {
			  for(int i=0; i<b.adjTriangle.size(); i++)
			  {
				  if(connectedcount == 1) return;
				  Triangle t = b.adjTriangle.get(i);
				  if(!visitconnected.contains(t))
				  {
					  visitconnected.add(t);
					  connectedhelper(t, t2, visitconnected);
				  }
			  }
		  }
		  
		  if (connectedcount == 1) return;
		  Edge c = edges.get(indexofEdge(t1.b, t1.c));
		  if(c.adjTriangle.contains(t2)) {
			  connectedcount=1;
			  return;
			  
		  }
		  else {
			  for(int i=0; i<c.adjTriangle.size(); i++)
			  {
				  if(connectedcount == 1) return;
				  Triangle t = c.adjTriangle.get(i);
				  if(!visitconnected.contains(t))
				  {
					  visitconnected.add(t);
					  connectedhelper(t, t2, visitconnected);
				  }
			  }
		  }
		  
	  }

	// INPUT // [xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 , xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3]   where xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 are 3 coordinates of first triangle and xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3 are coordinates of second triangle as given in specificaition.
	  public boolean IS_CONNECTED(float [] triangle_coord_1, float [] triangle_coord_2)
	  {
		 
		  ArrayList<Triangle> visitconnected = new ArrayList<Triangle>();
		  float xa1 = triangle_coord_1[0];
		  float ya1 = triangle_coord_1[1];
		  float za1 = triangle_coord_1[2];
		  float xa2 = triangle_coord_1[3];
		  float ya2 = triangle_coord_1[4];
		  float za2 = triangle_coord_1[5];
		  float xa3 = triangle_coord_1[6];
		  float ya3 = triangle_coord_1[7];
		  float za3 = triangle_coord_1[8];
		  
		  float xb1 = triangle_coord_2[0];
		  float yb1 = triangle_coord_2[1];
		  float zb1 = triangle_coord_2[2];
		  float xb2 = triangle_coord_2[3];
		  float yb2 = triangle_coord_2[4];
		  float zb2 = triangle_coord_2[5];
		  float xb3 = triangle_coord_2[6];
		  float yb3 = triangle_coord_2[7];
		  float zb3 = triangle_coord_2[8];
		  int o1 = indexofNode(xa1, ya1, za1);
		  int o2 = indexofNode(xa2, ya2, za2);
		  int o3 = indexofNode(xa3, ya3, za3);
		  int p1 = indexofNode(xb1, yb1, zb1);
		  int p2 = indexofNode(xb2, yb2, zb2);
		  int p3 = indexofNode(xb3, yb3, zb3);
		  if(o1 == -1 || o2 == -1 || o3 == -1) {
			  System.out.println(" one node of triangle 1 does not exist");
			  return false;
		  }
		  if(p1 == -1 || p2 == -1|| p3 == -1) {
			  System.out.println("one node of triangle 2 does not exist");
			  return false;
		  }
		   Node n1 = nodes.get(o1);
		   Node n2 = nodes.get(o2);
		   Node n3 = nodes.get(o3);
		   int tt1 = indexofTriangle(n1, n2, n3); if(tt1 == -1) return false;
		  Triangle t1 = triangles.get(tt1);
		
		  Node m1 = nodes.get(p1);
		  Node m2 = nodes.get(p2);
		  Node m3 = nodes.get(p3);
		
		  int tt2 = indexofTriangle(m1, m2, m3); if(tt2 == -1) return false;
		  Triangle t2 = triangles.get(tt2);
		  connectedcount = 0;
		  connectedhelper(t1, t2, visitconnected);
		  if(connectedcount == 1) return true;
		  else return false;
	  }


	// INPUT [x1,y1,z1,x2,y2,z2] // where (x1,y1,z1) refers to first end point of edge and  (x2,y2,z2) refers to the second.
	  public TriangleInterface [] TRIANGLE_NEIGHBOR_OF_EDGE(float [] edge_coordinates)
	  { 
		  float x1 = edge_coordinates[0];
		  float y1 = edge_coordinates[1];
		  float z1 = edge_coordinates[2];
		  float x2 = edge_coordinates[3];
		  float y2 = edge_coordinates[4];
		  float z2 = edge_coordinates[5];
		  
		  
		  Edge e = edges.get(this.indexofEdge(nodes.get(this.indexofNode(x1, y1, z1)), nodes.get(this.indexofNode(x2, y2, z2))));
		  TriangleInterface[] arr = new TriangleInterface[e.adjTriangle.size()];
		  for(int i=0; i<arr.length; i++)
		{
			arr[i] = e.adjTriangle.get(i);
			System.out.println(arr[i]);
		}
		  return arr;
	  }

	  boolean[] vistriangles = new boolean[triangles.size()];
	  private ArrayList<Triangle> neightriangle(Triangle t)
	  {
		  ArrayList<Triangle> arr = new ArrayList<Triangle>();
		  Edge e1 = edges.get(this.indexofEdge(t.a, t.b));
		  for(int i=0; i<e1.adjTriangle.size(); i++)
		  {
			  Triangle t1 = e1.adjTriangle.get(i);
			  if(t1.compareTo(t) != 0)
			  {
				  arr.add(t1);
			  }
		  }
		  
		  Edge e2 = edges.get(this.indexofEdge(t.a, t.c));
		  for(int i=0; i<e2.adjTriangle.size(); i++)
		  {
			  Triangle t1 = e2.adjTriangle.get(i);
			  if(t1.compareTo(t) != 0)
			  {
				  arr.add(t1);
			  }
		  }
		  
		  Edge e3 = edges.get(this.indexofEdge(t.b, t.c));
		  for(int i=0; i<e3.adjTriangle.size(); i++)
		  {
			  Triangle t1 = e3.adjTriangle.get(i);
			  if(t1.compareTo(t) != 0)
			  {
				  arr.add(t1);
			  }
		  }
//		  Triangle[] arr1 = new Triangle[arr.size()];
//		  for(int i=0; i<arr.size(); i++)
//			  arr1[i] = arr.get(i);
		  return arr;
	  }
	  void diahelper(ArrayList<Triangle> arr, Triangle t)

	  {
		  Edge e1 = edges.get(this.indexofEdge(t.a, t.b));
		  for(int i=0; i<e1.adjTriangle.size(); i++)
		  {
			  Triangle t1 = e1.adjTriangle.get(i);
			  int index = this.indexofTriangle(t1.a, t1.b, t1.c);
			  if(vistriangles[index] == false)
			  {
				  vistriangles[index] = true;
				  arr.add(t1);
				  diahelper(arr, t1);
			  }
		  }
		  
		  Edge e2 = edges.get(this.indexofEdge(t.a, t.c));
		  for(int i=0; i<e2.adjTriangle.size(); i++)
		  {
			  Triangle t1 = e2.adjTriangle.get(i);
			  int index = this.indexofTriangle(t1.a, t1.b, t1.c);
			  if(vistriangles[index] == false)
			  {
				  vistriangles[index] = true;
				  arr.add(t1);
				  diahelper(arr, t1);
			  }
		  }
		  
		  Edge e3 = edges.get(this.indexofEdge(t.b, t.c));
		  for(int i=0; i<e3.adjTriangle.size(); i++)
		  {
			  Triangle t1 = e3.adjTriangle.get(i);
			  int index = this.indexofTriangle(t1.a, t1.b, t1.c);
			  if(vistriangles[index] == false)
			  {
				  vistriangles[index] = true;
				  arr.add(t1);
				  diahelper(arr, t1);
			  }
		  }
	  }
	  
	  
	  public int dia(ArrayList<Triangle> t, Triangle t1)
		{
			ArrayList<ArrayList<Triangle>> n=new ArrayList<ArrayList<Triangle>>();
			ArrayList<Triangle> n0=new ArrayList<Triangle>();
			int index=-1;
			for(int i=0;i<t.size();i++)
			{
				if(t.get(i).compareTo(t1)==0)
				{
					index=i;
					n0.add(t.get(i));
				}
			}
			n.add(n0);
			for(int i3=0;i3<n.size();i3++)
			{
//				System.out.println("biggest list executed "+i3+1+" times");
					ArrayList<Triangle> n1=new ArrayList<Triangle>();
				for(int i1=0;i1<n.get(i3).size();i1++)
				{
//					System.out.println(i1+"th child of biggest list executed");
//					System.out.println("triangle to be checked is "+n.get(i3).get(i1));
					Node p1=n.get(i3).get(i1).a;
					Node p2=n.get(i3).get(i1).b;
					Node p3=n.get(i3).get(i1).c;
					int x=0;
		//			Edge e1=new Edge(p1, p2);
		//			Edge e2=new Edge(p2, p1);
		//			Edge e3=new Edge(p1, p3);
		//			Edge e4=new Edge(p3, p1);
		//			Edge e5=new Edge(p2, p3);
		//			Edge e6=new Edge(p3, p2);
					for(int j=0;j<t.size();j++)
					{
//						System.out.println("              triangle is "+t.get(j));
						if(t.get(j).compareTo(n.get(i3).get(i1))!=0)
						{
							if(t.get(j).a.compareTo(p1)==0 || t.get(j).a.compareTo(p2)==0 || t.get(j).a.compareTo(p3)==0)
							{
//								System.out.println(t.get(j).point1 +" matched ");
								x++;
								
							}
							 if(t.get(j).b.compareTo(p1)==0 || t.get(j).b.compareTo(p2)==0 || t.get(j).b.compareTo(p3)==0)
							{
//								System.out.println(t.get(j).point2 +" matched ");
								x++;
								
							}
							if(t.get(j).c.compareTo(p1)==0 || t.get(j).c.compareTo(p2)==0 || t.get(j).c.compareTo(p3)==0)
							{
//								System.out.println(t.get(j).point3 +" matched ");
								x++;
								
							}
//							System.out.println("value of x= "+x);
							if(x==2)
							{
//								System.out.println("edge matched with this triangle having isVisted= "+t.get(j).isVisited());
								if(t.get(j).isVisited()==false)
								{
									
								t.get(j).vis=true;
								n1.add(t.get(j));
//								System.out.println("list added to this child of biggest list");
								}
								x=0;
		//						if(t.get(j).compareTo(t2)==0)
		//						{
		//							break;
		//						}
							}
							else
							{
								x=0;
								
							}
						}
						else 
						{
							t.get(j).vis=true;
						}
					}
		//			if(n1.get(n1.size()-1).compareTo(t2)==0)
		//			{
		//				break;
		//			}
					
				}
				
				if(n1.size()!=0) {
					n.add(n1);
//					System.out.println("size of n1 = "+n1.size());	
				}
				else 
					return (n.size()-1);
			}
			return 0;
		}
	  
	  
	  public int MAXIMUM_DIAMETER()
	  {
		  boolean[] vistriangles1 = new boolean[triangles.size()];
		   vistriangles = vistriangles1;
		   ArrayList<ArrayList<Triangle>> array = new ArrayList<ArrayList<Triangle>>();
		   ArrayList<ArrayList<Node>> arraynode = new ArrayList<ArrayList<Node>>();
		   
		   for(int i=0; i<triangles.size(); i++)
		   {
			   Triangle t = triangles.get(i);
			   if(vistriangles[this.indexofTriangle(t.a, t.b, t.c)] == false) {
			   vistriangles[this.indexofTriangle(t.a, t.b, t.c)] = true;
			   ArrayList<Triangle> arr = new ArrayList<Triangle>();
			   arr.add(t);
			   diahelper(arr, t);
			   ArrayList<Node> a1 = new ArrayList<Node>();
			   for(int j=0; j<arr.size(); j++)
			   {
				   Triangle t3 = arr.get(j);
				   if(!a1.contains(t3.a))
					{
					   a1.add(t3.a);
					}
				   if(!a1.contains(t3.b))
					{
					   a1.add(t3.b);
					}
				   if(!a1.contains(t3.c))
					{
					   a1.add(t3.c);
					}
			   }
			   arraynode.add(a1);
			   array.add(arr);
			   }
		   }
		   for(int i=0;i<array.size();i++)
		   {
			   for(int j=0;j<array.get(i).size();j++)
			   {
				   array.get(i).get(j).vis=false;
			   }
		   }
		  int x1=0;
		   for(int i=0;i<array.size();i++)
		   {
			   for(int j=0;j<array.get(i).size();j++)
			   {
				   int x=dia(array.get(i), array.get(i).get(j));
					if(x1<x)
					{
						x1=x;
					}
			   }
		   }
//		   System.out.println("x1= "+x1);
		  return x1;
//		   boolean[] vistriangles1 = new boolean[triangles.size()];
//		   vistriangles = vistriangles1;
//		   ArrayList<ArrayList<Triangle>> array = new ArrayList<ArrayList<Triangle>>();
//		   
//		   for(int i=0; i<triangles.size(); i++)
//		   {
//			   Triangle t = triangles.get(i);
//			   if(vistriangles[this.indexofTriangle(t.a, t.b, t.c)] == false) {
//			   vistriangles[this.indexofTriangle(t.a, t.b, t.c)] = true;
//			   ArrayList<Triangle> arr = new ArrayList<Triangle>();
//			   arr.add(t);
//			   diahelper(arr, t);
//			   array.add(arr);
//			   }
//		   }
//		   for(int i=0; i<array.size(); i++)
//		   {
//			   ArrayList<Triangle> arr = array.get(i);
//			   
//			   for(int j=0; j<arr.size(); j++)
//			   {
//				   boolean[] temp = new boolean[arr.size()];
//				   vistriangles = temp;
//				   Triangle root = arr.get(j);
//				   vistriangles[this.indexofTriangle(root.a, root.b, root.c)] = true;
//				   ArrayList<ArrayList<Triangle> > compwaliarray = new ArrayList<ArrayList<Triangle>>();
//				   ArrayList<Triangle> a = this.neightriangle(root);
//				   ArrayList<Triangle> sorta = new ArrayList<Triangle>();
//				   for(int k=0; k<a.size(); k++)
//				   {
//					   Triangle t2 = a.get(k);
//					   if(vistriangles[this.indexofTriangle(t2.a, t2.b, t2.c)] == false)
//					   {
//						   sorta.add(t2);
////						   same function call again
//					   }
//				   }
//				   compwaliarray.add(sorta);
//				   
//				   
//				   
//			   }
//		   }
//		   System.out.println("size of array : "+array.size());
//		  return 0;
	  }

	  private float xcen=0;
	  private float ycen = 0;
	  private float zcen = 0;
	  private int countcen = 0;
	  private void centroidhelper(Node v, boolean visited[], boolean visitedtriangles[])
	  {
		  int a = nodes.indexOf(v);
			visited[a] = true; 
			 for(int j=0; j<v.adjtriangles.size(); j++)
			  {
				  Triangle t = v.adjtriangles.get(j);
				  int index = triangles.indexOf(t);
				  if(visitedtriangles[index] == false) {
					  countcen =countcen+3;
					visitedtriangles[index] = true;
					xcen += t.a.getX();
					xcen += t.b.getX();
					xcen += t.c.getX();
					
					ycen += t.a.getY();
					ycen += t.b.getY();
					ycen += t.c.getY();
					
					zcen += t.a.getZ();
					zcen += t.b.getZ();
					zcen += t.c.getZ();
				  }
			  }
			for(int i=0; i<v.adjecent.size(); i++)
			{
				Node n = v.adjecent.get(i);
				int b = nodes.indexOf(n);
				if(!visited[b])
					centroidhelper(n, visited, visitedtriangles);
			}
	  }
	 
	  public PointInterface [] CENTROID (){
		  ArrayList<Node> forcentroid = new ArrayList<Node>();
		  boolean[] visited = new boolean[nodes.size()];
		  boolean [] visitedtriangles = new boolean[triangles.size()];
		  int total = 0;
			boolean[] visited1 = new boolean[nodes.size()];
			for(int v = 0; v < nodes.size(); ++v) { 
	            if(!visited1[v]) { 
	            	Node n = nodes.get(v);
	                countcompohelper(n, visited1);
	                forcentroid.add(n);
	                total++;
	            } 
	        }
		  PointInterface[] arr = new PointInterface[total];
		  for(int i=0; i<total; i++)
		  {
			  Node n = forcentroid.get(i);
			  centroidhelper(n, visited, visitedtriangles);
			  xcen = xcen/(countcen);
			  ycen = ycen/(countcen);
			  zcen = zcen/(countcen);
			  PointInterface p = new Node(xcen, ycen, zcen);
			  arr[i] = p;
			  xcen = 0;
			  ycen = 0;
			  
			  zcen = 0;
			  countcen = 0;
		  }
		  for(int i=0; i<arr.length; i++)
			  System.out.print(arr[i]);
		  System.out.println("");
		  return arr;
	}

	// INPUT [x,y,z]
	  public PointInterface CENTROID_OF_COMPONENT (float [] point_coordinates)
	  {
		  float x1 = point_coordinates[0];
		  float y1 = point_coordinates[1];
		  float z1 = point_coordinates[2];
		  int a = this.indexofNode(x1, y1, z1);
		  if(a == -1) return null;
		  Node n = nodes.get(a);
		  boolean[] visited = new boolean[nodes.size()];
		  boolean [] visitedtriangles = new boolean[triangles.size()];
		  countcen = 0;
		  xcen=0;
		  ycen=0;
		  zcen=0;
		  centroidhelper(n, visited, visitedtriangles);
		  xcen = xcen/(countcen);
		  ycen = ycen/(countcen);
		  zcen = zcen/(countcen);
		  PointInterface p = new Node(xcen, ycen, zcen);
		  System.out.println(p);
		  return p;
	}


	  
	  
	 boolean[]visited1 = new boolean[nodes.size()];
	  
	  
	  private Node[] mindistance(ArrayList<Node> arr1, ArrayList<Node> arr2)
	  {
		  float shortest = 100000000;
		  Node[] nodearray = new Node[2];
		  for(int i=0; i<arr1.size(); i++)
		  {
			  Node n1 = arr1.get(i);
//			  if(n1 == null) {
//				  System.out.println("n1 was null");
//				  return null;
//			  }
			  for(int j=0; j<arr2.size(); j++)
			  {
				  Node n2 = arr2.get(j);
//					if(n2 == null)
//					{
//						System.out.println("n2 was null");
//						return null;
//					}
				  float f = distance(n1, n2);
					  if(f < shortest) {
						  shortest = f;
						  nodearray[0] = n1;
						  nodearray[1] = n2;
					  }
				  }
			  }
		  return nodearray;
	  }

	@Override
	public PointInterface[] CLOSEST_COMPONENTS() {
		//// TODO Auto-generated method stub
		 boolean[] vistriangles1 = new boolean[triangles.size()];
		   vistriangles = vistriangles1;
		   ArrayList<ArrayList<Triangle>> array = new ArrayList<ArrayList<Triangle>>();
		   ArrayList<ArrayList<Node>> arraynode = new ArrayList<ArrayList<Node>>();
		   
		   for(int i=0; i<triangles.size(); i++)
		   {
			   Triangle t = triangles.get(i);
			   if(vistriangles[this.indexofTriangle(t.a, t.b, t.c)] == false) {
			   vistriangles[this.indexofTriangle(t.a, t.b, t.c)] = true;
			   ArrayList<Triangle> arr = new ArrayList<Triangle>();
			   arr.add(t);
			   diahelper(arr, t);
			   ArrayList<Node> a1 = new ArrayList<Node>();
			   for(int j=0; j<arr.size(); j++)
			   {
				   Triangle t3 = arr.get(j);
				   if(!a1.contains(t3.a))
					{
					   a1.add(t3.a);
					}
				   if(!a1.contains(t3.b))
					{
					   a1.add(t3.b);
					}
				   if(!a1.contains(t3.c))
					{
					   a1.add(t3.c);
					}
			   }
			   arraynode.add(a1);
			   array.add(arr);
			   }
		   }
//		   System.out.println("showing arraynode");
//		   for(int i=0; i<arraynode.size(); i++)
//		   {
//			   ArrayList<Node> arr = arraynode.get(i);
//			   for(int j=0; j<arr.size(); j++)
//			   {
//				   System.out.print(arr.get(j));
//			   }
//			   System.out.println("");
//		   }
		   
		   PointInterface[] points = new PointInterface[2];
			  float shortest = 1000000000;
			  for(int i=0; i<arraynode.size(); i++)
			  {
				 // System.out.println("showing arraynode1 "+arraynode.size());
				  for(int j=i+1; j<arraynode.size(); j++)
				  {
					 // System.out.println("showing arraynode2");
					  Node[] array1 = mindistance(arraynode.get(i), arraynode.get(j));
					  float a = distance(array1[0], array1[1]);
					  //System.out.println("distance between "+array1[0]+" and "+array1[1]+" is "+a);
					  if(a < shortest)
					  {
						  shortest = a;
						  points = array1;
					  }
				  }
				 // System.out.println("Pahle for k andar" + i);
			  }
			 // System.out.println("Bahr");
			  System.out.println(points[0]);
			  System.out.println(points[1]);
			  return points;
			  
	}






	
}

