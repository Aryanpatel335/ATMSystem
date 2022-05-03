import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        int option;


        do {
            System.out.println("1 = open account with your id \n2 = make a new account for system \n3 = Exit System");
            Scanner userinput = new Scanner(System.in);
            option = userinput.nextInt();

            if (option == 1) {
                int idnum;
                System.out.println("Enter your id");
                Scanner identry = new Scanner(System.in);
                idnum = identry.nextInt();
                checking MembId= new checking();

                if (MembId.checkID(idnum) == true) {
                    Bankaccount obj1 = new Bankaccount(idnum);
                    obj1.showMenu();
                } else {
                    System.out.println("Id not found in database");
                }


            } else if (option == 2) {


                WriteUserID add = new WriteUserID();
                add.addToFile();


            }
            if(option==3){

               break;

            }



        }while(option !=1 || option !=2 || option !=3);


        System.out.println("Thanks Have a good day");

    }
}

class Bankaccount{

    int balance;
    int previousTransaction;

    private int customerId;

    public Bankaccount(int cid){

        this.customerId= cid;
        




    }

    void deposit(int amount){
        if(amount !=0){
            balance = balance + amount;
            previousTransaction = amount;
        }


    }
    void withdraw(int amount){
        if(amount !=0){

            balance = balance - amount;
            previousTransaction = -amount;

        }


    }
    void getPreviousTransaction(){
        if(previousTransaction > 0 ){

            System.out.println("Deposited : " + previousTransaction);
        }
        else if(previousTransaction < 0 ){

            System.out.println("withdraw : " + Math.abs(previousTransaction));
        }
        else{
            System.out.println("No transaction occured");

        }

    }
    public static boolean checkAccount(int id){
        String num;
        try {
            FileInputStream myObj = new FileInputStream("accounts.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(myObj));
            while ((num = br.readLine()) != null) {

                if(Integer.parseInt(num) == id){

                    return true;
                }
                else{
                    return false;
                }
            }
            myObj.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }



    void showMenu(){
        char option = '\0';

        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome user: " + customerId);
        System.out.println("\n");
        System.out.println("A. Check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. exit");

        do{

            System.out.println("====================================================================");
            System.out.println("Enter an option");
            System.out.println("====================================================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option){

                case 'A':
                    System.out.println(balance);
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("Enter the amount to deposit");
                    int amount1 = scanner.nextInt();
                    deposit(amount1);
                    System.out.println("\n");
                    break;


                case 'C':
                    System.out.println("Enter the amount to withrdraw");
                    int amount2  = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("The previous deposit was ");
                    getPreviousTransaction();
                    System.out.println("-----------------------------------");
                    System.out.println("\n");

                    break;
                case 'E':
                    break;

                default:
                    System.out.println("Invalid option");
                    break;

            }


        }while(option !='E');
        System.out.println("Thank you come again!");



    }






}


