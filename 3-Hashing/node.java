
public class node<K> {
	K head;
	node<K> left;
	node<K> right;
	node(K head, node left, node right)
	{
		this.head = head;
		this.left = left;
		this.right = right;
	}
	
	K value()
	{
		return head;
	}
	node<K> left()
	{
		return left;
	}
	
	node<K> right()
	{
		return right;
	}
}
