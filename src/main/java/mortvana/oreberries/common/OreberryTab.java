package mortvana.oreberries.common;

import net.minecraft.creativetab.CreativeTabs;

public class OreberryTab extends CreativeTabs{

    public static OreberryTab tabOreberries = new OreberryTab("oreberries");
    static boolean hasInit;
    static int icon;

    public OreberryTab(String name)
    {
        super(name);
    }

    public static void init (int index)
    {
        if (!hasInit)
        {
            hasInit = true;
            icon = index;
        }
    }

    public int getTabIconItemIndex ()
    {
        return icon;
    }
}
