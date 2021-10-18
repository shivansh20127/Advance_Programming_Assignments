package com.company;

import java.util.Scanner;
class Instructor extends Data implements user
{
    private final Backpack back_obj;
    Instructor(String name,int id,Backpack obj)
    {
        super(name,id);
        this.back_obj=obj;
    }
    public void addclassmaterial()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");
        int x=sc.nextInt();
        if(x==1)
        {
            ClassMaterial lectureSlide = new Slides(this);
            back_obj.getMaterial().add(lectureSlide);
        }
        if(x==2)
        {
            ClassMaterial lectureVideo = new Lecture(this);
            back_obj.getMaterial().add(lectureVideo);
        }
    }
    public void addAssignment()
    {
        assessment new_ass = new assignment(this);
        back_obj.getList_of_assessments().add(new_ass);
    }
    public void addQuiz()
    {
        assessment new_quiz=new quiz(this);
        back_obj.getList_of_assessments().add(new_quiz);
    }
    public void gradeassessments() {
        System.out.println("List of assessments");
        Scanner scan = new Scanner(System.in);
        back_obj.viewallassessments();
        System.out.print("Enter ID of assessment to view submissions: ");
        int decided=scan.nextInt();
        back_obj.getList_of_assessments().get(decided).gradesub(this);
    }
    @Override
    public void viewLecture()
    {
        back_obj.printMaterial();
    }
    @Override
    public void addComment()
    {
        Comments new_comm=new Comments(this);
        back_obj.addComments(new_comm);
    }
    @Override
    public void viewComment()
    {
        back_obj.printComments();
    }
    public void enter()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("Welcome "+this.getName());
            System.out.println("1. Add class material\n2. Add assessments");
            System.out.println("3. View lecture materials\n4. View assessments");
            System.out.println("5. Grade assessments\n6. Close assessment");
            System.out.println("7. View comments\n8. Add comments\n9. Logout");
            int op=sc.nextInt();
            if(op==1)
            {
                addclassmaterial();
            }
            if(op==2)
            {
                Scanner scan=new Scanner(System.in);
                System.out.println("1. Add Assignment\n"+"2. Add Quiz");
                int choice=sc.nextInt();
                if(choice==1) {
                    addAssignment();
                }
                if(choice==2) {
                    addQuiz();
                }
            }
            if(op==3)
            {
                viewLecture();
            }
            if(op==4) {
                back_obj.viewallassessments();
            }
            if(op==5) {
                gradeassessments();
            }
            if(op==6) {
                System.out.println("List of Open Assignments:");
                back_obj.viewopenassessments();
                Scanner sc_fc=new Scanner(System.in);
                System.out.print("Enter id of assignment to close: ");
                int pos_to_close=sc_fc.nextInt();
                back_obj.getList_of_assessments().get(pos_to_close).close();
            }
            if(op==7)
            {
                viewComment();
            }
            if(op==8)
            {
                addComment();
            }
            if(op==9) { return; }
        }
    }
}

