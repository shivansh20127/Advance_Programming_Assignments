package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Pair
{
    //Implemented pair class to store two numbers as a pair
    private int f;          //denotes the first element in a pair
    private int s;          //denoted the second element in a pair
    public Pair(int x,int y)        //constructor
    {
        this.f=x;
        this.s=y;
    }
    void setff(int x) {			//setter for first element
        this.f=x;
    }
    void setss(int y) {			//setter for second element
        this.s=y;
    }
    int getff() {				//getter for first element
        return this.f;
    }
    int getss() {				//getter for second element
        return this.s;
    }
}
class Slot			//class for slot
{
    private int day_number;		//denotes the day number
    private int quantity;		//denotes the quantity of the vaccine slot
    private Vaccine vaccine_name;	//denotes the object of vaccine class
    int getday_number() {			//getter for day number
        return this.day_number;
    }
    int getQuantity() {				//getter for quantity
        return this.quantity;
    }
    void setQuantity(int x) {		//setter for quantity
        this.quantity=x;
    }
    Vaccine getVaccine_name() {		//getter for vaccine name
        return this.vaccine_name;
    }
    public Slot(int x,int y,Vaccine vax) {	//constructor
        this.day_number=x;
        this.quantity=y;
        this.vaccine_name=vax;
    }
    void print_details(Slot slot,int ID) {		//printing details of a slot
        System.out.print("Slot added by Hospital "+ID);
        System.out.print(" for Day: "+slot.day_number);
        System.out.print(" , Available Quantity: "+quantity);
        System.out.print(" of Vaccine "+ this.vaccine_name.name);
        System.out.println();
    }
}
class Hospital								//class for hospital
{
    private String name;					//denotes the name of the hospital
    private int pincode;					//denotes the pincode of the hospital
    private int id;							//denotes the Unique id of the hospital
    private ArrayList<Slot> slots=new ArrayList<>(); 	//denotes the arraylist of slots
    String getname() {						//getter for name
        return this.name;
    }
    int getpincode() {						//getter for pincode
        return this.pincode;
    }
    int getId() {							//getter for id
        return this.id;
    }
    ArrayList<Slot> getSlots() {			//getter for slots
        return this.slots;
    }
    public Hospital(String name,int pincode,int ID)		//constructor
    {
        this.name=name;
        this.pincode=pincode;
        this.id=ID;
    }
    void display_details() {				//displaying details of a hospital
        System.out.print("Hospital Name: "+this.name);
        System.out.print(" , PinCode: "+this.pincode);
        System.out.print(" , Unique ID: "+this.id);
        System.out.println();
    }
    void addSlot(Slot slot) {				//adding slot to the hospital
        slots.add(slot);
    }
    void display_slots() {					//displaying slots of a hospital
        if(this.slots.size()==0)
        {
            System.out.println("No slots available");
            return;
        }
        for(int j=0;j<slots.size();j++)
        {
            System.out.print("Day: " + slots.get(j).getday_number());
            System.out.print(" Vaccine: " + slots.get(j).getVaccine_name().name);
            System.out.print(" Available Qty: " + slots.get(j).getQuantity());
            System.out.println();
        }
    }
    ArrayList<Pair> display_slots_for_booking(int day) {		//displaying slots of a hospital for booking
        ArrayList<Pair> day_which_he_can_book=new ArrayList<>();
        for(int j=0;j<slots.size();j++)
        {
            if(slots.get(j).getday_number()>=day) {
                System.out.print(j + " -> Day: " + slots.get(j).getday_number());
                System.out.print(" Available Qty: " + slots.get(j).getQuantity());
                System.out.print(" Vaccine: " + slots.get(j).getVaccine_name().name);
                System.out.println();
                Pair p=new Pair(j,slots.get(j).getday_number());
                day_which_he_can_book.add(p);
            }
        }
        return day_which_he_can_book;
    }
    Slot change_slot(int pos) {				//changing slot of a hospital after it is booked
        slots.get(pos).setQuantity(slots.get(pos).getQuantity()-1);
        return slots.get(pos);
    }

    //checking if a vaccine of that name is available in a hospital
    boolean check_vaccine_slot(String required) {
        for(Slot s: slots)
        {
            if(s.getVaccine_name().name.equals(required)) return true;
        }
        return false;
    }

    //collecting all pair of index and dat of vaccine of that name is available in a hospital
    ArrayList<Pair> find_slot_vs_index(String input,int day) {
        ArrayList<Pair> day_which_he_can_book=new ArrayList<>();
        for(int j=0;j<slots.size();j++)
        {
            if(slots.get(j).getVaccine_name().name.equals(input) && slots.get(j).getday_number()>=day)
            {
                Pair p=new Pair(j,slots.get(j).getday_number());
                day_which_he_can_book.add(p);
            }
        }
        return day_which_he_can_book;
    }

    //display all slots of a hospital which are available for booking and with a given vaccine name
    ArrayList<Pair> display_slot_by_vaccine_name(String input,int day) {
        ArrayList<Pair> day_which_he_can_book=new ArrayList<>();
        for(int j=0;j<slots.size();j++)
        {
            if(slots.get(j).getVaccine_name().name.equals(input) && slots.get(j).getday_number()>=day)
            {
                System.out.print(j + " -> Day: " + slots.get(j).getday_number());
                System.out.print(" Available Qty: " + slots.get(j).getQuantity());
                System.out.print(" Vaccine: " + slots.get(j).getVaccine_name().name);
                System.out.println();
                Pair p=new Pair(j,slots.get(j).getday_number());
                day_which_he_can_book.add(p);
            }
        }
        return day_which_he_can_book;
    }
}
class Citizen 							//class for citizen
{
    private String name;				//denotes the name of the citizen
    private int age;					//denotes the age of the citizen
    private String UID;					//denotes the Unique id of the citizen
    private int dose_count;				//denotes the number of doses taken by the citizen
    private String status;				//denotes the vaccination status of the citizen
    private int nextduedate;			//denotes the next due date of the citizen
    private Vaccine vax_status;			//denotes the vaccine details of the citizen
    String getName() {					//getter for name
        return this.name;
    }
    int getDose_count() {				//getter for dose_count
        return this.dose_count;
    }
    String getStatus() {				//getter for status
        return this.status;
    }
    int getNextduedate() {				//getter for nextduedate
        return this.nextduedate;
    }
    Vaccine getVax_status() {			//getter for vax_status
        return this.vax_status;
    }
    public Citizen(String name,int age,String uid)		//constructor
    {
        this.name=name;
        this.age=age;
        this.UID=uid;
        this.dose_count=0;
        this.status="REGISTERED";
        this.nextduedate=1;
        vax_status=null;
    }
    void update_newdate(int date) 		//updating the next due date of the citizen
    {
        this.nextduedate=date;
    }
    void display_details() {			//displaying details of a citizen
        System.out.print("Citizen Name: "+this.name);
        System.out.print(" , Age: "+this.age);
        System.out.print(" , Unique ID: "+this.UID);
        System.out.println();
    }
    void update_dose_count()			//updating the dose count of the citizen
    {
        this.dose_count+=1;
    }
    void set_status(Vaccine curr) {		//updating the vaccination status of the citizen
        if(curr.number_of_doses==this.dose_count) { status="FULLY VACCINATED"; }
        else { status = "PARTIALLY VACCINATED"; }
    }
    void set_vax_status(Vaccine vax)	//setter for Vaccine details
    {
        this.vax_status=vax;
    }
}
class Vaccine							//class for vaccine
{
    String name;						//denotes the name of the vaccine
    int number_of_doses;				//denotes the number of doses of the vaccine
    int gap;							//denotes the gap between doses of the vaccine
    public Vaccine(String name,int number_of_doses,int gap)		//constructor
    {
        this.name=name;
        this.number_of_doses=number_of_doses;
        this.gap=gap;
    }
    void display_details() {			//displaying details of a vaccine
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
                else if(list_of_citizen.containsKey(uid))
                {
                    System.out.println("ID already Exists.");
                }
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
                    if(list_of_citizen.get(cust_booking_id).getStatus().equals("FULLY VACCINATED"))
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
                            if(temp.getpincode()==booking_pincode)
                            {
                                System.out.println(temp.getId()+" "+temp.getname());
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
                        if(hospitalbyid.containsKey(booking_hid)==false)
                        {
                            System.out.println("Invalid Hospital ID.");
                            continue;
                        }
                        Hospital temp=hospitalbyid.get(booking_hid);
                        if(temp.getSlots().size()==0)
                        {
                            System.out.println("No slots available");
                            continue;
                        }
                        Citizen curr_cit=list_of_citizen.get(cust_booking_id);
                        int next_day=curr_cit.getNextduedate();
                        ArrayList<Pair> dwhcb=temp.display_slots_for_booking(next_day);
                        int max_day=dwhcb.get(0).getss();
                        for(Pair x:dwhcb)
                        {
                            max_day=Math.max(x.getss(),max_day);
                        }
                        if(curr_cit.getNextduedate() > max_day)
                        {
                            System.out.println("No slots available");
                            continue;
                        }
                        System.out.print("Choose Slot: ");
                        int booking_slot=sc.nextInt();
                        int day_he_choose=-1;
                        for(Pair x:dwhcb)
                        {
                            if(booking_slot==x.getff())
                            {
                                day_he_choose=x.getss();
                            }
                        }
                        if(day_he_choose==-1) {
                            System.out.println("Invalid Input");
                            continue;
                        }
                        if(day_he_choose>= curr_cit.getNextduedate())
                        {
                            if (booking_slot < dwhcb.size())
                            {
                                if(temp.getSlots().get(booking_slot).getQuantity()==0)
                                {
                                    System.out.println("No slots available");
                                }
                                else
                                {
                                    Slot booked_slot=temp.change_slot(booking_slot);
                                    if(curr_cit.getStatus().equals("REGISTERED"))
                                    {
                                        curr_cit.update_dose_count();
                                        curr_cit.set_status(booked_slot.getVaccine_name());
                                        curr_cit.set_vax_status(booked_slot.getVaccine_name());
                                        int day_to_update = day_he_choose + booked_slot.getVaccine_name().gap;
                                        curr_cit.update_newdate(day_to_update);
                                        System.out.println(curr_cit.getName()+" vaccinated with "+booked_slot.getVaccine_name().name);
                                    }
                                    else if(curr_cit.getStatus().equals("PARTIALLY VACCINATED"))
                                    {
                                        if(booked_slot.getVaccine_name().name.equals(curr_cit.getVax_status().name))
                                        {
                                            curr_cit.update_dose_count();
                                            curr_cit.set_status(booked_slot.getVaccine_name());
                                            curr_cit.set_vax_status(booked_slot.getVaccine_name());
                                            int day_to_update = day_he_choose + booked_slot.getVaccine_name().gap;
                                            curr_cit.update_newdate(day_to_update);
                                            System.out.println(curr_cit.getName()+" vaccinated with "+booked_slot.getVaccine_name().name);
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
                            if(temp.getVax_status()==null || temp.getVax_status().name.equals(vaccine_chosen))
                            {
                                ArrayList<Integer> available_hospital=new ArrayList<>();
                                boolean flag=false;
                                for(Hospital it : hospitalArrayList)
                                {
                                    if(it.check_vaccine_slot(vaccine_chosen))
                                    {
                                        flag=true;
                                        available_hospital.add(it.getId());
                                        System.out.println(it.getId()+" "+it.getname());
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
                                    int next_day=temp.getNextduedate();
                                    ArrayList<Pair> ind_to_day=hos_chosen.find_slot_vs_index(vaccine_chosen,next_day);
                                    int max_day=ind_to_day.get(0).getss();
                                    for(Pair p : ind_to_day)
                                    {
                                        max_day=Math.max(p.getss(),max_day);
                                    }
                                    Citizen curr_cit=list_of_citizen.get(cust_booking_id);
                                    if(curr_cit.getNextduedate() > max_day)
                                    {
                                        System.out.println("No slots available");
                                        continue;
                                    }
                                    ind_to_day=hos_chosen.display_slot_by_vaccine_name(vaccine_chosen,next_day);
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
                                    if(curr_cit.getNextduedate() > day_he_choose)
                                    {
                                        System.out.println("No slots available");
                                        continue;
                                    }
                                    if(hos_chosen.getSlots().get(booking_slot).getQuantity()==0)
                                    {
                                        System.out.println("No slots available");
                                    }
                                    else
                                    {
                                        Slot booked_slot=hos_chosen.change_slot(booking_slot);
                                        if(curr_cit.getStatus().equals("REGISTERED"))
                                        {
                                            curr_cit.update_dose_count();
                                            curr_cit.set_status(booked_slot.getVaccine_name());
                                            curr_cit.set_vax_status(booked_slot.getVaccine_name());
                                            int day_to_update = day_he_choose + booked_slot.getVaccine_name().gap;
                                            curr_cit.update_newdate(day_to_update);
                                            System.out.println(curr_cit.getName()+" vaccinated with "+booked_slot.getVaccine_name().name);
                                        }
                                        else if(curr_cit.getStatus().equals("PARTIALLY VACCINATED"))
                                        {
                                            if(booked_slot.getVaccine_name().name.equals(curr_cit.getVax_status().name))
                                            {
                                                curr_cit.update_dose_count();
                                                curr_cit.set_status(booked_slot.getVaccine_name());
                                                curr_cit.set_vax_status(booked_slot.getVaccine_name());
                                                int day_to_update = day_he_choose + booked_slot.getVaccine_name().gap;
                                                curr_cit.update_newdate(day_to_update);
                                                System.out.println(curr_cit.getName()+" vaccinated with "+booked_slot.getVaccine_name().name);
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
                System.out.println("Citizen"+" "+temp.getStatus());
                if(temp.getStatus().equals("REGISTERED")==false)
                {
                    System.out.println("Vaccine Given: " + temp.getVax_status().name);
                    System.out.println("Number of Doses given: " + temp.getDose_count());
                    if ((temp.getStatus()).equals("FULLY VACCINATED"))
                        continue;
                    else
                        System.out.println("Next Dose due date: " + temp.getNextduedate());
                }
            }
            else if(choice==8)
            {
                System.out.println("Stay home,stay safe!\n{End of Test Case}");
                System.out.println("---------------------------------");
                System.exit(0);
            }
            else {
                System.out.println("Invalid Choice.Try Again with a valid option");
            }
        }
    }
}
