public class XRK {
    private static String image = "O  O  O  O \n" +
            "  O  O  O\n" +
            "   O   O\n" +
            "     O";
    private static int score = 0;

    public static void main(String[] args) {new XRK().run();}

    public void run(){
        System.out.println("Welcome to Random Bowling!");
        imagePrint(image);
        int round = 0;
        while(round < 3 && isFull(image)){
            round++;
            System.out.println("Throw " + round + "\n");
            knockdown(image);
        }
        System.out.println("\n" + "Your score is " + score + " points! ");

    }

    public void knockdown(String str) {
        if (isFull(str)) {
            int counter = 0;
            int bollToknock = (int) (Math.random() * 10 - score);
            if(bollToknock < 0){
                bollToknock = 0;
            }
            while(counter < bollToknock && bollToknock != 0){
                int random = (int)(Math.random() * str.length());
                if(str.charAt(random) == 'O'){
                    StringBuilder stringBuilder = new StringBuilder(str);
                    stringBuilder.setCharAt(random,'X');
                    str = stringBuilder.toString();
                    image = str;
                    counter++;
                }
            }
            imagePrint(image);
            System.out.println("\n" + bollToknock + " fell over this round! ");
            score += bollToknock;
        }
    }

    public void imagePrint(String str){
        System.out.println(str);
    }

    public boolean isFull(String str){
        boolean isAvailable = true;
        int standBoll = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'O') {
                standBoll++;
            }
        }
        if (standBoll == 0) {
            isAvailable = false;
        }
        return isAvailable;
    }
}
