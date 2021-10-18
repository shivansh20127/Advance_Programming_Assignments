package com.company;

import java.util.Scanner;

public class submission
{
    private final String answer;
    private boolean is_graded;
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
}
