package ma.ens.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ma.ens.pizzarecipes.R;
import ma.ens.pizzarecipes.classes.PizzaRecipe;
import ma.ens.pizzarecipes.service.PizzaCatalog;

public class RecipeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        long code = getIntent().getLongExtra("selected_recipe_code", -1);

        PizzaRecipe recipe = PizzaCatalog.getCatalog().getByCode(code);

        ImageView img = findViewById(R.id.imgDetail);
        TextView title = findViewById(R.id.titleDetail);
        TextView meta = findViewById(R.id.metaDetail);
        TextView ingredients = findViewById(R.id.ingredientsDetail);
        TextView desc = findViewById(R.id.descDetail);
        TextView steps = findViewById(R.id.stepsDetail);

        if (recipe != null) {
            img.setImageResource(recipe.getPicture());
            title.setText(recipe.getTitle());
            meta.setText(recipe.getCookingTime() + " • " + recipe.getPrice() + " €");
            ingredients.setText(recipe.getIngredients());
            desc.setText(recipe.getDescription());
            steps.setText(recipe.getPreparation());
        } else {
            title.setText("Recipe not found");
        }
    }
}
