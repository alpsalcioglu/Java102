import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    AccountManager accountManager = new AccountManager();

    User user1 = new User("Alp","Salcıoğlu","alpsalcioglu10@gmail.com","Alp123","Software Engineer",20);
    User user2 = new User("Tuana","Al","tuanaalgmail.com","Tuana123","Agriculture Engineer",22);

    Account individualAccount = new IndividualAccount(user1);
    Account enterpriseAccount = new EnterpriseAccount(user2);

    accountManager.addAccount(individualAccount);
    accountManager.addAccount(enterpriseAccount);
        boolean isTrue = true;
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("Password: ");
        String password = input.next();

        Account loggedInAccount = accountManager.login(email,password);
        if (loggedInAccount != null) {
            System.out.println("Login successful!");
            loggedInAccount.showUserInfo();
            do {
                System.out.println("Choose an insurance plan to add:");
                System.out.println("1. Health Insurance");
                System.out.println("2. Residence Insurance");
                System.out.println("3. Travel Insurance");
                System.out.println("4. Car Insurance");
                System.out.println("5. Exit");
                int choice = input.nextInt();

                System.out.print("Enter insurance name:");
                String insuranceName = input.next();

                System.out.print("Enter insurance price:");
                double price = input.nextDouble();


                // Sigortayı ekle
                Insurance insurance = null;
                switch (choice) {
                    case 1:
                        insurance = new HealthInsurance(insuranceName, price, new Date(), new Date());
                        isTrue=false;
                        break;
                    case 2:
                        insurance = new ResidenceInsurance(insuranceName, price, new Date(), new Date());
                        isTrue=false;
                        break;
                    case 3:
                        insurance = new TravelInsurance(insuranceName, price, new Date(), new Date());
                        isTrue=false;
                        break;
                    case 4:
                        insurance = new CarInsurance(insuranceName, price, new Date(), new Date());
                        isTrue=false;
                        break;
                    case 5:
                        System.out.println("Good Bye!");
                        isTrue = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        continue;
                }
                if (insurance != null) {
                    loggedInAccount.addInsurance(insurance);
                    System.out.println(insuranceName + " added successfully.");
                }

            } while (isTrue);

             System.out.println("Your insurance plans : ");
            for (Insurance insurance : loggedInAccount.insuranceArrayList) {
                System.out.println("Insurance Name: " + insurance.name + ", Price: " + insurance.price + ", Start Date: " + insurance.startDate + ", End Date: " + insurance.endDate);
            }
        } else {
            System.out.println("Invalid email or password.");
        }




    }
}