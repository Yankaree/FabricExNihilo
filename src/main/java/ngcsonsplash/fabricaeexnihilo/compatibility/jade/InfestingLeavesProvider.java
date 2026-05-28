package ngcsonsplash.fabricaeexnihilo.compatibility.jade;

import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import ngcsonsplash.fabricaeexnihilo.modules.infested.InfestingLeavesBlockEntity;

import static ngcsonsplash.fabricaeexnihilo.FabricaeExNihilo.id;

public class InfestingLeavesProvider implements IBlockComponentProvider {
    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (!(blockAccessor.getBlockEntity() instanceof InfestingLeavesBlockEntity leaves)) return;
        tooltip.add(Text.translatable("fabricaeexnihilo.hud.infesting_leaves.progress", (int) (leaves.getProgress() * 100)));
    }

    @Override
    public Identifier getUid() {
        return id("infesting_leaves");
    }
}
