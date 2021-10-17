import java.util.ArrayList;
import java.util.*;
public class Slides implements Lecture
{
	private ArrayList<String> slides=new ArrayList<>();
	private final String topic;
	private final int number;
	private final Date upload;
	private final String uploaded_by;
	private final Scanner sc = Assignment2.sc;
	public Slides(String id)
	{
		System.out.print("Enter topic of slides: ");
		this.topic=sc.nextLine();
		System.out.print("Enter number of slides: ");
		this.number=sc.nextInt();
		System.out.println("Enter content of slides");
		for(int i=0;i<number;i++)
		{
			System.out.print("Content of Slide "+(i+1));
			String sl=sc.nextLine();
			slides.add(sl);
		}
		this.upload=new Date();
		this.uploaded_by=id;
	}
	@Override
	public void view()
	{
		System.out.println("Title: "+this.topic);
		for(int i=0;i<this.number;i++)
		{
			System.out.println("Slide "+(i+1)+": "+slides.get(i));
		}
		System.out.println("Number of slides: "+this.number);
		System.out.println("Date of upload: "+this.upload);
		System.out.println("Uploaded by: "+this.uploaded_by);
	}
}
