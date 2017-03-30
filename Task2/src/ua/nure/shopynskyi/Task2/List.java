package ua.nure.shopynskyi.Task2;

public interface List extends java.lang.Iterable<Object> {

	// Appends the specified element to the end of this list
	void add(Object el);

	// Appends all of the elements in the specified collection to the end of
	// this list
	void addAll(List list);

	// Returns an array containing all of the elements in this list in proper
	// sequence
	Object[] toArray();

	// Removes all of the elements from this list
	void clear();

	// Returns true if this list contains the specified element
	boolean contains(Object el);

	// Returns the element at the specified position in this list.
	Object get(int index);

	// Returns the index of the first occurrence of the specified element in
	// this list
	int indexOf(Object el);

	// Removes the element at the specified position in this list, returns the
	// element previously at the specified position
	Object remove(int j);

	// Removes the first occurrence of the specified element from this list,
	// returns true if this list contained the specified element
	boolean remove(Object el);

	// Returns the number of elements in this list
	int size();

	Iterator iterator();

}