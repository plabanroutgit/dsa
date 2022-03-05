package alimir;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList {
	private static final int DEFAULT_CAPACITY = 10; // Default initial capacity.
	private static final Object[] EMPTY_ELEMENTDATA = {}; // Initiliazing the arraylist EMPTY_ELEMENTDATA
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}; // Initializing it with the default capacity
																			// 10

	transient Object[] elementData; // A non-private to access the nested class
	private int size;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	public MyArrayList() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA; // here, this keyword is returning the instance of
																// ArrayList
	}

	public MyArrayList(int initialCapacity) // ArrayList Constructor invokes with the initialCapacity argument for the
											// initial Array
	{
		if (initialCapacity > 0) { // if the value is grater than 0, it will create a new object
			this.elementData = new Object[initialCapacity]; // new object creation
		} else if (initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity); // if the value is <= 0, it will
																						// throw an
																						// IllegalArgumentException
		}
	}

	public <E> MyArrayList(Collection<? extends E> c) {
		elementData = c.toArray();
		if ((size = elementData.length) != 0) {

			// c.toArray might (incorrectly) not return Object[]
			if (elementData.getClass() != Object[].class)
				elementData = Arrays.copyOf(elementData, size, Object[].class);
		} else {

			// replace with empty array.
			this.elementData = EMPTY_ELEMENTDATA;
		}
	}

	public <E> boolean add(E e) {
		ensureCapacityInternal(size + 1); // modCount!! increments
		elementData[size++] = e;
		return true;
	}

	// Removes the element at the specified position in this list.
	// Shifts any subsequent elements to the left (subtracts one from their
	// indices).
	/*public <E> E remove(int index) {
		rangeCheck(index);
		//modCount++;
		//<E> E oldValue = elementData(index);
		
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		elementData[--size] = null; // clear to let GC do its work
		//return oldValue;
		return (E)0;
	}*/

	private void ensureCapacityInternal(int minCapacity) // Detemining the current size of occupied elements
	{
		if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity); // here, Math.max will return the maximum or largest
																	// value from the given arguments DEFAULT_CAPACITY
																	// AND minCapacity
		}

		ensureExplicitCapacity(minCapacity);
	}

	private void ensureExplicitCapacity(int minCapacity) {
		//modCount++; // modCount increases

		// overflow-conscious code
		if (minCapacity - elementData.length > 0)
			grow(minCapacity);
	}

	private void grow(int minCapacity) // The grow method expands the size of the Array
	{
		// overflow-conscious code
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if (newCapacity - MAX_ARRAY_SIZE > 0)
			newCapacity = hugeCapacity(minCapacity); // minCapacity will be close to the size of the array
		elementData = Arrays.copyOf(elementData, newCapacity); // The Arrays.copyOf will copy the specified array
	}

	private static int hugeCapacity(int minCapacity) {
		if (minCapacity < 0) // overflow
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	}

	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

}
