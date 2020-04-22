import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Main
{
	static LinkedList<Hostel> allHostels = new LinkedList<Hostel>();
    static LinkedList<Department> allDepartments = new LinkedList<Department>();
    static LinkedList<Course> allCourses = new LinkedList<Course>();
    static LinkedList<Student_> StuList = new LinkedList<Student_>();
    static LinkedList<CourseFullName> l2 = new LinkedList<CourseFullName> ();
    
	private static void getData(String studentfilename, String coursefilename) throws IOException
	{
		FileReader fr = new FileReader(studentfilename); 
	    BufferedReader br = new BufferedReader(fr);
	    
	    
	    
	    
	    while(br.ready()) {
		    String str = br.readLine();
		    String[] words = str.split(" ");
		    
		    Student obj = new Student(words[1], words[0], words[3], words[2], 0, 0);
		    StuList.add(obj);
									    Iterator<Position_<Hostel>> it = allHostels.positions();
									    if(allHostels.count() != 0) {
									    	int count = 0;
									    	int count2 = 0;
									    	Hostel obj5 = allHostels.head.value();
									    	if(obj5.name().equals(words[3]))
									    	{
									    		
									    		count2++;
									    		obj5.list.add(obj);
									    		
									    	}
									    		while(it.hasNext() && count2 == 0)
									    		{
											    	
											    	Hostel obj3 = it.next().value();
											    	if(obj3.name.equals(words[3]))
											    	{
											    		
											    		obj3.list.add(obj);
											    		count++;
											    		break;
											    	}
									    	}
									    		if(count ==0 && count2 == 0)
									    		{
									    			LinkedList<Student_> list1 = new LinkedList<Student_>();
									    			list1.add(obj);
									    			Hostel obj4 = new Hostel(words[3], list1);
									    			allHostels.add(obj4);
									    		}
									    }
									    		else
											    {
											    	LinkedList<Student_> list1 = new LinkedList<Student_>();
									    			list1.add(obj);
									    			Hostel obj4 = new Hostel(words[3], list1);
									    			allHostels.add(obj4);
											    }	
									    		
					Iterator<Position_<Department>> it2 = allDepartments.positions();
					if(allDepartments.count() != 0) {
									    	
					   	int count1 = 0;
					   	int count21 = 0;
					   	Department obj51 = allDepartments.head.value();
					  	if(obj51.name().equals(words[2]))
					   	{ 
					  		count21++;
					 		obj51.list.add(obj);
										    		
					   	}
					 		while(it2.hasNext() && count21 == 0)
					   		{
							    	Department obj31 = it2.next().value();
							    	if(obj31.name.equals(words[2]))
							    	{
								    		obj31.list.add(obj);
								    		count1++;
								    		break;
							    	}
					    	}
					   		if(count1 ==0 && count21 == 0)
					   		{
					    			LinkedList<Student_> list11 = new LinkedList<Student_>();
					    			list11.add(obj);
					    			Department obj41 = new Department(words[2], list11);
									allDepartments.add(obj41);
				    		}
		    }
		    else
		    {
		    	LinkedList<Student_> list11 = new LinkedList<Student_>();
    			list11.add(obj);
    			Department obj41 = new Department(words[2], list11);
    			allDepartments.add(obj41);
		    }
		    
		    
		    //System.out.println(obj.name());
	    }
	    fr.close();
	    br.close();
	    
	    //To print all the elements
	    /*
	    Iterator<Position_<Hostel>> it = allHostels.positions();
	    Hostel o1 = allHostels.head.value();
	    System.out.print("Hostel's name : "+o1.name+ " ");
	    Iterator<Position_<Student_> > it3 = o1.list.positions();
    	while(it3.hasNext())
    	{
    		System.out.print(it3.next().value().name() + " ");
    	}
    	System.out.println(" ");
	    while(it.hasNext())
	    {
	    	Hostel o = it.next().value();
	    	System.out.print("Hostel's name : "+o.name + " ");
	    	Iterator<Position_<Student_> > it2 = o.list.positions();
	    	while(it2.hasNext())
	    	{
	    		System.out.print(it2.next().value().name() + " ");
	    	}
	    	System.out.println(" ");
	    }
	    */
	    //ashwini wala code<start>
	    
	    FileReader fr111=new FileReader(coursefilename);
		BufferedReader br111=new BufferedReader(fr111);
//		int x6=0;
		while(br111.ready())
		{
//			x6++;
			String str111=br111.readLine();
			String [] words111=str111.split(" ",4);
			
			String s13=words111[0];//entryNo
			String s14=words111[1];//coursenum
			String s15=words111[2];//coursegrade
			String s16=words111[3];//coursetitle
			String s17=StuList.head.value().entryNo();
			
			if(s17.equals(s13))
			{
				CourseGrade c3=new CourseGrade(s16,s14, s15);
				Student aa = (Student) StuList.head.value();
				aa.list.add(c3);
				if(s15.equals("A")||s15.equals("Aminus")||s15.equals("B")||s15.equals("Bminus")||s15.equals("C")||s15.equals("Cminus")||s15.equals("D"))
				{
//					System.out.println("grade is passing");
					Student o=(Student) StuList.head.value();
					int gradeo=0;
					if (s15.equals("A"))
						gradeo=10;

					else if (s15.equals("Aminus")) 
						gradeo= 9;

					else if (s15.equals("B")) 
						gradeo=8;

					else if (s15.equals("Bminus")) 
						gradeo= 7;

					else if (s15.equals("C")) 
						gradeo=6;

					else if (s15.equals("Cminus")) 
						gradeo=5;

					else if (s15.equals("D")) 
						gradeo= 4;
					
					o.gradesearned +=gradeo;
					o.list1.add(1);
					o.list2.add(1);
//					System.out.println("completed credits for entry no "+o.entryNo()+"is "+o.list1.count());
//					System.out.println("Total credits for entry no "+o.entryNo()+"is " +o.list2.count());
				}
				else if(s15.equals("E")||s15.equals("F"))
				{
//					System.out.println("grade is fail");
					Student o=(Student) StuList.head.value();
					o.list2.add(1);
//					System.out.println("completed credits for entry no "+o.entryNo()+"is"+o.list1.count());
//					System.out.println("Total credits credits for entry no "+o.entryNo()+"is "+o.list2.count());
				}
				
			}
			else
			{
//				System.out.println("Grade when size of all students greater than 1 is"+s15);
				LinkedListIterator<Student_> it3=new LinkedListIterator<Student_>(StuList.head);
				while(it3.hasNext())
				{
					Student o=(Student) it3.next().value();
					String s18=o.entryNo();
					if(s18.equals(s13))
					{
						CourseGrade c3=new CourseGrade(s16,s14, s15);
						o.list.add(c3);
						if(s15.equals("A")||s15.equals("Aminus")||s15.equals("B")||s15.equals("Bminus")||s15.equals("C")||s15.equals("Cminus")||s15.equals("D"))
						{	
							int gradeo=0;
							if (s15.equals("A"))
								gradeo=10;

							else if (s15.equals("Aminus")) 
								gradeo= 9;

							else if (s15.equals("B")) 
								gradeo=8;

							else if (s15.equals("Bminus")) 
								gradeo= 7;

							else if (s15.equals("C")) 
								gradeo=6;

							else if (s15.equals("Cminus")) 
								gradeo=5;

							else if (s15.equals("D")) 
								gradeo= 4;
							
							o.gradesearned +=gradeo;
//							System.out.println("grade is passing with size of all students linkedlist greater than 1");
							o.list1.add(1);
							o.list2.add(1);
//							System.out.println("completed credits for entry no "+o.entryNo()+"is"+o.list1.count());
//							System.out.println("Total credits credits for entry no "+o.entryNo()+"is "+o.list2.count());
						}
						else if(s15.equals("E")||s15.equals("F"))
						{
//							System.out.println("grade is fail with size of all students linkedlist greater than 1");
							o.list2.add(1);
//							System.out.println("completed credits for entry no "+o.entryNo()+"is"+o.list1.count());
//							System.out.println("Total credits for entry no "+o.entryNo()+"is  "+o.list2.count());
						}
						
					}
				}
				
				
			}
		}
	    //ashwini wala code<end>
	    
	    
	    
	    
	    FileReader fr2 = new FileReader(coursefilename); 
	    BufferedReader br2 = new BufferedReader(fr2);
	    
	    while(br2.ready())
	    {
	    	//System.out.println("Hello Manoj");
	    	String str = br2.readLine();
	    	String[] words = str.split(" ", 4);
	    	
	    	
//	    	//store data in the objects of StuList
//	    	if(StuList.head.value().entryNo().equals(words[0]))
//	    	{
//	    		LinkedList<CourseGrade_> list = new LinkedList<CourseGrade_>();
//	    		Student o = (Student) StuList.head.value();
//	    		o.cre += 3;
//	    		CourseGrade n = new CourseGrade(words[3], words[1], words[2]);
//	    		o.list.add(n);
//	    	}
//	    	
//	    	Iterator<Position_<Student_>> i = StuList.positions();
//	    	while(i.hasNext())
//	    	{
//	    		
//	    		Student o = (Student) i.next().value();
//	    		if(o.entryNo().equals(words[0])) {
//	    		o.cre += 3;
//	    		CourseGrade n = new CourseGrade(words[3], words[1], words[2]);
//	    		o.list.add(n);
//	    		}
//	    	}
//	    	
//	    	
	    	
	    	// Store data in l2
	    	int cont = 0;
	    	//CourseFullName o3 = new CourseFullName(words[1], words[3]);
	    	if(l2.count() !=0) {
	    			if(l2.head.value().CourseName.equals(words[1]))
	    			{
	    				cont++;
	    				//kuch nhi krna
	    			}
	    			
	    	Iterator<Position_<CourseFullName>> i4 = l2.positions();
	    	while(i4.hasNext() && cont == 0)
	    	{
	    		if(i4.next().value().CourseName.equals(words[1]))
	    		{
	    			cont++;
	    			break;
	    		}
	    	}
	    	}
	    	
	    	if(cont == 0 || l2.count() == 0)
	    	{
	    		CourseFullName a = new CourseFullName(words[1], words[3]);
	    		l2.add(a);
	    	}
	    	
	    	//stored in l2
	    	//complete
	    	//storing in allCourses
	    	
	    	
	    	Iterator<Position_<Course>> it31 = allCourses.positions();
	    	if(allCourses.count() != 0)
	    	{
	    		
	    		int count2=0;
	    		Course obj5 = allCourses.head.value();
	    		if(obj5.name().equals(words[1]))
	    		{
	    			
	    			count2++;
	    			Iterator<Position_<Student_>> it4 = StuList.positions();
	    			if(StuList.head.value().entryNo().equals(words[0]))
	    			{
	    				Student_ obj7 = StuList.head.value();
	    				obj5.list.add(obj7);
	    				
	    			}
	    			else {
	    				while(it4.hasNext())
	    				{
	    					Student_ obj7 = it4.next().value();
	    					if(obj7.entryNo().equals(words[0]))
	    					{
	    						obj5.list.add(obj7);
	    						break;
	    					}
	    				}
	    			}
	     		}
	    		else {
	    			//System.out.println("Hello Manoj");
	    			//System.out.println("allCourses ka count : " + allCourses.count());
	    			if(allCourses.count() == 1)
	    			{
	    				
	    				LinkedList<Student_> list = new LinkedList<Student_>();
	    				Iterator<Position_<Student_>> it4 = StuList.positions();
		    			if(StuList.head.value().entryNo().equals(words[0]))
		    			{
		    				Student_ obj7 = StuList.head.value();
		    				list.add(obj7);
		    			}
		    		
		    			else {
		    				
		    				while(it4.hasNext())
		    				{
		    					
		    					Student_ obj7 = it4.next().value();
		    					if(obj7.entryNo().equals(words[0]))
		    					{
		    						list.add(obj7);
		    						break;
		    					}
		    				}
		    				}
		    			
		    			Course oo = new Course(words[1], list);
		    			allCourses.add(oo);
	    				
	    				
	    				
//	    				Course obj51 = allCourses.head.value();
//	    				if(obj51.name().equals(words[1]))
//	    				{
//		    			Iterator<Position_<Student_>> it4 = StuList.positions();
//		    			if(StuList.head.value().entryNo().equals(words[0]))
//		    			{
//		    				Student_ obj7 = StuList.head.value();
//		    				obj51.list.add(obj7);
//		    			}
//		    		
//		    			else {
//		    				
//		    				while(it4.hasNext())
//		    				{
//		    					
//		    					Student_ obj7 = it4.next().value();
//		    					if(obj7.entryNo().equals(words[0]))
//		    					{
//		    						obj51.list.add(obj7);
//		    						break;
//		    					}
//		    				}
//		    				}
//	    				}
//	    				else
//	    				{
//	    					LinkedList<Student_> list = new LinkedList<Student_>();
//	    					Iterator<Position_<Student_> > it4 = StuList.positions();
//	    		    		if(StuList.head.value().entryNo().equals(words[0]))
//	    		    		{
//	    		    			list.add(StuList.head.value());
//	    		    		}
//	    		    		else {
//	    		    			
//	    		    			while(it4.hasNext())
//	    		    			{
//	    		    				Student_ ob = it4.next().value();
//	    		    				if(ob.entryNo().equals(words[0]))
//	    		    				{
//	    		    					 list.add(ob);
//	    		    					 break;
//	    		    				}
//	    		    				
//	    		    			}
//	    		    			
//	    		    		}
//	    		    		Course objj = new Course(words[1], list);
//	    		    		allCourses.add(objj);
//	    				}
	    				
	    				
	    			}
	    			int count = 0;
	    			while(it31.hasNext() && allCourses.count() != 1)
	    			{
	    				
	    				//System.out.println("Hello Manoj");
	    				Course obj51 = it31.next().value();
	    				if(obj51.name().equals(words[1]))
	    				{
	    					count++;
	    					Iterator<Position_<Student_>> it4 = StuList.positions();
	    					if(StuList.head.value().entryNo().equals(words[0]))
	    					{
	    						Student_ obj7 = StuList.head.value();
	    						obj51.list.add(obj7);
	    					}
		    		
		    			else {
		    				
		    				while(it4.hasNext())
		    				{
		    					
		    					Student_ obj7 = it4.next().value();
		    					if(obj7.entryNo().equals(words[0]))
		    					obj51.list.add(obj7);
		    				}
		    				}
	    				}
	    			}
	    				if(count == 0)
	    				{
	    					LinkedList<Student_> list = new LinkedList<Student_>();
	    					Iterator<Position_<Student_> > it4 = StuList.positions();
	    		    		if(StuList.head.value().entryNo().equals(words[0]))
	    		    		{
	    		    			list.add(StuList.head.value());
	    		    		}
	    		    		else {
	    		    			
	    		    			while(it4.hasNext())
	    		    			{
	    		    				Student_ ob = it4.next().value();
	    		    				if(ob.entryNo().equals(words[0]))
	    		    				{
	    		    					 list.add(ob);
	    		    				}
	    		    				
	    		    			}
	    		    			
	    		    		}
	    		    		Course objj = new Course(words[1], list);
	    		    		allCourses.add(objj);

	    				}
	    			}
	    		}
	    	//neeche ka shi hai
	    	
	    	else
	    	{
	    		LinkedList<Student_> list = new LinkedList<Student_>();
	    		Iterator<Position_<Student_> > it4 = StuList.positions();
	    		if(StuList.head.value().entryNo().equals(words[0]))
	    		{
	    			list.add(StuList.head.value());
	    		}
	    		else {
	    			while(it4.hasNext())
	    			{
	    				Student_ ob = it4.next().value();
	    				if(ob.entryNo().equals(words[0]))
	    				{
	    					 list.add(ob);
	    					 break;
	    				}
	    				
	    			}
	    		}
	    		Course objj = new Course(words[1], list);
	    		allCourses.add(objj);
	    	}
	    	 //System.out.println(words[0]);	
	    }
	
	
	    // print the allCourses list
//	    
//	    Iterator<Position_<Course>> it = allCourses.positions();
//	    
//	    Course o1 = allCourses.head.value();
//	    System.out.println(allCourses.count());
//	    System.out.print("Course's name : "+o1.name+ " ");
//	    System.out.print(o1.list.count());
//	    Iterator<Position_<Student_> > it3 = o1.list.positions();
//	    System.out.print(o1.list.head.value().name() + " ");
//    	while(it3.hasNext())
//    	{
//    		System.out.print(it3.next().value().name() + " ");
//    	}
//    	System.out.println(" ");
//	    while(it.hasNext())
//	    {
//	    	Course o = it.next().value();
//	    	System.out.print("Course's name : "+o.name + " ");
//	    	System.out.print(o.list.count());
//	    	Iterator<Position_<Student_> > it2 = o.list.positions();
//	    	System.out.print(o.list.head.value().name() + " ");
//	    	while(it2.hasNext())
//	    	{
//	    		System.out.print(it2.next().value().name() + " ");
//	    	}
//	    	System.out.println(" ");
//	    }
//	    
	    
	    
	    //print l2 list
//	    CourseFullName o5 = l2.head.value();
//	    System.out.println(o5.CourseName() + " " + o5.CourseTitle());
//	    Iterator<Position_<CourseFullName>> i5 = l2.positions();
//	    while(i5.hasNext())
//	    {
//	    	CourseFullName o6 = i5.next().value();
//	    	System.out.println(o6.CourseName() + " " + o6.CourseTitle());
//	    }
//	

	}
	
	private static void answerQueries(String queries) throws IOException
	{
	    //getQueries
	    
	    FileReader fr3 = new FileReader(queries);
	    BufferedReader br3 = new BufferedReader(fr3);
	    
	    int c = 0;
	    while(br3.ready())
	    {
	    	String str = br3.readLine();
	    	c++;
	    }
	    br3.close();
	    fr3.close();
	    

	    
	    FileReader fr4 = new FileReader(queries);
	    BufferedReader br4 = new BufferedReader(fr4);
	    
	    String[] query = new String[c];
	    int k=0;
	    while(br4.ready())
	    {
	    	String str = br4.readLine();
	    	query[k] = str;
	    	k++;
	    }
	    
	    for(int j=c-1; j>=0; j--)
	    {
	    	String str = query[j];
	    	String[] words = str.split(" ");
	    	if(words[0].equals("COURSETITLE"))
	    	{
	    		if(l2.head.value().CourseName().equals(words[1]))
	    		{
	    			System.out.print(l2.head.value().CourseTitle());
	    		}
	    		else
	    		{
	    			Iterator<Position_<CourseFullName>> i6 = l2.positions();
	    			while(i6.hasNext())
	    			{
	    				CourseFullName o6 = i6.next().value();
	    				if(o6.CourseName().equals(words[1]))
	    				{
	    					System.out.print(o6.CourseTitle());
	    					break;
	    				}
	    			}
	    		}
	    	}
	    	
	    	else if(words[0].equals("SHARE"))
	    	{
	    		//allCourses
	    		//allDepartments
	    		int cn=0;
	    		Iterator<Position_<Hostel>> i8 = allHostels.positions();
    			if(allHostels.head.value().name().equals(words[2]))
    					{//System.out.println("I am here");
    				cn++;
    				String[] array= new String[allHostels.head.value().list.count()-1];
    				int l=0;
    				Iterator<Position_<Student_>> ii = allHostels.head.value().list.positions();
    				if(!allHostels.head.value().list.head.value().entryNo().equals(words[1]))
    				{//System.out.println("I am here");
    					array[l] = allHostels.head.value().list.head.value().entryNo();
						l++;
    				}
    				
    				while(ii.hasNext())
    				{//System.out.println("I am here");
    					Student ooo = (Student) ii.next().value();
    					if(!ooo.entryNo().equals(words[1])) {
    						array[l] = ooo.entryNo();
    						l++;
    					}
    				}
    				
    				//BubbleSort
    				//System.out.println("array ki length : "+array.length);
    				for (int p = 0; p < ( array.length - 1 ); p++) {
    				      for (int d = 0; d < array.length - p - 1; d++) {
//    				    	  System.out.println("heloo");
//    				    	  System.out.println(array[d].compareTo(array[d+1]));
    				    	  if(array[d].compareTo(array[d+1]) > 0)
    				        {
    				          String swap       = array[d];
    				          array[d]   = array[d+1];
    				          array[d+1] = swap;
    				        }
    				      }
    				    }
    				
    				for(int t = 0; t<array.length; t++)
    				{
    					System.out.print(array[t]+ " ");
    				}
    				
    					}
    			while(i8.hasNext() && cn == 0)
    			{
    				Hostel ob = i8.next().value();
	    			if(ob.name().equals(words[2]))
	    			{
	    				cn++;
	    				String[] array= new String[ob.list.count()-1];
	    				int l=0;
	    				Iterator<Position_<Student_>> i9 = ob.list.positions();
	    				if(!ob.list.head.value().entryNo().equals(words[1]))
	    				{
	    					array[l] = ob.list.head.value().entryNo();
	    					l++;
	    				}
	    				
	    				while(i9.hasNext())
	    				{
	    					Student oa = (Student) i9.next().value();
	    					if(!oa.entryNo().equals(words[1]))
	    					{
	    						array[l] = oa.entryNo();
	    						l++;
	    					}
	    				}
	    				//bubbleSort;
	    				//System.out.println("array ki length : "+array.length);
	    				for (int p = 0; p < ( array.length - 1 ); p++) {
	    				      for (int d = 0; d < array.length - p - 1; d++) {
//	    				    	  System.out.println("heloo");
//	    				    	  System.out.println(array[d].compareTo(array[d+1]));
	    				    	  if(array[d].compareTo(array[d+1]) > 0)
	    				        {
	    				          String swap       = array[d];
	    				          array[d]   = array[d+1];
	    				          array[d+1] = swap;
	    				        }
	    				      }
	    				    }
	    				
	    				
	    				for(int t = 0; t<array.length; t++)
	    				{
	    					System.out.print(array[t]+ " ");
	    				}
	    			}
    			}
	    		
	    		if(cn == 0)
	    		{
	    			Iterator<Position_<Course>> i81 = allCourses.positions();
	    			if(allCourses.head.value().name().equals(words[2]))
	    					{
	    				cn++;
	    				String[] array= new String[allCourses.head.value().list.count()-1];
	    				int l=0;
	    				Iterator<Position_<Student_>> ii = allCourses.head.value().list.positions();
	    				if(!allCourses.head.value().list.head.value().entryNo().equals(words[1]))
	    				{
	    					array[l] = allCourses.head.value().list.head.value().entryNo();
    						l++;
	    				}
	    				
	    				while(ii.hasNext())
	    				{
	    					Student ooo = (Student) ii.next().value();
	    					if(!ooo.entryNo().equals(words[1])) {
	    						array[l] = ooo.entryNo();
	    						l++;
	    					}
	    				}
	    				//BubbleSort
	    				//System.out.println("array ki length : "+array.length);
	    				for (int p = 0; p < ( array.length - 1 ); p++) {
	    				      for (int d = 0; d < array.length - p - 1; d++) {
//	    				    	  System.out.println("heloo");
//	    				    	  System.out.println(array[d].compareTo(array[d+1]));
	    				    	  if(array[d].compareTo(array[d+1]) > 0)
	    				        {
	    				          String swap       = array[d];
	    				          array[d]   = array[d+1];
	    				          array[d+1] = swap;
	    				        }
	    				      }
	    				    }
	    				
	    				
	    				for(int t = 0; t<array.length; t++)
	    				{
	    					System.out.print(array[t]+ " ");
	    				}
	    				
	    					}
	    			while(i81.hasNext() && cn == 0)
	    			{
	    				Course ob = i81.next().value();
		    			if(ob.name().equals(words[2]))
		    			{
		    				cn++;
		    				String[] array= new String[ob.list.count()-1];
		    				int l=0;
		    				Iterator<Position_<Student_>> i9 = ob.list.positions();
		    				if(!ob.list.head.value().entryNo().equals(words[1]))
		    				{
		    					array[l] = ob.list.head.value().entryNo();
		    					l++;
		    				}
		    				
		    				while(i9.hasNext())
		    				{
		    					Student oa = (Student) i9.next().value();
		    					if(!oa.entryNo().equals(words[1]))
		    					{
		    						array[l] = oa.entryNo();
		    						l++;
		    					}
		    				}
		    				//BubbleSort
		    				//System.out.println("array ki length : "+array.length);
		    				for (int p = 0; p < ( array.length - 1 ); p++) {
		    				      for (int d = 0; d < array.length - p - 1; d++) {
//		    				    	  System.out.println("heloo");
//		    				    	  System.out.println(array[d].compareTo(array[d+1]));
		    				    	  if(array[d].compareTo(array[d+1]) > 0)
		    				        {
		    				          String swap       = array[d];
		    				          array[d]   = array[d+1];
		    				          array[d+1] = swap;
		    				        }
		    				      }
		    				    }
		    				
		    				
		    				for(int t = 0; t<array.length; t++)
		    				{
		    					System.out.print(array[t]+ " ");
		    				}
		    			}
	    			}
	    		}
	    		
	    		if(cn == 0)
	    		{
	    			Iterator<Position_<Department>> i81 = allDepartments.positions();
	    			if(allDepartments.head.value().name().equals(words[2]))
	    					{
	    				cn++;
	    				String[] array= new String[allDepartments.head.value().list.count()-1];
	    				int l=0;
	    				Iterator<Position_<Student_>> ii = allDepartments.head.value().list.positions();
	    				if(!allDepartments.head.value().list.head.value().entryNo().equals(words[1]))
	    				{
	    					array[l] = allDepartments.head.value().list.head.value().entryNo();
    						l++;
	    				}
	    				
	    				while(ii.hasNext())
	    				{
	    					Student ooo = (Student) ii.next().value();
	    					if(!ooo.entryNo().equals(words[1])) {
	    						array[l] = ooo.entryNo();
	    						l++;
	    					}
	    				}
	    				//BubbleSort
	    				//System.out.println("array ki length : "+array.length);
	    				for (int p = 0; p < ( array.length - 1 ); p++) {
	    				      for (int d = 0; d < array.length - p - 1; d++) {
//	    				    	  System.out.println("heloo");
//	    				    	  System.out.println(array[d].compareTo(array[d+1]));
	    				    	  if(array[d].compareTo(array[d+1]) > 0)
	    				        {
	    				          String swap       = array[d];
	    				          array[d]   = array[d+1];
	    				          array[d+1] = swap;
	    				        }
	    				      }
	    				    }
	    				
	    				
	    				for(int t = 0; t<array.length; t++)
	    				{
	    					System.out.print(array[t]+ " ");
	    				}
	    				
	    					}
	    			while(i81.hasNext() && cn == 0)
	    			{
	    				Department ob = i81.next().value();
		    			if(ob.name().equals(words[2]))
		    			{
		    				cn++;
		    				String[] array= new String[ob.list.count()-1];
		    				int l=0;
		    				Iterator<Position_<Student_>> i9 = ob.list.positions();
		    				if(!ob.list.head.value().entryNo().equals(words[1]))
		    				{
		    					array[l] = ob.list.head.value().entryNo();
		    					l++;
		    				}
		    				
		    				while(i9.hasNext())
		    				{
		    					Student oa = (Student) i9.next().value();
		    					if(!oa.entryNo().equals(words[1]))
		    					{
		    						array[l] = oa.entryNo();
		    						l++;
		    					}
		    				}
		    				//BubbleSort
//		    				System.out.println("array ki length : "+array.length);
		    				for (int p = 0; p < ( array.length - 1 ); p++) {
		    				      for (int d = 0; d < array.length - p - 1; d++) {
//		    				    	  System.out.println("heloo");
//		    				    	  System.out.println(array[d].compareTo(array[d+1]));
		    				    	  if(array[d].compareTo(array[d+1]) > 0)
		    				        {
		    				          String swap       = array[d];
		    				          array[d]   = array[d+1];
		    				          array[d+1] = swap;
		    				        }
		    				      }
		    				    }
		    				
		    				
		    				for(int t = 0; t<array.length; t++)
		    				{
		    					System.out.print(array[t]+ " ");
		    				}
		    			}
	    			}
	    		}
	    		
	    		
	    	}
	    	
	    	else if(words[0].equals("INFO"))
	    	{
	    		//System.out.println("Ye info wala hai");
	    		Student ttt = (Student) StuList.head.value();
	    		if(ttt.entryNo().equals(words[1]))
	    		{
	    			System.out.print(ttt.entryNo()+" "+ttt.name()+ " "+ ttt.department()+" "+ttt.hostel()+" "+ ttt.cgpa()+" ");
	    			String[] array = new String[ttt.list.count()];
	    			String[] array2 = new String[ttt.list.count()];
	    			int i=0;
	    			CourseGrade rj = ttt.list.head.value();
	    			array[i] = rj.coursenum;
	    			array2[i] = rj.grade;
	    			i++;
	    			Iterator<Position_<CourseGrade>> iiit = ttt.list.positions();
	    			while(iiit.hasNext())
	    			{
	    				CourseGrade rj2 = iiit.next().value();
	    				array[i] = rj2.coursenum();
	    				array2[i] = rj2.grade;
	    				i++;
	    			}
	    			
	    			for (int p = 0; p < ( array.length - 1 ); p++) {
  				      for (int d = 0; d < array.length - p - 1; d++) {
//  				    	  System.out.println("heloo");
//  				    	  System.out.println(array[d].compareTo(array[d+1]));
  				    	  if(array[d].compareTo(array[d+1]) > 0)
  				        {
  				          String swap = array[d];
  				          array[d]   = array[d+1];
  				          array[d+1] = swap;
  				          swap = array2[d];
  				          array2[d] = array2[d+1];
  				          array2[d+1] = swap;
  				        }
  				      }
  				    }
	    			
	    			for(int t = 0; t<array.length; t++)
    				{
    					System.out.print(array[t]+ " " + array2[t]+ " ");
    				}
	    			
	    		}
	    		else {
	    			//System.out.println("Pappu pass ho gya!");
	    			Iterator<Position_<Student_>> iit = StuList.positions();
	    			while(iit.hasNext())
	    			{
	    				Student ttr = (Student) iit.next().value();
	    				if(ttr.entryNo().equals(words[1]))
	    				{
	    					System.out.print(ttr.entryNo()+ " "+  ttr.name()+ " "+ttr.department()+" "+ttr.hostel()+ " "+ttr.cgpa()+ " ");
	    					String[] array = new String[ttr.list.count()];
	    					String[] array2 = new String[ttr.list.count()];
	    					int i=0;
	    	    			CourseGrade rj = ttr.list.head.value();
	    	    			array[i] = rj.coursenum();
	    	    			array2[i] = rj.grade;
	    	    			i++;
	    	    			Iterator<Position_<CourseGrade>> iiit = ttr.list.positions();
	    	    			while(iiit.hasNext())
	    	    			{
	    	    				CourseGrade rj2 = iiit.next().value();
	    	    				array[i] = rj2.coursenum();
	    	    				array2[i] = rj2.grade;
	    	    				i++;
	    	    			}
	    	    			for (int p = 0; p < ( array.length - 1 ); p++) {
	    	  				      for (int d = 0; d < array.length - p - 1; d++) {
//	    	  				    	  System.out.println("heloo");
//	    	  				    	  System.out.println(array[d].compareTo(array[d+1]));
	    	  				    	  if(array[d].compareTo(array[d+1]) > 0)
	    	  				        {
	    	  				          String swap = array[d];
	    	  				          array[d]   = array[d+1];
	    	  				          array[d+1] = swap;
	    	  				          swap = array2[d];
	    	  				          array2[d] = array2[d+1];
	    	  				          array2[d+1] = swap;
	    	  				        }
	    	  				      }
	    	  				    }
	    		    			
	    		    			for(int t = 0; t<array.length; t++)
	    	    				{
	    	    					System.out.print(array[t]+ " " + array2[t]+ " ");
	    	    				}
	    	    			
	    					break;
	    				}
	    			}
	    			
	    		}
	    		
	    		
	    	}
	    	System.out.println("");
	    	//else if( last Query)
	    	
	    }
	}
	
	public static void main(String[] args) throws IOException {
	/*LinkedList<Integer> list = new LinkedList<Integer>();
	list.add(12);
	list.add(13);
	list.add(list.count());
	//System.out.println(list.head);
	//list.positions();
	//LinkedListIterator<Integer> it = list.positions();
	//System.out.println(list.positions());
//	Node<Integer> it = list.positions();
	Iterator<Position_<Integer>> it = list.positions();
	//System.out.println(it.next().value());
	//System.out.println(it.next().value());
	System.out.println(list.head.value());
	while(it.hasNext())
	{
		System.out.println(it.next().value());
	}
	FileReader fr = new FileReader("C:\\Users\\USER\\Desktop\\text.txt"); 
    BufferedReader br = new BufferedReader(fr);
	//BufferedReader br=new BufferedReader("C:\\Users\\USER\\Desktop\\text.txt");
	String str = br.readLine();
	//String str = "Hey this is ram.";
	String[] words = str.split(" ", 4);
	for(String word : words)
	{
		System.out.println(word);
	}
	*/
		getData("C:\\Users\\USER\\Desktop\\COL106\\Assignment2\\students.txt","C:\\Users\\USER\\Desktop\\COL106\\Assignment2\\courses.txt");
		answerQueries("C:\\Users\\USER\\Desktop\\COL106\\Assignment2\\query.txt");

	}
}
