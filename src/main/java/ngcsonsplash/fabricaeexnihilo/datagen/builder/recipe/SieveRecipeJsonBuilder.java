package ngcsonsplash.fabricaeexnihilo.datagen.builder.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.data.server.recipe.RecipeExporter;
import ngcsonsplash.fabricaeexnihilo.recipe.sieve.SieveRecipe;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;

public class SieveRecipeJsonBuilder {
    private final Item output;
    private final Ingredient input;
    private double chance = 0.5;

    public SieveRecipeJsonBuilder(Item output, Ingredient input) {
        this.output = output;
        this.input = input;
    }

    public SieveRecipeJsonBuilder chance(double chance) {
        this.chance = chance;
        return this;
    }

    public void offerTo(RecipeExporter exporter) {
        offerTo(exporter, "sieve_recipe");
    }

    public void offerTo(RecipeExporter exporter, String recipePath) {
        offerTo(exporter, Identifier.of(recipePath));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        exporter.accept(recipeId, new SieveRecipe(output, input, chance), null);
    }
}
