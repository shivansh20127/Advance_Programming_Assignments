package com.company;

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
        this.quizq=sc.nextLine();
        this.weightage=1;
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
        System.out.println(this.quizq+" ");
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
        System.out.print("ID: "+pos+" Question: "+this.quizq);
    }
}
