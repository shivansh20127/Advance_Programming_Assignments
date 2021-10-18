package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class quiz implements assessment
{
    private final String quizq;
    private final int weightage;
    private boolean status;
    private final Data set_by;
    private HashMap<Data,submission> all_submissions=new HashMap<>();
    public quiz(Data _obj)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter quiz question: ");
        this.quizq=sc.nextLine();
        this.weightage=1;
        this.status=true;
        this.set_by=_obj;
    }
    @Override
    public void addSubmission(Data _obj,submission _aobj) {
        all_submissions.put(_obj,_aobj);
    }
    @Override
    public void gradesub(Data _by) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Choose ID from these ungraded submissions");
        ArrayList<submission> temp=new ArrayList<>();
        int count=0;
        for(Data x : all_submissions.keySet())
        {
            if(all_submissions.get(x).isIs_graded()==false)
            {
                System.out.println(count+". "+x.getName());
                temp.add(all_submissions.get(x));
                count++;
            }
        }
        if(temp.size()==0) {
            System.out.println("No ungraded submissions");
            return;
        }
        int to_grade=scan.nextInt();
        submission to_do=temp.get(to_grade);
        System.out.println("Submission:");
        System.out.println("Submission: "+to_do.getFilename());
        System.out.println("-------------------------------");
        System.out.println("Max Marks: "+this.weightage);
        System.out.print("Marks scored: ");
        int marks_scored=scan.nextInt();
        to_do.update_gradingdetails(_by,marks_scored);
        to_do.setIs_graded();
        Data whom=null;
        for(Data x : all_submissions.keySet())
        {
            if(all_submissions.get(x)==to_do)
            {
                whom=x;
                break;
            }
        }
        ((Student)whom).addGraded_ones(to_do);
    }
    @Override
    public submission makesub() {
        System.out.print(this.quizq+" ");
        Scanner scan = new Scanner(System.in);
        String answer=scan.nextLine();
        submission made=new submission(answer);
        return made;
    }
    @Override
    public int getmarks() { return this.weightage; }
    @Override
    public void close() { this.status=false; }
    @Override
    public boolean getstatus() {
        return this.status;
    }
    @Override
    public void view(int pos)
    {
        System.out.println("ID: "+pos+" Question: "+this.quizq);
    }
}
