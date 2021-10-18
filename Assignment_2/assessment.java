package com.company;

import java.util.HashMap;

public interface assessment
{
    public submission makesub();
    public HashMap<Data,submission> getAll_submissions();
    public int getmarks();
    public void close();
    public boolean getstatus();
    public void view(int pos);
}
