package com.company;

import java.util.HashMap;

public interface assessment
{
    public submission makesub();
    public void addSubmission(Data _obj,submission _aobj);
    public void gradesub(Data _by);
    public int getmarks();
    public void close();
    public boolean getstatus();
    public void view(int pos);
}
