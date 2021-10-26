package com.company;

public class ladder extends floor
{
    ladder(int _point,int _jump)
    {
        super(_point,_jump);
    }
    @Override
    public String getMessage() { return(" has reached a ladder floor "); }

}