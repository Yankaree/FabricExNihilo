package ngcsonsplash.fabricaeexnihilo.recipe;

import ngcsonsplash.fabricaeexnihilo.util.EmptyInventory;

public interface RecipeContext extends EmptyInventory {
    /**
     * @deprecated Not intended for direct use
     */
    @Deprecated
    @Override
    default int getSize() {
        return EmptyInventory.super.getSize();
    }

    /**
     * @deprecated Not intended for direct use
     */
    @Deprecated
    @Override
    default boolean isEmpty() {
        return EmptyInventory.super.isEmpty();
    }
}