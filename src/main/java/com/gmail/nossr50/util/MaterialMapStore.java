package com.gmail.nossr50.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

/**
 * Stores hash tables for item and block names This allows for better support across multiple
 * versions of Minecraft
 */
public class MaterialMapStore {

    private final @NotNull Set<NamespacedKey> abilityBlackList = new HashSet<>();
    private final @NotNull Set<NamespacedKey> toolBlackList = new HashSet<>();
    private final @NotNull Set<NamespacedKey> mossyWhiteList = new HashSet<>();
    private final @NotNull Set<NamespacedKey> treeFellerDestructibleWhiteList = new HashSet<>();
    private final @NotNull Set<NamespacedKey> herbalismAbilityBlackList = new HashSet<>();
    private final @NotNull Set<NamespacedKey> blockCrackerWhiteList = new HashSet<>();
    private final @NotNull Set<NamespacedKey> canMakeShroomyWhiteList = new HashSet<>();
    private final @NotNull Set<NamespacedKey> multiBlockPlant = new HashSet<>();
    private final @NotNull Set<NamespacedKey> multiBlockHangingPlant = new HashSet<>();
    private final @NotNull Set<NamespacedKey> foodItemWhiteList = new HashSet<>();
    private final @NotNull Set<NamespacedKey> glassBlocks = new HashSet<>();

    private final @NotNull Set<NamespacedKey> ultriteArmor = new HashSet<>();
    private final @NotNull Set<NamespacedKey> ultriteTools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> netheriteArmor = new HashSet<>();
    private final @NotNull Set<NamespacedKey> netheriteTools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> woodTools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> stoneTools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> leatherArmor = new HashSet<>();
    private final @NotNull Set<NamespacedKey> ironArmor = new HashSet<>();
    private final @NotNull Set<NamespacedKey> ironTools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> stringTools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> prismarineTools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> goldArmor = new HashSet<>();
    private final @NotNull Set<NamespacedKey> goldTools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> chainmailArmor = new HashSet<>();
    private final @NotNull Set<NamespacedKey> diamondArmor = new HashSet<>();
    private final @NotNull Set<NamespacedKey> diamondTools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> armors = new HashSet<>();

    private final @NotNull Set<NamespacedKey> swords = new HashSet<>();
    private final @NotNull Set<NamespacedKey> axes = new HashSet<>();
    private final @NotNull Set<NamespacedKey> hoes = new HashSet<>();
    private final @NotNull Set<NamespacedKey> shovels = new HashSet<>();
    private final @NotNull Set<NamespacedKey> pickAxes = new HashSet<>();
    private final @NotNull Set<NamespacedKey> tridents = new HashSet<>();
    private final @NotNull Set<NamespacedKey> bows = new HashSet<>();
    private final @NotNull Set<NamespacedKey> crossbows = new HashSet<>();
    private final @NotNull Set<NamespacedKey> tools = new HashSet<>();
    private final @NotNull Set<NamespacedKey> enchantables = new HashSet<>();
    private final @NotNull Set<NamespacedKey> maces = new HashSet<>();

    private final @NotNull Set<NamespacedKey> ores = new HashSet<>();
    private final @NotNull Set<NamespacedKey> intendedToolPickAxe = new HashSet<>();
    private final @NotNull Set<NamespacedKey> intendedToolShovel = new HashSet<>();

    private final @NotNull HashMap<NamespacedKey, Integer> tierValue = new HashMap<>();


    public MaterialMapStore() {
        fillVanillaMaterialRegisters();
    }

    private void fillVanillaMaterialRegisters() {
        //The order matters
        fillAbilityBlackList();
        fillToolBlackList();
        fillMossyWhiteList();
        fillTreeFellerDestructibleWhiteList();
        fillHerbalismAbilityBlackList();
        fillBlockCrackerWhiteList();
        fillShroomyWhiteList();
        fillMultiBlockPlantSet();
        fillMultiBlockHangingPlantSet();
        fillFoodWhiteList();
        fillGlassBlockWhiteList();
        fillArmors();
        fillTools();
        fillEnchantables();
        fillOres();
        fillIntendedTools();

        fillTierMap();
    }

    public boolean isMultiBlockPlant(@NotNull Material material) {
        return multiBlockPlant.contains(material.getKey().getKey());
    }

    public boolean isMultiBlockHangingPlant(@NotNull Material material) {
        return multiBlockHangingPlant.contains(material.getKey().getKey());
    }

    public boolean isAbilityActivationBlackListed(@NotNull Material material) {
        return abilityBlackList.contains(material.getKey().getKey());
    }

    public boolean isToolActivationBlackListed(@NotNull Material material) {
        return toolBlackList.contains(material.getKey().getKey());
    }

    public boolean isMossyWhiteListed(@NotNull Material material) {
        return mossyWhiteList.contains(material.getKey().getKey());
    }

    public boolean isTreeFellerDestructible(@NotNull Material material) {
        return treeFellerDestructibleWhiteList.contains(material.getKey());
    }

    public boolean isHerbalismAbilityWhiteListed(@NotNull Material material) {
        return herbalismAbilityBlackList.contains(material.getKey());
    }

    public boolean isBlockCrackerWhiteListed(@NotNull Material material) {
        return blockCrackerWhiteList.contains(material.getKey());
    }

    public boolean isShroomyWhiteListed(@NotNull Material material) {
        return canMakeShroomyWhiteList.contains(material.getKey());
    }

    private void fillTierMap() {
        for (NamespacedKey id : leatherArmor) {
            tierValue.put(id, 1);
        }

        for (NamespacedKey id : ironArmor) {
            tierValue.put(id, 2);
        }

        for (NamespacedKey id : goldArmor) {
            tierValue.put(id, 3);
        }

        for (NamespacedKey id : chainmailArmor) {
            tierValue.put(id, 3);
        }

        for (NamespacedKey id : diamondArmor) {
            tierValue.put(id, 6);
        }

        for (NamespacedKey id : netheriteArmor) {
            tierValue.put(id, 12);
        }

        for (NamespacedKey id : ultriteArmor) {
            tierValue.put(id, 16);
        }
    }

    private void fillOres() {
        addVanilla(ores, "coal_ore");
        addVanilla(ores, "diamond_ore");
        addVanilla(ores, "nether_quartz_ore");
        addVanilla(ores, "quartz_ore"); //Pre 1.13
        addVanilla(ores, "gold_ore");
        addVanilla(ores, "iron_ore");
        addVanilla(ores, "lapis_ore");
        addVanilla(ores, "lapis_lazuli_ore");
        addVanilla(ores, "redstone_ore");
        addVanilla(ores, "emerald_ore");
        addVanilla(ores, "ancient_debris");
        addVanilla(ores, "nether_gold_ore");
        addVanilla(ores, "gilded_blackstone");

        addVanilla(ores, "deepslate_redstone_ore");
        addVanilla(ores, "deepslate_copper_ore");
        addVanilla(ores, "deepslate_coal_ore");
        addVanilla(ores, "deepslate_diamond_ore");
        addVanilla(ores, "deepslate_emerald_ore");
        addVanilla(ores, "deepslate_iron_ore");
        addVanilla(ores, "deepslate_gold_ore");
        addVanilla(ores, "deepslate_lapis_ore");
        addVanilla(ores, "copper_ore");
    }

    private void fillIntendedTools() {
        intendedToolPickAxe.addAll(ores);

        addVanilla(intendedToolPickAxe, "lapis_lazuli_ore");
        addVanilla(intendedToolPickAxe, "packed_mud");
        addVanilla(intendedToolPickAxe, "mud_bricks");
        addVanilla(intendedToolPickAxe, "reinforced_deepslate");
        addVanilla(intendedToolPickAxe, "ice");
        addVanilla(intendedToolPickAxe, "packed_ice");
        addVanilla(intendedToolPickAxe, "blue_ice");
        addVanilla(intendedToolPickAxe, "frosted_ice");
        addVanilla(intendedToolPickAxe, "anvil");
        addVanilla(intendedToolPickAxe, "bell");
        addVanilla(intendedToolPickAxe, "block_of_redstone");
        addVanilla(intendedToolPickAxe, "brewing_stand");
        addVanilla(intendedToolPickAxe, "cauldron");
        addVanilla(intendedToolPickAxe, "chain");
        addVanilla(intendedToolPickAxe, "hopper");
        addVanilla(intendedToolPickAxe, "iron_bars");
        addVanilla(intendedToolPickAxe, "iron_door");
        addVanilla(intendedToolPickAxe, "iron_trapdoor");
        addVanilla(intendedToolPickAxe, "lantern");
        addVanilla(intendedToolPickAxe, "weighted_pressure_plates");
        addVanilla(intendedToolPickAxe, "block_of_iron");
        addVanilla(intendedToolPickAxe, "copper_blocks");
        addVanilla(intendedToolPickAxe, "cut_copper");
        addVanilla(intendedToolPickAxe, "cut_copper_slab");
        addVanilla(intendedToolPickAxe, "cut_copper_stairs");
        addVanilla(intendedToolPickAxe, "lapis_lazuli_block");
        addVanilla(intendedToolPickAxe, "lightning_rod");
        addVanilla(intendedToolPickAxe, "block_of_diamond");
        addVanilla(intendedToolPickAxe, "block_of_emerald");
        addVanilla(intendedToolPickAxe, "block_of_gold");
        addVanilla(intendedToolPickAxe, "block_of_netherite");
        addVanilla(intendedToolPickAxe, "piston");
        addVanilla(intendedToolPickAxe, "sticky_piston");
        addVanilla(intendedToolPickAxe, "conduit");
        addVanilla(intendedToolPickAxe, "shulker_box");
        addVanilla(intendedToolPickAxe, "element_constructor"); //be & ee
        addVanilla(intendedToolPickAxe, "compound_creator"); //be & ee
        addVanilla(intendedToolPickAxe, "material_reducer"); //be & ee
        addVanilla(intendedToolPickAxe, "activator_rail");
        addVanilla(intendedToolPickAxe, "detector_rail");
        addVanilla(intendedToolPickAxe, "powered_rail");
        addVanilla(intendedToolPickAxe, "rail");
        addVanilla(intendedToolPickAxe, "andesite");
        addVanilla(intendedToolPickAxe, "basalt");
        addVanilla(intendedToolPickAxe, "blackstone");
        addVanilla(intendedToolPickAxe, "blast_furnace");
        addVanilla(intendedToolPickAxe, "block_of_coal");
        addVanilla(intendedToolPickAxe, "block_of_quartz");
        addVanilla(intendedToolPickAxe, "bricks");
        addVanilla(intendedToolPickAxe, "cobblestone");
        addVanilla(intendedToolPickAxe, "cobblestone_wall");
        addVanilla(intendedToolPickAxe, "concrete");
        addVanilla(intendedToolPickAxe, "dark_prismarine");
        addVanilla(intendedToolPickAxe, "diorite");
        addVanilla(intendedToolPickAxe, "dispenser");
        addVanilla(intendedToolPickAxe, "dripstone_block");
        addVanilla(intendedToolPickAxe, "dropper");
        addVanilla(intendedToolPickAxe, "enchantment_table");
        addVanilla(intendedToolPickAxe, "end_stone");
        addVanilla(intendedToolPickAxe, "ender_chest");
        addVanilla(intendedToolPickAxe, "furnace");
        addVanilla(intendedToolPickAxe, "glazed_terracotta");
        addVanilla(intendedToolPickAxe, "granite");
        addVanilla(intendedToolPickAxe, "grindstone");
        addVanilla(intendedToolPickAxe, "heat_block"); //be & ee
        addVanilla(intendedToolPickAxe, "lodestone");
        addVanilla(intendedToolPickAxe, "mossy_cobblestone");
        addVanilla(intendedToolPickAxe, "nether_bricks");
        addVanilla(intendedToolPickAxe, "nether_brick_fence");
        addVanilla(intendedToolPickAxe, "nether_gold_ore");
        addVanilla(intendedToolPickAxe, "nether_quartz_ore");
        addVanilla(intendedToolPickAxe, "netherrack");
        addVanilla(intendedToolPickAxe, "observer");
        addVanilla(intendedToolPickAxe, "prismarine");
        addVanilla(intendedToolPickAxe, "prismarine_bricks");
        addVanilla(intendedToolPickAxe, "pointed_dripstone");
        addVanilla(intendedToolPickAxe, "polished_andesite");
        addVanilla(intendedToolPickAxe, "polished_blackstone");
        addVanilla(intendedToolPickAxe, "polished_blackstone_bricks");
        addVanilla(intendedToolPickAxe, "polished_diorite");
        addVanilla(intendedToolPickAxe, "polished_granite");
        addVanilla(intendedToolPickAxe, "red_sandstone");
        addVanilla(intendedToolPickAxe, "sandstone");
        addVanilla(intendedToolPickAxe, "smoker");
        addVanilla(intendedToolPickAxe, "spawner");
        addVanilla(intendedToolPickAxe, "stonecutter");
        addVanilla(intendedToolPickAxe, "colored_terracotta");
        addVanilla(intendedToolPickAxe, "smooth_stone");
        addVanilla(intendedToolPickAxe, "stone");
        addVanilla(intendedToolPickAxe, "stone_bricks");
        addVanilla(intendedToolPickAxe, "stone_button");
        addVanilla(intendedToolPickAxe, "stone_pressure_plate");
        addVanilla(intendedToolPickAxe, "terracotta");
        addVanilla(intendedToolPickAxe, "ancient_debris");
        addVanilla(intendedToolPickAxe, "crying_obsidian");
        addVanilla(intendedToolPickAxe, "glowing_obsidian"); //be
        addVanilla(intendedToolPickAxe, "obsidian");
        addVanilla(intendedToolPickAxe, "respawn_anchor");

        //slabs
        addVanilla(intendedToolPickAxe, "petrified_oak_slab");
        addVanilla(intendedToolPickAxe, "stone_slab");
        addVanilla(intendedToolPickAxe, "smooth_stone_slab");
        addVanilla(intendedToolPickAxe, "cobblestone_slab");
        addVanilla(intendedToolPickAxe, "mossy_cobblestone_slab");
        addVanilla(intendedToolPickAxe, "stone_brick_slab");
        addVanilla(intendedToolPickAxe, "mossy_stone_brick_slab");
        addVanilla(intendedToolPickAxe, "andesite_slab");
        addVanilla(intendedToolPickAxe, "polished_andesite_slab");
        addVanilla(intendedToolPickAxe, "diorite_slab");
        addVanilla(intendedToolPickAxe, "polished_diorite_slab");
        addVanilla(intendedToolPickAxe, "granite_slab");
        addVanilla(intendedToolPickAxe, "polished_granite_slab");
        addVanilla(intendedToolPickAxe, "sandstone_slab");
        addVanilla(intendedToolPickAxe, "cut_sandstone_slab");
        addVanilla(intendedToolPickAxe, "smooth_sandstone_slab");
        addVanilla(intendedToolPickAxe, "red_sandstone_slab");
        addVanilla(intendedToolPickAxe, "cut_red_sandstone_slab");
        addVanilla(intendedToolPickAxe, "smooth_red_sandstone_slab");
        addVanilla(intendedToolPickAxe, "brick_slab");
        addVanilla(intendedToolPickAxe, "prismarine_brick_slab");
        addVanilla(intendedToolPickAxe, "dark_prismarine_slab");
        addVanilla(intendedToolPickAxe, "nether_brick_slab");
        addVanilla(intendedToolPickAxe, "red_netherbrick_slab");
        addVanilla(intendedToolPickAxe, "quartz_slab");
        addVanilla(intendedToolPickAxe, "smooth_quartz_slab");
        addVanilla(intendedToolPickAxe, "purpur_slab");
        addVanilla(intendedToolPickAxe, "end_stone_brick_slab");
        addVanilla(intendedToolPickAxe, "blackstone_slab");
        addVanilla(intendedToolPickAxe, "polished_blackstone_slab");
        addVanilla(intendedToolPickAxe, "polished_blackstone_brick_slab");
        addVanilla(intendedToolPickAxe, "lightly_weathered_cut_copper_slab");
        addVanilla(intendedToolPickAxe, "semi_weathered_cut_copper_slab");
        addVanilla(intendedToolPickAxe, "waxed_semi_weathered_cut_copper_slab");
        addVanilla(intendedToolPickAxe, "weathered_cut_copper_slab");
        addVanilla(intendedToolPickAxe, "waxed_cut_copper_slab");
        addVanilla(intendedToolPickAxe, "waxed_lightly_weathered_cut_copper_slab");

        //stairs (not all of these exist, just copied the above list and replaced slab with stairs)
        addVanilla(intendedToolPickAxe, "petrified_oak_stairs");
        addVanilla(intendedToolPickAxe, "stone_stairs");
        addVanilla(intendedToolPickAxe, "smooth_stone_stairs");
        addVanilla(intendedToolPickAxe, "cobblestone_stairs");
        addVanilla(intendedToolPickAxe, "mossy_cobblestone_stairs");
        addVanilla(intendedToolPickAxe, "stone_brick_stairs");
        addVanilla(intendedToolPickAxe, "mossy_stone_brick_stairs");
        addVanilla(intendedToolPickAxe, "andesite_stairs");
        addVanilla(intendedToolPickAxe, "polished_andesite_stairs");
        addVanilla(intendedToolPickAxe, "diorite_stairs");
        addVanilla(intendedToolPickAxe, "polished_diorite_stairs");
        addVanilla(intendedToolPickAxe, "granite_stairs");
        addVanilla(intendedToolPickAxe, "polished_granite_stairs");
        addVanilla(intendedToolPickAxe, "sandstone_stairs");
        addVanilla(intendedToolPickAxe, "cut_sandstone_stairs");
        addVanilla(intendedToolPickAxe, "smooth_sandstone_stairs");
        addVanilla(intendedToolPickAxe, "red_sandstone_stairs");
        addVanilla(intendedToolPickAxe, "cut_red_sandstone_stairs");
        addVanilla(intendedToolPickAxe, "smooth_red_sandstone_stairs");
        addVanilla(intendedToolPickAxe, "brick_stairs");
        addVanilla(intendedToolPickAxe, "prismarine_brick_stairs");
        addVanilla(intendedToolPickAxe, "dark_prismarine_stairs");
        addVanilla(intendedToolPickAxe, "nether_brick_stairs");
        addVanilla(intendedToolPickAxe, "red_netherbrick_stairs");
        addVanilla(intendedToolPickAxe, "quartz_stairs");
        addVanilla(intendedToolPickAxe, "smooth_quartz_stairs");
        addVanilla(intendedToolPickAxe, "purpur_stairs");
        addVanilla(intendedToolPickAxe, "end_stone_brick_stairs");
        addVanilla(intendedToolPickAxe, "blackstone_stairs");
        addVanilla(intendedToolPickAxe, "polished_blackstone_stairs");
        addVanilla(intendedToolPickAxe, "polished_blackstone_brick_stairs");
        addVanilla(intendedToolPickAxe, "lightly_weathered_cut_copper_stairs");
        addVanilla(intendedToolPickAxe, "semi_weathered_cut_copper_stairs");
        addVanilla(intendedToolPickAxe, "waxed_semi_weathered_cut_copper_stairs");
        addVanilla(intendedToolPickAxe, "weathered_cut_copper_stairs");
        addVanilla(intendedToolPickAxe, "waxed_cut_copper_stairs");
        addVanilla(intendedToolPickAxe, "waxed_lightly_weathered_cut_copper_stairs");

        //1.17 Mining (non-ores)
        addVanilla(intendedToolPickAxe, "calcite");
        addVanilla(intendedToolPickAxe, "smooth_basalt");
        addVanilla(intendedToolPickAxe, "block_of_amethyst");
        addVanilla(intendedToolPickAxe, "small_amethyst_bud");
        addVanilla(intendedToolPickAxe, "medium_amethyst_bud");
        addVanilla(intendedToolPickAxe, "large_amethyst_bud");
        addVanilla(intendedToolPickAxe, "amethyst_cluster");
        addVanilla(intendedToolPickAxe, "budding_amethyst");
        addVanilla(intendedToolPickAxe, "deepslate");
        addVanilla(intendedToolPickAxe, "cobbled_deepslate");
        addVanilla(intendedToolPickAxe, "tuff");
    }

    private void fillArmors() {
        fillArmor(leatherArmor, "leather");
        fillArmor(ironArmor, "iron");
        fillArmor(chainmailArmor, "chainmail");
        fillArmor(goldArmor, "golden");
        fillArmor(diamondArmor, "diamond");
        fillArmor(netheriteArmor, "netherite");
        fillArmor(ultriteArmor, "generations_core", "ultrite");

        addVanilla(armors, "turtle_shell");
    }

    private void fillEnchantables() {
        enchantables.addAll(armors);
        enchantables.addAll(swords);
        enchantables.addAll(axes);
        enchantables.addAll(hoes);
        enchantables.addAll(pickAxes);
        enchantables.addAll(tridents);
        enchantables.addAll(bows);
        enchantables.addAll(crossbows);
        enchantables.addAll(maces);

        addVanilla(enchantables, "shears");
        addVanilla(enchantables, "fishing_rod");
        addVanilla(enchantables, "carrot_on_a_stick");
        addVanilla(enchantables, "enchanted_book");
        addVanilla(enchantables, "flint_and_steel");
        addVanilla(enchantables, "turtle_shell");
    }

    private void fillTool(Set<NamespacedKey> set, String id) {
        fillTool(set, "minecraft", id);
    }

    private void fillTool(Set<NamespacedKey> set, String namespace, String id) {
        fillElement(set, swords, namespace, id, "sword");
        fillElement(set, axes, namespace, id, "axe");
        fillElement(set, hoes, namespace, id, "hoe");
        fillElement(set, pickAxes, namespace, id, "pickaxe");
        fillElement(set, shovels, namespace, id, "shovel");
    }

    private void fillTools() {
        fillTool(woodTools, "wooden");
        fillTool(stoneTools, "stone");
        fillTool(ironTools, "iron");
        fillTool(goldTools, "golden");
        fillTool(diamondTools, "diamond");
        fillTool(netheriteTools, "netherite");
        fillTool(ultriteTools, "generations_core", "ultrite");

        fillTridents();
        fillMaces();
        fillStringTools();
        fillPrismarineTools();
        fillBows();
        fillCrossbows();

        //Tools collection
        tools.addAll(tridents);
        tools.addAll(stringTools);
        tools.addAll(bows);
        tools.addAll(crossbows);
        tools.addAll(maces);
    }

    private void fillBows() {
        addVanilla(bows, "bow");
    }

    private void fillCrossbows() {
        addVanilla(crossbows, "crossbow");
    }

    private void fillStringTools() {
        addVanilla(stringTools, "bow");
        addVanilla(stringTools, "fishing_rod");
        addVanilla(stringTools, "carrot_on_a_stick");
        addVanilla(stringTools, "crossbow");
    }

    private void fillPrismarineTools() {
        addVanilla(prismarineTools, "trident");
    }

    private void fillMaces() {
        addVanilla(maces, "mace");
    }

    private void fillTridents() {
        addVanilla(tridents, "trident");
    }

    private void fillArmor(Set<NamespacedKey> set, String id) {
        fillArmor(set, "minecraft", id);
    }

    private void fillArmor(Set<NamespacedKey> set, String namespace, String id) {
        fillElement(set, armors, namespace, id, "helmet");
        fillElement(set, armors, namespace, id, "chestplate");
        fillElement(set, armors, namespace, id, "leggings");
        fillElement(set, armors, namespace, id, "boots");
    }

    public void fillElement(Set<NamespacedKey> primary, Set<NamespacedKey> secondary, String namespace, String id, String type) {
        var boots = NamespacedKey.fromString(namespace + ":" + id + "_" + type);
        primary.add(boots);
        secondary.add(boots);
    }

    private void fillGlassBlockWhiteList() {
        addVanilla(glassBlocks, "glass");
        addVanilla(glassBlocks, "glass_pane");
        addVanilla(glassBlocks, "black_stained_glass");
        addVanilla(glassBlocks, "black_stained_glass_pane");
        addVanilla(glassBlocks, "blue_stained_glass");
        addVanilla(glassBlocks, "blue_stained_glass_pane");
        addVanilla(glassBlocks, "brown_stained_glass");
        addVanilla(glassBlocks, "brown_stained_glass_pane");
        addVanilla(glassBlocks, "cyan_stained_glass");
        addVanilla(glassBlocks, "cyan_stained_glass_pane");
        addVanilla(glassBlocks, "gray_stained_glass");
        addVanilla(glassBlocks, "gray_stained_glass_pane");
        addVanilla(glassBlocks, "green_stained_glass");
        addVanilla(glassBlocks, "green_stained_glass_pane");
        addVanilla(glassBlocks, "light_blue_stained_glass");
        addVanilla(glassBlocks, "light_blue_stained_glass_pane");
        addVanilla(glassBlocks, "light_gray_stained_glass");
        addVanilla(glassBlocks, "light_gray_stained_glass_pane");
        addVanilla(glassBlocks, "lime_stained_glass");
        addVanilla(glassBlocks, "lime_stained_glass_pane");
        addVanilla(glassBlocks, "magenta_stained_glass");
        addVanilla(glassBlocks, "magenta_stained_glass_pane");
        addVanilla(glassBlocks, "orange_stained_glass");
        addVanilla(glassBlocks, "orange_stained_glass_pane");
        addVanilla(glassBlocks, "pink_stained_glass");
        addVanilla(glassBlocks, "pink_stained_glass_pane");
        addVanilla(glassBlocks, "purple_stained_glass");
        addVanilla(glassBlocks, "purple_stained_glass_pane");
        addVanilla(glassBlocks, "red_stained_glass");
        addVanilla(glassBlocks, "red_stained_glass_pane");
        addVanilla(glassBlocks, "white_stained_glass");
        addVanilla(glassBlocks, "white_stained_glass_pane");
        addVanilla(glassBlocks, "yellow_stained_glass");
        addVanilla(glassBlocks, "yellow_stained_glass_pane");
    }

    private void fillFoodWhiteList() {
        addVanilla(foodItemWhiteList, "apple");
        addVanilla(foodItemWhiteList, "baked_potato");
        addVanilla(foodItemWhiteList, "beetroot");
        addVanilla(foodItemWhiteList, "beetroot_soup");
        addVanilla(foodItemWhiteList, "bread");
        addVanilla(foodItemWhiteList, "cake");
        addVanilla(foodItemWhiteList, "carrot");
        addVanilla(foodItemWhiteList, "chorus_fruit");
        addVanilla(foodItemWhiteList, "cooked_chicken");
        addVanilla(foodItemWhiteList, "cooked_cod");
        addVanilla(foodItemWhiteList, "cooked_mutton");
        addVanilla(foodItemWhiteList, "cooked_porkchop");
        addVanilla(foodItemWhiteList, "cooked_rabbit");
        addVanilla(foodItemWhiteList, "cooked_salmon");
        addVanilla(foodItemWhiteList, "cookie");
        addVanilla(foodItemWhiteList, "dried_kelp");
        addVanilla(foodItemWhiteList, "golden_apple");
        addVanilla(foodItemWhiteList, "enchanted_golden_apple");
        addVanilla(foodItemWhiteList, "golden_carrot");
        addVanilla(foodItemWhiteList, "melon_slice");
        addVanilla(foodItemWhiteList, "mushroom_stew");
        addVanilla(foodItemWhiteList, "poisonous_potato");
        addVanilla(foodItemWhiteList, "potato");
        addVanilla(foodItemWhiteList, "pumpkin_pie");
        addVanilla(foodItemWhiteList, "rabbit_stew");
        addVanilla(foodItemWhiteList, "raw_beef");
        addVanilla(foodItemWhiteList, "raw_chicken");
        addVanilla(foodItemWhiteList, "raw_cod");
        addVanilla(foodItemWhiteList, "raw_mutton");
        addVanilla(foodItemWhiteList, "raw_porkchop");
        addVanilla(foodItemWhiteList, "raw_rabbit");
        addVanilla(foodItemWhiteList, "raw_salmon");
        addVanilla(foodItemWhiteList, "rotten_flesh");
        addVanilla(foodItemWhiteList, "suspicious_stew");
        addVanilla(foodItemWhiteList, "sweet_berries");
        addVanilla(foodItemWhiteList, "tropical_fish");
    }

    /**
     * Checks if a Material is used for Armor
     *
     * @param material target material
     * @return true if it is used for armor
     */
    public boolean isArmor(@NotNull Material material) {
        return isArmor(material.getKey());
    }

    /**
     * Checks if the id provided is used as armor
     *
     * @param id target item id
     * @return true if the item id matches armor
     */
    public boolean isArmor(@NotNull NamespacedKey id) {
        return armors.contains(id);
    }

    public boolean isTool(@NotNull NamespacedKey id) {
        return tools.contains(id);
    }

    public boolean isEnchantable(@NotNull NamespacedKey id) {
        return enchantables.contains(id);
    }

    public boolean isOre(@NotNull NamespacedKey id) {
        return ores.contains(id);
    }

    public boolean isBow(@NotNull NamespacedKey id) {
        return bows.contains(id);
    }

    public boolean isCrossbow(@NotNull NamespacedKey id) {
        return crossbows.contains(id);
    }

    public boolean isTrident(@NotNull NamespacedKey id) {
        return tridents.contains(id);
    }

    public boolean isMace(@NotNull NamespacedKey id) {
        return maces.contains(id);
    }

    public boolean isLeatherArmor(@NotNull NamespacedKey id) {
        return leatherArmor.contains(id);
    }

    public boolean isIronArmor(@NotNull NamespacedKey id) {
        return ironArmor.contains(id);
    }

    public boolean isGoldArmor(@NotNull NamespacedKey id) {
        return goldArmor.contains(id);
    }

    public boolean isDiamondArmor(@NotNull NamespacedKey id) {
        return diamondArmor.contains(id);
    }

    public boolean isChainmailArmor(@NotNull NamespacedKey id) {
        return chainmailArmor.contains(id);
    }

    public boolean isNetheriteArmor(@NotNull NamespacedKey id) {
        return netheriteArmor.contains(id);
    }

    public boolean isWoodTool(@NotNull NamespacedKey id) {
        return woodTools.contains(id);
    }

    public boolean isStoneTool(@NotNull NamespacedKey id) {
        return stoneTools.contains(id);
    }

    public boolean isIronTool(@NotNull NamespacedKey id) {
        return ironTools.contains(id);
    }

    public boolean isGoldTool(@NotNull NamespacedKey id) {
        return goldTools.contains(id);
    }

    public boolean isDiamondTool(@NotNull NamespacedKey id) {
        return diamondTools.contains(id);
    }

    public boolean isSword(@NotNull NamespacedKey id) {
        return swords.contains(id);
    }

    public boolean isAxe(@NotNull NamespacedKey id) {
        return axes.contains(id);
    }

    public boolean isPickAxe(@NotNull NamespacedKey id) {
        return pickAxes.contains(id);
    }

    public boolean isShovel(@NotNull NamespacedKey id) {
        return shovels.contains(id);
    }

    public boolean isHoe(@NotNull NamespacedKey id) {
        return hoes.contains(id);
    }

    public boolean isNetheriteTool(@NotNull NamespacedKey id) {
        return netheriteTools.contains(id);
    }

    public boolean isStringTool(@NotNull NamespacedKey id) {
        return stringTools.contains(id);
    }

    public boolean isPrismarineTool(@NotNull NamespacedKey id) {
        return prismarineTools.contains(id);
    }

    public boolean isGlass(@NotNull Material material) {
        return glassBlocks.contains(material.getKey());
    }

    public boolean isFood(@NotNull Material material) {
        return foodItemWhiteList.contains(material.getKey());
    }

    private void fillMultiBlockPlantSet() {
        //Multi-Block Plants
        addVanilla(multiBlockPlant, "cactus");
        addVanilla(multiBlockPlant, "cactus_flower");
        addVanilla(multiBlockPlant, "chorus_plant");
        addVanilla(multiBlockPlant, "chorus_flower");
        addVanilla(multiBlockPlant, "sugar_cane");
        addVanilla(multiBlockPlant, "kelp_plant");
        addVanilla(multiBlockPlant, "kelp");
        addVanilla(multiBlockPlant, "tall_seagrass");
        addVanilla(multiBlockPlant, "large_fern");
        addVanilla(multiBlockPlant, "tall_grass");
        addVanilla(multiBlockPlant, "bamboo");
    }

    private void fillMultiBlockHangingPlantSet() {
        addVanilla(multiBlockHangingPlant, "weeping_vines_plant");
        addVanilla(multiBlockHangingPlant, "twisted_vines_plant");
        addVanilla(multiBlockHangingPlant, "cave_vines_plant");
        addVanilla(multiBlockHangingPlant, "pale_hanging_moss");
    }

    private void fillShroomyWhiteList() {
        addVanilla(canMakeShroomyWhiteList, "dirt");
        addVanilla(canMakeShroomyWhiteList, "grass_block");
        addVanilla(canMakeShroomyWhiteList, "dirt_path");
    }

    private void fillBlockCrackerWhiteList() {
        addVanilla(blockCrackerWhiteList, "stone_bricks");
        addVanilla(blockCrackerWhiteList, "infested_stone_bricks");

    }

    private void fillHerbalismAbilityBlackList() {
        addVanilla(herbalismAbilityBlackList, "dirt");
        addVanilla(herbalismAbilityBlackList, "grass_block");
        addVanilla(herbalismAbilityBlackList, "dirt_path");
        addVanilla(herbalismAbilityBlackList, "farmland");
    }

    private void fillTreeFellerDestructibleWhiteList() {
        addVanilla(treeFellerDestructibleWhiteList, "pale_hanging_moss");
        addVanilla(treeFellerDestructibleWhiteList, "oak_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "cherry_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "acacia_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "birch_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "dark_oak_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "pale_oak_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "jungle_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "spruce_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "azalea_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "flowering_azalea_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "mangrove_leaves");
        addVanilla(treeFellerDestructibleWhiteList, "mangrove_roots");
        addVanilla(treeFellerDestructibleWhiteList, "nether_wart_block");
        addVanilla(treeFellerDestructibleWhiteList, "warped_wart_block");
        addVanilla(treeFellerDestructibleWhiteList, "brown_mushroom_block");
        addVanilla(treeFellerDestructibleWhiteList, "red_mushroom_block");
    }

    private void fillMossyWhiteList() {
        addVanilla(mossyWhiteList, "cobblestone");
        addVanilla(mossyWhiteList, "dirt");
        addVanilla(mossyWhiteList, "grass_path");
        addVanilla(mossyWhiteList, "stone_bricks");
        addVanilla(mossyWhiteList, "cobblestone_wall");
    }

    private void fillAbilityBlackList() {
        addVanilla(abilityBlackList, "warped_fence_gate");
        addVanilla(abilityBlackList, "crimson_fence_gate");
        addVanilla(abilityBlackList, "warped_pressure_plate");
        addVanilla(abilityBlackList, "crimson_pressure_plate");
        addVanilla(abilityBlackList, "warped_button");
        addVanilla(abilityBlackList, "crimson_button");
        addVanilla(abilityBlackList, "warped_door");
        addVanilla(abilityBlackList, "crimson_door");
        addVanilla(abilityBlackList, "warped_trapdoor");
        addVanilla(abilityBlackList, "crimson_trapdoor");
        addVanilla(abilityBlackList, "black_bed");
        addVanilla(abilityBlackList, "blue_bed");
        addVanilla(abilityBlackList, "brown_bed");
        addVanilla(abilityBlackList, "cyan_bed");
        addVanilla(abilityBlackList, "gray_bed");
        addVanilla(abilityBlackList, "green_bed");
        addVanilla(abilityBlackList, "light_blue_bed");
        addVanilla(abilityBlackList, "light_gray_bed");
        addVanilla(abilityBlackList, "lime_bed");
        addVanilla(abilityBlackList, "magenta_bed");
        addVanilla(abilityBlackList, "orange_bed");
        addVanilla(abilityBlackList, "pink_bed");
        addVanilla(abilityBlackList, "purple_bed");
        addVanilla(abilityBlackList, "red_bed");
        addVanilla(abilityBlackList, "white_bed");
        addVanilla(abilityBlackList, "yellow_bed");
        addVanilla(abilityBlackList, "brewing_stand");
        addVanilla(abilityBlackList, "bookshelf");
        addVanilla(abilityBlackList, "cake");
        addVanilla(abilityBlackList, "chest");
        addVanilla(abilityBlackList, "dispenser");
        addVanilla(abilityBlackList, "enchanting_table");
        addVanilla(abilityBlackList, "ender_chest");
        addVanilla(abilityBlackList, "oak_fence_gate");
        addVanilla(abilityBlackList, "acacia_fence_gate");
        addVanilla(abilityBlackList, "dark_oak_fence_gate");
        addVanilla(abilityBlackList, "pale_oak_fence_gate");
        addVanilla(abilityBlackList, "spruce_fence_gate");
        addVanilla(abilityBlackList, "birch_fence_gate");
        addVanilla(abilityBlackList, "jungle_fence_gate");
        addVanilla(abilityBlackList, "furnace");
        addVanilla(abilityBlackList, "jukebox");
        addVanilla(abilityBlackList, "lever");
        addVanilla(abilityBlackList, "note_block");
        addVanilla(abilityBlackList, "stone_button");
        addVanilla(abilityBlackList, "oak_button");
        addVanilla(abilityBlackList, "birch_button");
        addVanilla(abilityBlackList, "acacia_button");
        addVanilla(abilityBlackList, "dark_oak_button");
        addVanilla(abilityBlackList, "pale_oak_button");
        addVanilla(abilityBlackList, "jungle_button");
        addVanilla(abilityBlackList, "spruce_button");
        addVanilla(abilityBlackList, "acacia_trapdoor");
        addVanilla(abilityBlackList, "birch_trapdoor");
        addVanilla(abilityBlackList, "dark_oak_trapdoor");
        addVanilla(abilityBlackList, "pale_oak_trapdoor");
        addVanilla(abilityBlackList, "jungle_trapdoor");
        addVanilla(abilityBlackList, "oak_trapdoor");
        addVanilla(abilityBlackList, "spruce_trapdoor");
        addVanilla(abilityBlackList, "acacia_sign");
        addVanilla(abilityBlackList, "acacia_wall_sign");
        addVanilla(abilityBlackList, "birch_sign");
        addVanilla(abilityBlackList, "birch_wall_sign");
        addVanilla(abilityBlackList, "dark_oak_sign");
        addVanilla(abilityBlackList, "pale_oak_sign");
        addVanilla(abilityBlackList, "dark_oak_wall_sign");
        addVanilla(abilityBlackList, "pale_oak_wall_sign");
        addVanilla(abilityBlackList, "jungle_sign");
        addVanilla(abilityBlackList, "jungle_wall_sign");
        addVanilla(abilityBlackList, "spruce_sign");
        addVanilla(abilityBlackList, "spruce_wall_sign");
        addVanilla(abilityBlackList, "oak_sign");
        addVanilla(abilityBlackList, "oak_wall_sign");
        addVanilla(abilityBlackList, "crafting_table");
        addVanilla(abilityBlackList, "beacon");
        addVanilla(abilityBlackList, "anvil");
        addVanilla(abilityBlackList, "dropper");
        addVanilla(abilityBlackList, "hopper");
        addVanilla(abilityBlackList, "trapped_chest");
        addVanilla(abilityBlackList, "iron_door");
        addVanilla(abilityBlackList, "iron_trapdoor");
        addVanilla(abilityBlackList, "oak_door");
        addVanilla(abilityBlackList, "acacia_door");
        addVanilla(abilityBlackList, "spruce_door");
        addVanilla(abilityBlackList, "birch_door");
        addVanilla(abilityBlackList, "jungle_door");
        addVanilla(abilityBlackList, "dark_oak_door");
        addVanilla(abilityBlackList, "pale_oak_door");
        addVanilla(abilityBlackList, "oak_fence");
        addVanilla(abilityBlackList, "acacia_fence");
        addVanilla(abilityBlackList, "dark_oak_fence");
        addVanilla(abilityBlackList, "pale_oak_fence");
        addVanilla(abilityBlackList, "birch_fence");
        addVanilla(abilityBlackList, "jungle_fence");
        addVanilla(abilityBlackList, "spruce_fence");
        addVanilla(abilityBlackList, "armor_stand");
        addVanilla(abilityBlackList, "black_shulker_box");
        addVanilla(abilityBlackList, "blue_shulker_box");
        addVanilla(abilityBlackList, "brown_shulker_box");
        addVanilla(abilityBlackList, "cyan_shulker_box");
        addVanilla(abilityBlackList, "gray_shulker_box");
        addVanilla(abilityBlackList, "green_shulker_box");
        addVanilla(abilityBlackList, "light_blue_shulker_box");
        addVanilla(abilityBlackList, "lime_shulker_box");
        addVanilla(abilityBlackList, "magenta_shulker_box");
        addVanilla(abilityBlackList, "orange_shulker_box");
        addVanilla(abilityBlackList, "pink_shulker_box");
        addVanilla(abilityBlackList, "purple_shulker_box");
        addVanilla(abilityBlackList, "red_shulker_box");
        addVanilla(abilityBlackList, "light_gray_shulker_box");
        addVanilla(abilityBlackList, "white_shulker_box");
        addVanilla(abilityBlackList, "yellow_shulker_box");
        addVanilla(abilityBlackList, "shulker_box");
        addVanilla(abilityBlackList, "wall_sign"); //1.13 and lower?
        addVanilla(abilityBlackList, "sign"); //1.13 and lower?
        addVanilla(abilityBlackList, "cartography_table");
        addVanilla(abilityBlackList, "grindstone");
        addVanilla(abilityBlackList, "lectern");
        addVanilla(abilityBlackList, "loom");
        addVanilla(abilityBlackList, "scaffolding");
        addVanilla(abilityBlackList, "smoker");
        addVanilla(abilityBlackList, "stonecutter");
        addVanilla(abilityBlackList, "sweet_berry_bush");
        addVanilla(abilityBlackList, "bell");
        addVanilla(abilityBlackList, "barrel");
        addVanilla(abilityBlackList, "blast_furnace");
        addVanilla(abilityBlackList, "campfire");
        addVanilla(abilityBlackList, "soul_campfire");
        addVanilla(abilityBlackList, "composter");
        addVanilla(abilityBlackList, "lodestone");
        addVanilla(abilityBlackList, "respawn_anchor");
    }

    private void fillToolBlackList() {
        addVanilla(toolBlackList, "chiseled_bookshelf");
        addVanilla(toolBlackList, "black_bed");
        addVanilla(toolBlackList, "blue_bed");
        addVanilla(toolBlackList, "brown_bed");
        addVanilla(toolBlackList, "cyan_bed");
        addVanilla(toolBlackList, "gray_bed");
        addVanilla(toolBlackList, "green_bed");
        addVanilla(toolBlackList, "light_blue_bed");
        addVanilla(toolBlackList, "light_gray_bed");
        addVanilla(toolBlackList, "lime_bed");
        addVanilla(toolBlackList, "magenta_bed");
        addVanilla(toolBlackList, "orange_bed");
        addVanilla(toolBlackList, "pink_bed");
        addVanilla(toolBlackList, "purple_bed");
        addVanilla(toolBlackList, "red_bed");
        addVanilla(toolBlackList, "white_bed");
        addVanilla(toolBlackList, "yellow_bed");
        addVanilla(toolBlackList, "brewing_stand");
        addVanilla(toolBlackList, "bookshelf");
        addVanilla(toolBlackList, "cake");
        addVanilla(toolBlackList, "chest");
        addVanilla(toolBlackList, "dispenser");
        addVanilla(toolBlackList, "enchanting_table");
        addVanilla(toolBlackList, "ender_chest");
        addVanilla(toolBlackList, "oak_fence_gate");
        addVanilla(toolBlackList, "acacia_fence_gate");
        addVanilla(toolBlackList, "dark_oak_fence_gate");
        addVanilla(toolBlackList, "pale_oak_fence_gate");
        addVanilla(toolBlackList, "spruce_fence_gate");
        addVanilla(toolBlackList, "birch_fence_gate");
        addVanilla(toolBlackList, "jungle_fence_gate");
        addVanilla(toolBlackList, "furnace");
        addVanilla(toolBlackList, "jukebox");
        addVanilla(toolBlackList, "lever");
        addVanilla(toolBlackList, "note_block");
        addVanilla(toolBlackList, "stone_button");
        addVanilla(toolBlackList, "oak_button");
        addVanilla(toolBlackList, "birch_button");
        addVanilla(toolBlackList, "acacia_button");
        addVanilla(toolBlackList, "dark_oak_button");
        addVanilla(toolBlackList, "pale_oak_button");
        addVanilla(toolBlackList, "jungle_button");
        addVanilla(toolBlackList, "spruce_button");
        addVanilla(toolBlackList, "acacia_trapdoor");
        addVanilla(toolBlackList, "birch_trapdoor");
        addVanilla(toolBlackList, "dark_oak_trapdoor");
        addVanilla(toolBlackList, "pale_oak_trapdoor");
        addVanilla(toolBlackList, "jungle_trapdoor");
        addVanilla(toolBlackList, "oak_trapdoor");
        addVanilla(toolBlackList, "spruce_trapdoor");
        addVanilla(toolBlackList, "crafting_table");
        addVanilla(toolBlackList, "beacon");
        addVanilla(toolBlackList, "anvil");
        addVanilla(toolBlackList, "dropper");
        addVanilla(toolBlackList, "hopper");
        addVanilla(toolBlackList, "trapped_chest");
        addVanilla(toolBlackList, "iron_door");
        addVanilla(toolBlackList, "iron_trapdoor");
        addVanilla(toolBlackList, "oak_door");
        addVanilla(toolBlackList, "acacia_door");
        addVanilla(toolBlackList, "spruce_door");
        addVanilla(toolBlackList, "birch_door");
        addVanilla(toolBlackList, "jungle_door");
        addVanilla(toolBlackList, "dark_oak_door");
        addVanilla(toolBlackList, "pale_oak_door");
        addVanilla(toolBlackList, "oak_fence");
        addVanilla(toolBlackList, "acacia_fence");
        addVanilla(toolBlackList, "dark_oak_fence");
        addVanilla(toolBlackList, "pale_oak_fence");
        addVanilla(toolBlackList, "birch_fence");
        addVanilla(toolBlackList, "jungle_fence");
        addVanilla(toolBlackList, "spruce_fence");
        addVanilla(toolBlackList, "armor_stand");
        addVanilla(toolBlackList, "black_shulker_box");
        addVanilla(toolBlackList, "blue_shulker_box");
        addVanilla(toolBlackList, "brown_shulker_box");
        addVanilla(toolBlackList, "cyan_shulker_box");
        addVanilla(toolBlackList, "gray_shulker_box");
        addVanilla(toolBlackList, "green_shulker_box");
        addVanilla(toolBlackList, "light_blue_shulker_box");
        addVanilla(toolBlackList, "lime_shulker_box");
        addVanilla(toolBlackList, "magenta_shulker_box");
        addVanilla(toolBlackList, "orange_shulker_box");
        addVanilla(toolBlackList, "pink_shulker_box");
        addVanilla(toolBlackList, "purple_shulker_box");
        addVanilla(toolBlackList, "red_shulker_box");
        addVanilla(toolBlackList, "light_gray_shulker_box");
        addVanilla(toolBlackList, "white_shulker_box");
        addVanilla(toolBlackList, "yellow_shulker_box");
        addVanilla(toolBlackList, "shulker_box");
        addVanilla(toolBlackList, "acacia_sign");
        addVanilla(toolBlackList, "acacia_hanging_sign");
        addVanilla(toolBlackList, "acacia_wall_sign");
        addVanilla(toolBlackList, "birch_sign");
        addVanilla(toolBlackList, "birch_hanging_sign");
        addVanilla(toolBlackList, "birch_wall_sign");
        addVanilla(toolBlackList, "dark_oak_sign");
        addVanilla(toolBlackList, "pale_oak_sign");
        addVanilla(toolBlackList, "dark_oak_hanging_sign");
        addVanilla(toolBlackList, "pale_oak_hanging_sign");
        addVanilla(toolBlackList, "dark_oak_wall_sign");
        addVanilla(toolBlackList, "pale_oak_wall_sign");
        addVanilla(toolBlackList, "jungle_sign");
        addVanilla(toolBlackList, "jungle_hanging_sign");
        addVanilla(toolBlackList, "jungle_wall_sign");
        addVanilla(toolBlackList, "spruce_sign");
        addVanilla(toolBlackList, "spruce_hanging_sign");
        addVanilla(toolBlackList, "spruce_wall_sign");
        addVanilla(toolBlackList, "oak_sign");
        addVanilla(toolBlackList, "oak_hanging_sign");
        addVanilla(toolBlackList, "oak_wall_sign");
        addVanilla(toolBlackList, "cherry_sign");
        addVanilla(toolBlackList, "cherry_hanging_sign");
        addVanilla(toolBlackList, "cherry_wall_sign");
        addVanilla(toolBlackList, "stripped_cherry_log");
        addVanilla(toolBlackList, "stripped_cherry_wood");
        addVanilla(toolBlackList, "stripped_acacia_log");
        addVanilla(toolBlackList, "stripped_acacia_wood");
        addVanilla(toolBlackList, "stripped_birch_log");
        addVanilla(toolBlackList, "stripped_birch_wood");
        addVanilla(toolBlackList, "stripped_dark_oak_log");
        addVanilla(toolBlackList, "stripped_pale_oak_log");
        addVanilla(toolBlackList, "stripped_dark_oak_wood");
        addVanilla(toolBlackList, "stripped_pale_oak_wood");
        addVanilla(toolBlackList, "stripped_jungle_log");
        addVanilla(toolBlackList, "stripped_jungle_wood");
        addVanilla(toolBlackList, "stripped_oak_log");
        addVanilla(toolBlackList, "stripped_oak_wood");
        addVanilla(toolBlackList, "stripped_spruce_log");
        addVanilla(toolBlackList, "stripped_spruce_wood");
        addVanilla(toolBlackList, "mangrove_wood");
        addVanilla(toolBlackList, "mangrove_log");
        addVanilla(toolBlackList, "stripped_mangrove_log");
        addVanilla(toolBlackList, "acacia_log");
        addVanilla(toolBlackList, "acacia_wood");
        addVanilla(toolBlackList, "birch_log");
        addVanilla(toolBlackList, "birch_wood");
        addVanilla(toolBlackList, "dark_oak_log");
        addVanilla(toolBlackList, "pale_oak_log");
        addVanilla(toolBlackList, "dark_oak_wood");
        addVanilla(toolBlackList, "pale_oak_wood");
        addVanilla(toolBlackList, "jungle_log");
        addVanilla(toolBlackList, "jungle_wood");
        addVanilla(toolBlackList, "oak_log");
        addVanilla(toolBlackList, "oak_wood");
        addVanilla(toolBlackList, "spruce_log");
        addVanilla(toolBlackList, "bell");
        addVanilla(toolBlackList, "barrel");
        addVanilla(toolBlackList, "blast_furnace");
        addVanilla(toolBlackList, "campfire");
        addVanilla(toolBlackList, "soul_campfire");
        addVanilla(toolBlackList, "cartography_table");
        addVanilla(toolBlackList, "composter");
        addVanilla(toolBlackList, "grindstone");
        addVanilla(toolBlackList, "lectern");
        addVanilla(toolBlackList, "loom");
        addVanilla(toolBlackList, "smoker");
        addVanilla(toolBlackList, "stonecutter");
        addVanilla(toolBlackList, "lodestone");
        addVanilla(toolBlackList, "respawn_anchor");
        addVanilla(toolBlackList, "sweet_berry_bush");
        addVanilla(toolBlackList, "smithing_table");
    }

    public boolean isIntendedToolPickaxe(@NotNull Material material) {
        return intendedToolPickAxe.contains(material.getKey().getKey());
    }

    public @NotNull Set<NamespacedKey> getNetheriteArmor() {
        return netheriteArmor;
    }

    public @NotNull Set<NamespacedKey> getNetheriteTools() {
        return netheriteTools;
    }

    public int getTier(@NotNull NamespacedKey id) {
        return tierValue.getOrDefault(id, 1); //1 for unknown items
    }

    private void addVanilla(Set<NamespacedKey> set, String name) {
        set.add(NamespacedKey.minecraft(name));
    }

    private void add(Set<NamespacedKey> set, String name) {
        set.add(NamespacedKey.fromString(name));
    }
}
