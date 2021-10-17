import java.util.*;
public class Lecture implements ClassMaterial
{
	private final String topic;
	private String filename;      				//not kept final,asking user to enter again if entered invalid
	private final String uploadby;
	private final Date uploaddate;
	private final Scanner sc = Assignment2.sc;
	Lecture(String _id)
	{
		System.out.print("Enter topic of video: ");
		this.topic=sc.nextLine();
		System.out.print("Enter filename of video: ");
		this.filename=getfilename();
		this.uploadby=_id;
		this.uploaddate=new Date();
	}
	private String getfilename()
	{
		String filename=sc.nextLine();
		while(!filename.endsWith(".mp4"))
		{
			System.out.print("Enter filename of video: ");
			filename=sc.nextLine();
		}
		return filename;
	}
	@Override
	public void view()
	{
		System.out.println("Title of video: "+this.topic);
		System.out.println("Video File: "+this.filename);
		System.out.println("Date of upload: "+this.uploaddate);
		System.out.println("Uploaded by: "+this.uploadby);
	}
}
