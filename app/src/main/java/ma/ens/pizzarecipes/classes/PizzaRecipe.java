package ma.ens.pizzarecipes.classes;


public class PizzaRecipe {

    private static long nextCode = 1;

    private long code;
    private String title;
    private double price;
    private int picture;
    private String cookingTime;
    private String ingredients;
    private String description;
    private String preparation;

    public PizzaRecipe() {
        this.code = nextCode++;
    }

    public PizzaRecipe(String title, double price, int picture, String cookingTime,
                       String ingredients, String description, String preparation) {
        this.code = nextCode++;
        this.title = title;
        this.price = price;
        this.picture = picture;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.description = description;
        this.preparation = preparation;
    }

    public long getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getPicture() {
        return picture;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    @Override
    public String toString() {
        return title + " | " + price + " € | " + cookingTime;
    }
}