package com.company;

public class grade
{
    private final Data graded_by;
    private final int graded_marks;
    grade(Data _obj,int obtained)
    {
        this.graded_by=_obj;
        this.graded_marks=obtained;
    }
    public Data getGraded_by() {
        return this.graded_by;
    }
    public int getGraded_marks() {
        return this.graded_marks;
    }
}
