import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PatikaStore {
    public static void main(String[] args) {
        boolean isTrue = true;
        System.out.println("\nWelcome to the PatikaStore!");
        while(isTrue) {
            Scanner input = new Scanner(System.in);

            System.out.println("\n1 - NoteBooks");
            System.out.println("2 - CellPhones");
            System.out.println("3 - Both NoteBooks and CellPhones");
            System.out.println("4 - All Brand Names");
            System.out.println("0 - Exit");
            System.out.print("----> Please Select: ");
            int selection = input.nextInt();
            switch (selection) {
                case 0:
                    System.out.println("See you again!");
                    isTrue = false;
                    break;
                case 1:
                    NoteBook.printNoteBook();
                    break;
                case 2:
                    CellPhone.printCellPhone();
                    break;
                case 3:
                    NoteBook.printNoteBook();
                    CellPhone.printCellPhone();
                    break;
                case 4:
                    Brand.printBrandName();
                    break;
            }
        }






    }






}