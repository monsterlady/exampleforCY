import java.util.Scanner;

public class Bingo {
    private Scanner scanner;
    private int size =5;
    private boolean[] bingoed;
    private int[] bingoArray;
    private String[] toShow;
    private int round;
    private boolean isCreated = false;
    public static void  main(String [] args){
        new Bingo().run();
    }

    private void run() {
        initArrys();
        System.out.println(getMenu());
        int select = getVaildInput();
        while(select != 9){
            switch (select){
                case 1:
                assignment1();
                isCreated = true;
                System.out.println(getMenu());
                select = getVaildInput();
                break;

               case 2:
                   if(!isCreated){
                       popupError();
                       System.out.println(getMenu());
                       select = getVaildInput();
                   } else {
                       assignment2();
                       System.out.println(getMenu());
                       select = getVaildInput();
                   }
                    break;

                case 3:
                    if(!isCreated){
                        popupError();
                        System.out.println(getMenu());
                        select = getVaildInput();
                    } else {
                        assignment3();
                        System.out.println(getMenu());
                        select = getVaildInput();
                    }
                    break;
            }
        }

    }

    private void initArrys(){
       bingoed = new boolean[size];
       bingoArray = new int[size];
       toShow  = new String[size];
    }

    private void assignment1(){
        scanner = new Scanner(System.in);
        for(int i = 0; i < bingoArray.length; i++){
            System.out.print("Enter a value for field"+ String.valueOf(i + 1) +": ");
            bingoArray[i] = scanner.nextInt();
        }
    }

    private void assignment2(){
        round++;
        int random = (int)(Math.random() * 20);
       for(int i = 0 ; i < bingoArray.length; i++) {
           if (bingoArray[i] == random && !bingoed[i]) {
               bingoed[i] = true;
               toShow[i] = "(" + String.valueOf(bingoArray[i]) + ")";
           }else if(bingoed[i]){
               toShow[i] = "(" + String.valueOf(bingoArray[i]) + ")";
           } else {
               toShow[i] = String.valueOf(bingoArray[i]);
           }
       }
           //System.out.print(" " + i);
           System.out.println("A number is drawn! The ball reads the number: "+ random +"! ");
           System.out.print("[");
           for(String s : toShow){
               System.out.print(s + " ");
           }
           System.out.print("] \n");

    }

    private void assignment3(){
        boolean isBingo = true;
        System.out.print("Your Bingo card:");
        System.out.print("[");
        for(String s : toShow){
            System.out.print(s + " ");
        }
        System.out.print("] \n");
        for(boolean b : bingoed){
            if(!b){
               isBingo = false;
            }
        }
        if(!isBingo) {
            System.out.println("Unfortunately you don’t have Bingo yet! ");
        } else {
            System.out.println("BINGO! All numbers are marked in "+ round +" turns. ");
        }
    }

    private void popupError(){
        System.out.println("You must first create a Bingo card before drawing a number! ");
    }

    private String getMenu(){
        String str = "******************************************"+"\n"+"*  BINGO  "+"\n"+"****************************************** "
                +"\n"+"*  1)  Create a Bingo card "+"\n"+"*  2)  Draw a number "+"\n"+"*  3)  Check Bingo card "+"\n"+"*  9)  Exit "+"\n"+
                "******************************************";
        return  str;
    }

    private int getVaildInput(){
        scanner = new Scanner(System.in);
        System.out.print("\n" + "Select a menu option:  ");
        int i = scanner.nextInt();
        if(i != 1 && i != 2 && i != 3 && i !=9 ){
            System.out.println("Please input valid number!");
            getVaildInput();
        }
        return i;

    }

}
