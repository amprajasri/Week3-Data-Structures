import java.util.ArrayList;

class Users
{
	int id;
	String name;
	int age;
	ArrayList<Integer> friendsList;
	Users next; 
	
	public Users(int id,String name,int age)
	{
		this.id=id;
		this.name=name;
		this.age=age;
		friendsList=new ArrayList<>();
	}
	
	public void addFriend(Users friend)
	{

		if(this.id==friend.id) 
		{
			System.out.println("can't add self friend");
			return;
		}
		Users copy=new Users(friend.id,friend.name,friend.age);
		if(this.next==null) 
		{
			this.next=copy;	
			
		}
		else 
		{
			copy.next=this.next;
			this.next=copy;
		}
		friendsList.add(friend.id);
	}
	
	public void displayFriends()
	{
		Users temp=this.next;
		System.out.println();
		System.out.println("friends list:");
		while(temp!=null)
		{
			System.out.println("id:"+temp.id);
			System.out.println("name:"+temp.name);
			System.out.println("age:"+temp.age);
			temp=temp.next;
		}
	}
	
	public void removeFriend(int friendId)
	{
		if(this.next==null) 
		{
				System.out.println("no data found");
		}
		Users temp=this.next;
		Users prev=null;
		while(temp!=null && temp.id!=friendId)
		{
			prev=temp;
			temp=temp.next;
		}
		if(temp==null) System.out.println("this user is nor in friend list");
		else if(prev!=null)
		{
			prev.next=temp.next;
			System.out.println("the user with id "+id+"is removed");
		}
		
		friendsList.remove(Integer.valueOf(friendId));
		
	}
	
	public void searchByName(String friendName)
	{
		Users temp=this.next;
		int i=0;
		boolean isFriend=false;
		while(temp!=null)
		{
			if(friendName.equalsIgnoreCase(temp.name))
			{
				isFriend=true;
				break;
			}
			i++;
			temp=temp.next;
		}
		if(isFriend)
		System.out.println("the user is in friend list at pos:"+(i+1));
		else
		System.out.println("the user is not in friend list");
	}
	
	public void count()
	{
		System.out.println("number of friends:"+friendsList.size());
	}
	
	public void mutualFriends(Users friend)
	{
		int mutual=0;
		for(Integer i:friendsList)
		{
			if(friend.friendsList.contains(i))
				mutual++;
		}
		System.out.println("number of mutual friends:"+mutual);
	}
	
}

public class SocialMediaFreinds
{
	public static void main(String[] args)
	{
		Users user1=new Users(1,"mukunda",21);
		Users user2=new Users(2,"priya",21);
		Users user3=new Users(3,"rajasri",22);
		Users user4=new Users(4,"sukanya",22);
		Users user5=new Users(5,"richi",22);
		user1.addFriend(user2);
		user1.addFriend(user3);
		user1.addFriend(user5);
		user2.addFriend(user4);
		user2.addFriend(user2);
		user2.addFriend(user3);
		user4.addFriend(user3);
		user4.addFriend(user5);
		user1.removeFriend(5);
		user4.searchByName("richi");
		user1.count();
		user2.mutualFriends(user1);
		user1.displayFriends();
		user2.displayFriends();
		user3.displayFriends();
		user4.displayFriends();
	}
}



