package com.company;
public final class empty_floor extends floor
{
    empty_floor()
    {
        super(1,0);
    }
    @Override
    public String getMessage(){
        return (" has reached an empty floor ");
    }
}