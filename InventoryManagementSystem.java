class ItemNode
{
	int itemId;
	String itemName;
	int itemQuantity;
	double itemPrice;
	ItemNode next;
	
	public ItemNode(int itemId,String itemName,int itemQuantity,double itemPrice)
	{
		this.itemId=itemId;
		this.itemName=itemName;
		this.itemQuantity=itemQuantity;
		this.itemPrice=itemPrice;
		this.next=null;
	}
}

class ItemList
{
	static ItemNode start=null;
	
	public void setStart(ItemNode s)
	{
		start=s;
	}
	
	public void insertAtBegin(ItemNode i)
	{
		i.next=start;
		start=i;
		setStart(start);
	}
	
	public void insertAtEnd(ItemNode i)
	{
		if(start==null)
			insertAtBegin(i);
		else 
		{
			ItemNode temp=start;
			while(temp.next!=null)
			temp=temp.next;
			temp.next=i;
		}
	}
	
	public void insertAtPos(ItemNode i,int pos)
	{
		if(start==null || pos==1)
		insertAtBegin(i);
		else
		{
			ItemNode temp=start;
			ItemNode prev=null;
			for(int j=0;j<pos-1;j++)
			{
				prev=temp;
				temp=temp.next;	
			}
			i.next=temp;
			prev.next=i;
		}
	}
	
	public void displayItems()
	{
		ItemNode temp=start;
		while(temp!=null)
		{
			System.out.println("iten id:"+temp.itemId);
			System.out.println("iten name:"+temp.itemName);
			System.out.println("iten Quantity:"+temp.itemQuantity);
			System.out.println("iten price:"+temp.itemPrice);
			System.out.println("___________________________");
			temp=temp.next;
		}
	}
	
	public void displayTotalValue()
	{
		double total=0;
		ItemNode temp=start;
		while(temp!=null)
		{
			total+=(temp.itemPrice*temp.itemQuantity);
			temp=temp.next;
		}
		System.out.println("total value:"+total);
		
	}
	
	public void deleteItem(int id)
	{
		if(start==null) 
		{
			System.out.println("no data found");
			return ;
		}
		ItemNode temp=start;
		ItemNode prev=null;
		while(temp!=null && temp.itemId!=id)
		{
			prev=temp;
			temp=temp.next;
		}
		if(temp==null)
		{
			System.out.println("item with id "+id+" not found");
		}
		else if(prev!=null)
		{
			prev.next=temp.next;
			System.out.println("item deleted");
		}
		else
		{
			setStart(temp.next);
		}
		
	}
	
	public void updateItemById(int id, int newQuantity)
	{
		if(start==null)
		{
			System.out.println("no data found");
			return;
		}
		ItemNode temp=start;
		while(temp!=null && temp.itemId!=id)
		{
			temp=temp.next;
		}
		if(temp==null)
		{
			System.out.println("item with id "+id+" not found");
		}
		else
		{
			temp.itemQuantity=newQuantity;
			System.out.println("item with id "+id+" found and updated");
		}
		
	}
	
	public void searchItemById(int id)
	{
		if(start==null)
		{
			System.out.println("no data found");
			return;
		}
		ItemNode temp=start;
		int pos=0;
		while(temp!=null && temp.itemId!=id)
		{
			temp=temp.next;
			pos++;
		}
		if(temp==null)
		{
			System.out.println("item with id "+id+" not found");
		}
		else
		{
			System.out.println("item with id "+id+" found at "+(pos+1));
		}
	}
	
	public void sort()
	{
		ItemNode sortedhead=ms(start);
		setStart(sortedhead);
		System.out.println();
		System.out.println("after sorting");
		displayItems();
	}
	
	public ItemNode ms(ItemNode start)
	{
		if(start==null || start.next==null)
			return start;
		
		ItemNode mid=getMid(start);
		ItemNode right=mid.next;
		mid.next=null;
		ItemNode left=ms(start);
		right=ms(right);
		return merge(left,right);
	}
	
	public ItemNode getMid(ItemNode start)
	{
		ItemNode slow=start;
		ItemNode fast=start.next;
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public ItemNode merge(ItemNode left,ItemNode right)
	{
		ItemNode temp1=left;
		ItemNode temp2=right;
		ItemNode temp=new ItemNode(0,"",0,0);
		ItemNode start=temp;
		while(temp1!=null && temp2!=null)
		{
			if(temp1.itemPrice<temp2.itemPrice)
			{
				temp.next=temp1;
				temp=temp.next;
				temp1=temp1.next;
			}
			else if(temp1.itemPrice>temp2.itemPrice)
			{
				temp.next=temp2;
				temp=temp.next;
				temp2=temp2.next;
			}
			else
			{
				temp.next=temp1;
				temp=temp.next;
				temp1=temp1.next;
				
				temp.next=temp2;
				temp=temp.next;
				temp2=temp2.next;
			}
		}
		if(temp1!=null)
		{
			temp.next=temp1;
		}
		if(temp2!=null)
		{
			temp.next=temp2;
		}
		return start.next;
	}
}

public class  InventoryManagementSystem
{
	public static void main(String args[])
	{
		ItemList items=new ItemList();
		items.insertAtBegin(new ItemNode(121,"chocolates",3,150));
		items.insertAtEnd(new ItemNode(122,"biscuts",2,50));
		items.insertAtPos(new ItemNode(123,"cakes",3,150), 2);
		items.insertAtBegin(new ItemNode(124,"cool drinks",3,100));
		items.displayItems();
		items.displayTotalValue();
		items.updateItemById(122,3);
		items.searchItemById(123);
		items.deleteItem(122);
		items.displayItems();
		items.insertAtBegin(new ItemNode(128,"milk shakes",1,300));
		items.insertAtBegin(new ItemNode(129,"cold coffee",3,400));
		items.sort();
	}
}