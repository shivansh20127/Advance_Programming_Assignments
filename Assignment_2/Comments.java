package com.company;
import java.util.*;
public class Comments
{
    private final String comment;
    private final Data madeby;
    private final Date madedate;
    Comments(Data _id)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter comment: ");
        this.comment =sc.nextLine();
        this.madeby=_id;
        this.madedate=new Date();
    }
    public void view()
    {
        System.out.println(this.comment+" - "+this.madeby.getName());
        System.out.println(this.madedate);
    }
}

