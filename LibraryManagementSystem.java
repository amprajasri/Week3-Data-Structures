class Book
{
	String title;
	String author;
	String genre;
	int id;
	boolean availability=true;
	Book prev;
	Book next;
	
	public Book(String title,String author,String genre,int id)
	{
		this.title=title;
		this.author=author;
		this.genre=genre;
		this.id=id;
	}
}

class BookList
{
	static Book start=null;
	static Book tail=null;
	
	public void insertAtBegin(Book b)
	{
		if(start==null)
		start=tail=b;
		else
		{
			start.prev=b;
			b.next=start;
			start=b;
		}
	}
	
	public void insertAtEnd(Book b)
	{
		if(tail==null)
		insertAtBegin(b);
		else
		{
			Book temp=start;
			while(temp.next!=null) temp=temp.next;
			temp.next=b;
			b.prev=temp;
			tail=b;
		}
	}
	
	public void insertAtPos(Book b,int pos)
	{
		if(start==null) 
		{
			insertAtBegin(b);
			return;
		}
		Book temp=start;
		for(int i=0;i<pos-1;i++)
		temp=temp.next;
		if(temp==null)
		insertAtEnd(b);
		else
		{
			b.next=temp;
			temp.prev.next=b;
			b.prev=temp.prev;
			temp.prev=b;
		}
	}
	
	public void removeBook(int bookId)
	{
		if(start==null) System.out.println("no data found");
		else
		{
		Book temp=start;
		while(temp!=null && temp.id!=bookId)
		temp=temp.next;
		if(temp==null) System.out.println("no book with id "+bookId+" found");
		else
		{
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
		}
		}
	}
	
	public void searchBook(String bookTitle)
	{
		if(start==null) System.out.println("no data found");
		else
		{
		Book temp=start;
		int i=0;
		while(temp!=null && !(bookTitle.equals(temp.title)))
		{
			temp=temp.next;
			i++;
		}
		if(temp==null) System.out.println("no book found");
		else
		{
			System.out.println("book found at pos "+(i+1));
		}
		}
	}
	
	public void updateBookStatus(int bookId)
	{
		if(start==null) System.out.println("no data found");
		else
		{
		Book temp=start;
		while(temp!=null && temp.id!=bookId)
		temp=temp.next;
		if(temp==null) System.out.println("no book with id "+bookId+" found");
		else
		{
			temp.availability=!temp.availability;
			System.out.println("book availability is updated");
		}
		}
	}
	
	public void displayBook()
	{
		Book temp=start;
		while(temp!=null)
		{
			System.out.println("book title:"+temp.title);
			System.out.println("book id:"+temp.id);
			System.out.println("book author:"+temp.author);
			System.out.println("book genere:"+temp.genre);
			System.out.println("book is availability:"+temp.availability);
			temp=temp.next;
		}
	}
	
	public void displayBookReverse()
	{
		Book temp=tail;
		while(temp!=null)
		{
			System.out.println("book title:"+temp.title);
			System.out.println("book id:"+temp.id);
			System.out.println("book author:"+temp.genre);
			System.out.println("book is availability:"+temp.availability);
			temp=temp.prev;
		}
	}
	
	public void countBooks()
	{
		if(start==null)  System.out.println("no data found");
		else
		{
			int count=0;
			Book temp=start;
			while(temp!=null)
			{
				temp=temp.next;
				count++;
			}
			System.out.println();
			System.out.println("total number of books:"+count);
			System.out.println();
		}
	}
	
}

public class LibraryManagementSystem
{
	public static void main(String args[])
	{
		Book b1=new Book("family","ramya","comedy",1);
		Book b2=new Book("ghost","priya","horror",2);
		Book b3=new Book("hunt","judy","crime",3);
		Book b4=new Book("good habits","ravi","motivation",4);
		Book b5=new Book("reveal","vamsi","thriller",5);
		BookList list=new BookList();
		list.insertAtBegin(b1);
		list.insertAtBegin(b2);
		list.insertAtEnd(b3);
		list.insertAtEnd(b4);
		list.insertAtPos(b5,3);
		list.displayBook();
		list.countBooks();
		list.updateBookStatus(2);
		list.removeBook(3);
		list.displayBookReverse();
		list.searchBook("family");
	}
}