package ngcsonsplash.fabricaeexnihilo.compatibility.megane;

import lol.bai.megane.api.MeganeModule;
import lol.bai.megane.api.registry.CommonRegistrar;
import ngcsonsplash.fabricaeexnihilo.modules.barrels.BarrelBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.crucibles.CrucibleBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.strainer.StrainerBlockEntity;

public class FENMeganeModule implements MeganeModule {
    @Override
    public void registerCommon(CommonRegistrar registrar) {
        registrar.addFluid(BarrelBlockEntity.class, new BarrelFluidProvider());
        registrar.addItem(BarrelBlockEntity.class, new BarrelItemProvider());
        registrar.addFluid(CrucibleBlockEntity.class, new CrucibleFluidProvider());
        registrar.addItem(StrainerBlockEntity.class, new StrainerItemProvider());
    }
}
