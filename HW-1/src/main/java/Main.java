import AnimalGeneral.CreateAnimalService;
import AnimalGeneral.CreateAnimalServiceImpl;
import CustExecptions.InvalidAnimalBirthDateException;

/**
 * Главный класс с вызовом метода main
 */
public class Main {
    /**
     * Точка старта приложения
     * @param args - входящие параметры
     */
    public static void main(String[] args) {
        CreateAnimalService createAnimalService = new CreateAnimalService();
        System.out.println("\nWhile cycle:");
        try {
            createAnimalService.createAnimals();
        } catch (InvalidAnimalBirthDateException e) {
            throw new RuntimeException("Работа метода завершилась ошибкой\n" + e);
        }

        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        System.out.println("\nFor cycle:");
        createAnimalServiceImpl.createAnimals(10);
        System.out.println("\nDo-While cycle:");
        createAnimalServiceImpl.createAnimals();
    }
}
