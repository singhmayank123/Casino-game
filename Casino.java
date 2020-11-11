import java.util.Random; 
import java.util.Scanner;


public class Casino{

    //casino membership class
    public static class CasinoMembership{

        //data members
        private int membership_id;
        private int points;
        private String status;

        //constructor
        CasinoMembership(){
            //give a randomly generated membership id
            Random rand = new Random();
            membership_id = rand.nextInt(1000000);

            //initialize points as 600
            points = 600;

            //give regular status
            status = "regular";
        }


        //method to display status of a member
        public void display_status(){
            System.out.println("Status: " + status);
        }


        //method to add points
        public void add_points(){

            //ask for how many points member wants to add
            System.out.println("How many points do you want to add?\n1) 200\n2) 500\n");
            //create an object of Scanner class 
            Scanner sc = new Scanner(System.in);

            Character ch = sc.next().charAt(0);

            //if user wants to add 200 points 
            if(ch == '1'){
                points += 200;
                System.out.println("Added 200 points");
                System.out.println("Current Points: " + String.valueOf(points));
            }
            //if user wants to add 500 points 
            else if(ch == '2'){
                points += 500;
                System.out.println("Added 500 points");
                System.out.println("Current Points: " + String.valueOf(points));
            }
            else{

                //invalid input
                System.out.println("Invalid Input!");
            }
        }


        //method to upgrade status from regular to elite
        public void upgrade_status(){

            //if points are less than 1000
            if(points < 1000){
                System.out.println("You must have 1000 points to upgrade");
                System.out.println("Current Points: " + String.valueOf(points));
            }
            else{
                status = "elite";
                System.out.println("Status upgraded!\nNew status: " + status);
            }
        }
    }



    //main method
    public static void main(String[] args) {
        
        //create a casino membership object
        CasinoMembership member = new CasinoMembership();

        //continuosly display a menu to user and ask for user's choice
        while(true){
            System.out.println("\n1) Show Status\n2) Add Coins\n3) Upgrade Status\n4) Quit");
            System.out.print("\nChoose an option: ");

            //create a Scanner object
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();


            //perform operations according to user choice
            switch(op){

                //show status
                case 1:
                    member.display_status();
                    break;
                //add points
                case 2:
                    member.add_points();
                    break;
                //upgrade status
                case 3:
                    member.upgrade_status();
                    break;
                case 4:
                    System.out.println("Exiting the application.......");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}