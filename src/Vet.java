import java.util.*;

public class Vet {
    private HashMap <Integer, Animal> animalsCare = new HashMap<>();
    private int numCalls = 0;
    private Zoo zoo;
    public Vet(Zoo zoo){
        this.zoo = zoo;
    }

    public void callVet(Animal animal){
        zoo.getAnimals().remove(animal.getAnimalId());
        animalsCare.put(animal.getAnimalId(), animal);
        zoo.putProfitsPerAnimal(animal.getAnimalId(), animal.getProfit());
        animal.setVetTimes(animal.getVetTimes()+1);
        numCalls++;
    }

    public HashMap<Integer, Animal> getAnimalsCare() {
        return animalsCare;
    }

    public void healAnimal(Animal animal){
        zoo.getAnimals().put(animal.getAnimalId(), animal);
        animalsCare.remove(animal.getAnimalId());
        animal.setSick(false);
        System.out.println("Animal healed");
    }

    public void printAllAnimalsInTheVet(){
        System.out.println("Printing all the animals in the vet");
        System.out.println("Number of animals: " + animalsCare.size());
        for(Animal animal : animalsCare.values()){
            System.out.println(animal.toString());
        }
    }

    public int getNumCalls() {
        return numCalls;
    }
}
