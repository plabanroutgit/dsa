package alimir;

import java.util.Arrays;

public class MyStackP<E> {
	private int size = 0;
	private static int DEFAULT_CAPACITY = 10;
	private Object[] element;

	public MyStackP() {
		element = new Object[DEFAULT_CAPACITY];
	}

	@SuppressWarnings("unused")
	public void push(E e) {
		if (size == element.length) {
			ensureCapacity();
		}
		element[size++] = (E) e;
	}

	@SuppressWarnings("unchecked")
	public E pop() {

		E e = (E) element[--size];
		element[size] = null;

		return e;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');

		for (int i = 0; i < size; i++) {
			if (i < size) {
				if (element[i] != null) {
					sb.append(element[i]);
				}
				sb.append(", ");
			}

		}
		sb.append(']');
		return sb.toString();
	}

	private void ensureCapacity() {
		int l = element.length * 2;
		element = Arrays.copyOf(element, l);
	}
}
