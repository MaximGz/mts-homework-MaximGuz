package AnimalGeneral;

/**
 * Класс-сервис, наследуемый от CreateAnimalService
 */
public class CreateAnimalServiceImpl extends CreateAnimalService {
    /**
     * Переопределенный метод класса
     * @see CreateAnimalService
     * для создания N животных, используя цикл for
     * @param n - количество животных
     */
    public void createAnimals(int n) {
        for (int i = 0; i < n; i++) {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = switchAnimal(randomAnimal);

            animal.name = "Animals.Animal" + i;
            animal.breed = "Breed" + i;
            animal.character = "Character" + i;
            animal.cost = Math.random() * 10000;
            animal.birthDate = generateRandomDate();

            System.out.println(animal);
        }
    }

    /**
     * Переопределенный метод класса
     * @see CreateAnimalService
     * для создания 10 животных, используя цикл do-while
     */
    @Override
    public void createAnimals() {
        int count = 0;

        do {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = switchAnimal(randomAnimal);

            animal.name = "Animals.Animal" + count;
            animal.breed = "Breed" + count;
            animal.character = "Character" + count;
            animal.cost = Math.random() * 10000;
            animal.birthDate = generateRandomDate();

            System.out.println(animal);
            count++;
        } while (count < 10);
    }
}
