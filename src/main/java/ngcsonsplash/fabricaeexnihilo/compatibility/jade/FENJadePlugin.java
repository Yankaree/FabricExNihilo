package ngcsonsplash.fabricaeexnihilo.compatibility.jade;

import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import ngcsonsplash.fabricaeexnihilo.modules.barrels.BarrelBlock;
import ngcsonsplash.fabricaeexnihilo.modules.crucibles.CrucibleBlock;
import ngcsonsplash.fabricaeexnihilo.modules.sieves.SieveBlock;
import ngcsonsplash.fabricaeexnihilo.modules.strainer.StrainerBlock;

public class FENJadePlugin implements IWailaPlugin {
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(new BarrelProvider(), BarrelBlock.class);
        registration.registerBlockComponent(new CrucibleProvider(), CrucibleBlock.class);
        registration.registerBlockComponent(new SieveProvider(), SieveBlock.class);
        registration.registerBlockComponent(new StrainerProvider(), StrainerBlock.class);
        registration.registerBlockComponent(new InfestingLeavesProvider(), StrainerBlock.class);
    }
}
