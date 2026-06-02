package ngcsonsplash.fabricaeexnihilo.datagen.builder.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.data.server.recipe.RecipeExporter;
import ngcsonsplash.fabricaeexnihilo.recipe.witchwater.WitchWaterWorldRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class WitchWaterWorldRecipeJsonBuilder {
    private final Block block;
    private final Item output;

    public WitchWaterWorldRecipeJsonBuilder(Block block, Item output) {
        this.block = block;
        this.output = output;
    }

    public void offerTo(RecipeExporter exporter) {
        offerTo(exporter, "witchwater_world_recipe");
    }

    public void offerTo(RecipeExporter exporter, String recipePath) {
        offerTo(exporter, Identifier.of(recipePath));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        exporter.accept(recipeId, new WitchWaterWorldRecipe(block, output), null);
    }
}
