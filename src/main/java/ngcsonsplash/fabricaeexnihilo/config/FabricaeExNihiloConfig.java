package ngcsonsplash.fabricaeexnihilo.config;

public class FabricaeExNihiloConfig {
    public BarrelConfig barrels = new BarrelConfig();
    public CrucibleConfig crucibles = new CrucibleConfig();
    public SeedConfig seeds = new SeedConfig();
    public SieveConfig sieves = new SieveConfig();
    public InfestedConfig infested = new InfestedConfig();
    public StrainerConfig strainers = new StrainerConfig();
    public WitchWaterConfig witchwater = new WitchWaterConfig();
    public MiscConfig misc = new MiscConfig();

    public static FabricaeExNihiloConfig createDefault() {
        return new FabricaeExNihiloConfig();
    }
}
