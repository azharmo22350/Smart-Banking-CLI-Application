import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;



public class Banking_Application{

    public static final String COLOR_RED_BOLD ="\u001B[1;31m"; 
    public static final String RESET = "\033[0m";
    
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {

       

        String[][] CustomerDetails =new String[0][];
         
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        
        final String COLOR_YELLOW_BOLD ="\u001B[1;33m" ;
        final String COLOR_GREEN_BOLD ="\u001B[1;32m" ;
        

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
                System.out.println("[7]. Exit");
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
                break;

        case CREATE_NEW_ACCOUNT:

            System.out.printf("Your ID generated SDB-%05d\n",(CustomerDetails.length+1));
            String ID =String.format("SDB-%05d",(CustomerDetails.length+1));
            String name =ValidUserName();  
            Double InitialDeposite =Deposite(screen);

             

            String[][] newCustomerDetails =new String[(CustomerDetails.length+1)][3];

            for(int k=0; k<CustomerDetails.length; k++)
            {
                
                newCustomerDetails[k] =CustomerDetails[k] ;
            }

            
            newCustomerDetails[newCustomerDetails.length-1][0] =name ;
            newCustomerDetails[newCustomerDetails.length-1][1] =ID ;
            newCustomerDetails[newCustomerDetails.length-1][2]=String.valueOf(InitialDeposite) ;

            


            CustomerDetails =newCustomerDetails ;
         


            System.out.printf("%syour ID and name added succesfully\n%s",COLOR_YELLOW_BOLD,RESET);

            System.out.printf("Your Name  is %s and Account balance is Rs.%,.2f \n", name,InitialDeposite);
            
            System.out.print("Need to add another customer [Y/N]");
            if(scanner.nextLine().toUpperCase().equals("N")) 
            {
                screen=DASHBOARD;
                break;
            }

            break;

        case DELETE_ACCOUNT:

                    
            String DeleteAccountNumber =ValidAccountNumber();
            boolean valid3 ;
            int RemoveIndex =0;
            for(int i=0; i< CustomerDetails.length; i++)
            {
                
                if(CustomerDetails[i][1].equals(DeleteAccountNumber))
                {
                    System.out.printf("%sYour name is %s%s\n",COLOR_GREEN_BOLD,CustomerDetails[i][0],RESET) ;
                    System.out.printf("%sYour Account balance is %s%s\n",COLOR_GREEN_BOLD,CustomerDetails[i][2],RESET) ;
                    RemoveIndex =i;
                    break ;
                }
            }


            
        System.out.print("Are u sure want delete [y/n] : ") ;

        if(scanner.nextLine().toUpperCase().equals("N"))
        {
                screen =DASHBOARD;
        }


        String[][] newCustomerDetail =new String[(CustomerDetails.length-1)][3];

        for(int k=0; k<CustomerDetails.length; k++)
        {
            if(k<RemoveIndex)
            {
                newCustomerDetail[k] =CustomerDetails[k]  ;
            }
            else if(k==RemoveIndex)
            {
            continue;
            }
            else
            {
            newCustomerDetail[k-1] =CustomerDetails[k]  ;
            }
        }

            CustomerDetails =newCustomerDetail ;

            for(int i=0; i< CustomerDetails.length; i++)
              {

                System.out.println(Arrays.toString(CustomerDetails[i]));

              }
                System.out.print("Do u want to continue [y/n] : ") ;

               if(scanner.nextLine().toUpperCase().equals("N"))
              {
                    screen =DASHBOARD;
             }
         


        break ;

        case DEPOSITE:

         String DepositeAC =ValidAccountNumber() ;
  
        int index=0 ;
        for (int i=0;i<CustomerDetails.length;i++)
        {
            System.out.println("CustomerDetails[i][1] " +CustomerDetails[i][1]);
            System.out.println("DepositeAC "+ DepositeAC);
            if(CustomerDetails[i][1].equals(DepositeAC))
            {
                
                index=i;
                break;
            }
        }

        System.out.printf("your account balance is : %s\n",CustomerDetails[index][2]);
            
            Double DepositeAmount =Deposite(screen);

            System.out.println();
            CustomerDetails[index][2] = String.valueOf( (Double.valueOf( CustomerDetails[index][2]) +DepositeAmount)  )   ;

            System.out.printf("your new account balance is : %s\n",  CustomerDetails[index][2]);

            screen =Resume();

            break;

    case WITHDRAWALS:
       
        String WithdrawAccountNumber =ValidAccountNumber();

        boolean valid4=false;
        do{
        valid4=true;
        System.out.print("Enter the withdraw amount : ") ;
        Double WithdrawAmmount =scanner.nextDouble();
        scanner.nextLine();

        if(WithdrawAmmount<100)
        {
                System.out.printf("%sWithdrawals can t below 100 %s\n",COLOR_RED_BOLD,RESET);
                valid4=false;
                continue;
        }
        if((FindAccountbalance(WithdrawAccountNumber,CustomerDetails)-WithdrawAmmount) <500)
            {
                 System.out.printf("%sYour minimal account balance can t reach below 500 %s\n",COLOR_RED_BOLD,RESET);
                 valid4=false;
                continue;
            }

   

        }

        while(!valid4);

        screen =Resume();

        break;

    
          
                
    default : System.exit(0);
                   
    }

    }

    while(true) ;
        
        
    }


    public static String Resume()
    {
        System.out.print("Do u want to continue [Y/N] : ");
        if (scanner.nextLine().toUpperCase().equals("N"))
        {
            return "Welcome to Smart Banking";
        }
        else{
            return "deposite";
        }
        
    }

    public static String ValidUserName()
    {
            String name;
            boolean valid1;

            do {

                valid1 =true;
                
                System.out.print("Enter your name : ");
                name =scanner.nextLine().strip();

                    if(name.isBlank())
                {
                    System.out.printf("%sName can t be empty%s\n ",COLOR_RED_BOLD,RESET);
                    valid1 =false ;
                    continue;
                }
                
                valid1 =true ;
                for(int i=0; i<name.length(); i++)
                {
                    if(  !( Character.isSpaceChar(name.charAt(i))  || Character.isLetter(name.charAt(i))))
                    {
                        System.out.printf("%sInvalid name%s\n",COLOR_RED_BOLD,RESET);
                        valid1 =false;
                        break ;
                    }
                }

                

            }

            while(!valid1);

            return name;

    }


    public static String ValidAccountNumber()
    {
        boolean valid3 =true;
        String AccountNumber;

        do{

                    valid3=true ;
                    System.out.print("Enter your account Number : ");
                    AccountNumber =scanner.nextLine().strip();

                    if(!AccountNumber.startsWith("SDB-"))
                    {
                        System.out.printf("%sA/C starts with SDB-%s\n",COLOR_RED_BOLD,RESET);
                        valid3=false ;
                        continue;
                        
                        
                    }
                    if(AccountNumber.isBlank())
                    {
                        System.out.printf("%sA/C can t be Empty%s\n",COLOR_RED_BOLD,RESET);
                        valid3=false;
                        continue;
                    }

                    String numpart = AccountNumber.substring(4);

                    for(int j=0; j< numpart.length();j++)
                    {

                        if(   !Character.isDigit(numpart.charAt(j))  || Character.isSpaceChar(numpart.charAt(j))  )
                        {
                                System.out.printf("%sInvalid Account Number %s\n",COLOR_RED_BOLD,RESET);
                                valid3=false;
                                break;

                        }
                    }

                }

            while(!valid3);

            return AccountNumber;

    }

    public static Double Deposite(String screen)
    {
        boolean valid2;
        Double Deposites;

        int MinimumValue =0;

        if(screen=="deposite")
        {
           MinimumValue =500;
        }
        else if(screen =="create new account")
        {
           MinimumValue =5000;
        }

        
                do
                   {

                    valid2=true ;
                    System.out.print("Enter Initial Deposite : ") ;
                    Deposites =scanner.nextDouble();
                    scanner.nextLine();

                        if(Deposites<MinimumValue)
                        {
                            System.out.printf("%sInsufficient balance%s\n",COLOR_RED_BOLD,RESET);
                            valid2 =false;

                        }
                   } 

                while(!valid2);

        return Deposites;
    }

    public static Double FindAccountbalance(String AccountNumber, String[][] CustomerDetails)
    {

        int index=0 ;
        for (int i=0;i<CustomerDetails.length;i++)
        {
            
            if(CustomerDetails[i][1].equals(AccountNumber))
            {
                
                index=i;
                break;
            }
        }

        

        return  Double.valueOf(CustomerDetails[index][2]) ;
       
    }

    public static int FindIndexNumber(String AccountNumber, String[][] CustomerDetails)
    {
         int index=0 ;
        for (int i=0;i<CustomerDetails.length;i++)
        {
            
            if(CustomerDetails[i][1].equals(AccountNumber))
            {
                
                index=i;
                break;
            }
        }

        return index ;


    }
    


}

