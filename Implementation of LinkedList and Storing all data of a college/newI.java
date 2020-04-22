import java.util.Iterator;

public class newI<T> implements Iterator<T>{
	public Position_<T> current;
	public newI(Node<T> head)
	{
		current = head;
	}
	
	@Override
	public T next() {
		// TODO Auto-generated method stub
		current = current.after();
		return current.value();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(current.after()!= null)
		return true;
		else
		return false;
	
	}
}
