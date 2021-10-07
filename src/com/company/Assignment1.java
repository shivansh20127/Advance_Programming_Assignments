package com.company;
import java.util.Scanner;

class Hospital
{
    int id;
    public Hospital(int id)
    {
        this.id=id;
    }
}
class Patient
{

}
public class Assignment1
{
    public static void menu()
    {
        System.out.println("---------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("---------------------------------");
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("CoWin Portal initialized....");
        while(true)
        {
            menu();
            int choice=sc.nextInt();
            switch (choice)
            {
                case 8:
                    System.exit(0);
            }
        }
    }
}
