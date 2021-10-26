package com.company;
public abstract class floor
{
    private final int point;
    private final int jump;
    public floor(int _point,int _jump)
    {
        this.point=_point;
        this.jump=_jump;
    }
    protected int getPoint(){
        return this.point;
    }
    protected int getJump(){
        return this.jump;
    }
    public abstract String getMessage();
}