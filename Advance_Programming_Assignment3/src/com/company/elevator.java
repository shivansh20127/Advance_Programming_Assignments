package com.company;

public final class elevator extends ladder
{
    elevator()
    {
        super(4,8);
    }
    @Override
    public String getMessage() { return(" has reached an elevator floor "); }
}

