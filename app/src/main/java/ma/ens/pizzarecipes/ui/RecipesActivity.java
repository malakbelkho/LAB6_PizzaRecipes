package ma.ens.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import ma.ens.pizzarecipes.R;
import ma.ens.pizzarecipes.adapter.RecipeListAdapter;
import ma.ens.pizzarecipes.classes.PizzaRecipe;
import ma.ens.pizzarecipes.service.PizzaCatalog;

import java.util.List;

public class RecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_recipes);

        ListView recipeListView = findViewById(R.id.lvRecipes);

        List<PizzaRecipe> recipes = PizzaCatalog.getCatalog().getAll();

        RecipeListAdapter adapter = new RecipeListAdapter(this, recipes);
        recipeListView.setAdapter(adapter);

        recipeListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent detailsIntent = new Intent(RecipesActivity.this, RecipeDetailsActivity.class);
            detailsIntent.putExtra("selected_recipe_code", id);
            startActivity(detailsIntent);
        });
    }
}
