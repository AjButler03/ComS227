package lect032723;

public class IntArrayList {
	private int[] data;
	private int size;
	
	public IntArrayList(int initialCapacity) {
		data = new int[initialCapacity];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public int get(int pos) {
		return data[pos];
	}
	
	/**
	 * check if data array is full, if it is grow the array.
	 */
	public void checkCapacity() {
		if (data.length == size) {
			int[] newData  = new int[data.length * 2];
			
			// populating old values into new, bigger array
			for (int i = 0; i < data.length; i++) {
				data[i] = newData[i];
			}
			
			// changing pointer of original variable to point to new array
			data = newData;
		}
	}
	public void add(int value) {
		checkCapacity();
		data[size] = value;
		size++;
	}
	
	public void add(int pos, int value) {
		checkCapacity();
		
		for (int i = size; i >= pos; i--) {
			data[i] = data[i - 1];
		}
		/*
		 * one solution, may need debugged
		int prev = data[pos];
		for (int i = pos + 1; i < size; i++) {
			data[i+1] = prev;
			prev = data[i];
		}
		*/
		
		data[pos] = value;
		size++;
	}
	
	public void remove(int pos) {
		for (int i = pos; i < size -1 ; i++) {
			data[i] = data[i+1];
		}
		size--;
	}
	
	public String toString() {
		String str = "[";
		for (int i = 0; i < size; i++) {
			str += data[i];
			if (i < size - 1) {
				str += ", ";
			}
		}
		str += "]";
		return str;
	}
}
