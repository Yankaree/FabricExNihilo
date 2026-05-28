package ngcsonsplash.fabricaeexnihilo.compatibility.rei.crucible;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.util.Identifier;
import ngcsonsplash.fabricaeexnihilo.compatibility.rei.PluginEntry;
import ngcsonsplash.fabricaeexnihilo.compatibility.rei.ReiIngredientUtil;
import ngcsonsplash.fabricaeexnihilo.recipe.crucible.CrucibleHeatRecipe;

import java.util.List;
import java.util.Optional;

public class CrucibleHeatDisplay implements Display {
    public final int heat;
    public final EntryIngredient source;
    private final Identifier id;

    public CrucibleHeatDisplay(RecipeEntry<CrucibleHeatRecipe> recipeEntry) {
        var recipe = recipeEntry.value();
        this.source = ReiIngredientUtil.of(recipe.getBlock());
        this.heat = recipe.getHeat();
        this.id = recipeEntry.id();
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PluginEntry.HEATING;
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return List.of(source);
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of();
    }

    @Override
    public Optional<Identifier> getDisplayLocation() {
        return Optional.of(id);
    }
}