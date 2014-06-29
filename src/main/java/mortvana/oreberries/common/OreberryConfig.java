package mortvana.oreberries.common;

import net.minecraftforge.common.Configuration;
import java.io.File;

public class OreberryConfig {

    public static File configFolder;
    private static Configuration config;

    public static void setConfigFolderBase(File folder){
        configFolder = new File(folder.getAbsolutePath() + "/Mortvana");
    }

    public static void init (Configuration config) {
        // Here we will set up the config file for the mod
        // First: Create a folder inside the config folder
        // Second: Create the actual config file
        // Note: Configs are a pain, but absolutely necessary for every mod.
        OreberryConfig.config = config;
        config.load();

        // Define the mod's IDs.
        // Avoid values below 4096 for items and in the 250-450 range for blocks
        oreberry = config.getBlock("Oreberry #1", 3000).getInt(3000);
        oreberry2 = config.getBlock("Oreberry #2", 3001).getInt(3001);
        oreberries = config.getItem("Oreberry Item", 25000).getInt(25000);
        ingot = config.getItem("Ingot Item", 25001).getInt(25001);
        nugget = config.getItem("Nugget Item", 25002).getInt(25002);

        netherBerries = config.get("Worldgen", "Spawn Oreberries in ALL Dimensions", false).getBoolean(false);
        dimensionalBerries = config.get("Worldgen", "Spawn Oreberries in all Overworld Dimensions", true).getBoolean(true);

        generateIronBush = config.get("Worldgen", "Generate Iron Bushes", true).getBoolean(true);
        generateGoldBush = config.get("Worldgen", "Generate Gold Bushes", true).getBoolean(true);
        generateCopperBush = config.get("Worldgen", "Generate Copper Bushes", true).getBoolean(true);
        generateTinBush = config.get("Worldgen", "Generate Tin Bushes", true).getBoolean(true);
        generateAluminiumBush = config.get("Worldgen", "Generate Aluminium Bushes", true).getBoolean(true);
        generateEssenceBush = config.get("Worldgen", "Generate Essence Bushes", true).getBoolean(true);

        ironBushDensity = config.get("Worldgen", "Iron Bush Density", 1).getInt(1);
        goldBushDensity = config.get("Worldgen", "Gold Bush Density", 1).getInt(1);
        copperBushDensity = config.get("Worldgen", "Copper Bush Density", 2).getInt(2);
        tinBushDensity = config.get("Worldgen", "Tin Bush Density", 2).getInt(2);
        aluminiumBushDensity = config.get("Worldgen", "Aluminium Bush Density", 2).getInt(2);
        silverBushDensity = config.get("Worldgen", "Silver Bush Density", 1).getInt(1);

        ironBushRarity = config.get("Worldgen", "Iron Bush Rarity", 5).getInt(5);
        goldBushRarity = config.get("Worldgen", "Gold Bush Rarity", 8).getInt(8);
        copperBushRarity = config.get("Worldgen", "Copper Bush Rarity", 3).getInt(3);
        tinBushRarity = config.get("Worldgen", "Tin Bush Rarity", 3).getInt(3);
        aluminiumBushRarity = config.get("Worldgen", "Aluminium Bush Rarity", 2).getInt(2);
        essenceBushRarity = config.get("Worldgen", "Essence Bush Rarity", 6).getInt(6);

        ironBushMinY = config.get("Worldgen", "Iron Bush Min Y", 32).getInt(32);
        ironBushMaxY = config.get("Worldgen", "Iron Bush Max Y", 64).getInt(64);
        goldBushMinY = config.get("Worldgen", "Gold Bush Min Y", 0).getInt(0);
        goldBushMaxY = config.get("Worldgen", "Gold Bush Max Y", 30).getInt(30);
        copperBushMinY = config.get("Worldgen", "Copper Bush Min Y", 20).getInt(20);
        copperBushMaxY = config.get("Worldgen", "Copper Bush Max Y", 60).getInt(60);
        tinBushMinY = config.get("Worldgen", "Tin Bush Min Y", 0).getInt(0);
        tinBushMaxY = config.get("Worldgen", "Tin Bush Max Y", 40).getInt(40);
        aluminiumBushMinY = config.get("Worldgen", "Aluminium Bush Min Y", 0).getInt(0);
        aluminiumBushMaxY = config.get("Worldgen", "Aluminium Bush Max Y", 60).getInt(60);
        essenceBushMinY = config.get("Worldgen", "Essence Bush Min Y", 0).getInt(0);
        essenceBushMaxY = config.get("Worldgen", "Essence Bush Max Y", 60).getInt(60);
    }

    public static int oreberry;
    public static int oreberry2;

    public static int oreberries;
    public static int nugget;
    public static int ingot;

    public static boolean netherBerries;
    public static boolean dimensionalBerries;

    public static boolean generateIronBush;
    public static boolean generateGoldBush;
    public static boolean generateCopperBush;
    public static boolean generateTinBush;
    public static boolean generateAluminiumBush;
    public static boolean generateEssenceBush;

    public static int ironBushDensity;
    public static int goldBushDensity;
    public static int copperBushDensity;
    public static int tinBushDensity;
    public static int aluminiumBushDensity;
    public static int silverBushDensity;

    public static int ironBushRarity;
    public static int goldBushRarity;
    public static int copperBushRarity;
    public static int tinBushRarity;
    public static int aluminiumBushRarity;
    public static int essenceBushRarity;

    public static int ironBushMinY;
    public static int ironBushMaxY;
    public static int goldBushMinY;
    public static int goldBushMaxY;
    public static int copperBushMinY;
    public static int copperBushMaxY;
    public static int tinBushMinY;
    public static int tinBushMaxY;
    public static int aluminiumBushMinY;
    public static int aluminiumBushMaxY;
    public static int essenceBushMinY;
    public static int essenceBushMaxY;
}
