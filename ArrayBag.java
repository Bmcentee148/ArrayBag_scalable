package ArrayBag;
/** This class will implement the {@code BagInterface} using
	an array. The array will be of a fixed size and once full, 
	the bag will no longer be able to accept more items.

	@author Brian McEntee */

public class ArrayBag<T> implements BagInterface<T>{
	
	
	
	//DATA MEMBERS
	private T[] bag; // used to hold the entries
	private int numOfEntries;
	
	@SuppressWarnings("unused")
	private ArrayBag() {
		//access to default constructor is forbidden
	}

	public ArrayBag(int max_capac) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[max_capac];
		bag = temp;
		numOfEntries = 0;
	}

	public boolean add(T anEntry) {
		boolean status = false;
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[2 *numOfEntries];
		if(! (anEntry == null)){
			if(this.atCapac()){
				System.arraycopy(bag,0,tempBag,0,numOfEntries);
				bag = tempBag;
			}
			
				bag[numOfEntries] = anEntry;
				status = true;
				numOfEntries++;
		}
		return status;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[numOfEntries];
		T[] r_array = temp;
		for(int i = 0; i < numOfEntries; i++) {
			r_array[i] = (T)bag[i];
		}
		return r_array;
	}

	public boolean isFull() {
		return false;
	}

	public T remove() {
		T removedEntry = null;
		if(!isEmpty()) {
			numOfEntries--;
			removedEntry = bag[numOfEntries];
		}
		return removedEntry;
	}

	public T remove(T anEntry) {
		T removedEntry = null;
		boolean found = false;
		
		for (int i = 0; ! found && (i < numOfEntries); i++) {
			if(bag[i].equals(anEntry)) {
				numOfEntries--;
				removedEntry= bag[i];
				bag[i] = bag[numOfEntries];
				bag[numOfEntries] = removedEntry;
				found = true;
			}
		}

		return removedEntry;
	}

	public boolean contains(T anEntry) {
		boolean isContained = false;
		for(int i = 0; (! isContained) && (i < numOfEntries); i++) {
			if(bag[i].equals(anEntry)) {
				isContained = true;
			}
		}
		return isContained;
	}

	public int getFrequencyOf(T anEntry) {
		int freq = 0;
		for(int i = 0; i < numOfEntries; i++) {
			if(bag[i].equals(anEntry)) {
				freq++;
			}
		}
		return freq;
	}

	public int getCurrentSize() {
		return numOfEntries;
	}

	public void clear() {
		numOfEntries = 0;
	}

	public boolean isEmpty() {
		return numOfEntries == 0;
	}

	private boolean atCapac() {
		return this.numOfEntries == bag.length;
	}

}