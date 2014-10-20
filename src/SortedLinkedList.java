/*
 * Author : Geetish Nayak
 * Andrew Id : gnayak
 * 
 * This is used to implement the Sorted LinkedList DataStructure
 * 
 */

public class SortedLinkedList implements MyListInterface{
	// declaration of variables
	private Node head;
	private static Node curr;
	private static Node prev;
	private static int size=0;
	private static int cnt=0; 
	
	// Static Node Class
	private static class Node{
		private String data;
		private Node next;
		
		public Node(String data,Node next){
			this.data = data;
			this.next = next;
		}
		
	}
	
	/*
	 * Default Contructor
	 */
	public SortedLinkedList(){
		head = null;
	}
	
	/*
	 * Constructor
	 * @param The string to initialize
	 * 
	 */
	public SortedLinkedList(String[] stringArray){
		// Initialization of curr and prev
		curr=head;
		prev=null;
		cnt=stringArray.length;
		// Call to helper function
		addHelper(stringArray);
		// Reinitialize curr and head
		curr=head;
		prev=null;
	}
	
	/* This is a helper class for addition purposes
	 * 
	 * 
	 */
	private void addHelper(String[] stringArray){
			// end condition
			if(cnt==0){
				return;
			}
			else{
				//call to add function
				add(stringArray[stringArray.length-cnt]);
				cnt--;
				curr=head;
				prev=null;
				// Recursion
				addHelper(stringArray);
			}
	}
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see MyListInterface#add(java.lang.String)
	 */
	@Override
	public void add(String value) {
		// end condition
		if(head==null){
			Node newNode = new Node(value,null);
			this.head = newNode;
			return;
		}
		else{ // LinkedList has elements
			  // duplicate
			 if(curr.data.trim().compareToIgnoreCase(value.trim())==0){
				 return;
			 }
			 else{
				 if(curr.data.compareToIgnoreCase(value)<0){ // value is greater then curr nodes value
					 prev = curr;
					 curr=curr.next;
					 if(curr==null){ // reached the end
						 // Just make a new Node and add
						 Node newNode = new Node(value,null);
						 prev.next = newNode;
						 return;
					 }
					 add(value);
				 }
				 else{
					 Node newNode = new Node(value,curr);
					 //Mistake I created
					 // add first
					 if(prev==null){
						 head = newNode;
						 return;
					 }
					 else{
						 prev.next = newNode;
						 return;
					 }
				 }
			 }
			 return;
		}
	}

	@Override
	public int size() {
		if(head==null)
			return 0;
		else{
			// end condition
			if(curr==null){
				
				int temp=size;
				size=0;
				curr=head;
				prev = null;
				// return the size
				return temp;
			}
			else{	
				// increment the size
				size++;
				curr=curr.next;
				return size();
			}
		}
			
		//return 0;
	}

	@Override
	public void display() {
		// if head is NULL
		if(head==null){
			return;
		}
		if(curr==null){
			curr=head;
			prev=null;
			return;
		}
		else{
			//display
			System.out.println(curr.data);
			curr=curr.next;
			display();
		}
		
	}

	@Override
	public boolean contains(String key) {
		if(head==null){
			return false;
		}
		else{
			//end of linked list
			if(curr==null){
				curr=head;
				prev=null;
				return false;
			}
			// Key is found
			if(curr.data.compareToIgnoreCase(key)==0){
				curr=head;
				prev=null;
				return true;
			}
			else{
					// Move the curr pointer to the next node
					curr=curr.next;
					// recursion
					return contains(key);
				
			}
		}
	}

	@Override
	public boolean isEmpty() {
		//Empty condition
		if(head!=null)
			return true;
		return false;
	}

	@Override
	public String removeFirst() {
		if(head==null){
			return null;
		}
		else{
			// remove the first element and 
			// change the head node
			String removedValue = head.data;
			head = head.next;
			curr = head;
			prev=null;
			return removedValue;
		}
	}

	@Override
	public String removeAt(int index) {
		if(head==null){
			return null;
		}
		else{
			if(index == 0){
				return removeFirst();
			}
			if(curr==null){ // end of linkedList
				curr=head;
				prev=null;
				return null;
			}
			else{
				cnt=cnt+1;
				if(cnt==index){ // If cnt has reached index
					String data = curr.data;
					cnt=0;
					prev.next = curr.next;
					prev=null;
					curr=head;
					return data;
					
				}
				else{
					prev=curr;
					curr=curr.next;
					index++;
				}
				
			}
		}
		return null;
	}

}
