package com.company;
import java.util.*;
public class Assignment2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Backpack course = new Backpack();
        course.addInstructor();
        course.addStudent();
        while(true)
        {
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as instructor");
            System.out.println("2. Enter as student");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            if(choice==1)
            {
                course.enterasInstructor();
            }
            else if(choice==2)
            {
                course.enterasStudent();
            }
            else if(choice==3)
            {
                System.out.println("Thank you for using Backpack");
                String s="-".repeat(97);
                System.out.print(s+'\n'+"{End of Test Case}");
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid choice");
            }
        }
    }
}
