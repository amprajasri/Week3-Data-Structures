class  StudentNode{
	int rollNumber;
	String name;
	int age;
	String grade;
	StudentNode next;
	static StudentNode start;
	
	public StudentNode(int rollNumber,String name,int age,String grade)
	{
		this.rollNumber=rollNumber;
		this.name=name;
		this.age=age;
		this.grade=grade;
		this.next=null;
	}
}

class StudentList
{
	static StudentNode start;
	public void insertAtBegin(StudentNode s)
	{
		s.next=start;
		start=s;
		setStart(start);
	}
	
	public void insertAtEnd(StudentNode s)
	{
		if(start==null) 
		{	
			insertAtBegin(s);
			return;
		}
		StudentNode temp=start;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=s;
	}
	
	public void insertAtPos(StudentNode s,int pos)
	{
		if(start==null) 
		{	
			insertAtBegin(s);
			return;
		}
		StudentNode temp=start;
		StudentNode prev=null;
		for(int i=0;i<pos-1;i++)
		{
			prev=temp;
			temp=temp.next;
		}
		s.next=temp;
		prev.next=s;
	}
	
	public static void setStart(StudentNode s)
	{
		start=s;
	}
	
	public void deleteStudent(int rollno)
	{
		StudentNode temp=start;
		if(start==null)
		{
			System.out.println("list is empty");
			return;
		}
		StudentNode prev=null;
		boolean found=false;
		if(start.rollNumber==rollno)
		{
			start=start.next;
		}
		else
		{
		while(temp!=null)
		{
			if(temp.rollNumber==rollno)
			{
				found=true;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		if(found)
		prev.next=temp.next;
	    else
		System.out.println("data not found");
		}
		
		
	}
	
	public void searchRollno(int rollno)
	{
		StudentNode temp=start;
		int pos=1;
		while(temp!=null && temp.rollNumber!=rollno)
		{
			temp=temp.next;
			pos++;
		}
		if(temp==null) System.out.println("no data found");
		else System.out.println("student found at :"+pos);
	}
	
	public void displayStudents()
	{
		StudentNode temp=start;
		while(temp!=null)
		{
			System.out.println("student name:"+temp.name);
			System.out.println("student rollNumber:"+temp.rollNumber);
			System.out.println("student age:"+temp.age);
			System.out.println("student grade:"+temp.grade);
			System.out.println("________________________");
			temp=temp.next;
		}
	}
	
	public void updateGrade(int rollno,String newGrade)
	{
		StudentNode temp=start;
		while(temp!=null && temp.rollNumber!=rollno)
			temp=temp.next;
		if(temp==null) System.out.println("roll number not found");
		else 
			temp.grade=newGrade;
	}
}




public class Student
{
  public static void main(String[] args) 
  {
	StudentList l=new StudentList();
	l.insertAtBegin(new StudentNode(544,"mukunda",21,"O"));
	l.insertAtEnd(new StudentNode(546,"raguram",21,"O"));
	l.insertAtPos(new StudentNode(545,"bhooja",21,"A+"),2);
	l.insertAtPos(new StudentNode(547,"siveesh",21,"A"),4);
	l.insertAtBegin(new StudentNode(543,"shadan",21,"A+"));
	l.deleteStudent(545);
	l.searchRollno(545);
	l.searchRollno(544);
	l.updateGrade(546,"A+");
	l.displayStudents();
  
  }
}