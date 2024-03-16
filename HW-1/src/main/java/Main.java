import animal.service.CreateAnimalService;
import animal.service.CreateAnimalServiceImpl;
import custexceptions.InvalidAnimalBirthDateException;

/**
 * Главный класс с вызовом метода main
 */
public class Main {
    /**
     * Точка старта приложения
     * @param args - входящие параметры
     */
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();

        System.out.println("\nWhile cycle:");
        try {
            createAnimalServiceImpl.createAnimalsfromInterface();
        } catch (InvalidAnimalBirthDateException e) {
            throw new RuntimeException("Работа метода завершилась ошибкой\n" + e);
        }
        System.out.println("\nFor cycle:");
        createAnimalServiceImpl.createAnimals(10);
        System.out.println("\nDo-While cycle:");
        createAnimalServiceImpl.createAnimals();
    }
}
