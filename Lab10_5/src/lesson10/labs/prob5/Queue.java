package lesson10.labs.prob5;

//Show the methods are not threadsafe.
//Then modify so that they are threadsafe.
public class Queue {
	class Node {
		Object value;
		Node next;
	}
	private Node head;
	private Node tail;
	public synchronized void add(Object newValue) {
		Node n = new Node();
		if(head == null) head = n;
		else tail.next = n;
		tail = n;
		tail.value = newValue;
	}
	public synchronized  Object remove() {
		if(head == null) return null;
		Node n = head;
		head = n.next;
		return n.value;
	}
	
	public static void main(String[] args) {
		// code to check both pre-sync & post-sync
        Queue queue = new Queue();
        Thread th1 = new Thread(() -> {
            queue.add("Element1");
            System.out.println("Thread1 added: Element1");
        });
        Thread th2 = new Thread(() -> {
            Object removed = queue.remove();
            System.out.println("Thread2 removed: " + removed);
        });
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(queue.remove());
    }
}
