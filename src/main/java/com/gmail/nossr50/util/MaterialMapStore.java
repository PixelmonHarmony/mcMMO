package com.gmail.nossr50.util;

import java.util.*;
import java.util.stream.Stream;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.jetbrains.annotations.NotNull;

/**
 * Stores hash tables for item and block names This allows for better support across multiple
 * versions of Minecraft
 */
public class MaterialMapStore {

    private final @NotNull Set<NamespacedKey> abilityBlackList;
    private final @NotNull Set<NamespacedKey> toolBlackList;
    private final @NotNull Set<NamespacedKey> mossyWhiteList;
    private final @NotNull Set<NamespacedKey> treeFellerDestructibleWhiteList;
    private final @NotNull Set<NamespacedKey> herbalismAbilityBlackList;
    private final @NotNull Set<NamespacedKey> blockCrackerWhiteList;
    private final @NotNull Set<NamespacedKey> canMakeShroomyWhiteList;
    private final @NotNull Set<NamespacedKey> multiBlockPlant;
    private final @NotNull Set<NamespacedKey> multiBlockHangingPlant;
    private final @NotNull Set<NamespacedKey> foodItemWhiteList;
    private final @NotNull Set<NamespacedKey> glassBlocks;

    private final @NotNull Set<NamespacedKey> netheriteArmor;
    private final @NotNull Set<NamespacedKey> netheriteTools;
    private final @NotNull Set<NamespacedKey> woodTools;
    private final @NotNull Set<NamespacedKey> stoneTools;
    private final @NotNull Set<NamespacedKey> leatherArmor;
    private final @NotNull Set<NamespacedKey> ironArmor;
    private final @NotNull Set<NamespacedKey> ironTools;
    private final @NotNull Set<NamespacedKey> stringTools;
    private final @NotNull Set<NamespacedKey> prismarineTools;
    private final @NotNull Set<NamespacedKey> goldArmor;
    private final @NotNull Set<NamespacedKey> goldTools;
    private final @NotNull Set<NamespacedKey> chainmailArmor;
    private final @NotNull Set<NamespacedKey> diamondArmor;
    private final @NotNull Set<NamespacedKey> diamondTools;
    private final @NotNull Set<NamespacedKey> armors;

    private final @NotNull Set<NamespacedKey> swords;
    private final @NotNull Set<NamespacedKey> axes;
    private final @NotNull Set<NamespacedKey> hoes;
    private final @NotNull Set<NamespacedKey> shovels;
    private final @NotNull Set<NamespacedKey> pickAxes;
    private final @NotNull Set<NamespacedKey> tridents;
    private final @NotNull Set<NamespacedKey> bows;
    private final @NotNull Set<NamespacedKey> crossbows;
    private final @NotNull Set<NamespacedKey> tools;
    private final @NotNull Set<NamespacedKey> enchantables;
    private final @NotNull Set<NamespacedKey> maces;

    private final @NotNull Set<NamespacedKey> ores;
    private final @NotNull Set<NamespacedKey> intendedToolPickAxe;
    private final @NotNull Set<NamespacedKey> intendedToolShovel;

    private final @NotNull HashMap<NamespacedKey, Integer> tierValue;


    public MaterialMapStore() {
        abilityBlackList = new HashSet<>();
        toolBlackList = new HashSet<>();
        mossyWhiteList = new HashSet<>();
        treeFellerDestructibleWhiteList = new HashSet<>();
        herbalismAbilityBlackList = new HashSet<>();
        blockCrackerWhiteList = new HashSet<>();
        canMakeShroomyWhiteList = new HashSet<>();
        multiBlockPlant = new HashSet<>();
        multiBlockHangingPlant = new HashSet<>();
        foodItemWhiteList = new HashSet<>();
        glassBlocks = new HashSet<>();

        leatherArmor = new HashSet<>();
        ironArmor = new HashSet<>();
        chainmailArmor = new HashSet<>();
        goldArmor = new HashSet<>();
        diamondArmor = new HashSet<>();
        netheriteArmor = new HashSet<>();
        armors = new HashSet<>();

        woodTools = new HashSet<>();
        stoneTools = new HashSet<>();
        ironTools = new HashSet<>();
        goldTools = new HashSet<>();
        diamondTools = new HashSet<>();
        netheriteTools = new HashSet<>();
        bows = new HashSet<>();
        crossbows = new HashSet<>();
        stringTools = new HashSet<>();
        prismarineTools = new HashSet<>();
        tools = new HashSet<>();

        swords = new HashSet<>();
        axes = new HashSet<>();
        pickAxes = new HashSet<>();
        shovels = new HashSet<>();
        hoes = new HashSet<>();
        tridents = new HashSet<>();
        maces = new HashSet<>();

        enchantables = new HashSet<>();

        ores = new HashSet<>();
        intendedToolPickAxe = new HashSet<>();
        intendedToolShovel = new HashSet<>();

        tierValue = new HashMap<>();

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
        add(enchantables, Tag.ITEMS_ENCHANTABLE_LEG_ARMOR,
                Tag.ITEMS_ENCHANTABLE_CHEST_ARMOR,
                Tag.ITEMS_ENCHANTABLE_HEAD_ARMOR,
                Tag.ITEMS_ENCHANTABLE_ARMOR,
                Tag.ITEMS_ENCHANTABLE_SWORD,
                Tag.ITEMS_ENCHANTABLE_FIRE_ASPECT,
                Tag.ITEMS_ENCHANTABLE_SHARP_WEAPON,
                Tag.ITEMS_ENCHANTABLE_WEAPON,
                Tag.ITEMS_ENCHANTABLE_MINING,
                Tag.ITEMS_ENCHANTABLE_MINING_LOOT,
                Tag.ITEMS_ENCHANTABLE_FISHING,
                Tag.ITEMS_ENCHANTABLE_TRIDENT,
                Tag.ITEMS_ENCHANTABLE_DURABILITY,
                Tag.ITEMS_ENCHANTABLE_BOW,
                Tag.ITEMS_ENCHANTABLE_EQUIPPABLE,
                Tag.ITEMS_ENCHANTABLE_CROSSBOW,
                Tag.ITEMS_ENCHANTABLE_VANISHING,
                Tag.ITEMS_ENCHANTABLE_MACE);

        add(ores, Tag.COAL_ORES, Tag.COPPER_ORES, Tag.DIAMOND_ORES, Tag.EMERALD_ORES, Tag.GOLD_ORES, Tag.IRON_ORES, Tag.LAPIS_ORES, Tag.REDSTONE_ORES);;

        add(intendedToolPickAxe, Tag.MINEABLE_PICKAXE);

        fillTierMap();
    }

    @SafeVarargs
    private void add(@NotNull Set<NamespacedKey> set, Object... objects) {
        Arrays.stream(objects).flatMap(a -> {
            if(a instanceof String id) {
                return Stream.of(id).map(NamespacedKey::fromString);
            } else if(a instanceof Tag<?> tag) {
                return ((Tag<Material>) tag).getValues().stream().map(Material::getKeyOrNull).filter(Objects::nonNull);
            } else {
                return Stream.empty();
            }
        }).forEach(set::add);
    }

    public boolean isMultiBlockPlant(@NotNull Material material) {
        return multiBlockPlant.contains(material.getKeyOrThrow());
    }

    public boolean isMultiBlockHangingPlant(@NotNull Material material) {
        return multiBlockHangingPlant.contains(material.getKeyOrThrow());
    }

    public boolean isAbilityActivationBlackListed(@NotNull Material material) {
        return abilityBlackList.contains(material.getKeyOrThrow());
    }

    public boolean isToolActivationBlackListed(@NotNull Material material) {
        return toolBlackList.contains(material.getKeyOrThrow());
    }

    public boolean isMossyWhiteListed(@NotNull Material material) {
        return mossyWhiteList.contains(material.getKeyOrThrow());
    }

    public boolean isTreeFellerDestructible(@NotNull Material material) {
        return treeFellerDestructibleWhiteList.contains(material.getKeyOrThrow());
    }

    public boolean isHerbalismAbilityWhiteListed(@NotNull Material material) {
        return herbalismAbilityBlackList.contains(material.getKeyOrThrow());
    }

    public boolean isBlockCrackerWhiteListed(@NotNull Material material) {
        return blockCrackerWhiteList.contains(material.getKeyOrThrow());
    }

    public boolean isShroomyWhiteListed(@NotNull Material material) {
        return canMakeShroomyWhiteList.contains(material.getKeyOrThrow());
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
    }

    private void fillArmors() {
        add(armors,
                Tag.ITEMS_HEAD_ARMOR,
                Tag.ITEMS_CHEST_ARMOR,
                Tag.ITEMS_LEG_ARMOR,
                Tag.ITEMS_FOOT_ARMOR
        );

        armors.forEach(key -> {
            switch (key.getKey().split("_")[0]) {
                case "leather" -> leatherArmor.add(key);
                case "iron" -> ironArmor.add(key);
                case "chainmail" -> chainmailArmor.add(key);
                case "golden" -> goldArmor.add(key);
                case "diamond" -> diamondArmor.add(key);
                case "netherite" -> netheriteArmor.add(key);
            }
        });
    }

    private void fillTools() {
        add(tools, Tag.ITEMS_HOES, Tag.ITEMS_PICKAXES, Tag.ITEMS_AXES, Tag.ITEMS_SWORDS, Tag.ITEMS_SHOVELS, "bow", "carrot_on_a_stick", "fishing_rod", "crossbow", "mace", "trident");

        tools.forEach(key -> {
            switch (key.getKey().split("_")[0]) {
                case "wooden" -> woodTools.add(key);
                case "stone" -> stoneTools.add(key);
                case "iron" -> ironTools.add(key);
                case "golden" -> goldTools.add(key);
                case "diamond" -> diamondTools.add(key);
                case "netherite" -> netheriteTools.add(key);
            }
        });

        add(ironTools, "bucket", "flint_and_steel", "shears");

        add(swords, Tag.ITEMS_SWORDS);
        add(axes, Tag.ITEMS_AXES);
        add(pickAxes, Tag.ITEMS_PICKAXES);
        add(hoes, Tag.ITEMS_HOES);
        add(shovels, Tag.ITEMS_SHOVELS);
        add(tridents, "trident");
        add(maces, "mace");
        add(stringTools, "bow", "fishing_rod", "carrot_on_a_stick", "crossbow");
        add(prismarineTools, "trident");
        add(bows, "bow");
        add(crossbows, "crossbow");
    }

    private void fillGlassBlockWhiteList() {
        add(glassBlocks, "glass",
                "glass_pane",
                "black_stained_glass",
                "black_stained_glass_pane",
                "blue_stained_glass",
                "blue_stained_glass_pane",
                "brown_stained_glass",
                "brown_stained_glass_pane",
                "cyan_stained_glass",
                "cyan_stained_glass_pane",
                "gray_stained_glass",
                "gray_stained_glass_pane",
                "green_stained_glass",
                "green_stained_glass_pane",
                "light_blue_stained_glass",
                "light_blue_stained_glass_pane",
                "light_gray_stained_glass",
                "light_gray_stained_glass_pane",
                "lime_stained_glass",
                "lime_stained_glass_pane",
                "magenta_stained_glass",
                "magenta_stained_glass_pane",
                "orange_stained_glass",
                "orange_stained_glass_pane",
                "pink_stained_glass",
                "pink_stained_glass_pane",
                "purple_stained_glass",
                "purple_stained_glass_pane",
                "red_stained_glass",
                "red_stained_glass_pane",
                "white_stained_glass",
                "white_stained_glass_pane",
                "yellow_stained_glass",
                "yellow_stained_glass_pane");
    }

    private void fillFoodWhiteList() {
        add(foodItemWhiteList, "apple",
                    "baked_potato",
                    "beetroot",
                    "beetroot_soup",
                    "bread",
                    "cake",
                    "carrot",
                    "chorus_fruit",
                    "cooked_chicken",
                    "cooked_cod",
                    "cooked_mutton",
                    "cooked_porkchop",
                    "cooked_rabbit",
                    "cooked_salmon",
                    "cookie",
                    "dried_kelp",
                    "golden_apple",
                    "enchanted_golden_apple",
                    "golden_carrot",
                    "melon_slice",
                    "mushroom_stew",
                    "poisonous_potato",
                    "potato",
                    "pumpkin_pie",
                    "rabbit_stew",
                    "raw_beef",
                    "raw_chicken",
                    "raw_cod",
                    "raw_mutton",
                    "raw_porkchop",
                    "raw_rabbit",
                    "raw_salmon",
                    "rotten_flesh",
                    "suspicious_stew",
                    "sweet_berries",
                    "tropical_fish");
    }

    /**
     * Checks if a Material is used for Armor
     *
     * @param material target material
     * @return true if it is used for armor
     */
    public boolean isArmor(@NotNull Material material) {
        return isArmor(material.getKeyOrThrow());
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

    public boolean isTool(@NotNull Material material) {
        return isTool(material.getKeyOrThrow());
    }

    public boolean isTool(@NotNull NamespacedKey id) {
        return tools.contains(id);
    }

    public boolean isEnchantable(@NotNull Material material) {
        return isEnchantable(material.getKeyOrThrow());
    }

    public boolean isEnchantable(NamespacedKey id) {
        return enchantables.contains(id);
    }

    public boolean isOre(@NotNull Material material) {
        return isOre(material.getKeyOrThrow());
    }

    public boolean isOre(@NotNull NamespacedKey id) {
        return ores.contains(id);
    }

    public boolean isBow(@NotNull Material material) {
        return isBow(material.getKeyOrThrow());
    }

    public boolean isBow(@NotNull NamespacedKey id) {
        return bows.contains(id);
    }

    public boolean isCrossbow(@NotNull Material material) {
        return isCrossbow(material.getKeyOrThrow());
    }

    public boolean isCrossbow(@NotNull NamespacedKey id) {
        return crossbows.contains(id);
    }

    public boolean isTrident(@NotNull Material material) {
        return isTrident(material.getKeyOrThrow());
    }

    public boolean isTrident(@NotNull NamespacedKey id) {
        return tridents.contains(id);
    }

    public boolean isMace(@NotNull Material material) {
        return isMace(material.getKeyOrThrow());
    }

    public boolean isMace(@NotNull NamespacedKey id) {
        return maces.contains(id);
    }

    public boolean isLeatherArmor(@NotNull Material material) {
        return isLeatherArmor(material.getKeyOrThrow());
    }

    public boolean isLeatherArmor(@NotNull NamespacedKey id) {
        return leatherArmor.contains(id);
    }

    public boolean isIronArmor(@NotNull Material material) {
        return isIronArmor(material.getKeyOrThrow());
    }

    public boolean isIronArmor(@NotNull NamespacedKey id) {
        return ironArmor.contains(id);
    }

    public boolean isGoldArmor(@NotNull Material material) {
        return isGoldArmor(material.getKeyOrThrow());
    }

    public boolean isGoldArmor(@NotNull NamespacedKey id) {
        return goldArmor.contains(id);
    }

    public boolean isDiamondArmor(@NotNull Material material) {
        return isDiamondArmor(material.getKeyOrThrow());
    }

    public boolean isDiamondArmor(@NotNull NamespacedKey id) {
        return diamondArmor.contains(id);
    }

    public boolean isChainmailArmor(@NotNull Material material) {
        return isChainmailArmor(material.getKeyOrThrow());
    }

    public boolean isChainmailArmor(@NotNull NamespacedKey id) {
        return chainmailArmor.contains(id);
    }

    public boolean isNetheriteArmor(@NotNull Material material) {
        return isNetheriteArmor(material.getKeyOrThrow());
    }

    public boolean isNetheriteArmor(@NotNull NamespacedKey id) {
        return netheriteArmor.contains(id);
    }

    public boolean isWoodTool(@NotNull Material material) {
        return isWoodTool(material.getKeyOrThrow());
    }

    public boolean isWoodTool(@NotNull NamespacedKey id) {
        return woodTools.contains(id);
    }

    public boolean isStoneTool(@NotNull Material material) {
        return isStoneTool(material.getKeyOrThrow());
    }

    public boolean isStoneTool(@NotNull NamespacedKey id) {
        return stoneTools.contains(id);
    }

    public boolean isIronTool(@NotNull Material material) {
        return isIronTool(material.getKeyOrThrow());
    }

    public boolean isIronTool(@NotNull NamespacedKey id) {
        return ironTools.contains(id);
    }

    public boolean isGoldTool(@NotNull Material material) {
        return isGoldTool(material.getKeyOrThrow());
    }

    public boolean isGoldTool(@NotNull NamespacedKey id) {
        return goldTools.contains(id);
    }

    public boolean isDiamondTool(@NotNull Material material) {
        return isDiamondTool(material.getKeyOrThrow());
    }

    public boolean isDiamondTool(@NotNull NamespacedKey id) {
        return diamondTools.contains(id);
    }

    public boolean isSword(@NotNull Material material) {
        return isSword(material.getKeyOrThrow());
    }

    public boolean isSword(@NotNull NamespacedKey id) {
        return swords.contains(id);
    }

    public boolean isAxe(@NotNull Material material) {
        return isAxe(material.getKeyOrThrow());
    }

    public boolean isAxe(@NotNull NamespacedKey id) {
        return axes.contains(id);
    }

    public boolean isPickAxe(@NotNull Material material) {
        return isPickAxe(material.getKeyOrThrow());
    }

    public boolean isPickAxe(@NotNull NamespacedKey id) {
        return pickAxes.contains(id);
    }

    public boolean isShovel(@NotNull Material material) {
        return isShovel(material.getKeyOrThrow());
    }

    public boolean isShovel(@NotNull NamespacedKey id) {
        return shovels.contains(id);
    }

    public boolean isHoe(@NotNull Material material) {
        return isHoe(material.getKeyOrThrow());
    }

    public boolean isHoe(@NotNull NamespacedKey id) {
        return hoes.contains(id);
    }

    public boolean isNetheriteTool(@NotNull Material material) {
        return isNetheriteTool(material.getKeyOrThrow());
    }

    public boolean isNetheriteTool(@NotNull NamespacedKey id) {
        return netheriteTools.contains(id);
    }

    public boolean isStringTool(@NotNull Material material) {
        return isStringTool(material.getKeyOrThrow());
    }

    public boolean isStringTool(@NotNull NamespacedKey id) {
        return stringTools.contains(id);
    }

    public boolean isPrismarineTool(@NotNull Material material) {
        return isPrismarineTool(material.getKeyOrThrow());
    }

    public boolean isPrismarineTool(@NotNull NamespacedKey id) {
        return prismarineTools.contains(id);
    }

    public boolean isGlass(@NotNull Material material) {
        return glassBlocks.contains(material.getKeyOrThrow());
    }

    public boolean isFood(@NotNull Material material) {
        return foodItemWhiteList.contains(material.getKeyOrThrow());
    }

    private void fillMultiBlockPlantSet() {
        //Multi-Block Plants
        add(multiBlockPlant, "cactus",
                "cactus_flower",
                "chorus_plant",
                "chorus_flower",
                "sugar_cane",
                "kelp_plant",
                "kelp",
                "tall_seagrass",
                "large_fern",
                "tall_grass",
                "bamboo");
    }

    private void fillMultiBlockHangingPlantSet() {
        add(multiBlockHangingPlant, "weeping_vines_plant",
                "twisted_vines_plant",
                "cave_vines_plant",
                "pale_hanging_moss");
    }

    private void fillShroomyWhiteList() {
        add(canMakeShroomyWhiteList, "dirt", "grass_block", "dirt_path");
    }

    private void fillBlockCrackerWhiteList() {
        add(blockCrackerWhiteList, "stone_bricks", "infested_stone_bricks");
    }

    private void fillHerbalismAbilityBlackList() {
        add(herbalismAbilityBlackList, "dirt",
                "grass_block",
                "dirt_path",
                "farmland");
    }

    private void fillTreeFellerDestructibleWhiteList() {
        add(treeFellerDestructibleWhiteList, "pale_hanging_moss",
                "oak_leaves",
                "cherry_leaves",
                "acacia_leaves",
                "birch_leaves",
                "dark_oak_leaves",
                "pale_oak_leaves",
                "jungle_leaves",
                "spruce_leaves",
                "azalea_leaves",
                "flowering_azalea_leaves",
                "mangrove_leaves",
                "mangrove_roots",
                "nether_wart_block",
                "warped_wart_block",
                "brown_mushroom_block",
                "red_mushroom_block");
    }

    private void fillMossyWhiteList() {
        add(mossyWhiteList, "cobblestone",
                "dirt",
                "grass_path",
                "stone_bricks",
                "cobblestone_wall");
    }

    private void fillAbilityBlackList() {
        add(abilityBlackList, "warped_fence_gate",
                                    "crimson_fence_gate",
                                    "warped_pressure_plate",
                                    "crimson_pressure_plate",
                                    "warped_button",
                                    "crimson_button",
                                    "warped_door",
                                    "crimson_door",
                                    "warped_trapdoor",
                                    "crimson_trapdoor",
                                    "black_bed",
                                    "blue_bed",
                                    "brown_bed",
                                    "cyan_bed",
                                    "gray_bed",
                                    "green_bed",
                                    "light_blue_bed",
                                    "light_gray_bed",
                                    "lime_bed",
                                    "magenta_bed",
                                    "orange_bed",
                                    "pink_bed",
                                    "purple_bed",
                                    "red_bed",
                                    "white_bed",
                                    "yellow_bed",
                                    "brewing_stand",
                                    "bookshelf",
                                    "cake",
                                    "chest",
                                    "dispenser",
                                    "enchanting_table",
                                    "ender_chest",
                                    "oak_fence_gate",
                                    "acacia_fence_gate",
                                    "dark_oak_fence_gate",
                                    "pale_oak_fence_gate",
                                    "spruce_fence_gate",
                                    "birch_fence_gate",
                                    "jungle_fence_gate",
                                    "furnace",
                                    "jukebox",
                                    "lever",
                                    "note_block",
                                    "stone_button",
                                    "oak_button",
                                    "birch_button",
                                    "acacia_button",
                                    "dark_oak_button",
                                    "pale_oak_button",
                                    "jungle_button",
                                    "spruce_button",
                                    "acacia_trapdoor",
                                    "birch_trapdoor",
                                    "dark_oak_trapdoor",
                                    "pale_oak_trapdoor",
                                    "jungle_trapdoor",
                                    "oak_trapdoor",
                                    "spruce_trapdoor",
                                    "acacia_sign",
                                    "acacia_wall_sign",
                                    "birch_sign",
                                    "birch_wall_sign",
                                    "dark_oak_sign",
                                    "pale_oak_sign",
                                    "dark_oak_wall_sign",
                                    "pale_oak_wall_sign",
                                    "jungle_sign",
                                    "jungle_wall_sign",
                                    "spruce_sign",
                                    "spruce_wall_sign",
                                    "oak_sign",
                                    "oak_wall_sign",
                                    "crafting_table",
                                    "beacon",
                                    "anvil",
                                    "dropper",
                                    "hopper",
                                    "trapped_chest",
                                    "iron_door",
                                    "iron_trapdoor",
                                    "oak_door",
                                    "acacia_door",
                                    "spruce_door",
                                    "birch_door",
                                    "jungle_door",
                                    "dark_oak_door",
                                    "pale_oak_door",
                                    "oak_fence",
                                    "acacia_fence",
                                    "dark_oak_fence",
                                    "pale_oak_fence",
                                    "birch_fence",
                                    "jungle_fence",
                                    "spruce_fence",
                                    "armor_stand",
                                    "black_shulker_box",
                                    "blue_shulker_box",
                                    "brown_shulker_box",
                                    "cyan_shulker_box",
                                    "gray_shulker_box",
                                    "green_shulker_box",
                                    "light_blue_shulker_box",
                                    "lime_shulker_box",
                                    "magenta_shulker_box",
                                    "orange_shulker_box",
                                    "pink_shulker_box",
                                    "purple_shulker_box",
                                    "red_shulker_box",
                                    "light_gray_shulker_box",
                                    "white_shulker_box",
                                    "yellow_shulker_box",
                                    "shulker_box",
                                    "wall_sign",
                                    "sign",
                                    "cartography_table",
                                    "grindstone",
                                    "lectern",
                                    "loom",
                                    "scaffolding",
                                    "smoker",
                                    "stonecutter",
                                    "sweet_berry_bush",
                                    "bell",
                                    "barrel",
                                    "blast_furnace",
                                    "campfire",
                                    "soul_campfire",
                                    "composter",
                                    "lodestone",
                                     "respawn_anchor");
    }

    private void fillToolBlackList() {
        add(toolBlackList, "chiseled_bookshelf",
            "black_bed",
            "blue_bed",
            "brown_bed",
            "cyan_bed",
            "gray_bed",
            "green_bed",
            "light_blue_bed",
            "light_gray_bed",
            "lime_bed",
            "magenta_bed",
            "orange_bed",
            "pink_bed",
            "purple_bed",
            "red_bed",
            "white_bed",
            "yellow_bed",
            "brewing_stand",
            "bookshelf",
            "cake",
            "chest",
            "dispenser",
            "enchanting_table",
            "ender_chest",
            "oak_fence_gate",
            "acacia_fence_gate",
            "dark_oak_fence_gate",
            "pale_oak_fence_gate",
            "spruce_fence_gate",
            "birch_fence_gate",
            "jungle_fence_gate",
            "furnace",
            "jukebox",
            "lever",
            "note_block",
            "stone_button",
            "oak_button",
            "birch_button",
            "acacia_button",
            "dark_oak_button",
            "pale_oak_button",
            "jungle_button",
            "spruce_button",
            "acacia_trapdoor",
            "birch_trapdoor",
            "dark_oak_trapdoor",
            "pale_oak_trapdoor",
            "jungle_trapdoor",
            "oak_trapdoor",
            "spruce_trapdoor",
            "crafting_table",
            "beacon",
            "anvil",
            "dropper",
            "hopper",
            "trapped_chest",
            "iron_door",
            "iron_trapdoor",
            "oak_door",
            "acacia_door",
            "spruce_door",
            "birch_door",
            "jungle_door",
            "dark_oak_door",
            "pale_oak_door",
            "oak_fence",
            "acacia_fence",
            "dark_oak_fence",
            "pale_oak_fence",
            "birch_fence",
            "jungle_fence",
            "spruce_fence",
            "armor_stand",
            "black_shulker_box",
            "blue_shulker_box",
            "brown_shulker_box",
            "cyan_shulker_box",
            "gray_shulker_box",
            "green_shulker_box",
            "light_blue_shulker_box",
            "lime_shulker_box",
            "magenta_shulker_box",
            "orange_shulker_box",
            "pink_shulker_box",
            "purple_shulker_box",
            "red_shulker_box",
            "light_gray_shulker_box",
            "white_shulker_box",
            "yellow_shulker_box",
            "shulker_box",
            "acacia_sign",
            "acacia_hanging_sign",
            "acacia_wall_sign",
            "birch_sign",
            "birch_hanging_sign",
            "birch_wall_sign",
            "dark_oak_sign",
            "pale_oak_sign",
            "dark_oak_hanging_sign",
            "pale_oak_hanging_sign",
            "dark_oak_wall_sign",
            "pale_oak_wall_sign",
            "jungle_sign",
            "jungle_hanging_sign",
            "jungle_wall_sign",
            "spruce_sign",
            "spruce_hanging_sign",
            "spruce_wall_sign",
            "oak_sign",
            "oak_hanging_sign",
            "oak_wall_sign",
            "cherry_sign",
            "cherry_hanging_sign",
            "cherry_wall_sign",
            "stripped_cherry_log",
            "stripped_cherry_wood",
            "stripped_acacia_log",
            "stripped_acacia_wood",
            "stripped_birch_log",
            "stripped_birch_wood",
            "stripped_dark_oak_log",
            "stripped_pale_oak_log",
            "stripped_dark_oak_wood",
            "stripped_pale_oak_wood",
            "stripped_jungle_log",
            "stripped_jungle_wood",
            "stripped_oak_log",
            "stripped_oak_wood",
            "stripped_spruce_log",
            "stripped_spruce_wood",
            "mangrove_wood",
            "mangrove_log",
            "stripped_mangrove_log",
            "acacia_log",
            "acacia_wood",
            "birch_log",
            "birch_wood",
            "dark_oak_log",
            "pale_oak_log",
            "dark_oak_wood",
            "pale_oak_wood",
            "jungle_log",
            "jungle_wood",
            "oak_log",
            "oak_wood",
            "spruce_log",
            "bell",
            "barrel",
            "blast_furnace",
            "campfire",
            "soul_campfire",
            "cartography_table",
            "composter",
            "grindstone",
            "lectern",
            "loom",
            "smoker",
            "stonecutter",
            "lodestone",
            "respawn_anchor",
            "sweet_berry_bush",
            "smithing_table");
    }

    public boolean isIntendedToolPickaxe(@NotNull Material material) {
        return intendedToolPickAxe.contains(material.getKeyOrThrow());
    }

    public boolean isIntendedToolPickaxe(@NotNull NamespacedKey string) {
        return intendedToolPickAxe.contains(string);
    }

    public @NotNull Set<NamespacedKey> getNetheriteArmor() {
        return netheriteArmor;
    }

    public @NotNull Set<NamespacedKey> getNetheriteTools() {
        return netheriteTools;
    }


    public int getTier(@NotNull Material material) {
        return getTier(material.getKeyOrThrow());
    }

    public int getTier(@NotNull NamespacedKey id) {
        return tierValue.getOrDefault(id, 1); //1 for unknown items
    }
}
