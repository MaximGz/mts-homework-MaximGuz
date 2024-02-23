
public class CreateAnimalService {
    public void createAnimals() {
        int count = 0;

        while (count < 10) {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = switchAnimal(randomAnimal);

            //Заполняем данные для уникальности животного
            animal.name = "Animal" + count;
            animal.breed = "Breed" + count;
            animal.cost = Math.random() * 10000;
            animal.character = "Character" + count;

            //Выводим данные животного
            System.out.println(animal.getClass().getSimpleName() + ": " + animal.getName() + ", " + animal.getBreed() + ", " + animal.getCharacter() + ", " + String.format("%.2f",animal.getCost()));
            count++;
        }
    }

    //Вынес создание рандомного животного в отдельный метод
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
