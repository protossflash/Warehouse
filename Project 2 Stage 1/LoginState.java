import java.util.*;
import java.text.*;
import java.io.*;

public class LoginState extends WareState{
    private static final int CLIENT_LOGIN = 0;
    private static final int CLERK_LOGIN = 1;
    private static final int MANAGER_LOGIN = 2;
    private static final int EXIT = 3;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private WareContext context;
    private static LoginState instance;
    private LoginState() {
        super();
        //context = WareContext.instance();
    }

    public static LoginState instance() {
        if (instance == null) {
            instance = new LoginState();
        }
        return instance;
    }

    public int getCommand() {
        do {
            try {
                int value = Integer.parseInt(getToken("Enter command:" ));
                if (value <= EXIT && value >= CLIENT_LOGIN) {
                    return value;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number");
            }
        } while (true);
    }

    public String getToken(String prompt) {
        do {
            try {
                System.out.println(prompt);
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
                if (tokenizer.hasMoreTokens()) {
                    return tokenizer.nextToken();
                }
            } catch (IOException ioe) {
                System.exit(0);
            }
        } while (true);
    }

    private boolean yesOrNo(String prompt) {
        String more = getToken(prompt + " (Y|y)[es] or anything else for no");
        if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
            return false;
        }
        return true;
    }


    private void client(){
            (WareContext.instance()).setLogin(WareContext.IsClient);
            (WareContext.instance()).changeState(0);
    }


    private void clerk(){
        String clerkID = getToken("Please input the clerk id: ");
        if (Warehouse.instance().searchMembership(clerkID) != null){
            (WareContext.instance()).setLogin(WareContext.IsClerk);
            (WareContext.instance()).setClerk(clerkID);
            (WareContext.instance()).changeState(1);
        }
        else
            System.out.println("Invalid clerk id.");
    }


    private void manager(){
        String managerID = getToken("Please input the manager id: ");
        if (Warehouse.instance().searchMembership(managerID) != null){
            (WareContext.instance()).setLogin(WareContext.IsManager);
            (WareContext.instance()).setManager(managerID);
            (WareContext.instance()).changeState(2);
        }
        else
            System.out.println("Invalid user id.");
    }

    public void process() {
        int command;
        System.out.println("Please input 0 to login as Client\n"+
                            "input 1 to login as Clerk\n" +
                            "input 2 to login as Manager\n" +
                            "input 3 to exit the system\n");
        while ((command = getCommand()) != EXIT) {
            switch (command) {
                case CLIENT_LOGIN:
                    client();
                    break;
                case CLERK_LOGIN:
                    clerk();
                    break;
                case MANAGER_LOGIN:
                    manager();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Please input 0 to login as Client\n"+
                    "input 1 to login as Clerk\n" +
                    "input 2 to login as Manager\n" +
                    "input 3 to exit the system\n");
        }
        (WareContext.instance()).changeState(3); // exit
    }

    public void run() { process(); }
}