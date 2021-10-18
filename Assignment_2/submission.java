package com.company;

import java.util.Scanner;

public class submission
{
    private final String answer;
    private boolean is_graded;
    private Data graded_by=null;
    private int graded_marks=-1;
    submission(String answer)
    {
        this.answer=answer;
        this.is_graded=false;
    }
    public String getFilename() {
        return this.answer;
    }
    public void setIs_graded() {
        this.is_graded=true;
    }
    public boolean isIs_graded() {
        return is_graded;
    }
    public void update_gradingdetails(Data _by, int _obtained) {
        this.graded_by=_by;
        this.graded_marks=_obtained;
    }
    public Data getGraded_by() {
        return this.graded_by;
    }
    public int getGraded_marks() {
        return this.graded_marks;
    }
}
