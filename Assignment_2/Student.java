package com.company;

import java.util.*;
class Student extends Data implements user
{
    private final Backpack obj;
    private HashMap<assessment,submission> atos = new HashMap<>();
    private HashMap<submission,grade> stog = new HashMap<>();
    Student(String _name,int _id,Backpack obj)
    {
        super(_name,_id);
        this.obj=obj;
    }
    @Override
    public void viewLecture() {
        obj.printMaterial();
    }
    @Override
    public void addComment() {
        Comments new_comm=new Comments(this);
        obj.addComments(new_comm);
    }
    @Override
    public void viewComment()
    {
        obj.printComments();
    }
    public void viewassessment() {
        ArrayList<assessment> tester=obj.getList_of_assessments();
        int count=0;
        for(assessment x : tester)
        {
            if(x.getstatus()==true && atos.containsKey(x)==false)
            {
                x.view(count);
            }
            count++;
        }
    }
    public void submitassessment() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Pending assessments");
        ArrayList<assessment> tester= obj.getList_of_assessments();
        int count=0;
        for(assessment x : tester)
        {
            if(atos.containsKey(x)==false)
            {
                x.view(count);
            }
        }
        System.out.print("Enter ID of assessment: ");
        int chosen_to_make=scan.nextInt();
        submission made= tester.get(chosen_to_make).makesub();
        atos.put(tester.get(chosen_to_make),made);
        tester.get(chosen_to_make).getAll_submissions().put(this,made);
    }
    public void showungraded()
    {
        System.out.println("Ungraded submissions");
        if(atos.isEmpty()) return;
        for(assessment x : atos.keySet())
        {
            if(atos.get(x).isIs_graded())
            {
                System.out.println("Submissions: "+atos.get(x).getFilename());
            }
        }
    }
    public void showgraded()
    {
        System.out.println("Graded submissions");
        if(stog.isEmpty()) return;
        for(submission x : stog.keySet())
        {
            System.out.println("Submissions: "+x.getFilename());
            System.out.println("Marks scored: "+stog.get(x).getGraded_marks());
            System.out.println("Graded by: "+stog.get(x).getGraded_by().getName());
        }
    }
    public void enter()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("Welcome "+this.getName());
            System.out.println("1. View lecture materials\n2. View assessments");
            System.out.println("3. Submit assessment\n4. View grades\n5. View comments");
            System.out.println("6. Add comments\n7. Logout");
            int op=sc.nextInt();
            if(op==1)
            {
                viewLecture();
            }
            if(op==2) {
                viewassessment();
            }
            if(op==3) {
                submitassessment();
            }
            if(op==4) {
                showgraded();
                showungraded();
            }
            if(op==5)
            {
                viewComment();
            }
            if(op==6)
            {
                addComment();
            }
            if(op==7){ return; }
        }
    }
}

