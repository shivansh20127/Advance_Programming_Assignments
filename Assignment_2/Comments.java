import java.util.*;
public class Comments
{
	private final String comment;
	private final String madeby;
	private final Date madedate;
	private final Scanner sc = Assignment2.sc;
	Comments(String _id)
	{
		System.out.print("Enter comment: ");
		this.comment = sc.nextLine();
		this.madeby=_id;
		this.madedate=new Date();
	}
	public void view()
	{
		System.out.println(this.comment+" - "+this.madeby);
		System.out.println(this.madedate);
	}
}
