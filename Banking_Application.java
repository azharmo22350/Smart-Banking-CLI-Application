import java.util.Scanner;

public class Banking_Application{
    
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {

         
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD ="\033[31";
        final String RESET = "\033[0m";

        final String DASHBOARD ="Welcome to Smart Banking" ;
        final String  CREATE_NEW_ACCOUNT= "create new account";
        final String DEPOSITE= "deposite";
        final String WITHDRAWALS = "withdrawals";
        final String BANKING_STATEMENT = "Banking statement";
        final String TRANSFER = "Transfer";
        final String DELETE_ACCOUNT = "Delete Account";
        final String EXIT = "Exit";


        String screen =DASHBOARD ;

        do
        {

        final String APP_TITLE = String.format("%s%s%s",
        COLOR_BLUE_BOLD, screen, RESET);

        System.out.println(CLEAR);
        System.out.println("-".repeat(30));
        System.out.println(" ".repeat((30 - APP_TITLE.length() + 7)/2).concat(APP_TITLE));
        System.out.println("-".repeat(30));


        switch(screen)
        {

        case DASHBOARD:

                System.out.println("[1]. Create new account");
                System.out.println("[2]. Deposite");
                System.out.println("[3]. Withdrawals");
                System.out.println("[4]. Banking statement");
                System.out.println("[5]. Transfer");
                System.out.println("[6]. Delete Account");
                System.out.println("[4]. Exit");
                System.out.print("Enter an option to continue > ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch(option){

                    case 1: screen =CREATE_NEW_ACCOUNT ; break;
                    case 2: screen =DEPOSITE; break;
                    case 3: screen =WITHDRAWALS;break;
                    case 4: screen =BANKING_STATEMENT; break;
                    case 5: screen =TRANSFER; break;
                    case 6: screen =DELETE_ACCOUNT; break;
                    case 7: 
                        {screen =EXIT; 
                        System.exit(0);
                        break;}
                    default:System.exit(0);
                }

        case CREATE_NEW_ACCOUNT:
               
                


    }

    }

    while(true) ;
        
        
    }
}

