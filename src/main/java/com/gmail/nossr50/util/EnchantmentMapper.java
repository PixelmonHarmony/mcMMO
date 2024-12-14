package com.gmail.nossr50.util;

import com.gmail.nossr50.mcMMO;
import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;

public class EnchantmentMapper {
    private final mcMMO pluginRef;
    private final Enchantment efficiency;
    private final Enchantment unbreaking;
    private final Enchantment infinity;
    private final Enchantment featherFalling;
    private final Enchantment luckOfTheSea;

    public EnchantmentMapper(mcMMO pluginRef) {
        this.pluginRef = pluginRef;
        this.efficiency = initEfficiency();
        this.unbreaking = initUnbreaking();
        this.infinity = initInfinity();
        this.featherFalling = initFeatherFalling();
        this.luckOfTheSea = initLuckOfTheSea();
    }

    private Enchantment initLuckOfTheSea() {
        // Look for the enchantment by name
        for (Enchantment enchantment : Registry.ENCHANTMENT) {
            if (enchantment.getKey().toString().equalsIgnoreCase("minecraft:luck_of_the_sea") || enchantment.getKey().toString().equalsIgnoreCase("minecraft:luck")) {
                return enchantment;
            }
        }

        pluginRef.getLogger().severe("Unable to find the Luck of the Sea enchantment, " +
                "mcMMO will not function properly.");
        throw new IllegalStateException("Unable to find the Luck of the Sea enchantment");
    }

    private Enchantment initFeatherFalling() {

        // Look for the enchantment by name
        for (Enchantment enchantment : Registry.ENCHANTMENT) {
            if (enchantment.getKey().toString().equalsIgnoreCase("minecraft:feather_falling") || enchantment.getKey().toString().equalsIgnoreCase("minecraft:protection_fall")) {
                return enchantment;
            }
        }

        pluginRef.getLogger().severe("Unable to find the Feather Falling enchantment, " +
                "mcMMO will not function properly.");
        throw new IllegalStateException("Unable to find the Feather Falling enchantment");
    }

    private Enchantment initInfinity() {
        // Look for the enchantment by name
        for (Enchantment enchantment : Registry.ENCHANTMENT) {
            if (enchantment.getKey().toString().equalsIgnoreCase("minecraft:infinity") || enchantment.getKey().toString().equalsIgnoreCase("minecraft:arrow_infinite")) {
                return enchantment;
            }
        }

        pluginRef.getLogger().severe("Unable to find the Infinity enchantment, " +
                "mcMMO will not function properly.");
        throw new IllegalStateException("Unable to find the Infinity enchantment");
    }

    private Enchantment initEfficiency() {
        // Look for the enchantment by name
        for (Enchantment enchantment : Registry.ENCHANTMENT) {
            if (enchantment.getKey().toString().equalsIgnoreCase("minecraft:efficiency") || enchantment.getKey().toString().equalsIgnoreCase("minecraft:dig_speed")) {
                return enchantment;
            }
        }

        pluginRef.getLogger().severe("Unable to find the Efficiency enchantment, " +
                "mcMMO will not function properly.");
        throw new IllegalStateException("Unable to find the Efficiency enchantment");
    }

    private Enchantment initUnbreaking() {
        // Look for the enchantment by name
        for (Enchantment enchantment : Registry.ENCHANTMENT) {
            if (enchantment.getKey().toString().equalsIgnoreCase("minecraft:unbreaking") || enchantment.getKey().toString().equalsIgnoreCase("minecraft:durability")) {
                return enchantment;
            }
        }

        pluginRef.getLogger().severe("Unable to find the Unbreaking enchantment, " +
                "mcMMO will not function properly.");
        throw new IllegalStateException("Unable to find the Unbreaking enchantment");
    }

    /**
     * Get the efficiency enchantment
     *
     * @return The efficiency enchantment
     */
    public Enchantment getEfficiency() {
        return efficiency;
    }

    public Enchantment getUnbreaking() {
        return unbreaking;
    }

    public Enchantment getInfinity() {
        return infinity;
    }

    public Enchantment getFeatherFalling() {
        return featherFalling;
    }

    public Enchantment getLuckOfTheSea() {
        return luckOfTheSea;
    }
}
