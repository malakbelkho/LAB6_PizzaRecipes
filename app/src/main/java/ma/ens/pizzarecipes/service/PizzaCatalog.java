package ma.ens.pizzarecipes.service;

import ma.ens.pizzarecipes.R;
import ma.ens.pizzarecipes.classes.PizzaRecipe;
import ma.ens.pizzarecipes.dao.RecipeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PizzaCatalog implements RecipeRepository<PizzaRecipe> {

    private static PizzaCatalog catalog;
    private final List<PizzaRecipe> recipes = new ArrayList<>();

    private PizzaCatalog() {
        loadRecipes();
    }

    public static PizzaCatalog getCatalog() {
        if (catalog == null) {
            catalog = new PizzaCatalog();
        }
        return catalog;
    }

    private void loadRecipes() {
        add(new PizzaRecipe(
                "Barbecue Chicken",
                3,
                R.drawable.pizza1,
                "35 min",
                "- Chicken breast\n- Barbecue sauce\n- Pizza crust\n- Gouda cheese\n- Red onion\n- Fresh cilantro",
                "A smoky and cheesy pizza with grilled chicken and barbecue sauce.",
                "1. Grill the chicken.\n2. Spread barbecue sauce on the crust.\n3. Add cheese, chicken and onion.\n4. Bake until golden."
        ));

        add(new PizzaRecipe(
                "Bruschetta Pizza",
                5,
                R.drawable.pizza2,
                "35 min",
                "- Sausage\n- Pizza crust\n- Pepperoni\n- Mozzarella\n- Tomatoes\n- Basil\n- Olive oil\n- Garlic",
                "A fresh Italian-style pizza full of tomato, basil and melted cheese.",
                "1. Cook the sausage.\n2. Add pepperoni, sausage and cheese on the crust.\n3. Bake for 10 to 12 minutes.\n4. Add tomato and basil mixture."
        ));

        add(new PizzaRecipe(
                "Spinach Alfredo",
                2,
                R.drawable.pizza3,
                "25 min",
                "- Pizza dough\n- Alfredo sauce\n- Tomatoes\n- Fresh spinach\n- Italian cheese",
                "A creamy vegetable pizza with spinach, tomatoes and Alfredo sauce.",
                "1. Prepare the dough.\n2. Spread Alfredo sauce.\n3. Add spinach, tomatoes and cheese.\n4. Bake until the crust is golden."
        ));

        add(new PizzaRecipe(
                "Deep Dish Sausage",
                8,
                R.drawable.pizza4,
                "45 min",
                "- Yeast\n- Flour\n- Vegetable oil\n- Oregano\n- Basil\n- Sausage\n- Mozzarella",
                "A rich deep-dish pizza with herbs, sausage and a thick cheesy filling.",
                "1. Prepare and knead the dough.\n2. Let it rise.\n3. Add sausage, cheese and vegetables.\n4. Bake until the crust is browned."
        ));

        add(new PizzaRecipe(
                "Homemade Classic",
                4,
                R.drawable.pizza5,
                "50 min",
                "- Yeast\n- Sugar\n- Warm water\n- Flour\n- Ground beef\n- Tomato sauce\n- Green pepper\n- Mozzarella",
                "A classic homemade pizza with a crispy crust and hearty topping.",
                "1. Prepare the dough.\n2. Cook beef and onion.\n3. Spread tomato sauce.\n4. Add toppings and bake."
        ));

        add(new PizzaRecipe(
                "Pesto Chicken",
                3,
                R.drawable.pizza6,
                "50 min",
                "- Chicken\n- Bread flour\n- Olive oil\n- Pesto\n- Onion\n- Peppers\n- Mushrooms\n- Mozzarella",
                "A colorful pizza with pesto, chicken and fresh vegetables.",
                "1. Make the dough.\n2. Cook chicken and vegetables.\n3. Spread pesto.\n4. Add toppings and bake."
        ));

        add(new PizzaRecipe(
                "Loaded Mexican",
                3,
                R.drawable.pizza7,
                "30 min",
                "- Black beans\n- Red onion\n- Yellow pepper\n- Chili powder\n- Tomatoes\n- Jalapeno\n- Spinach\n- Cheddar",
                "A spicy Mexican-inspired pizza with beans, vegetables and cheese.",
                "1. Mash the beans.\n2. Mix vegetables and spices.\n3. Spread on the crust.\n4. Add cheese and bake."
        ));

        add(new PizzaRecipe(
                "Bacon Cheeseburger",
                2,
                R.drawable.pizza8,
                "20 min",
                "- Ground beef\n- Onion\n- Pizza sauce\n- Bacon\n- Pickles\n- Mozzarella\n- Cheddar",
                "A fun pizza that mixes cheeseburger flavors with a crispy crust.",
                "1. Cook beef and onion.\n2. Spread pizza sauce.\n3. Add beef, bacon, pickles and cheese.\n4. Bake until melted."
        ));

        add(new PizzaRecipe(
                "Pizza Margherita",
                1,
                R.drawable.pizza9,
                "30 min",
                "- Yeast\n- Warm water\n- Olive oil\n- Flour\n- Tomatoes\n- Mozzarella\n- Basil",
                "A simple Italian classic with tomato, mozzarella and basil.",
                "1. Prepare the dough.\n2. Add tomatoes and mozzarella.\n3. Add basil and seasoning.\n4. Bake until golden."
        ));

        add(new PizzaRecipe(
                "Stuffed Pepperoni",
                5,
                R.drawable.pizza10,
                "45 min",
                "- Yeast\n- Flour\n- Olive oil\n- Sausage\n- Mushrooms\n- Pepperoni\n- Mozzarella\n- Cheddar",
                "A generous stuffed pizza filled with cheese, sausage and pepperoni.",
                "1. Prepare the dough.\n2. Place filling inside the crust.\n3. Seal the pizza.\n4. Bake, then add sauce and finish cooking."
        ));
    }

    @Override
    public PizzaRecipe add(PizzaRecipe item) {
        recipes.add(item);
        return item;
    }

    @Override
    public PizzaRecipe edit(PizzaRecipe item) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getCode() == item.getCode()) {
                recipes.set(i, item);
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean remove(long code) {
        return recipes.removeIf(recipe -> recipe.getCode() == code);
    }

    @Override
    public PizzaRecipe getByCode(long code) {
        for (PizzaRecipe recipe : recipes) {
            if (recipe.getCode() == code) {
                return recipe;
            }
        }
        return null;
    }

    @Override
    public List<PizzaRecipe> getAll() {
        return Collections.unmodifiableList(recipes);
    }
}