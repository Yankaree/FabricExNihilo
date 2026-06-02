package ngcsonsplash.fabricaeexnihilo.datagen.builder.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.data.server.recipe.RecipeExporter;
import ngcsonsplash.fabricaeexnihilo.recipe.tool.ToolRecipe;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;

public class ToolRecipeJsonBuilder {
    private final Item output;
    private final Ingredient input;

    public ToolRecipeJsonBuilder(Item output, Ingredient input) {
        this.output = output;
        this.input = input;
    }

    public void offerTo(RecipeExporter exporter) {
        offerTo(exporter, "tool_recipe");
    }

    public void offerTo(RecipeExporter exporter, String recipePath) {
        offerTo(exporter, Identifier.of(recipePath));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        exporter.accept(recipeId, new ToolRecipe(output, input), null);
    }
}
