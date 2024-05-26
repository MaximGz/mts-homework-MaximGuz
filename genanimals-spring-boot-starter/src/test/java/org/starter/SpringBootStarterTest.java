package org.starter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.starter.service.CreateAnimalService;
import org.starter.service.NamesListService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@Import({ConfigClass.class, TestConfig.class})
public class SpringBootStarterTest {
    @Autowired
    CreateAnimalService createAnimalService;
    @Autowired
    @Qualifier("namesListServiceTest")
    NamesListService namesListService;

    @DisplayName("Проверка на соответствие имени животного со списком имен его класса")
    @Test
    public void checkAnimalsNamesInList() {
        Map<String, List<Animal>> animals = createAnimalService.createAnimals(10000);

        for (String key : animals.keySet()) {
            for(Animal a : animals.get(key)) {;
                String simpleClass = a.getClass().getSimpleName();
                String name = a.getName();
                switch (simpleClass) {
                    case "Cat":
                        assertTrue(namesListService.getCatNames().contains(name));
                        break;
                    case "Dog":
                        assertTrue(namesListService.getDogNames().contains(name));
                        break;
                    case "Cow":
                        assertTrue(namesListService.getCowNames().contains(name));
                        break;
                    case "Wolf":
                        assertTrue(namesListService.getWolfNames().contains(name));
                        break;
                    case "Lion":
                        assertTrue(namesListService.getLionNames().contains(name));
                        break;
                    case "Shark":
                        assertTrue(namesListService.getSharkNames().contains(name));
                        break;
                }
            }
        }
    }
    @DisplayName("Проверка на количество созданных животных")
    @Test
    public void checkAnimalsCountInService() {
        Map<String, List<Animal>> animalsWithoutParams = createAnimalService.createAnimals();

        int countAnimalsWithoutParams = 0;
        for (String key : animalsWithoutParams.keySet()) {
            countAnimalsWithoutParams += animalsWithoutParams.get(key).size();
        }

        assertEquals(countAnimalsWithoutParams, 10);

        Map<String, List<Animal>> animalsWithParams = createAnimalService.createAnimals(27);

        int countAnimalsWithParams = 0;
        for (String key : animalsWithParams.keySet()) {
            countAnimalsWithParams += animalsWithParams.get(key).size();
        }

        assertEquals(countAnimalsWithParams, 27);
    }

    @DisplayName("Проверка полученных имен из application-test")
    @Test
    public void positiveCheckNamesListService() {
        assertEquals(namesListService.getCatNames().size(), 4);
        assertEquals(namesListService.getCatNames().get(0), "Barsik");
        assertEquals(namesListService.getCatNames().get(3), "Matroskin");
    }
    @Autowired
    ApplicationContext ctx;

    @Test
    @DisplayName("Проверка, что в списке бинов есть namesListServiceTest из TestConfig")
    public void existsNamesListServiceTest() {
        String[] beanNames = ctx.getBeanDefinitionNames();
        boolean exists = false;
        for (String beanName : beanNames) {
            if(beanName.equals("namesListServiceTest")) {
                exists = true;
            }
        }
        assertTrue(exists);
    }
}
