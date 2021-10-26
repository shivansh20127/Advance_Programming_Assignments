package com.company;

public class snake extends floor
{
    snake(int _point,int _jump)
    {
        super(_point,_jump);
    }

    @Override
    public String getMessage(){
        return(" has reached a snake floor ");
    }
}