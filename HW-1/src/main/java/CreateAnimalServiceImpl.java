public class CreateAnimalServiceImpl extends CreateAnimalService{
    //Перегруженный метод с циклом for
    public void createAnimals(int n) {
        for (int i = 0; i < n; i++) {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = switchAnimal(randomAnimal);

            animal.name = "Animal" + i;
            animal.breed = "Breed" + i;
            animal.character = "Character" + i;
            animal.cost = Math.random() * 10000;

            System.out.println(animal.getClass().getSimpleName() + ": " + animal.getName() + ", " + animal.getBreed() + ", " + animal.getCharacter() + ", " + String.format("%.2f",animal.getCost()));
        }
    }
    //Переопределенный метод с циклом do-while
    @Override
    public void createAnimals() {
        int count = 0;

        do {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = switchAnimal(randomAnimal);

            animal.name = "Animal" + count;
            animal.breed = "Breed" + count;
            animal.character = "Character" + count;
            animal.cost = Math.random() * 10000;

            System.out.println(animal.getClass().getSimpleName() + ": " + animal.getName() + ", " + animal.getBreed() + ", " + animal.getCharacter() + ", " + String.format("%.2f",animal.getCost()));
            count++;
        } while (count < 10);
    }
}
