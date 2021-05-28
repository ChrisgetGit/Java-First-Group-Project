import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        System.out.println(zoo.getName());
        new Animal("Pinky", "Panther", 5, 7, 9, 10000, zoo);
        new Animal("Pandy", "Panda", 6, 3, 15, 5000, zoo);
        new Animal("Koaly", "Koala", 3, 2, 7, 7500, zoo);
        new Animal("King-Kong", "Gorilla", 7, 10, 5, 6000, zoo);
        new Animal("Pingu", "Penguin", 3, 7, 2, 1000, zoo);
        new Animal("Flippy", "Dolphin", 5, 4, 10, 12000, zoo);
        new Animal("Simba", "Lion", 8, 2, 8, 13000, zoo);
        new Animal("Blacky", "Panther", zoo);
        new Animal("Whitey", "Panther", zoo);
        new Animal("Bluey", "Panther", zoo);
        new Animal("Kung-Fu", "Panda", zoo);
        new Animal("Bamboo", "Panda", zoo);
        new Animal("Clammy", "Koala", zoo);
        new Animal("Pinguy", "Penguin", zoo);
        new Animal("Dolphino", "Dolphin", zoo);
        new Animal("Jumpy", "Dolphin", zoo);
        zoo.getManager().hireEmployee(new Employee("Peter", zoo));
        zoo.getManager().hireEmployee(new Employee("Irati", zoo));
        zoo.getManager().hireEmployee(new Employee("Chris", zoo));
        zoo.getManager().hireEmployee(new Employee("Andrey", zoo));
        /*for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000001).checkSickAnimal(animal);
            if (animal.isSick()){
                zoo.getEmployees().get(2000001).sendToVet(animal);
            }
        }*/
        for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000001).checkSickAnimal(animal);
        }
        for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000001).checkSickAnimal(animal);
        }
        for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000001).checkSickAnimal(animal);
        }


        for(String species : zoo.getAnimalSpecies().keySet()) {
            for (Animal animal : zoo.getAnimalSpecies().get(species)) {
                if (animal.isSick()){
                    zoo.getEmployees().get(2000000).sendToVet(animal);
                }
            }
        }



        for(String species : zoo.getAnimalSpecies().keySet()) {
            for (Animal animal : zoo.getAnimalSpecies().get(species)) {
                if (zoo.getVet().getAnimalsCare().containsKey(animal.getAnimalId())) {
                    zoo.getVet().healAnimal(animal);
                }
            }
        }




        for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000000).checkSickAnimal(animal);
        }
        for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000000).checkSickAnimal(animal);
        }
        for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000000).checkSickAnimal(animal);
        }

        for(String species : zoo.getAnimalSpecies().keySet()) {
            for (Animal animal : zoo.getAnimalSpecies().get(species)) {
                if (animal.isSick()){
                    zoo.getEmployees().get(2000001).sendToVet(animal);
                }
            }
        }

        for(String species : zoo.getAnimalSpecies().keySet()) {
            for (Animal animal : zoo.getAnimalSpecies().get(species)) {
                if (zoo.getVet().getAnimalsCare().containsKey(animal.getAnimalId())) {
                    zoo.getVet().healAnimal(animal);
                }
            }
        }


        for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000002).checkSickAnimal(animal);
        }
        for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000002).checkSickAnimal(animal);
        }
        for (Animal animal: zoo.getAnimals().values()){
            zoo.getEmployees().get(2000002).checkSickAnimal(animal);
        }

        if (zoo.getAnimals().get(100000002).isSick()){
            zoo.getEmployees().get(2000002).sendToVet(zoo.getAnimals().get(100000002));
        }
        if (zoo.getAnimals().get(100000005).isSick()){
            zoo.getEmployees().get(2000002).sendToVet(zoo.getAnimals().get(100000005));
        }
        if (zoo.getAnimals().get(100000008).isSick()){
            zoo.getEmployees().get(2000002).sendToVet(zoo.getAnimals().get(100000008));
        }
        if (zoo.getAnimals().get(100000011).isSick()){
            zoo.getEmployees().get(2000002).sendToVet(zoo.getAnimals().get(100000011));
        }
        if (zoo.getAnimals().get(100000014).isSick()){
            zoo.getEmployees().get(2000002).sendToVet(zoo.getAnimals().get(100000014));
        }

        zoo.printAllEmployees();
        zoo.getStock();
        zoo.calcProfitPerAnimal();

        UserInterface userInterface = new UserInterface(zoo);



    }
}
