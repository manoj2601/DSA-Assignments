
public class ArrayList<T> {
	
	
private static final int SIZE_FACTOR=5;
	
	private T data[];
	
	private int index;
	
	private int size;
	
	public ArrayList(){
		this.data=(T[]) new Object[SIZE_FACTOR];
		this.size=SIZE_FACTOR;
	}
	
	public void add(T obj){
		//System.out.println("index:"+this.index+"size:"+this.size+"data size:"+this.data.length);
		if(this.index==this.size-1){
			//we need to increase the size of data[]
			increaseSizeAndReallocate();
		}
		data[this.index]=obj;
		this.index++;
		
	}
	
	public void set(int index, T value)
	{
		this.data[index] = value;
	}
	
	private void increaseSizeAndReallocate() {
		this.size=this.size+SIZE_FACTOR;
		T newData[]=(T[]) new Object[this.size];
		for(int i=0; i<data.length;i++){
			newData[i]=data[i];
		}
		this.data=newData;
		//System.out.println("***index:"+this.index+"size:"+this.size+"data size:"+this.data.length);
	}
	
	public T get(int i) {
		return this.data[i];
	}
	
	public void remove(int i) throws Exception{
		if(i>this.index-1){
			throw new Exception("ArrayIndexOutOfBound");
		}
		if(i<0){
			throw new Exception("Negative Value");
		}
		//System.out.println("Object getting removed:"+this.data[i]);
		for(int x=i; x<this.data.length-1;x++){
			data[x]=data[x+1];
		}
		this.index--;
	}
	
	public boolean contains(T obj)
	{
		for(int i=0; i<this.index; i++)
		{
			if(obj == data[i])
			{
				return true;
			}
		}
		return false;
	}
	
	public int size()
	{
		return this.index;
	}
	
	public int indexOf(T obj)
	{
		for(int i=0; i<this.index; i++)
		{
			if(obj == data[i])
				return i;
		}
		return -1;
		
	}
	
	
}
