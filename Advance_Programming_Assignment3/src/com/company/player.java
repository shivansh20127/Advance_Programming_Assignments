package com.company;
import java.util.Scanner;
public final class player
{
    private final String name;
    private Dice obj;
    private int score;
    private int present_pos;
    player(String _name)
    {
        this.name=_name;
        obj=new Dice(2);
        this.score=0;
        present_pos=-1;
    }
    public int getScore(){
        return this.score;
    }
    public void updateScore(int value) {
        this.score+=value;
    }

    public void displayScore() {
        System.out.println("Total points "+this.score);
    }

    public String getName(){
        return this.name;
    }

    public int getPresent_pos(){
        return this.present_pos;
    }

    public void updatePresent_pos(int x){
        this.present_pos+=x;
    }

    public void start_game(){
        Scanner sc=new Scanner(System.in);
        System.out.println("The game setup is ready ");
        while(true){
            System.out.println("Hit enter to roll the dice");
            String input=sc.nextLine();
            if(input.equals(""))
            {
                obj.roll_dice();
                int face=obj.getVal_of_face();
                System.out.println("Dice gave "+face);
                if(obj.getVal_of_face()==1)
                {
                    System.out.println("Player position Floor-0" );
                    empty_floor e=new empty_floor();
                    System.out.println(this.getName()+e.getMessage());
                    this.updateScore(1);
                    this.updatePresent_pos(1);
                    System.out.println("Total Points "+this.getScore());
                    return ;
                }
                else
                {
                    System.out.println("Game cannot start until you get 1");
                }
            }
        }
    }

    public void end_game(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Hit enter to roll the dice");
            String input=sc.nextLine();
            if(input.equals(""))
            {
                obj.roll_dice();
                int face=obj.getVal_of_face();
                System.out.println("Dice gave "+face);
                if(obj.getVal_of_face()==1){
                    System.out.println("Player position Floor-"+13);
                    empty_floor e=new empty_floor();
                    System.out.println(this.getName()+e.getMessage());
                    this.updateScore(e.getPoint());
                    System.out.println("Total Points "+this.getScore());
                    System.out.println("Game Over");
                    System.out.println(this.getName()+" accumulated "+this.getScore()+" points");
                    return ;
                }
                else{
                    System.out.println("Player cannot move");
                }
            }
        }
    }

    public void play()
    {
        this.start_game();
        Scanner sc=new Scanner(System.in);
        while(this.getPresent_pos()<=13)
        {
            if(this.getPresent_pos()==13)
            {
                System.out.println("Game over\n" +this.getName()+"accumulated "+this.getScore()+" points"  );
                System.out.println("---------------------------------------------------------------");
                return ;
            }
            if(this.getPresent_pos()==12){
                this.end_game();
                return;
            }
            System.out.println("Hit enter to roll the dice");
            String input=sc.nextLine();
            if(input.equals(""))
            {
                obj.roll_dice();
                int face=obj.getVal_of_face();
                System.out.println("Dice gave "+face);
                this.updatePresent_pos(face);                 //updated curr position of player
                System.out.println("Player position Floor-"+this.getPresent_pos());
                int curr=this.getPresent_pos();
                if(curr!=2 && curr!=5 && curr!=8 && curr!=11)
                {
                    empty_floor e=new empty_floor();
                    System.out.println(this.getName()+e.getMessage());
                    this.updateScore(e.getPoint());
                    System.out.println("Total Points "+this.getScore());
                    continue;
                }
                else if(this.getPresent_pos()==2)
                {
                    elevator e=new elevator();
                    System.out.println(this.getName()+e.getMessage());
                    this.updateScore(e.getPoint());
                    System.out.println("Total Points "+this.getScore());
                    this.updatePresent_pos(e.getJump());
                    System.out.println("Player position Floor-"+this.getPresent_pos());
                    empty_floor temp=new empty_floor();
                    System.out.println(this.getName()+temp.getMessage());
                    this.updateScore(temp.getPoint());
                    System.out.println("Total Points "+this.getScore());
                    continue;
                }
                else if(this.getPresent_pos()==5)
                {
                    snake s=new snake(-2,-4);
                    System.out.println(this.getName()+s.getMessage());
                    this.updateScore(s.getPoint());
                    System.out.println("Total Points "+this.getScore());
                    this.updatePresent_pos(s.getJump());
                    System.out.println("Player position Floor-"+this.getPresent_pos());
                    empty_floor temp=new empty_floor();
                    System.out.println(this.getName()+temp.getMessage());
                    this.updateScore(temp.getPoint());
                    System.out.println("Total Points "+this.getScore());
                    continue;
                }

                else if(this.getPresent_pos()==8)
                {
                    ladder l=new ladder(2,4);
                    System.out.println(this.getName()+l.getMessage());
                    this.updateScore(l.getPoint());
                    System.out.println("Total Points "+this.getScore());
                    this.updatePresent_pos(l.getJump());
                    System.out.println("Player position Floor-"+this.getPresent_pos());
                    empty_floor temp=new empty_floor();
                    System.out.println(this.getName()+temp.getMessage());
                    this.updateScore(temp.getPoint());
                    System.out.println("Total points "+this.getScore());
                    continue;
                }
                else
                {
                    king_cobra k=new king_cobra();
                    System.out.println(this.getName()+k.getMessage());
                    this.updateScore(k.getPoint());
                    System.out.println("Total Points "+this.getScore());
                    this.updatePresent_pos(k.getJump());
                    System.out.println("Player position Floor-"+this.getPresent_pos());
                    empty_floor temp=new empty_floor();
                    System.out.println(this.getName()+temp.getMessage());
                    this.updateScore(temp.getPoint());
                    System.out.println("Total points "+this.getScore());
                    continue;

                }
            }
        }
    }
}
