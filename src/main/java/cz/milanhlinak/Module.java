package cz.milanhlinak;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import cz.milanhlinak.animal.Animal;
import cz.milanhlinak.animal.AnimalProvider;
import cz.milanhlinak.animal.AnimalProviderImpl;
import org.reflections.Reflections;

import java.util.Set;

public class Module extends AbstractModule {

    @Override
    protected void configure() {

        Reflections reflections = new Reflections("cz.milanhlinak.animal");
        Set<Class<? extends Animal>> animals = reflections.getSubTypesOf(Animal.class);

        Multibinder<Animal> animalBinder = Multibinder.newSetBinder(binder(), Animal.class);
        animals.forEach(animal -> animalBinder.addBinding().to(animal));

        bind(AnimalProvider.class).to(AnimalProviderImpl.class).in(Singleton.class);
    }
}