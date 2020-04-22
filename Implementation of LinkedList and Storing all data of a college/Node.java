
public class Node<T> implements Position_<T>{

	public T d;
	public Node<T> n;
	
	Node(T data1, Node<T> next1)
	{
		d = data1;
		n = next1;
	}
	@Override
	public T value() {
		// TODO Auto-generated method stub
		return d;
	}

	@Override
	public Position_<T> after() {
		// TODO Auto-generated method stub
		return n;
	}

}
