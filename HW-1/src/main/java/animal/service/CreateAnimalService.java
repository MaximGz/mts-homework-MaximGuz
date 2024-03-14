package animal.service;

import animal.AbstractAnimal;
import custexceptions.InvalidAnimalBirthDateException;

public interface CreateAnimalService {
    /**
     * Дефолт метод по созданию 10 животных
     */
    default void create10Animals() throws InvalidAnimalBirthDateException {
        int count = 0;
        SearchServiceImpl ssi = new SearchServiceImpl();
        while (count < 10) {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = HelperService.switchAnimal(randomAnimal);

            //реализовал логику через сеттеры, т.к. раскидал все классы по пакетам и теперь из этого класса
            //нет доступа к protected переменным
            animal.setName("Animals.Animal" + count);
            animal.setBreed("Breed" + count);
            animal.setCost(Math.random() * 10000);
            animal.setCharacter("Character" + count);
            animal.setBirthDate(HelperService.generateRandomDate());

            System.out.println(animal);

            ssi.checkLeapYearAnimal(animal);

            count++;
        }
    }

    void createAnimals();
}
