package ngcsonsplash.fabricaeexnihilo.datagen.builder.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.data.server.recipe.RecipeExporter;
import ngcsonsplash.fabricaeexnihilo.recipe.witchwater.WitchWaterEntityRecipe;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;

public class WitchWaterEntityRecipeJsonBuilder {
    private final EntityType<?> entity;
    private final Item output;

    public WitchWaterEntityRecipeJsonBuilder(EntityType<?> entity, Item output) {
        this.entity = entity;
        this.output = output;
    }

    public void offerTo(RecipeExporter exporter) {
        offerTo(exporter, "witchwater_entity_recipe");
    }

    public void offerTo(RecipeExporter exporter, String recipePath) {
        offerTo(exporter, Identifier.of(recipePath));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        exporter.accept(recipeId, new WitchWaterEntityRecipe(entity, output), null);
    }
}
