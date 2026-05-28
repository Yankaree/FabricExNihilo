package ngcsonsplash.fabricaeexnihilo.modules.sieves;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import ngcsonsplash.fabricaeexnihilo.FabricaeExNihilo;
import ngcsonsplash.fabricaeexnihilo.modules.base.Colored;
import ngcsonsplash.fabricaeexnihilo.util.Color;

public class MeshItem extends Item implements Colored {
    private final Color color;
    private final int enchantability;

    public MeshItem(Color color, int enchantability, Settings settings) {
        super(settings.maxCount(FabricaeExNihilo.CONFIG.get().sieves().meshStackSize()));
        this.color = color;
        this.enchantability = enchantability;
    }

    @Override
    public int getColor(int index) {
        return color.toInt();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    public Text getName(ItemStack stack) {
        return getName();
    }

}