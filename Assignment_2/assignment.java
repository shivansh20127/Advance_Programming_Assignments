package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class assignment implements assessment
{
    private final String probstat;
    private final int weightage;
    private boolean status;
    private final Data set_by;
    private HashMap<Data,submission> all_submissions=new HashMap<>();
    public assignment(Data _obj)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter problem statement: ");
        this.probstat=sc.nextLine();
        System.out.print("Enter max marks: ");
        this.weightage=sc.nextInt();
        this.status=true;
        this.set_by=_obj;
    }
    public void addSubmission(Data _obj,submission _aobj) {
        all_submissions.put(_obj,_aobj);
    }
    @Override
    public HashMap<Data,submission> getAll_submissions() {
        return this.all_submissions;
    }
    @Override
    public submission makesub() {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter filename of assignment: ");
        String filename=scan.nextLine();
        while(!filename.endsWith(".zip"))
        {
            System.out.println("You entered a file which was not having .zip extension");
            System.out.println("Please enter again");
            System.out.print("Enter filename of assignment: ");
            filename=scan.nextLine();
        }
        submission made=new submission(filename);
        return made;
    }
    @Override
    public boolean getstatus() {
        return this.status;
    }
    @Override
    public int getmarks() { return this.weightage; }
    @Override
    public void close() {
        this.status=false;
    }
    @Override
    public void view(int pos)
    {
        System.out.print("ID: "+pos+" Assignment "+this.probstat);
        System.out.println(" Max Marks: "+this.weightage);
    }
}
