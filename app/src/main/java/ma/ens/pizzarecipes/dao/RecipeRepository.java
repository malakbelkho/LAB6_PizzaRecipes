package ma.ens.pizzarecipes.dao;

import java.util.List;

public interface RecipeRepository<T> {

    T add(T item);

    T edit(T item);

    boolean remove(long code);

    T getByCode(long code);

    List<T> getAll();
}