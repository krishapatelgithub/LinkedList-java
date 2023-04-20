import java.util.*;
class Node
{
	int data;
	Node next;
	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}
class LL
{
	public int size;
	public Node head=null;
	public Node tail=null;
	public void addNode(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}
	public void display()
	{
		Node current=head;
		if(head==null)
		{
			System.out.println("Linked List is empty.");
			return;
		}
		else
		{
			do
			{
				System.out.print(current.data+" ");
				current=current.next;
			}while(current!=null);
		}
		System.out.println("");
	}
	public void ADbeg(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			Node temp=head;
			head=newNode;
			head.next=temp;
		}
		size++;
	}
	public void ADend(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}
	public void ADmid(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			int count=(size%2==0)?(size/2):((size+1)/2);
			Node temp=head;
			Node current=null;
			for(int i=1;i<=count;i++)
			{
				current=temp;
				temp=temp.next;
			}
			current.next=newNode;
			newNode.next=temp;
			size++;
		}
	}
	public void DELbeg()
	{
		if(head==null)
		{
			System.out.println("List is empty.");
			return;
		}
		else
		{
			if(head==tail)
			{
				head=null;
				tail=null;
			}
			else
			{
				head=head.next;
			}
			size--;
		}
	}
	public void DELend()
	{
		if(head==null)
		{
			System.out.println("List is emplty.");
			return;
		}
		else
		{
			if(head==tail)
			{
				head=null;
				tail=null;
			}
			else
			{
				Node current=head;
				do
				{
					current=current.next;
				}while(current.next!=tail);
				tail=current;
				tail.next=null;
			}
			size--;
		}
	}
	public void DELmid()
	{
		if(head==null)
		{
			System.out.println("List is empty.");
			return;
		}
		else
		{
			if(head==tail)
			{
				head=null;
				tail=null;
			}
			else
			{
				int count=(size%2==0)?(size/2):((size+1)/2);
				Node temp=head;
				Node current=null;
				for(int i=1;i<=count-1;i++)
				{
					current=temp;
					temp=temp.next;
				}
				current.next=temp.next;
				temp=null;
				size--;
			}
		}
	}
}
class lab39
{
	public static void main(String args[])
	{
		LL list=new LL();
		Scanner sc=new Scanner(System.in);
		char ch;
		int c;
		do
		{
			System.out.println("1.create a node.");
			System.out.println("2.Display list.");
			System.out.println("3.Insert node at begin.");
			System.out.println("4.Insert node at end.");
			System.out.println("5.Insert node at middle.");
			System.out.println("6.Delete from begin.");
			System.out.println("7.Delete from end.");
			System.out.println("8.Delete from middle.");
			System.out.println("9.Count total number of nodes.");
			System.out.print("Enter your choice: ");
			c=sc.nextInt();
			switch(c)
			{
				case 1:
					System.out.print("Enter Element: ");
					list.addNode(sc.nextInt());
					break;
				case 2:
					list.display();
					break;
				case 3:
					System.out.print("Enter Element: ");
					list.ADbeg(sc.nextInt());
					break;
				case 4:
					System.out.print("Enter Element: ");
					list.ADend(sc.nextInt());
					break;
				case 5:
					System.out.print("Enter Element: ");
					list.ADmid(sc.nextInt());
					break;
				case 6:
					list.DELbeg();
					break;
				case 7:
					list.DELend();
					break;
				case 8:
					list.DELmid();
					break;
				case 9:
					int max=list.size;
					System.out.println("Total number of nodes: "+max);
					break;
				default:
					System.out.println("Wrong choice.");
					break;
			}
			System.out.print("Do you want to continue: ");
			ch=sc.next().charAt(0);
		}while(ch=='y');
	}
}