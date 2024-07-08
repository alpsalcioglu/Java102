import java.util.Scanner;

public class Game {


    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to the Adventure Game !");
        System.out.print("Please enter a name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println();
        System.out.println("Dear " + player.getName() + ", welcome to this dark and fogy island!");
        System.out.println("Remember this, everything that happened here is real...");
        System.out.println("Please select a character to start this journey...");
        player.selectChar();
        Location location = null;
        while(true){
            player.printInfo();
            System.out.println("----------\nLocations: ");
            System.out.println("1. Safe House -> There are no enemies here. Totally safe!");
            System.out.println("2. Tool Store -> You can purchase your armor and weapons here!");
            System.out.println("3. Cave -> Enter the Cave, be careful there may be zombies! Award: <Food>");
            System.out.println("4. Forest -> Enter the Forest, be careful there may be vampires! Award: <Firewood>");
            System.out.println("5. River -> Enter the River, be careful there may be bears! Award: <Water>" );
            System.out.println("0. Exit Game\n");
            System.out.print("Please enter the location that you want to go: ");
            int selectLoc = input.nextInt();
            System.out.println("---------");
            switch (selectLoc){
                case 0:
                    location= null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Please enter a valid location!");
            }
            if(location==null){
                System.out.println("I didn't expect you to give up so quick, good bye! ");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER");
                break;
            }
        }

    }

}
