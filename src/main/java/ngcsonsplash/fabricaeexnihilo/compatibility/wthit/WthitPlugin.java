package ngcsonsplash.fabricaeexnihilo.compatibility.wthit;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import ngcsonsplash.fabricaeexnihilo.modules.barrels.BarrelBlock;
import ngcsonsplash.fabricaeexnihilo.modules.crucibles.CrucibleBlock;
import ngcsonsplash.fabricaeexnihilo.modules.infested.InfestingLeavesBlock;
import ngcsonsplash.fabricaeexnihilo.modules.sieves.SieveBlock;

public class WthitPlugin implements IWailaPlugin {
    @Override
    public void register(IRegistrar registrar) {
        registrar.addComponent(new BarrelComponentProvider(), TooltipPosition.BODY, BarrelBlock.class);
        registrar.addComponent(new CrucibleComponentProvider(), TooltipPosition.BODY, CrucibleBlock.class);
        registrar.addComponent(new SieveComponentProvider(), TooltipPosition.BODY, SieveBlock.class);
        registrar.addComponent(new InfestingLeavesProvider(), TooltipPosition.BODY, InfestingLeavesBlock.class);
    }
}
