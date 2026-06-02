package ngcsonsplash.fabricaeexnihilo.datagen.builder.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.data.server.recipe.RecipeExporter;
import ngcsonsplash.fabricaeexnihilo.recipe.barrel.BarrelRecipe;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;

public class BarrelRecipeJsonBuilder {
    private final Item output;
    private final Ingredient input;
    private int time = 200;

    public BarrelRecipeJsonBuilder(Item output, Ingredient input) {
        this.output = output;
        this.input = input;
    }

    public BarrelRecipeJsonBuilder time(int time) {
        this.time = time;
        return this;
    }

    public void offerTo(RecipeExporter exporter) {
        offerTo(exporter, "barrel_recipe");
    }

    public void offerTo(RecipeExporter exporter, String recipePath) {
        offerTo(exporter, Identifier.of(recipePath));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        exporter.accept(recipeId, new BarrelRecipe(output, input, time), null);
    }
}
