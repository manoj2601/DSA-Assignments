
public class Pair<K,T> {
	K key;
	T value;
	Pair(K key, T value)
	{
		this.key = key;
		this.value = value;
	}
	
	public K key() {
		return key;
	}

	public T value() {
		return value;
	}
	
	
}
