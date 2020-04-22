public class MyHashTablesep<K,T> implements MyHashTable_<K,T>{
	
	int N;
	int Max_size;
	node[] array;
	MyHashTablesep(int N, node[] array)
	{
		this.N = N;
		double a = N;
		Max_size = (int) a;
		this.array = array;
	}
	
	
	@Override
	public int insert(K key, T obj) {
		// TODO Auto-generated method stub
		if(this.contains(key)) return -1;
		
		Pair2 k = (Pair2) key;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
//		System.out.println(hash1+ " hash1");
		int hash12 = hash1;
		int l=1;
		int r=0;
		Pair<K,T> p = new Pair(key, obj);
		node n = new node(p, null, null);
		if(array[hash12] == null)
		{
			array[hash12] = n;
		}
		
		else 
		{
			node n2 = array[hash12];
			while(true)
			{
					Pair2 val = (Pair2) ((Pair) n2.value()).key();
					String str = val.fname() + val.lname();
					if(s.compareTo(str) < 0)
					{
						if(n2.left()!= null)
						n2 = n2.left();
						else {
							n2.left = n;
							l++;
							break;
						}
						l++;
					}
					else if(s.compareTo(str) > 0)
					{
						if(n2.right() != null)
						n2 = n2.right();
						else {
							n2.right = n;
							r++;
							break;
						}
						r++;
					}
			}
		}
		return l+r;
		
	}

	
	@Override
	public int update(K key, T obj) {
		// TODO Auto-generated method stub
		
		Pair2 k = (Pair2) key;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		int l=1;
		int r=0;
		Pair<K,T> p = new Pair(key, obj);
			node n2 = array[hash1];
			
			if(!this.contains(key)) return -1;
			else {
			while(true)
			{
							Pair2 val = (Pair2) ( (Pair) n2.value()).key();
							String str = val.fname() + val.lname();
							if(s.compareTo(str) < 0)
							{
								n2 = n2.left();
								l++;
							}
							else if(s.compareTo(str) > 0)
							{
								n2 = n2.right();
								r++;
							}
							else if(s.compareTo(str) == 0)
							{
								( (Pair) n2.value()).value = obj;
								break;
							}
			}
			}
		return l+r;
	}

	
	
	@Override
	public int delete(K key) {
		// TODO Auto-generated method stub
		Pair2 k = (Pair2) key;
		int i=0;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		node n2 = array[hash1];
		int l = 0;
		int r = 0;
		node prev = array[hash1];
		if(!this.contains(key)) return -1;
		else {
			
			//I am going for the head;
			Pair2 val = (Pair2) ((Pair) array[hash1].value()).key();
			String str = val.fname() + val.lname();
			int bhahubali = 0;
			if(s.compareTo(str) < 0)
			{
				prev = array[hash1];
				n2 = array[hash1].left();
//				l++;
				i++;
			}
			else if(s.compareTo(str) > 0)
			{
				prev = array[hash1];
				n2 = array[hash1].right();
//				r++;
				i++;
			}
			
			else if(s.compareTo(str) == 0)
			{
				i++;
				//head hi mil gyaa
				if(array[hash1].left() == null && array[hash1].right() == null)
				{
					array[hash1] = null;
					bhahubali = 1;
				}
				else if(array[hash1].right() != null && array[hash1].left() == null)
					{i++;
						array[hash1] = array[hash1].right();
						bhahubali = 1;
					}
				else if (array[hash1].left() != null && array[hash1].right() == null)
				{i++;
					array[hash1]  = array[hash1].left();
					bhahubali = 1;
				}
				else if(array[hash1].left() != null && array[hash1].right() != null)
				{
						bhahubali = 1;
						n2 = array[hash1];
//						System.out.println("most crucial case for head");
						//most crucial case
						node n3 = n2.right();
						if(n3.left() == null && n3.right() == null)
						{
							i++;
							n3.left=array[hash1].left();
							array[hash1] = n3;
															
						}
						else {
						node prev2 = n2;
							//special case1
						int jai=0;
							if(n3.left() == null)
							{i++;
								n3.left = array[hash1].left();
								array[hash1] = n3;
								jai = 1;
							}
							//special case1
							else if(n3.left() != null)
							{i++;
								prev2 = n3;
								n3 = n3.left();
							}
							
							
							while(jai != 1)
							{
								i++;
								if(n3.left() != null)
								{
									prev2 = n3;
									n3 = n3.left();
									i++;
								}
								else if(n3.left() == null)
								{
									prev2.left = n3.right();
									
									
									
									n3.left = n2.left();
									n3.right = n2.right();
									array[hash1] = n3;
									break;
								}
							}
						}
				}
				
			}
			//I am done with the head.
			
			
			while(bhahubali != 1)
			{
				Pair2 val1 = (Pair2) ((Pair) n2.value()).key();
					String str1 = val1.fname() + val1.lname();
					if(s.compareTo(str1) < 0)
					{
//						System.out.println("going to left");
						i++;
						prev = n2;
						n2 = n2.left();
//						l++;
					}
					else if(s.compareTo(str1) > 0)
					{
						i++;
//						System.out.println("going to right");
						prev = n2;
						n2 = n2.right();
						r++;
					}
					else if(s.compareTo(str1) == 0)
					{//bhahubali = 1;
//						System.out.println("found");
						i++;
						
						//mil gyaa
						if(n2.left() == null && n2.right() == null)
						{
//							System.out.println("Hello Manoj");
						if(prev.left() == n2) { prev.left = null;}
						else if(prev.right() == n2 ) { prev.right = null;}
							n2  = null;
							break;
						}
						else if(n2.right() != null && n2.left() == null)
							{
								i++;
								if(prev.left() == n2)
								{
									prev.left = n2.right();
								}
								else prev.right = n2.right();
								n2 = null;
								break;
//								node n3 = n2.left();
							}
						else if(n2.right() == null && n2.left() != null)
						{i++;
							if(prev.left() == n2)
							{
								prev.left = n2.left();
							}
							else if(prev.right() == n2) prev.right = n2.left();
							break;
						}
						
						else if(n2.right() != null && n2.left() != null)
						{
							node n3 = n2.right();
							if(n3.left() == null && n3.right() == null)
							{
								i++;
								n3.left = n2.left();
								if(prev.left() == n2)
								{
									prev.left = n3;
								}
								else prev.right = n3;
								
																
								break;
							}
							//new
							else {
								node prev2 =n2;
								int jai = 0;
								if(n3.left() == null)
								{
									n3.left = n2.left();
									n2 = n3;
									jai = 1;
								}
								else if(n3.left() != null)
								{i++;
									prev2 = n3;
									n3 = n3.left();
									
								}
								while(jai != 1)
								{
									i++;
									if(n3.left() != null)
									{i++;
										prev2 = n3;
										n3 = n3.left();
									}
									else if(n3.left() == null)
									{
										prev2.left = n3.right();
										n3.left = n2.left();
										n3.right = n2.right();
										if(prev.left == n2) prev.left = n3;
										else prev.right = n3;
										
										
										//System.out.println("Jaaat");
										n2 = null;
										break;
									
									}
								}
								break;
			}
			
		}}}}
		return i;
	}

	
	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		Pair2 k = (Pair2) key;
		int l=0; int r = 0;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		node n2 = array[hash1];
		while(n2!= null)
		{
			
				String str = ((Pair2)((Pair) n2.value()).key()).fname() + ((Pair2)((Pair) n2.value()).key()).lname();
				if(s.compareTo(str) < 0)
				{
					if(n2.left() != null) {
					n2 = n2.left();
					l++;
					}
					else return false;
					
				}
				else if(s.compareTo(str) > 0)
				{
					if(n2.right() != null) {
					n2 = n2.right();
					r++;
					}else return false;
				}
				else if(s.compareTo(str) == 0)
				{
					return true;
				}
				}
		return false;
		}

	
	@Override
	public T get(K key){
		// TODO Auto-generated method stub
		Pair2 k = (Pair2) key;
		int l=0; int r = 0;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		node n2 = array[hash1];
		if(this.contains(key))
		{
			while(true)
			{
					String str = ((Pair2)((Pair) n2.value()).key()).fname() + ((Pair2)((Pair) n2.value()).key()).lname();
					if(s.compareTo(str) < 0)
					{
						n2 = n2.left();
					}
					else if(s.compareTo(str) > 0)
					{
						n2 = n2.right();
					}
					else if(s.compareTo(str) == 0)
					{
						return (T) ((Pair) n2.value()).value();
					}
			}
		}
		else return null;
		
	}

	
	@Override
	public String address(K key) {
		// TODO Auto-generated method stub
		String t = "Manoj";
		
		if(!(this.contains(key))) {
//			System.out.println("andar wali addressing start");
			return "-1";
		}
		else
		{//System.out.println("andar wali addressing start");
			Pair2 k = (Pair2) key;
			String s = k.fname() + k.lname();
			int hash1 = (int) djb2(s, Max_size);
//			System.out.println(hash1+ " hash1");
			int hash12 = hash1;
			int l=1;
			int r=0;
			System.out.print(hash12+"-");
//			Pair<K,T> p = new Pair(key, obj);
//			node n = new node(p, null, null);
//			System.out.println(hash12 + " it is hash12 for "+ k.fname());
			node n2 = array[hash12];
			while(true)
			{
					Pair2 val = (Pair2) ((Pair) n2.value()).key();
					String str = val.fname() + val.lname();
					if(s.compareTo(str) < 0)
					{
						System.out.print("L");
						n2 = n2.left();
						l++;
					}
					else if(s.compareTo(str) > 0)
					{
						System.out.print("R");
						n2 = n2.right();
						r++;
					}
					else if(s.compareTo(str) == 0)
					{
						break;
					}
			}
			
		}
		
		return t;
	}

	
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}

	
}
