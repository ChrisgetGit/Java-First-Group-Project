import java.util.*;
import java.util.Scanner;

public class Employee {
    private String name;
    final int employeeId;
    private static int tempId = 2000000;
    private String email;
    private String password;
    private Zoo zoo;

    public Employee(String name, Zoo zoo) {
        this.name = name;
        this.employeeId = tempId;
        this.email = Integer.toString(tempId) + "@gmail.com";
        this.password = name + Integer.toString(tempId);
        tempId++;
        this.zoo = zoo;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void feedAnimal(Animal animal) {
        animal.feedAnimal();
    }

    public void medicateAnimal(Animal animal) {
        animal.medicateAnimal();
        Random rand = new Random();
        int n = rand.nextInt(100);
        if (animal.isSick() && n<20){
            animal.setSick(false);
        }
        System.out.println(animal.getSpecies() + " with ID: " + animal.getAnimalId() + " received medication\n animal sick after medication: " + animal.isSick());
    }

    public void entertainAnimal(Animal animal) {
        animal.entertainAnimal();
    }

    public void checkAnimal(Animal animal) {
        Random rand = new Random();
        int n = rand.nextInt(100);
        if (!animal.isSick() && n < 20) {
            animal.setSick(true);
            animal.setSickTimes(animal.getSickTimes() + 1);
        }
        System.out.println("The animal is sick: " + animal.isSick());
        if (animal.isSick()) {
            System.out.println("Do you want to send this sick animal to the vet? YES/NO");
            Scanner scan = new Scanner(System.in);
            String yesNo = scan.nextLine();
            switch (yesNo) {
                case "YES":
                    sendToVet(animal);
                    System.out.println("The " + animal.getSpecies() + " with ID " + animal.getAnimalId() + " sent to the vet!");
                    break;
                case "NO":
                    System.out.println("Really , let it rot the poor thing???");
                    break;
                default:
                    System.out.println("Is it so hard to type YES or NO??");
                    break;
            }

        }
    }
           public void checkSickAnimal(Animal animal){
               Random rand2 = new Random();
               int n2 = rand2.nextInt(100);
               if (!animal.isSick() && n2 < 20) {
                   animal.setSick(true);
                   animal.setSickTimes(animal.getSickTimes()+1);
                   animal.setSickTimesTotal(animal.getSickTimesTotal()+1);
               }

       }


    public void sendToVet(Animal animal) {
        zoo.getVet().callVet(animal);
    }

    @Override
    public String toString() {
        System.out.println("--------------------------------------------------------------");
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        String template = "  %5s    |%10s    | %13s   |%13s  |";

        formatter.format(template, employeeId, name, email, password);

        formatter.close();
        return stringBuilder.toString();
    }
}