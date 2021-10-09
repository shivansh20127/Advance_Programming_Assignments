package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Pair
{
    int f;
    int s;
    public Pair(int x,int y)
    {
        this.f=x;
        this.s=y;
    }
    void setff(int x) {
        this.f=x;
    }
    void setss(int y) {
        this.s=y;
    }
    int getff() {
        return this.f;
    }
    int getss() {
        return this.s;
    }
}
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
        System.out.print(" of Vaccine "+ this.vaccine_name.name);
        System.out.println();
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
    void display_slots()
    {
        if(this.slots.size()==0)
        {
            System.out.println("No slots available");
            return;
        }
        for(int j=0;j<slots.size();j++)
        {
            System.out.print("Day: " + slots.get(j).day_number);
            System.out.print(" Vaccine: " + slots.get(j).vaccine_name.name);
            System.out.print(" Available Qty: " + slots.get(j).quantity);
            System.out.println();
        }
    }
    ArrayList<Integer> display_slots_for_booking()
    {
        ArrayList<Integer> day_which_he_can_book=new ArrayList<>();
        for(int j=0;j<slots.size();j++)
        {
            System.out.print(j + " -> Day: " + slots.get(j).day_number);
            System.out.print(" Available Qty: " + slots.get(j).quantity);
            System.out.print(" Vaccine: " + slots.get(j).vaccine_name.name);
            System.out.println();
            day_which_he_can_book.add(slots.get(j).day_number);
        }
        return day_which_he_can_book;
    }
    Slot change_slot(int pos)
    {
        slots.get(pos).quantity-=1;
        return slots.get(pos);
    }
    boolean check_vaccine_slot(String required)
    {
        for(Slot s: slots)
        {
            if(s.vaccine_name.name.equals(required)) return true;
        }
        return false;
    }
    ArrayList<Pair> display_slot_by_vaccine_name(String input)
    {
        ArrayList<Pair> day_which_he_can_book=new ArrayList<>();
        for(int j=0;j<slots.size();j++)
        {
            if(slots.get(j).vaccine_name.name.equals(input))
            {
                System.out.print(j + " -> Day: " + slots.get(j).day_number);
                System.out.print(" Available Qty: " + slots.get(j).quantity);
                System.out.print(" Vaccine: " + slots.get(j).vaccine_name.name);
                System.out.println();
                Pair p=new Pair(j,slots.get(j).day_number);
                day_which_he_can_book.add(p);
            }
        }
        return day_which_he_can_book;
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
    Vaccine vax_status;
    public Citizen(String name,int age,String uid)
    {
        this.name=name;
        this.age=age;
        this.UID=uid;
        this.dose_count=0;
        this.status="REGISTERED";
        this.nextduedate=1;
        vax_status=null;
    }
    void update_newdate(int date)
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
    void set_vax_status(Vaccine vax)
    {
        this.vax_status=vax;
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
        HashMap<String,Vaccine> vaccine_hs=new HashMap<>();
        HashMap<Integer,Hospital> hospitalbyid=new HashMap<>();
        HashMap<String,Citizen> list_of_citizen=new HashMap<>();
        int Hid=(int)1e5;
        while(true)
        {
            menu();
            int choice=sc.nextInt();
            if(choice==1)
            {
                System.out.print("Vaccine Name: ");
                String name = sc.next();
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
                String name=sc.next();
                System.out.print("PinCode: ");
                int pincode=sc.nextInt();
                int ID=++Hid;
                System.out.println("Allocated Hospital ID is "+ID);
                Hospital new_hospital=new Hospital(name,pincode,ID);
                hospitalArrayList.add(new_hospital);
                hospitalbyid.put(ID,new_hospital);
                new_hospital.display_details();
            }
            else if(choice==3)
            {
                System.out.print("Citizen Name: ");
                String name=sc.next();
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
            else if(choice==5)
            {
                System.out.print("Enter patient Unique ID: ");
                String cust_booking_id=sc.next();
                if(list_of_citizen.containsKey(cust_booking_id))
                {
                    if(list_of_citizen.get(cust_booking_id).status.equals("FULLY VACCINATED"))
                    {
                        System.out.println("You are Fully Vaccinated");
                        continue;
                    }
                    System.out.println("1. Search by Area\n2. Search by Vaccine\n3. Exit");
                    System.out.print("Enter option: ");
                    int booking_choice=sc.nextInt();
                    if(booking_choice==1)
                    {
                        System.out.print("Enter PinCode: ");
                        int booking_pincode=sc.nextInt();
                        boolean find=false;
                        for(int loop=0;loop<hospitalArrayList.size();loop++)
                        {
                            Hospital temp=hospitalArrayList.get(loop);
                            if(temp.pincode==booking_pincode)
                            {
                                System.out.println(temp.id+" "+temp.name);
                                find=true;
                            }
                        }
                        if(find==false)
                        {
                            System.out.println("No Hospital found");
                            continue;
                        }
                        System.out.print("Enter hospital id: ");
                        int booking_hid=sc.nextInt();
                        Hospital temp=hospitalbyid.get(booking_hid);
                        if(temp.slots.size()==0)
                        {
                            System.out.println("No slots available");
                            continue;
                        }
                        ArrayList<Integer> dwhcb=temp.display_slots_for_booking();
                        int max_day=dwhcb.get(0);
                        for(Integer x:dwhcb)
                        {
                            max_day=Math.max(x,max_day);
                        }
                        Citizen curr_cit=list_of_citizen.get(cust_booking_id);
                        if(curr_cit.nextduedate > max_day)
                        {
                            System.out.println("No slots available");
                            continue;
                        }
                        System.out.print("Choose Slot: ");
                        int booking_slot=sc.nextInt();
                        int day_he_choose=dwhcb.get(booking_slot);
                        if(day_he_choose>= curr_cit.nextduedate)
                        {
                            if (booking_slot < dwhcb.size())
                            {
                                if(temp.slots.get(booking_slot).quantity==0)
                                {
                                    System.out.println("No slots available");
                                }
                                else
                                {
                                    Slot booked_slot=temp.change_slot(booking_slot);
                                    if(curr_cit.status.equals("REGISTERED"))
                                    {
                                        curr_cit.update_dose_count();
                                        curr_cit.set_status(booked_slot.vaccine_name);
                                        curr_cit.set_vax_status(booked_slot.vaccine_name);
                                        int day_to_update = day_he_choose + booked_slot.vaccine_name.gap;
                                        curr_cit.update_newdate(day_to_update);
                                    }
                                    else if(curr_cit.status.equals("PARTIALLY VACCINATED"))
                                    {
                                        if(booked_slot.vaccine_name.name.equals(curr_cit.vax_status.name))
                                        {
                                            curr_cit.update_dose_count();
                                            curr_cit.set_status(booked_slot.vaccine_name);
                                            curr_cit.set_vax_status(booked_slot.vaccine_name);
                                            int day_to_update = day_he_choose + booked_slot.vaccine_name.gap;
                                            curr_cit.update_newdate(day_to_update);
                                        }
                                        else
                                        {
                                            System.out.println("Vaccine Mixing is not allowed");
                                        }
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Invalid Option");
                            }
                        }
                        else
                        {
                            System.out.println("No slots available");
                        }
                    }
                    else if(booking_choice==2)
                    {
                        System.out.print("Enter Vaccine name: ");
                        String vaccine_chosen=sc.next();
                        if(vaccines.contains(vaccine_chosen))
                        {
                            Citizen temp=list_of_citizen.get(cust_booking_id);
                            if(temp.vax_status==null || temp.vax_status.name.equals(vaccine_chosen))
                            {
                                ArrayList<Integer> available_hospital=new ArrayList<>();
                                boolean flag=false;
                                for(Hospital it : hospitalArrayList)
                                {
                                    if(it.check_vaccine_slot(vaccine_chosen))
                                    {
                                        flag=true;
                                        available_hospital.add(it.id);
                                        System.out.println(it.id+" "+it.name);
                                    }
                                }
                                if(!flag)
                                {
                                    System.out.println("No slots available");
                                    continue;
                                }
                                System.out.print("Enter hospital id: ");
                                int book_ho_id=sc.nextInt();
                                if(available_hospital.contains(book_ho_id))
                                {
                                    Hospital hos_chosen=hospitalbyid.get(book_ho_id);
                                    ArrayList<Pair> ind_to_day=hos_chosen.display_slot_by_vaccine_name(vaccine_chosen);
                                    int max_day=ind_to_day.get(0).getss();
                                    for(Pair p : ind_to_day)
                                    {
                                        max_day=Math.max(p.getss(),max_day);
                                    }
                                    Citizen curr_cit=list_of_citizen.get(cust_booking_id);
                                    if(curr_cit.nextduedate > max_day)
                                    {
                                        System.out.println("No slots available");
                                        continue;
                                    }
                                    System.out.print("Choose Slot: ");
                                    int booking_slot=sc.nextInt();
                                    int day_he_choose=-1;
                                    for(Pair p : ind_to_day)
                                    {
                                        if(p.getff()==booking_slot)
                                        {
                                            day_he_choose=p.getss();
                                        }
                                    }
                                    if(day_he_choose==-1)
                                    {
                                        System.out.println("Invalid Option");
                                        continue;
                                    }
                                    if(curr_cit.nextduedate > day_he_choose)
                                    {
                                        System.out.println("No slots available");
                                        continue;
                                    }
                                    if(hos_chosen.slots.get(booking_slot).quantity==0)
                                    {
                                        System.out.println("No slots available");
                                    }
                                    else
                                    {
                                        Slot booked_slot=hos_chosen.change_slot(booking_slot);
                                        if(curr_cit.status.equals("REGISTERED"))
                                        {
                                            curr_cit.update_dose_count();
                                            curr_cit.set_status(booked_slot.vaccine_name);
                                            curr_cit.set_vax_status(booked_slot.vaccine_name);
                                            int day_to_update = day_he_choose + booked_slot.vaccine_name.gap;
                                            curr_cit.update_newdate(day_to_update);
                                        }
                                        else if(curr_cit.status.equals("PARTIALLY VACCINATED"))
                                        {
                                            if(booked_slot.vaccine_name.name.equals(curr_cit.vax_status.name))
                                            {
                                                curr_cit.update_dose_count();
                                                curr_cit.set_status(booked_slot.vaccine_name);
                                                curr_cit.set_vax_status(booked_slot.vaccine_name);
                                                int day_to_update = day_he_choose + booked_slot.vaccine_name.gap;
                                                curr_cit.update_newdate(day_to_update);
                                            }
                                            else
                                            {
                                                System.out.println("Vaccine Mixing is not allowed");
                                            }
                                        }
                                    }
                                }
                                else
                                {
                                    System.out.println("Invalid Hospital Id input");
                                    continue;
                                }
                            }
                            else
                            {
                                System.out.println("Vaccine mixing is not allowed");
                                continue;
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Vaccine Input");
                            continue;
                        }
                    }
                    else if(booking_choice==3)
                    {
                        continue;
                    }
                }
                else
                {
                    System.out.println("Patient is not Registered for Slot Booking");
                }
            }
            else if(choice==6)
            {
                System.out.print("Enter Hospital Id: ");
                int idds=sc.nextInt();
                if(hospitalbyid.containsKey(idds))
                {
                    hospitalbyid.get(idds).display_slots();
                }
                else {
                    System.out.println("Invalid Id input");
                }
            }
            else if(choice==7)
            {
                System.out.print("Enter Patient ID: ");
                String curr_id=sc.next();
                Citizen temp=list_of_citizen.get(curr_id);
                System.out.println(temp.status);
                if(temp.status.equals("REGISTERED")==false)
                {
                    System.out.println("Vaccine Given: " + temp.vax_status.name);
                    System.out.println("Number of Doses given: " + temp.dose_count);
                    if ((temp.status).equals("FULLY VACCINATED"))
                        continue;
                    else
                        System.out.println("Next Dose due date: " + temp.nextduedate);
                }
            }
            else if(choice==8)
            {
                System.out.println("Stay home, stay safe!");
                System.out.println("{End of Test Case}");
                System.exit(0);
            }
        }
    }
}
