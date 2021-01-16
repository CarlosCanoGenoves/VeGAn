package VEGAN;

public class Tuple <K, V> {
	public K Item1;
	public V Item2;
	
	public Tuple(K item1, V item2) {
		super();
		Item1 = item1;
		Item2 = item2;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Tuple<?, ?>))
			return false;
		
		Tuple<?, ?> tuple = (Tuple<?, ?>) obj;
		return Item1.equals(tuple.Item1) && Item2.equals(tuple.Item2);
	}
	
	
}
