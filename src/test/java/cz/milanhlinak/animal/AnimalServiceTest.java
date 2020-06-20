package cz.milanhlinak.animal;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cz.milanhlinak.Module;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;

public class AnimalServiceTest {

    private final AnimalProvider animalService;

    public AnimalServiceTest() {
        Injector injector = Guice.createInjector(new Module());
        animalService = injector.getInstance(AnimalProvider.class);
    }

    @Test
    public void test() {

        Set<Animal> animals = animalService.getAnimals();
        Assert.assertEquals(2, animals.size());

        Set<Animal> cats = animals.stream().filter(animal -> animal instanceof Cat).collect(Collectors.toSet());
        Assert.assertEquals(1, cats.size());

        Set<Animal> dogs = animals.stream().filter(animal -> animal instanceof Dog).collect(Collectors.toSet());
        Assert.assertEquals(1, dogs.size());
    }
}
