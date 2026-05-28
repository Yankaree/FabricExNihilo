package ngcsonsplash.fabricaeexnihilo.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.item.ItemConvertible;
import ngcsonsplash.fabricaeexnihilo.FabricaeExNihilo;
import ngcsonsplash.fabricaeexnihilo.client.renderers.*;
import ngcsonsplash.fabricaeexnihilo.modules.ModBlocks;
import ngcsonsplash.fabricaeexnihilo.modules.ModItems;
import ngcsonsplash.fabricaeexnihilo.modules.barrels.BarrelBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.crucibles.CrucibleBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.infested.InfestingLeavesBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.sieves.SieveBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.strainer.StrainerBlockEntity;

import java.util.ArrayList;

@Environment(EnvType.CLIENT)
public class FabricaeExNihiloClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Fluid Rendering
        FluidRenderManager.setupClient();
        // Register BERs
        BlockEntityRendererFactories.register(SieveBlockEntity.TYPE, SieveBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(CrucibleBlockEntity.TYPE, CrucibleBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BarrelBlockEntity.TYPE, BarrelBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(InfestingLeavesBlockEntity.TYPE, InfestingLeavesBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(StrainerBlockEntity.TYPE, StrainerBlockEntityRenderer::new);
        FabricaeExNihilo.LOGGER.debug("Registered BERs");

        // Color Providers
        var coloredItems = new ArrayList<ItemConvertible>();

        coloredItems.addAll(ModItems.MESHES.values());
        coloredItems.addAll(ModItems.ORE_PIECES.values());
        coloredItems.addAll(ModBlocks.INFESTED_LEAVES.values());

        ColorProviderRegistry.ITEM.register(FENItemColorProvider.INSTANCE, coloredItems.toArray(ItemConvertible[]::new));

        ColorProviderRegistry.BLOCK.register(FENBlockColorProvider.INSTANCE, ModBlocks.INFESTED_LEAVES.values().toArray(Block[]::new));
        FabricaeExNihilo.LOGGER.debug("Registered color providers");

        // Render Layers
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SIEVES.values().toArray(Block[]::new));
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CRUCIBLES.values().toArray(Block[]::new));
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.STRAINERS.values().toArray(Block[]::new));
    }

}
