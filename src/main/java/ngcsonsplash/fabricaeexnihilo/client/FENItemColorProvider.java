package ngcsonsplash.fabricaeexnihilo.client;

import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;
import ngcsonsplash.fabricaeexnihilo.modules.base.Colored;
import ngcsonsplash.fabricaeexnihilo.util.Color;

public final class FENItemColorProvider implements ItemColorProvider {

    private FENItemColorProvider() {
    }

    public static final FENItemColorProvider INSTANCE = new FENItemColorProvider();

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        return stack.getItem() instanceof Colored colored ? colored.getColor(tintIndex) : Color.WHITE.toIntAlphaOne();
    }

}