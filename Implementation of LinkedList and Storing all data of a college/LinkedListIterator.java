import java.util.Iterator;


public class LinkedListIterator<T> implements Iterator<Position_<T>>{

	public Position_<T> current;
	public LinkedListIterator(Node<T> head)
	{
		current = head;
	}
	
	@Override
	public Position_<T> next() {
		// TODO Auto-generated method stub
		current = current.after();
		return current;
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
