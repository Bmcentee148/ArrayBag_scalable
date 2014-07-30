/** 
	An interface to describe the operations of a bag of objects
	@author Brian McEntee
	@version 7.23.14 
*/

public interface BagInterface<T> {
	
	/** Gets the current numbers of entries in the bag.
		@return The number of entries in the bag */
	public int getCurrentSize();

	/** Determines whether or not the bag is full.
		@return True if the bag is full, else false. */
	public boolean isFull();

	/** Determines whether or not the bag is empty.
		@return True if the bag is empty, else false. */
	public boolean isEmpty();

	/** Adds an item to the bag.
		@param anEntry The item to be added to the bag.
		@return True if the addition was successful, else false. */
	public boolean add(T Entry);

	/** Removes a random item from the bag.
		@return The object removed from the bag. */
	public T remove();

	/** Removes the first instance of a specific item from the bag.
		@param anEntry The item to be removed from the bag.
		@return The item removed from the bag or null if the item is not found. */
	public T remove(T anEntry);

	/** Removes all entries from the bag. */
	public void clear();

	/** Determines the frequency of occurences of an item in the bag.
		@param anEntry The entry to find and count occurences of. 
		@return The number of occurences the item occurs in the bag, or -1 if
			  	the item does not occur in the bag. */
	public int getFrequencyOf(T anEntry);

	/** Determines whether or not a particular item is in the bag. 
		@param anEntry The item to be searched for in the bag.
		@return True if the item is in the bag, else false. */
	public boolean contains(T anEntry);

	/** Creates an array out of all the entries currently in the bag.
		@return The array of objects created from the items in the bag. */
	public T[] toArray();

}