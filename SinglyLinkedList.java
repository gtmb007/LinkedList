import java.util.Scanner;
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data=data;
		next=null;
	}
}
class SinglyLinkedList {
	Node head;
	boolean isEmpty() {
		if(head==null) {
			return true;
		} else {
			return false;
		}
	}
	void insertAtBegin(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;	
		} else {
			newNode.next=head;
			head=newNode;
		}
	}
	void insertAtEnd(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
		} else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newNode;
		}
	}
	void insertAtIndex(int data,int index) {
		if(index>size()) {
                        System.out.println("Can't Insert");
                } else if(index==0) {
			insertAtBegin(data);
		} else if(index==size()) {
			insertAtEnd(data);
		} else {
			Node newNode=new Node(data);
			Node temp=head;
			Node pre=head;
			for(int i=0;i<index;i++) {
				pre=temp;
				temp=temp.next;	
			}
			newNode.next=temp;
			pre.next=newNode;
		}
	}
	void deleteAtBegin() {
		if(head==null) {
			System.out.println("List is Empty");
		} else {
			head=head.next;
		}
	}
	void deleteAtEnd() {
		if(head==null) {
			System.out.println("List is Empty");
		} else if(head.next==null) {
			head=null;	
		} else {
			Node temp=head;
			Node pre=head;
			while(temp.next!=null) {
				pre=temp;
				temp=temp.next;
			}
			pre.next=null;
			temp=null;
		}
	}
	void deleteAtIndex(int index) {
		if(index>=size()) {
                        System.out.println("Can't Delete");
                } else if(index==0) {
			deleteAtBegin();
		} else if(index==size()-1) {
			deleteAtEnd();
		} else {
			Node temp=head;
			Node pre=head;
			for(int i=0;i<index;i++) {
				pre=temp;
				temp=temp.next;
			}
			pre.next=temp.next;
			temp=null;
		}
	}
	void traverseList() {
		if(head==null) {
			System.out.println("List is empty");
		} else {
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	int size() {
		int count=0;
		Node temp=head;
		while(temp!=null) {
			temp=temp.next;
			count++;
		}
		return count;
	}
}
class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		SinglyLinkedList list=new SinglyLinkedList();
		System.out.println("© 2019 Gautam Bharadwaj");
		while(true) {
			System.out.println("\nSingly Linked List Menu: \n1. Insert at Begin\n2. Insert at End\n3. Insert at Specified Index\n4. Delete at Begin\n5. Delete at End\n6. Delete at Specified Index\n7. Traverse the List\n8. List is Empty or not\n9. Size of List\n10. Exit\n");
			System.out.print("Enter your choice: ");
			int option=sc.nextInt();
			switch(option) {
				case 1: System.out.print("Enter the element: ");
					list.insertAtBegin(sc.nextInt());
					break;
				case 2: System.out.print("Enter the element: ");
					list.insertAtEnd(sc.nextInt());
					break;
				case 3: System.out.print("Enter the index: ");
                                        int index=sc.nextInt();
					System.out.print("Enter the element: ");
					int data=sc.nextInt();
					list.insertAtIndex(data,index);
					break;
				case 4: list.deleteAtBegin();
					break;
				case 5: list.deleteAtEnd();
					break;
				case 6: System.out.print("Enter the index: ");
					list.deleteAtIndex(sc.nextInt());
					break;
				case 7: list.traverseList();
					break;
				case 8: System.out.println(list.isEmpty());
					break;
				case 9: System.out.println(list.size());
					break;
				case 10: System.exit(0);
				default : System.out.println("Please enter correct choice!");
			}
		}
	}	
}
