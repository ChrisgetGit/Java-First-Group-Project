import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    String line = "-=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=-";
    private static Scanner scan = new Scanner(System.in);
    private Zoo zoo;

    public UserInterface(Zoo zoo) {
        programRoot(zoo);
    }

    public void programRoot(Zoo zoo) {
        System.out.println("WELCOME:\nPlease Login To The System:\n" + line + "\n| 1. Manager Login | 2. Employee Login | 3. Vet Login |\n" + line);
        int enteredCommand = scan.nextInt();
        this.zoo = zoo;
        switch (enteredCommand) {
            case 1:
                managerInterface();
                break;

            case 2:
                employeeInterface();
                break;
            case 3:
                vetInterface();
                break;
            default:
                System.out.println("Is it so hard to enter 1, 2 or 3???");
                break;
        }
    }

    String password = "";

    public void vetInterface() {
        clearConsole();
        if (password.equals("")) {
            System.out.println("Please enter Vets Password");
            scan = new Scanner(System.in);
            password = scan.nextLine();
            if (!password.equals("Password")) {
                System.out.println("Wrong Password, try again");
                password = "";
                vetInterface();
            } else {
                System.out.println("Logged in successfully");
            }
        }

        String vetMenu = line + "\n|  1. Heal Animal | 0. Log Out  |\n" + line;
        System.out.println(vetMenu);

        scan = new Scanner(System.in);
        int vetsChoice = scan.nextInt();

        switch (vetsChoice) {
            case 1:
                System.out.println("Which animal are you applying treatment to? Please select the ID");
                zoo.getVet().printAllAnimalsInTheVet();
                scan = new Scanner(System.in);
                int animalID = scan.nextInt();
                if (zoo.getVet().getAnimalsCare().containsKey(animalID)) {
                    zoo.getVet().healAnimal(zoo.getVet().getAnimalsCare().get(animalID));
                    vetInterface();
                } else {
                    System.out.println("Animal not found in the Vet, please try again");
                    vetInterface();
                }
                break;
            case 0:
                clearConsole();
                System.out.println("Thank you for using ZOO-Management-System");
                password = "";
                programRoot(zoo);
                break;

        }


    }


    public void employeeInterface() {
        int employeeLogged = 0;

        clearConsole();

        System.out.println("Enter your email");
        scan = new Scanner(System.in);
        String eMail = scan.nextLine();
        boolean loggedIn = true;
        for (Employee employee : zoo.getEmployees().values()) {
            if (employee.getEmail().equals(eMail)) {
                System.out.println("Enter your password Mr." + employee.getName());
                scan = new Scanner(System.in);
                String password = scan.nextLine();
                if (employee.getPassword().equals(password)) {
                    System.out.println("Logged in successfully");
                    employeeLogged = employee.getEmployeeId();
                    loggedIn = false;
                } else {
                    System.out.println("Password doesn't match for the email provided, try again");
                    employeeInterface();
                }
            }
        }
        if (loggedIn) {
            System.out.println("Try again, invalid data");
            employeeInterface();
        }

        boolean goOn = true;
        String menu = "0. Log Out\n 1. Medicate animal\n 2. Check Animal\n 3. Entertain Animal\n 4. Check Tasks Waiting To Be Done";
        String writeReport = " 1. Is Animal Sick? \n";
        String isSick = " 1. Animal Is Sick \n 2. Animal Is Not Sick";
        String sendToVet = " 1. Send To Vet \n Don't Send To Vet";

        int userInput = 0;
        while (goOn) {
            clearConsole();
            System.out.println("Employee HOME\n" + menu);
            scan = new Scanner(System.in);
            int userChoice = scan.nextInt();
            switch (userChoice) {
                case 0:
                    clearConsole();
                    System.out.println("Thank you for using ZOO-Management-System");
                    programRoot(zoo);
                    break;

                case 1:
                    System.out.println("Which animal are you medicating: enter ID pls");
                    zoo.printAllAnimals();
                    scan = new Scanner(System.in);
                    int animalID = scan.nextInt();
                    zoo.getEmployees().get(employeeLogged).medicateAnimal(zoo.getAnimals().get(animalID));
                case 2:
                    System.out.println("Which animal do you want to check?: enter ID pls");
                    zoo.printAllAnimals();
                    scan = new Scanner(System.in);
                    animalID = scan.nextInt();
                    zoo.getEmployees().get(employeeLogged).checkAnimal(zoo.getAnimals().get(animalID));
            }

        }

    }


    public void managerInterface() {
        clearConsole();
        /*System.out.println("Please enter Management Password");
        scan = new Scanner(System.in);
        String password = scan.nextLine();
        if (!password.equals("Password")) {
            System.out.println("Wrong Password, try again");
            managerInterface();
        } else {
            System.out.println("Logged in successfully");
        }*/

        boolean goOn = true;
        System.out.printf("\n WELCOME TO THE ZOO MANAGEMENT SYSTEM");
        String menu = "\n 1. Get Report\n 2. Employee Management \n 3. Animal Management \n 0. Log out";
        String reportMenu = " 0. GO BACK\n 1. Animal Report \n 2. Employee Report \n 3. Stock Report \n 4. Financial Report";
        String financialReport = " 0. GO BACK\n 1. Visitor Income \n 2. Food Expenses \n 3. Medicine Expenses \n 4. Salary Expenses \n 5. Vet Expenses \n 6. New Animal Expenses \n 7. Animal Profits \n 8. Total Profit/Loss";
        String animalReport = " 0. GO BACK\n 1. Number in Total\n 2. Number per Species\n 3. See all animals in the vet\n 4. Animals Sick in Total now\n 5. Animals Sick per Species now\n 6. Total Animals Sick in History\n 7. Total Vet calls and per Species";
        String stockReport = " 0. GO BACK\n 1. Medicine \n 2. Food";
        String employeeManagement = " 0. GO BACK\n 1. Add employee (login) \n 2. Fire employee\n 3. Check all employees";
        String animalManagement = " 0. GO BACK\n 1. Add Animal(New Or Old) ";
        String makeOrder = " 0. GO BACK\n 1. Food \n 2. Medicine";
        boolean letItPass = false;
        int userInput = 0;
        String message = "";


        while (goOn) {

            clearConsole();
            System.out.println(message + "\n");
            message = "";
            System.out.println("MANAGER HOME\n" + menu);
            if (!letItPass) {
                userInput = scan.nextInt();
            }


            switch (userInput) {

                case 0:

                    clearConsole();
                    System.out.println("Thank you for using ZOO-Management-System");
                    programRoot(zoo);
                    break;

                case 1:
                    clearConsole();
                    System.out.println(reportMenu);
                    int userInput2 = scan.nextInt();

                    switch (userInput2) {

                        case 0:
                            break;

                        case 4:
                            clearConsole();
                            System.out.println(financialReport);
                            int userFinRepChoice = scan.nextInt();
                            switch (userFinRepChoice) {
                                case 0:
                                    break;

                                case 1:
//                                    boolean enterPressed = pressEnterToContinue();
//                                    if(enterPressed){
                                    message = "Visitor Income: ";

                                    break;
//                                    }
                                case 2:
                                    message = "Food Expenses: ";
                                    break;
                                case 3:
                                    message = "Medicine Expenses: ";
                                    break;
                                case 4:
                                    message = "Salary Expenses: ";
                                    break;
                                case 5:
                                    message = "Vet Expenses: ";
                                    break;
                                case 6:
                                    message = "New Animal Expenses: ";
                                    break;
                                case 7:
                                    message = "Animal Profits: ";
                                    zoo.calcProfitPerAnimal();
                                    break;
                                case 8:
                                    message = "Total Profits: ";
                                    break;
                                default:
                                    message = "command not found";
                                    break;
                            }
                            break;
                        case 1:
                            clearConsole();
                            System.out.println(animalReport);
                            int animalReportInterface = scan.nextInt();
                            switch (animalReportInterface) {
                                case 0:
                                    letItPass = true;
                                    break;
                                case 1:
                                    zoo.printAllAnimals();
                                    break;
                                case 2:
                                    zoo.printAllAnimalsSpecies();
                                    break;
                                case 3:
                                    zoo.getVet().printAllAnimalsInTheVet();
                                    break;
                                case 4:
                                    zoo.printSickAnimals();
                                    break;
                                case 5:
                                    zoo.printSickAnimalsSpecies();
                                    break;
                                case 6:
                                    zoo.printSickAnimalsHistory();
                                    break;
                                case 7:
                                    zoo.printVetCalls();
                                    break;

                                default:
                                    message = "command not found";
                                    break;
                            }
                            break;
                        case 2:
                            clearConsole();
                            message = "Employee Report: ";
                            zoo.printAllEmployees();
                            break;
                        case 3:
                            clearConsole();
                            System.out.println(stockReport);
                            int stockReportInterface = scan.nextInt();
                            switch (stockReportInterface) {
                                case 1:
                                    System.out.println("Medicine: "+zoo.getStock().get("AmountMeds"));
                                    break;
                                case 2:
                                    System.out.println("Food: "+ zoo.getStock().get("AmountFood"));
                                    break;
                                default:
                                    message = "command not found";
                                    break;
                            }
                            break;
                        default:
                            clearConsole();
                            message = "Command not found Irati";
                            break;
                    }
                    break;
                case 2:
                    clearConsole();
                    System.out.println(employeeManagement);
                    int userInput3 = scan.nextInt();
                    switch (userInput3) {
                        case 0:
                            break;
                        case 1:
                            System.out.println(" Add Employee: ");
                            zoo.addEmployee();
                            break;
                        case 2:
                            System.out.println(" Fire Employee: ");
                            zoo.removeEmployee();
                            break;
                        case 3:
                            System.out.println(" Check All Employees: ");
                            zoo.printAllEmployees();
                            break;

                    }
                    break;
                case 3:
                    clearConsole();
                    System.out.println("Animal Management");
                    System.out.println(animalManagement);
                    int animalUserInput = scan.nextInt();
                    switch (animalUserInput) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Add Animal: ");
                            zoo.addAnimal();

                            break;
                        /*case 2:
                            System.out.println("Sell Animal");
                            zoo.removeAnimal();
                            break;*/
                        default:
                            System.out.println("command not found");
                            break;
                    }
                    break;
                case 4:
                    clearConsole();
                    System.out.println(makeOrder);
                    int orderUserInput = scan.nextInt();
                    switch (orderUserInput) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Order Food: ");
                            break;
                        case 2:
                            System.out.println("Order Medicine: ");
                            break;
                        default:
                            message = "command not found";
                            break;

                    }
                    break;
            }
        }
    }


    public void clearConsole() {
        try {
            CLS.main();
            System.out.println(zoo.theString);
            zoo.theString = "";
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
/*
public boolean pressEnterToContinue(){
        String pressedEnter = scan.nextLine();
    return pressedEnter.equals("");
}

}
  Financial Reports (visitor
                               income, food expenses,
                       medicine expenses, salary
                               expenses, vet expenses, new
                       animal expenses, old animal
              sell - total profit


 */