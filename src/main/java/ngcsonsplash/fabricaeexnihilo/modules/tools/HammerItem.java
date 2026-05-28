package ngcsonsplash.fabricaeexnihilo.modules.tools;

import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ngcsonsplash.fabricaeexnihilo.modules.ModTags;

import java.util.List;

public class HammerItem extends Item {

    private final ToolMaterial material;

    public HammerItem(ToolMaterial material, Item.Settings settings) {
        super(settings.component(DataComponentTypes.TOOL, createToolComponent(material)));
        this.material = material;
    }

    private static ToolComponent createToolComponent(ToolMaterial material) {
        return new ToolComponent(
                List.of(ToolComponent.Rule.ofAlwaysDropped(ModTags.HAMMERABLES, material.getMiningSpeedMultiplier())),
                1.0f,
                1
        );
    }

    public static boolean isHammer(ItemStack stack) {
        return stack.getItem() instanceof HammerItem || stack.isIn(ModTags.HAMMERS);
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return state.isIn(ModTags.HAMMERABLES) ? material.getMiningSpeedMultiplier() : 1F;
    }

    @Override
    public boolean isCorrectForDrops(ItemStack stack, BlockState state) {
        return state.isIn(ModTags.HAMMERABLES);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0f) {
            stack.damage(1, miner, EquipmentSlot.MAINHAND);
        }
        return true;
    }
}
