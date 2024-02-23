public class Main {
    public static void main(String[] args) {
        CreateAnimalService createAnimalService = new CreateAnimalService();
        System.out.println("\nWhile cycle:");
        createAnimalService.createAnimals();

        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        System.out.println("\nFor cycle:");
        createAnimalServiceImpl.createAnimals(10);
        System.out.println("\nDo-While cycle:");
        createAnimalServiceImpl.createAnimals();
    }
}
