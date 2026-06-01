package ngcsonsplash.fabricaeexnihilo.config;

import net.minecraft.util.Identifier;
import java.util.ArrayList;
import java.util.List;

public class WitchWaterConfig {
    public List<StatusEffectStats> effects = new ArrayList<>(List.of(
            new StatusEffectStats(Identifier.of("blindness"), 210, 0),
            new StatusEffectStats(Identifier.of("hunger"), 210, 2),
            new StatusEffectStats(Identifier.of("slowness"), 210, 0),
            new StatusEffectStats(Identifier.of("weakness"), 210, 2),
            new StatusEffectStats(Identifier.of("wither"), 210, 0)
    ));

    public static class StatusEffectStats {
        public Identifier type;
        public int duration;
        public int amplifier;

        public StatusEffectStats() {}
        public StatusEffectStats(Identifier type, int duration, int amplifier) {
            this.type = type;
            this.duration = duration;
            this.amplifier = amplifier;
        }
    }
}
