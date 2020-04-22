import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assignment3 {
	
	public static void main(String[] args) throws IOException, Exception
	{
		int N = Integer.parseInt(args[0]);
		String a = args[1];
		if(a.contentEquals("DH")) {
		Pair[] array = new Pair[(int) N];
		
		FileReader fr = new FileReader(args[2]); 
	    BufferedReader br = new BufferedReader(fr);
	    
	    MyHashTable table = new MyHashTable(N, array);
	    while(br.ready()) {
		    String str = br.readLine();
		    String[] words = str.split(" ");
		     if(words[0].equals("insert"))
		     {
		    	 Student value = new Student(words[1], words[2], words[3], words[4], words[5]);
		    	 Pair2 key = new Pair2(words[1], words[2]);
		    	 int m = table.insert(key, value);
		    	 if(m == -1) System.out.println("E");
		    	 else System.out.println(m);
		     }
		     else if(words[0].equals("update"))
		     {
		    	 Student value = new Student(words[1], words[2], words[3], words[4], words[5]);
		    	 Pair2 key = new Pair2(words[1], words[2]);
		    	 int c = table.update(key, value);
		    	 
		    	 if(c == N+1) System.out.println("E");
		    	 else System.out.println(c);
		     }
		     else if(words[0].equals("delete"))
		    {
		    	 Pair2 key = new Pair2(words[1], words[2]);
		    	 int c = table.delete(key);
		    	 if(c == N+1) System.out.println("E");
		    	 else
		    	 System.out.println(c);
		     }
		     else if(words[0].equals("contains"))
			    {
			    	 Pair2 key = new Pair2(words[1], words[2]);
			    	 if(table.contains(key)) System.out.println("T");
			    	 else System.out.println("F");
			     }
		     else if(words[0].equals("get"))
		     {
		    	 Pair2 key = new Pair2(words[1], words[2]);
		    	 Student obj2 = (Student) table.get(key);
		    	 if(obj2 != null)
		    	 {
		    		 System.out.println(obj2.fname()+" "+obj2.lname()+" "+obj2.hostel()+" "+obj2.department()+" "+obj2.cgpa());
		    	 }
		    	 else
		    	 {
		    		 System.out.println("E");
		    	 }
		     }
		     
		     
		     //address
		     
		     else if(words[0].equals("address"))
		     {
		    	 Pair2 key = new Pair2(words[1], words[2]);
		    	 String s = table.address(key);
		    	 System.out.println(s);
		     }
	 }
	    }
	    
	    else if(a.contentEquals("SCBST"))
	    {
	    	node[] array = new node[N];
			MyHashTablesep table = new MyHashTablesep(N, array);
			FileReader fr = new FileReader(args[2]); 
		    BufferedReader br = new BufferedReader(fr);
		    
		    while(br.ready()) {
		    	
			    String str = br.readLine();
			    String[] words = str.split(" ");
			     if(words[0].equals("insert"))
			     {
			    	 Student value = new Student(words[1], words[2], words[3], words[4], words[5]);
			    	 Pair2 p2 = new Pair2(words[1], words[2]);
			    	 int m = table.insert(p2, value);
			    	 if(m == -1) System.out.println("E");
			    	 else System.out.println(m);
			     }
			     else if(words[0].equals("update"))
			     {
			    	 Student value = new Student(words[1], words[2], words[3], words[4], words[5]);
			    	 Pair2 key = new Pair2(words[1], words[2]);
			    	 int m = table.update(key, value);
			    	 if(m == -1) System.out.println("E");
			    	 else System.out.println(m);
			     }
			     else if(words[0].equals("delete"))
			    {
			    	 Pair2 key = new Pair2(words[1], words[2]);
			    	 int b = table.delete(key);
			    	 if(b == -1) System.out.println("E");
			    	 else System.out.println(b);
			     }
			     else if(words[0].equals("contains"))
				    {
				    	 Pair2 key = new Pair2(words[1], words[2]);
				    	 if(table.contains(key)) System.out.println("T");
				    	 else System.out.println("F");
				     }
			     else if(words[0].equals("address"))
			     {
			    	 Pair2 key = new Pair2(words[1], words[2]);
			    	 String s = table.address(key);
			    	 if(s.contentEquals("-1")) System.out.println("E");
			    	 else System.out.println();
			     }
			     else if(words[0].contentEquals("get"))
			     {
			    	 Pair2 key = new Pair2(words[1], words[2]);
			    	 Student obj2 = (Student) table.get(key);
			    	 if(obj2 != null)
			    	 {
			    		 System.out.println(obj2.fname()+" "+obj2.lname()+" "+obj2.hostel()+" "+obj2.department()+" "+obj2.cgpa());
			    	 }
			    	 else
			    	 {
			    		 System.out.println("E");
			    	 }
			     }
			    
		 }
	    }
	    
	    
	}
}
