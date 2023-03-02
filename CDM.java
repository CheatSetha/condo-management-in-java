package HomeWorkCondo;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CDM {
    public static void pressAnyKey(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to continue...!");
        input.nextLine();
    }
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        int floor, room;
        String[][] condo;
        String buyerName;
        boolean availble = false;


        do {
            System.out.println("-------setup condo-------");
            System.out.print("Enter the number of floor : ");
            floor = input.nextInt();
            System.out.println();//new line
            System.out.print("Enter the number of room in a floor : ");
            room = input.nextInt();


        } while (floor <= 0 || room <= 0); //check if user input less than 0
        condo = new String[floor][room];
        System.out.println("Condo setup already");
        System.out.println("Condo's floor is " + floor);
        System.out.println("A floor has " + room + " rooms");
        System.out.println("Condo's total room is " + (floor * room));
        pressAnyKey();


        do {
            System.out.println("---------------The Setha Condo-----------");
            System.out.println("1. Buy condo");
            System.out.println("2. Sell condo");
            System.out.println("3. Search condo");
            System.out.println("4. Display condo info");
            System.out.println("5. exit");
            System.out.print("Choose from 1 to 5 : ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    int buyRoom, buyFloor;
                    //String buyerName;
                    // boolean availble = false;
                    //validation of user input
                    do {

                        do {
                            System.out.println("==========buy condo=========== ");

                            System.out.print("Enter floor that you wanna buy (1-"+condo.length+") : ");
                            buyFloor = input.nextInt();

                            System.out.print("Enter room that you wanna buy (1-"+condo[floor-1].length+") :");
                            buyRoom = input.nextInt();
                        } while (buyFloor < 1 || buyRoom < 1 ||buyRoom >condo[floor-1].length ||buyFloor>(condo.length-1));//end of validate user input
                        //check if owned can't buy
                        if (condo[buyFloor - 1][buyRoom - 1] == null) {

                            System.out.print("Enter your name : ");
                            buyerName = input.next();
                            availble = true;
                            condo[buyFloor - 1][buyRoom - 1] = buyerName;
                            System.out.println("========Information======");
                            System.out.println("Congratualation " + buyerName + " You have bought a condo.");
                            System.out.println("Your condo's floor is " + buyFloor);
                            System.out.println("Your condo's room is " + buyRoom);
                            System.out.println("Thank you!");


                        } else {
//                            ask user that want to cont or not
                            System.out.println("This room not available! sorry pleas kindly choose another!");
                            System.out.println("Do you wanna choose again? ");
                            System.out.println("pres 1 to countue choose and other for exit : ");
                            int numOpt = input.nextInt();
                            if (numOpt == 1) {
                                availble = false;
                            } else {
                                availble = true;
                            }
                        }
                        pressAnyKey();


                    } while (!availble);

                    break;
                case 2:

                    //start sell

                    do {
                        System.out.println("=========Sell condo=========");
                        System.out.println("Enter the floor that you was bought: ");
                        buyFloor = input.nextInt();
                        System.out.println("Enter your room number : ");
                        buyRoom = input.nextInt();
                        if (buyFloor > 0 && buyFloor <= floor && buyRoom > 0 && buyRoom <= room) {
                            if (condo[buyFloor - 1][buyRoom - 1] != null) {
                                System.out.println("Enter the owner's name : ");
                                buyerName = input.next();
                                if (buyerName.equalsIgnoreCase(condo[buyFloor - 1][buyRoom - 1])) {
                                    condo[buyFloor - 1][buyRoom - 1] = null;
                                    System.out.println("You have sold the condo! ");
                                    availble = true;
                                } else {
                                    System.out.println("invalid name ");
                                    availble = false;
                                    System.out.println("Do you wanna choose again? ");
                                    System.out.println("pres 1 to countue choose and other for exit : ");
                                    int numOpt = input.nextInt();
                                    switch (numOpt){
                                        case 1 -> availble=false;
                                        default -> availble=true;
                                    }

                                }
                            } else {
                                System.out.println("my apologise you are'nt this codo's owner");

                                System.out.println("Do you wanna choose again? ");
                                System.out.println("pres 1 to countue choose and other for exit : ");
                                int numOpt = input.nextInt();
                                switch (numOpt){
                                    case 1 -> availble=false;
                                    default -> availble=true;
                                }
                            }
                        } else {
                            System.out.println("Invalid floor or room!");
                            availble = false;
                            System.out.println("Do you wanna choose again? ");
                            System.out.println("pres 1 to countue choose and other for exit : ");
                            int numOpt = input.nextInt();
                            switch (numOpt){
                                case 1 -> availble=false;
                                default -> availble=true;
                            }
                        }
                    } while (!availble);
                    //end sell
                    break;
                case 3:
                    int searchOption;
                    int searchFloor;
                    int searchRoom;
                    String searchOwner;

                    System.out.println("===========Search condo=============");
                    System.out.println("1. search by owner's name : ");
                    System.out.println("2. Search by floor and room : ");
                    System.out.println("2. Search by floor : ");
                    System.out.println("3. Exit");
                    System.out.print("Choose your option from 1 to 3 : ");
                    searchOption = input.nextInt();
                    switch (searchOption) {
                        case 1 -> {
                            String name;
                            System.out.println("===================== Search Condo by Owner's Name ===================");
                            System.out.print("Enter the owner name : ");
                            input.nextLine();
                            name = input.nextLine();
                            String newName = Arrays.toString(new String[condo.length][]);
                            first:  for(int i=(condo.length-1); i>=0; i--){
                                for (int j = 0; j < condo[i].length; j++) {
                                    newName = condo[i][j];
                                    if(Objects.equals(newName, condo[i][j])){
                                        System.out.println("The owner's name is "+name+" in floor "+(i-1)+" in room "+(j+1));
                                        break first;
                                    }else {
                                        System.out.println("User : "+name+" does not exist in our system.");
                                    }
                                }
                            }
                        }

                        case 2 ->{
                            System.out.println("-------search by floor and room--------");
                            System.out.println("Enter floor : ");
                            searchFloor= input.nextInt();
                            System.out.println("Enter room : ");
                            searchRoom= input.nextInt();

                            if(searchFloor>0 && searchFloor<=floor && searchRoom>0 && searchRoom<= room){
                                System.out.println("Floor of : "+searchFloor+" Room of : " +searchRoom+
                                        ((condo[searchFloor-1][searchRoom-1]==null)? " is available"
                                                : "  Owner is "+ condo[searchFloor-1][searchRoom-1]));
                                // print condo[floor-1][room-1]
                            }else{
                                System.out.println("ERROR!! searchRoom and searchFloor is incorrect ");
                                System.out.println("Choose Floor from  1 to "+floor);
                                System.out.println("Choose Room from  1 to "+room);
                            }
                            // print condo[floor-1][room-1]
                             }
                        case 3 -> {
                            System.out.println("------Search by floor------");
                            System.out.println("Enter the floor to search : ");
                            searchFloor = input.nextInt();
                            if (searchFloor>0 && searchFloor<=floor){
                                System.out.println("Floor "+searchFloor +" : ");
                                for (int i = 0; i <condo[searchFloor-1].length ; i++) {
                                    System.out.println("\t "+condo[searchFloor-1][i]);

                                }
                                System.out.println();//new line here
                            }else System.out.println("Error! invalid floor please choose from 1 to"+floor);

                        }
//                        case 4 ->{
//                            String searchOwnerName;
//                            boolean found=false;
//
//
//                        }


                        case 4 -> System.out.println("Exit the search menu......!");
                        default -> System.out.println("Wrong option! Please choose from 1 to 3...!");

                    }
                    break;

                case 4:
                    System.out.println("=======Show condo information=======");
                    for(int i=(condo.length-1); i>=0; i--){
                        System.out.print("Floor ["+(i+1)+"]");
                        for (int j = 0; j < condo[i].length; j++) {
                            System.out.print("\t"+condo[i][j]+" ");

                        }
//                        for(int j=(condo[i].length-1); j>=0; j--){
//                            System.out.print("\t"+condo[i][j]+" ");
//                        }
                        System.out.println();
                    }
//                    for (int i = 0; i < condo.length; i++) {
//                        System.out.println("floor " + (i + 1) + " : ");
//
//                        for (int j = 0; j < condo[i].length; j++) {
//                            System.out.println("room [" + (i + 1) + "[" + (j + 1) + "]" + "=== " + condo[i][j]);
//
//                        }
//                        System.out.println();//break point
//                    }
                    break;
                case 5:
                    System.out.println("exit");
                    break;
            }
        } while (option != 5);
    }
}
