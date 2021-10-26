package com.company;
import java.util.Scanner;

public final class board
{
    private final player who_is_playing;
    public board()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name and hit enter");
        String play_name=sc.nextLine();
        while(play_name.equals(""))
        {
            System.out.println("Enter the name and hit enter");
            Scanner scan=new Scanner(System.in);
            play_name= sc.nextLine();
        }
        who_is_playing=new player(play_name);
    }
    public void enter() {
        who_is_playing.play();
    }
}
