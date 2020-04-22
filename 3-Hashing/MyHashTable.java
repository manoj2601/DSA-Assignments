import java.lang.Math; 

public class MyHashTable<K, T> implements MyHashTable_<K, T> {

	int N;
	int Max_size;
	Pair[] array;
	MyHashTable(int N, Pair[] array)
	{
		this.N = N;
		Max_size = (int) N;
		this.array = array;
	}
	@Override
	public int insert(K key, T obj) 
	{
		// TODO Auto-generated method stub2
		Pair2 k = (Pair2) key;
		if(this.contains(key)) return -1;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		int hash2 = (int) sdbm(s, Max_size);
		int i=1;
		int k2 = hash1;
		while(true)
		{
			if(array[k2] == null)
			{
				Pair a = new Pair(key, obj);
				array[k2] = a;
				break;
			}
			else {
				
				k2 = (hash1 + i*hash2)%Max_size;
				i++;
			}
		}
		return i;
	}

	@Override
	public int update(K key, T obj) {
		// TODO Auto-generated method stub
		Pair2 k = (Pair2) key;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		int hash2 = (int) sdbm(s, Max_size);
		int hash12 = hash1;
		int i=1;
		if(!this.contains(key)) return Max_size+1;
		else {
		for(i=1; i<Max_size; i++)
		{
			if(array[hash12] != null) {
				Pair2 k2 = (Pair2) array[hash12].key();
			if(k2.fname().equals(k.fname()) && k2.lname().equals(k.lname()) )
			{
//				System.out.println("key for update found");
				Pair a = new Pair(key, obj);
				array[hash12] = a;
				break;
			}
			else{
					hash12 = (hash1 + i*hash2)%Max_size;
				}
			}
			else {
				hash12 = (hash1 + i*hash2)%Max_size;
			}
		}
		}
		return i;
	}

	@Override
	public int delete(K key) {
		// TODO Auto-generated method stub
		Pair2 k = (Pair2) key;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		int hash2 = (int) sdbm(s, Max_size);
		int hash12 = hash1;
		int i=1;
		if(!this.contains(key)) return Max_size+1;
		else {
		for(i=1; i<Max_size; i++)
		{
			if(array[hash12] != null) {
			Pair2 k2 = (Pair2) array[hash12].key();
			if(k2.fname().equals(k.fname()) && k2.lname().equals(k.lname()))
			{
				array[hash12] = null;
				break;
			}
				else {
					hash12 = (hash1 + i*hash2)%Max_size;
				} 
			}
			else {
				hash12 = (hash1 + i*hash2)%Max_size;
			} 
		}
		return i;
		}
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		Pair2 k = (Pair2) key;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		int hash2 = (int) sdbm(s, Max_size);
		
		int hash12 = hash1; 
		int i;
		for(i=1; i<Max_size; i++)
		{
			if(array[hash12] != null) {
			Pair2 k2 = (Pair2) array[hash12].key();
			if(k2.fname().equals(k.fname()) && k2.lname().equals(k.lname()))
			{
				return true;
			}
			else {
				hash12 = (hash1 + i*hash2)%Max_size;
			}
			}
			else {
				hash12 = (hash1 + i*hash2)%Max_size;
			}
		}
		return false;
	}

	@Override
	public T get(K key) throws NotFoundException {
		// TODO Auto-generated method stub
		Pair2 k = (Pair2) key;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		int hash2 = (int) sdbm(s, Max_size);
		int hash12 = hash1;
		int i;
		if(contains(key))
		{
			for(i=1; i<Max_size; i++)
			{
				if(array[hash12] != null) {
				Pair2 k2 = (Pair2) array[hash12].key();
				if(k2.fname().equals(k.fname()) && k2.lname().equals(k.lname()))
				{
					return (T) array[hash12].value();
				}
				else {
					hash12 = (hash1 + i*hash2)%Max_size;
				}
				}
				else
				{
					hash12 = (hash1 + i*hash2)%Max_size;
				}
			}
		}
		
		return null;
	}

	@Override
	public String address(K key) throws NotFoundException {
		// TODO Auto-generated method stub
		Pair2 k = (Pair2) key;
		String s = k.fname() + k.lname();
		int hash1 = (int) djb2(s, Max_size);
		int hash2 = (int) sdbm(s, Max_size);
		int hash12 = hash1;
		int i;
		if(this.contains(key)) {
		for(i=1; i<Max_size; i++)
		{
			if(array[hash12] != null) {
				//System.out.println("Nikki");
				Pair2 k2 = (Pair2) array[hash12].key();
				
			if(k2.fname().equals(k.fname()) && k2.lname().equals(k.lname()))
			{
				return Integer.toString(hash12);
			}
			else {
				hash12 = (hash1 + i*hash2)%Max_size;
			}
			}
			else {
					hash12 = (hash1 + i*hash2)%Max_size;
				}
			}
		return "Chaudhary";
		}
		else
		return "E";
	}
	 
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}
	
	
	public static long sdbm(String str, int hashtableSize) { 
	    long hash = 0; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
	    } 
	    return Math.abs(hash) % (hashtableSize - 1) + 1; 
	}
	
}
