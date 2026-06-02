package ngcsonsplash.fabricaeexnihilo.datagen.builder.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.data.server.recipe.RecipeExporter;
import ngcsonsplash.fabricaeexnihilo.recipe.crucible.CrucibleHeatRecipe;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;

public class CrucibleHeatRecipeJsonBuilder {
    private final Item output;
    private final Ingredient input;
    private int heatTime = 200;

    public CrucibleHeatRecipeJsonBuilder(Item output, Ingredient input) {
        this.output = output;
        this.input = input;
    }

    public CrucibleHeatRecipeJsonBuilder heatTime(int heatTime) {
        this.heatTime = heatTime;
        return this;
    }

    public void offerTo(RecipeExporter exporter) {
        offerTo(exporter, "crucible_heat_recipe");
    }

    public void offerTo(RecipeExporter exporter, String recipePath) {
        offerTo(exporter, Identifier.of(recipePath));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        exporter.accept(recipeId, new CrucibleHeatRecipe(output, input, heatTime), null);
    }
}
