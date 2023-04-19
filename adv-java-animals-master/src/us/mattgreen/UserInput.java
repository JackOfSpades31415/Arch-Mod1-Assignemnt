package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
    public String choice;

    public UserInput(String choice){
        this.choice = choice;

    }

    public static void chooseAnimal(ArrayList<Talkable> zoo) throws IllegalArgumentException {
        Scanner keyboard = new Scanner(System.in);
        try {
            String resp;
            String name;
            System.out.println("What type of animal would you like to add?");
            resp = keyboard.nextLine().toLowerCase();
            if (resp.equals("dog")) {
                char friend;
                System.out.println("What is their name?");
                name = keyboard.nextLine();
                if (name.isBlank()){
                    throw new IllegalArgumentException(name);
                }
                System.out.println("Are they friendly? (Y/N)");
                friend = keyboard.nextLine().toLowerCase().charAt(0);
                if(friend == 'y'){
                    zoo.add(new Dog(true, name));
                }
                else if(friend == 'n') {
                    zoo.add(new Dog(false, name));
                }
                else{
                    throw new IllegalArgumentException(String.valueOf(friend));
                }

            } else if (resp.equals("cat")) {
                int miceKill;
                System.out.println("What is their name?");
                name = keyboard.nextLine();
                if (name.isBlank()){
                    throw new IllegalArgumentException(name);
                }
                System.out.println("What is their mice kill count?");
                miceKill = Integer.parseInt(keyboard.nextLine());
                zoo.add(new Cat(miceKill, name));
            } else
                throw new IllegalArgumentException(resp);

        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage() + " is not a valid animal.");
        }


    }
}
