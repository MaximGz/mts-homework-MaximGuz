package AnimalGeneral;

import PetAnimals.*;
import PredatorAnimals.*;

/**
 * Класс-сервис для работы с Animal
 */
public class CreateAnimalService {
    /**
     * Метод для создания 10 рандомных животных
     */
    public void createAnimals() {
        int count = 0;

        while (count < 10) {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = switchAnimal(randomAnimal);

            animal.name = "Animals.Animal" + count;
            animal.breed = "Breed" + count;
            animal.cost = Math.random() * 10000;
            animal.character = "Character" + count;

            System.out.println(animal);
            count++;
        }
    }

    /**
     * Метод для создания рандомного животного
     * @param randomAnimal - экзмепляр животного, представленный в числовом формате
     * @return - новый объект животного
     */
    public AbstractAnimal switchAnimal(int randomAnimal) {
        return switch (randomAnimal) {
            case 0 -> new Dog();
            case 1 -> new Cat();
            case 2 -> new Cow();
            case 3 -> new Wolf();
            case 4 -> new Shark();
            case 5 -> new Lion();
            default -> null;
        };
    }
}
