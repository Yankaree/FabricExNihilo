package ngcsonsplash.fabricaeexnihilo.modules.witchwater;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import ngcsonsplash.fabricaeexnihilo.modules.ModEffects;
import ngcsonsplash.fabricaeexnihilo.util.Color;

public class WitchWaterStatusEffect extends StatusEffect {

    public WitchWaterStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, Color.DARK_PURPLE.toInt());
    }

    public static StatusEffectInstance getInstance() {
        return new StatusEffectInstance(ModEffects.WITCH_WATERED, 72000, 1, false, false, false);
    }

}
