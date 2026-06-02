package ngcsonsplash.fabricaeexnihilo.datagen.builder.recipe;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import ngcsonsplash.fabricaeexnihilo.recipe.barrel.MilkingRecipe;
import net.minecraft.data.server.recipe.RecipeExporter;

public class MilkingRecipeJsonBuilder {
    private final EntityType<?> entity;
    private final FluidVariant fluid;
    private long amount = 810;
    private int cooldown = 20;

    public MilkingRecipeJsonBuilder(EntityType<?> entity, FluidVariant fluid) {
        this.entity = entity;
        this.fluid = fluid;
    }

    public MilkingRecipeJsonBuilder amount(long amount) {
        this.amount = amount;
        return this;
    }

    public MilkingRecipeJsonBuilder cooldown(int cooldown) {
        this.cooldown = cooldown;
        return this;
    }

    public void offerTo(RecipeExporter exporter) {
        offerTo(exporter, "milking_recipe");
    }

    public void offerTo(RecipeExporter exporter, String recipePath) {
        offerTo(exporter, Identifier.of(recipePath));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        exporter.accept(recipeId, new MilkingRecipe(entity, fluid, amount, cooldown), null);
    }
}
