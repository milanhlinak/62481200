package cz.milanhlinak.animal;

import com.google.inject.Inject;

import java.util.Set;

public class AnimalProviderImpl implements AnimalProvider {

    private final Set<Animal> animals;

    @Inject
    public AnimalProviderImpl(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public Set<Animal> getAnimals() {
        return this.animals;
    }
}
