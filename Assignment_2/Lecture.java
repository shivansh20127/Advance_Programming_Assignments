package com.company;

import java.util.*;
public class Lecture implements ClassMaterial
{
    private final String topic;
    private String filename;      				//not kept final,asking user to enter again if entered invalid
    private final Instructor uploadby;
    private final Date uploaddate;
    Lecture(Instructor _id)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter topic of video: ");
        this.topic=sc.nextLine();
        System.out.print("Enter filename of video: ");
        this.filename=getfilename();
        this.uploadby=_id;
        this.uploaddate=new Date();
    }
    private String getfilename()
    {
        Scanner sc=new Scanner(System.in);
        String filename=sc.nextLine();
        while(filename.endsWith(".mp4")==false || filename.length()<=4)
        {
            System.out.println("You entered a file which was not having .mp4 extension");
            System.out.println("Please enter again");
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
        System.out.println("Uploaded by: "+this.uploadby.getName());
    }
}

