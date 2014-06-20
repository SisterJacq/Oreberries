package mortvana.oreberries.common;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import mortvana.oreberries.block.OreberryBush;
import mortvana.oreberries.block.OreberryBushTwo;
import mortvana.oreberries.item.IngotItem;
import mortvana.oreberries.item.NuggetItem;
import mortvana.oreberries.item.OreberryItem;
import mortvana.oreberries.item.block.OreberryBush2Item;
import mortvana.oreberries.item.block.OreberryBushItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class OreberryContent {
    public static Item oreberries;
    public static Item nugget;
    public static Item ingot;

    public static OreberryBush oreberry;
    public static OreberryBush oreberry2;

    public OreberryContent(){
        registerItems();
        registerBlocks();
        addCraftingRecipes();
    }

    void registerBlocks(){
        String[] berryOres = new String[] { "berry_iron", "berry_gold", "berry_copper", "berry_tin", "berry_iron_ripe", "berry_gold_ripe", "berry_copper_ripe", "berry_tin_ripe" };
        oreberry = (OreberryBush) new OreberryBush(OreberryConfig.oreberry, berryOres, 0, 4, new String[] { "oreIron", "oreGold", "oreCopper", "oreTin" }).setUnlocalizedName("oreberries.one");
        GameRegistry.registerBlock(oreberry, OreberryBushItem.class, "oreberries.one");
        String[] berryOresTwo = new String[] { "berry_aluminium", "berry_essence", "", "", "berry_aluminium_ripe", "berry_essence_ripe", "", "" };
        oreberry2 = (OreberryBush) new OreberryBushTwo(OreberryConfig.oreberry2, berryOresTwo, 4, 2, new String[] { "oreAluminium", "oreEssence" }).setUnlocalizedName("oreberries.two");
        GameRegistry.registerBlock(oreberry2, OreberryBush2Item.class, "oreberries.two");
    }

    void registerItems(){
        oreberries = new OreberryItem(OreberryConfig.oreberries).setUnlocalizedName("oreberry");
        GameRegistry.registerItem(oreberries, "oreberries");
        nugget = new NuggetItem(OreberryConfig.nugget).setUnlocalizedName("oreberryNugget");
        GameRegistry.registerItem(nugget, "nugget");
        ingot = new IngotItem(OreberryConfig.ingot).setUnlocalizedName("oreberryIngot");
        GameRegistry.registerItem(ingot, "ingot");
    }

    private void addCraftingRecipes(){
        String[] patternFull = { "###", "###", "###" };
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.ingotIron), patternFull, '#', "nuggetIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.ingotGold), patternFull, '#', "nuggetGold"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot, 1, 2), patternFull, '#', "nuggetCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot, 1, 3), patternFull, '#', "nuggetTin"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot, 1, 4), patternFull, '#', "nuggetAluminium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot, 1, 4), patternFull, '#', "nuggetAluminum"));
    }

    public void oreRegistry() {
        ensureOreIsRegistered("ingotIron", new ItemStack(Item.ingotIron));
        ensureOreIsRegistered("ingotGold", new ItemStack(Item.ingotGold));
        ensureOreIsRegistered("nuggetGold", new ItemStack(Item.goldNugget));

        OreDictionary.registerOre("nuggetIron", new ItemStack(nugget, 1, 0));
        OreDictionary.registerOre("nuggetCopper", new ItemStack(nugget, 1, 2));
        OreDictionary.registerOre("nuggetTin", new ItemStack(nugget, 1, 3));
        OreDictionary.registerOre("nuggetAluminium", new ItemStack(nugget, 1, 4));
        OreDictionary.registerOre("nuggetAluminum", new ItemStack(nugget, 1, 4));

        OreDictionary.registerOre("nuggetIron", new ItemStack(oreberries, 1, 0));
        OreDictionary.registerOre("nuggetGold", new ItemStack(oreberries, 1, 1));
        OreDictionary.registerOre("nuggetCopper", new ItemStack(oreberries, 1, 1));
        OreDictionary.registerOre("nuggetTin", new ItemStack(oreberries, 1, 3));
        OreDictionary.registerOre("nuggetAluminium", new ItemStack(oreberries, 1, 4));
        OreDictionary.registerOre("nuggetAluminum", new ItemStack(oreberries, 1, 4));
        OreDictionary.registerOre("nuggetEssence", new ItemStack(oreberries, 1, 5));

        OreDictionary.registerOre("oreberryIron", new ItemStack(oreberries, 1, 0));
        OreDictionary.registerOre("oreberryGold", new ItemStack(oreberries, 1, 0));
        OreDictionary.registerOre("oreberryCopper", new ItemStack(oreberries, 1, 0));
        OreDictionary.registerOre("oreberryTin", new ItemStack(oreberries, 1, 0));
        OreDictionary.registerOre("oreberryAluminium", new ItemStack(oreberries, 1, 0));
        OreDictionary.registerOre("oreberryAluminum", new ItemStack(oreberries, 1, 0));
        OreDictionary.registerOre("oreberryEssence", new ItemStack(oreberries, 1, 0));

        OreDictionary.registerOre("ingotCopper", new ItemStack(ingot, 1, 0));
        OreDictionary.registerOre("ingotTin", new ItemStack(ingot, 1, 1));
        OreDictionary.registerOre("ingotAluminium", new ItemStack(ingot, 1, 2));
        OreDictionary.registerOre("ingotAluminum", new ItemStack(ingot, 1, 2));

    }

    private void ensureOreIsRegistered (String oreName, ItemStack is)
    {
        int oreId = OreDictionary.getOreID(is);
        if (oreId == -1)
        {
            OreDictionary.registerOre(oreName, is);
        }
    }

    public static boolean thaumcraftAvailable;

    public void intermodCommunication () {
        if (Loader.isModLoaded("Thaumcraft")) {
            FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(oreberry, 1, 12));
            FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(oreberry, 1, 13));
            FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(oreberry, 1, 14));
            FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(oreberry, 1, 15));
            FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(oreberry2, 1, 12));
            FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(oreberry2, 1, 13));
        }
    }
}
