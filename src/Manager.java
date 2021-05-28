public class Manager {
    private String name = "Cheffy";
    private Zoo zoo;

    public Manager(Zoo zoo){
        this.zoo = zoo;
    }

    public void hireEmployee(Employee employee){
        zoo.getEmployees().put(employee.getEmployeeId(), employee);
        System.out.println("employee " + employee.getName() + " hired, see if he does a good job");
    }

    public String getName() {
        return name;
    }

    public void addAnimal(Animal animal){
        Animal panther = new Animal("Pinky", "Panther", 5, 7, 9, 10000, zoo);
    }

}
