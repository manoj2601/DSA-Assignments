
import java.util.ArrayList;

public class MaxHeap<T extends Comparable> implements PriorityQueueInterface<T> {

	 public ArrayList<T> A = new ArrayList<T>();	
	 int size=0;
	 public int rightChild(ArrayList<T> A, int i)
	 {
		 if(i != 0) {
		 if(2*i+2 < A.size())
		return 2*i + 2;
		 }
		 else if( i == 0 && A.size()>2)
		 {
			 return 2;
		 }
		 return -1;
	 }
	 public int size()
	 {
		 return size;
	 }
	 public int leftChild(ArrayList<T> A, int i)
	 {
		 if(i != 0) {
		 if((2*i) + 1 < A.size())
		return (2*i) + 1;
		 }
		 else if(i == 0 && A.size() > 1) {
			 return 1;
		 }
		 return -1;
	 }
	 
	 public int parent(ArrayList<T> A, int i)
	 {
		 if(i!= 0) {
		 if(i<A.size())
			 return (i-1)/2;
		 }
		 return -1;
	 }

    @Override
    public void insert(T element) 
    {
    	
    	
    	
    	size++;
    	int m=0;
    	int i=0;
    	  A.add(element);
    	  int index = A.size()-1;
    	  while((index>0) && (A.get(parent(A, index))).compareTo(A.get(index)) < 0){
		      T temp;
		      temp = A.get(parent(A, index));
		      A.set(parent(A, index), A.get(index));
		      A.set(index, temp);
		      index = parent(A, index);
    	  }
    	  }
    

    @Override
    public T extractMax() 
    {
    	if(A.size() == 0)
    		return null;
    	size--;
    	T temp;
    	temp = A.get(0);
    	A.set(0, A.get(A.size()-1));
	try{
    	A.remove(A.size()-1);
	}
	catch(Exception e)
	{
	}
    	int index = 0;
    	while(!(leftChild(A, index) < 0) || !(rightChild(A,  index)<0))
    	{
    		int a1=0;
    		int b1=0;
    		if(leftChild(A, index) > 0) {
    			
    			a1 = ( (Triangle) A.get(leftChild(A, index))).id;
    		}
    		if(rightChild(A, index)>0) { 
    			b1 = ((Triangle)A.get(rightChild(A, index))).id;
    			}

    		if(temp instanceof Triangle)
    		{
    		if(((Triangle)A.get(index)).id < a1 || ((Triangle)A.get(index)).id < b1)
    		{
    			int a;
    			int b;
    			if(A.get(leftChild(A, index)) != null)
    				a = ((Triangle)A.get(leftChild(A, index))).id;
    			else a = 0;
    			if(!(rightChild(A, index)<0) && A.get(rightChild(A, index)) != null)
    				b = ((Triangle) A.get(rightChild(A, index))).id;
    			else b = 0;
    			if(a > b && ((a!= 0) || (b!= 0)))
    			{
    				T temp21;
    				temp21 = A.get(index);
	   	    		 A.set(index, A.get(leftChild(A, index)));
	   	    		 A.set(leftChild(A, index), temp21);
	   	    		 index = leftChild(A, index);
    			}
    			else if((a!= 0) || (b!= 0)) {
    				T temp21 = A.get(index);
   	    		 A.set(index, A.get(rightChild(A, index)));
   	    		 A.set(rightChild(A, index), temp21);
   	    		 index = rightChild(A, index);
    			}
    			else break;
    		}
   		
    		else break;
    		//for Student end
    	}

    	}
        return (T) temp;
    }

}
