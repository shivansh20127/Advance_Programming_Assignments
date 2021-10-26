package com.company;
import java.util.Random;
public final class Dice
{
    private final int num_face;
    private int val_of_face;
    private final Random random = new Random();
    Dice(int _num_face)
    {
        this.num_face=_num_face;
    }
    public void roll_dice()
    {
        int num=this.random.nextInt((int)1e9);
        String number=Integer.toBinaryString(num);
        Character final_num=number.charAt(number.length()-1);
        if(final_num=='0') this.val_of_face=1;
        else this.val_of_face=2;
    }
    public int getVal_of_face()
    {
        return this.val_of_face;
    }
}