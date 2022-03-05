package alimir;

public class MyQueueP {

	private int front, rear, capacity = 0;
	private int[] queue;

	public MyQueueP(int c) {
		capacity = c;
		queue = new int[capacity];

	}

	public void enqueue(int x) {
		if (rear == capacity) {
			return;
		}
		queue[rear++] = x;
	}

	public void dequeue() {
		if (front == rear) {
			return;
		}

		for (int i = 0; i < rear - 1; i++) {
			queue[i] = queue[i + 1];
		}
		rear--;
		queue[rear] = 0;
	}

	public void printQueue() {

		for (int i = 0; i < rear; i++) {
			System.out.print(queue[i] +  ", ");
		}
		System.out.println();
		
	}

}
