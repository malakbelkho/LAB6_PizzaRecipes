package ma.ens.pizzarecipes.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ma.ens.pizzarecipes.R;
import ma.ens.pizzarecipes.classes.PizzaRecipe;

import java.util.List;

public class RecipeListAdapter extends BaseAdapter {

    private final Context context;
    private final List<PizzaRecipe> recipeList;

    public RecipeListAdapter(Context context, List<PizzaRecipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
    }

    @Override
    public int getCount() {
        return recipeList.size();
    }

    @Override
    public Object getItem(int position) {
        return recipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return recipeList.get(position).getCode();
    }

    @Override
    public View getView(int position, View rowView, ViewGroup parent) {
        if (rowView == null) {
            rowView = LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false);
        }

        ImageView image = rowView.findViewById(R.id.imgRecipe);
        TextView title = rowView.findViewById(R.id.tvTitle);
        TextView time = rowView.findViewById(R.id.tvTime);
        TextView price = rowView.findViewById(R.id.tvPrice);

        PizzaRecipe recipe = recipeList.get(position);

        image.setImageResource(recipe.getPicture());
        title.setText(recipe.getTitle());
        time.setText("⏱ " + recipe.getCookingTime());
        price.setText("💰 " + recipe.getPrice() + " €");

        return rowView;
    }
}
