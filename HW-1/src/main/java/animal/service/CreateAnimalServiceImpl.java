package animal.service;

import animal.AbstractAnimal;

import static animal.service.HelperService.switchAnimal;

/**
 * Класс-сервис, наследуемый от CreateAnimalService
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {
    /**
     * Перегруженный метод интерфейса для создания N животных, используя цикл for
     *
     * @param n - количество животных
     * @see CreateAnimalService
     */
    public void createAnimals(int n) {
        for (int i = 0; i < n; i++) {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = HelperService.switchAnimal(randomAnimal);

            animal.setName("Animals.Animal" + i);
            animal.setBreed("Breed" + i);
            animal.setCharacter("Character" + i);
            animal.setCost(Math.random() * 10000);
            animal.setBirthDate(HelperService.generateRandomDate());

            System.out.println(animal);
        }
    }

    /**
     * Переопределенный метод интерфейса
     *
     * @see CreateAnimalService
     * для создания 10 животных, используя цикл do-while
     */
    @Override
    public void createAnimals() {
        int count = 0;

        do {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = HelperService.switchAnimal(randomAnimal);

            animal.setName("Animals.Animal" + count);
            animal.setBreed("Breed" + count);
            animal.setCharacter("Character" + count);
            animal.setCost(Math.random() * 10000);
            animal.setBirthDate(HelperService.generateRandomDate());

            System.out.println(animal);
            count++;
        } while (count < 10);
    }
}
