package queue;

public class Queue {
	private static class Node{
		int priority;
		String name;
		Node next;
	}
	private Node first = null;
	
	private Node last = null;
	
	public void enqueue(int P,String N) {
		//if the queue is not null, add new node behind exist last node
		//else the node should be both the first and the last node
		Node oldest = last;
		last = new Node();
		last.priority = P;
		last.name = N;
		
		if(first==null) 
			first = last;		
		else 
			oldest.next = last;
	}
	
	public String dequeue(){
		//if the queue is empty, it can't return value
		if(first== null)
			throw new IllegalStateException("Empty Queue Can't Dequeue!");
		//else we need to compare each priority node to figure out which node has the max priority 
		Node max = first;
		Node backup = first;
		while(first.next != null)
		{
			if(first.next.priority>max.priority)
				max = first.next;
			first = first.next;
		}
		first = backup;
		String n = max.name;
		max = max.next;
		return n;
	}
	
	public boolean isempty() {
		return first==null;
	}

	public static void main(String[] args) {
		//test function  
		//you can delete it 
		Queue q = new Queue();
		q.enqueue(10, "aass");
		q.enqueue(11, "akk");
		q.enqueue(0, "aij");
		String n=q.dequeue();
		System.out.println(n);
	}
}
