import java.util.Iterator;

public class LinkedList<T> implements LinkedList_<T>{

	Node<T> head;
	
	@Override
	public Position_<T> add(T e) {
		// TODO Auto-generated method stub
		Node<T> node = new Node<T> (e, null);
		if(head == null)
		{
			head = node;
			return node;
		}
		else{
			Node<T> n1 = head;
			while(n1.n != null)
			{
				n1 = n1.n;
			}
			n1.n = node;
			return n1;
		}
	}

	@Override
	public Iterator<Position_<T>> positions() {
		// TODO Auto-generated method stub
		LinkedListIterator<T> it = new LinkedListIterator<T>(head);
		return it;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		if(head==null)
		return 0;
		else
		{
			int ans=0;
			Node<T> n3 = head;
			while(n3.n!= null)
			{
				ans++;
				n3=n3.n;
			}
			ans++;
			return ans;
		}
	}

}
