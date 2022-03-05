package alimir;

public class MyQueuePOps {

	public static void main(String[] args) {
		MyQueueP q = new MyQueueP(10);
		
		q.enqueue(22);
		q.enqueue(22333);
		q.enqueue(76);
		q.enqueue(65);
		
		q.printQueue();
		
		q.dequeue();
		q.printQueue();
	}
	
	
}
