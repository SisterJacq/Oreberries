package mortvana.oreberries.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class IngotItem extends SimpleItem{
    public static String[] names = new String[] { "copper", "tin", "aluminium", /*"essence"*/ };
    public static String[] tex= new String[] { "copper_ingot", "tin_ingot", "aluminium_ingot", /*"essence"*/ };

    public IngotItem(int id){
        super(id, names, tex, "ingots/");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        switch (stack.getItemDamage())
        {
            case 0:
                list.add(StatCollector.translateToLocal("ingot1.tooltip"));
                break;
            case 1:
                list.add(StatCollector.translateToLocal("ingot2.tooltip"));
                break;
            case 2:
                list.add(StatCollector.translateToLocal("ingot3.tooltip"));
                break;
        }
    }
}
