package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Slot
{
    int day_number;
    int quantity;
    Vaccine vaccine_name;
    public Slot(int x,int y,Vaccine vax)
    {
        this.day_number=x;
        this.quantity=y;
        this.vaccine_name=vax;
    }
    void print_details(Slot slot,int ID)
    {
        System.out.print("Slot added by Hospital "+ID);
        System.out.print(" for Day: "+slot.day_number);
        System.out.print(" , Available Quantity: "+quantity);
        System.out.println(" of Vaccine"+ this.vaccine_name.name);
    }
}
class Hospital
{
    String name;
    int pincode;
    int id;
    ArrayList<Slot> slots=new ArrayList<>();
    public Hospital(String name,int pincode,int ID)
    {
        this.name=name;
        this.pincode=pincode;
        this.id=ID;
    }
    void display_details()
    {
        System.out.print("Hospital Name: "+this.name);
        System.out.print(" , PinCode: "+this.pincode);
        System.out.print(" , Unique ID: "+this.id);
        System.out.println();
    }
    void addSlot(Slot slot)
    {
        slots.add(slot);
    }
}
class Citizen
{
    String name;
    int age;
    String UID;
    int dose_count;
    String status;
    int nextduedate;
    public Citizen(String name,int age,String uid)
    {
        this.name=name;
        this.age=age;
        this.UID=uid;
        this.dose_count=0;
        this.status="REGISTERED";
    }
    void set_date(int date)
    {
        this.nextduedate=date;
    }
    void display_details()
    {
        System.out.print("Citizen Name: "+this.name);
        System.out.print(" , Age: "+this.age);
        System.out.print(" , Unique ID: "+this.UID);
        System.out.println();
    }
    void update_dose_count()
    {
        this.dose_count+=1;
    }
    void set_status(Vaccine curr)
    {
        if(curr.number_of_doses==this.dose_count) { status="FULLY VACCINATED"; }
        else { status = "PARTIALLY VACCINATED"; }
    }
}
class Vaccine
{
    String name;
    int number_of_doses;
    int gap;
    public Vaccine(String name,int number_of_doses,int gap)
    {
        this.name=name;
        this.number_of_doses=number_of_doses;
        this.gap=gap;
    }
    void display_details()
    {
        System.out.print("Vaccine Name: "+this.name);
        System.out.print(" , Number of Doses: "+this.number_of_doses);
        System.out.print(" , Gap Between Doses: "+this.gap);
        System.out.println();
    }
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
        ArrayList<String> vaccines=new ArrayList<>();
        ArrayList<Hospital> hospitalArrayList=new ArrayList<>();
        HashMap<String,Vaccine> vaccine_hs=new HashMap<>();           //List of Vaccines -> mapped from vaccine name to Vaccine
        HashMap<String,Hospital> hospitalbyname=new HashMap<>();        //Filter Hospital by name
        HashMap<Integer,Hospital> hospitalbypincode=new HashMap<>();    //Filter Hospital by PinCode
        HashMap<Integer,Hospital> hospitalbyid=new HashMap<>();
        HashMap<String,Citizen> list_of_citizen=new HashMap<>();
        int Hid=(int)1e6;                                               //Random ID assigned to Hospital
        while(true)
        {
            menu();
            int choice=sc.nextInt();
            if(choice==1)
            {
                System.out.print("Vaccine Name: ");
                String name = sc.nextLine();
                System.out.print("Number of Doses: ");
                int number_of_doses = sc.nextInt();
                int gap = 0;
                if (number_of_doses != 1)
                {
                    System.out.print("Gap between Doses: ");
                    gap = sc.nextInt();
                }
                Vaccine new_vaccine;
                if(!vaccine_hs.containsKey(name))
                {
                    new_vaccine=new Vaccine(name,number_of_doses,gap);
                    vaccine_hs.put(name,new_vaccine);
                    new_vaccine.display_details();
                    vaccines.add(name);
                }
                else
                {
                    System.out.println("Duplicate Vaccine Addition");
                    System.out.println("Press Y to update previous details and N to abort");
                    String option = sc.next();
                    if (option.equals("Y"))
                    {
                        new_vaccine = new Vaccine(name, number_of_doses, gap);
                        vaccine_hs.put(name, new_vaccine);
                        new_vaccine.display_details();
                    }
                    else continue;
                }
            }
            else if(choice==2)
            {
                System.out.print("Hospital Name: ");
                String name=sc.nextLine();
                System.out.print("PinCode: ");
                int pincode=sc.nextInt();
                int ID=Hid++;
                Hospital new_hospital=new Hospital(name,pincode,ID);
                hospitalArrayList.add(new_hospital);
                hospitalbyname.put(name,new_hospital);
                hospitalbypincode.put(pincode,new_hospital);
                hospitalbyid.put(ID,new_hospital);
                new_hospital.display_details();
            }
            else if(choice==3)
            {
                System.out.print("Citizen Name: ");
                String name=sc.nextLine();
                System.out.print("Age: ");
                int age=sc.nextInt();
                System.out.print("Unique ID: ");
                String uid=sc.next();
                Citizen new_citizen=new Citizen(name,age,uid);
                new_citizen.display_details();
                if(age<18)
                {
                    System.out.println("Only above 18 are allowed");
                }
                else if(uid.length()!=12) System.out.println("Invalid Unique Id");
                else list_of_citizen.put(uid,new_citizen);
            }
            else if(choice==4)
            {
                System.out.print("Enter Hospital ID: ");
                int hosid=sc.nextInt();
                System.out.print("Enter number of Slots to be added: ");
                int slots=sc.nextInt();
                for(int i=0;i<slots;i++)
                {
                    System.out.print("Enter Day Number: ");
                    int day_number=sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity=sc.nextInt();
                    System.out.println("Select Vaccine");
                    for(int k=0;k<vaccines.size();k++)
                    {
                        System.out.println(k+". "+vaccines.get(k));
                    }
                    int slot_vax=sc.nextInt();
                    Slot new_slot=new Slot(day_number,quantity,vaccine_hs.get(vaccines.get(slot_vax)));
                    hospitalbyid.get(hosid).addSlot(new_slot);
                    new_slot.print_details(new_slot,hosid);
                }
            }
            else if(choice==8)
            {
                System.out.println("{End of Test Case}");
                System.exit(0);
            }
        }
    }
}
