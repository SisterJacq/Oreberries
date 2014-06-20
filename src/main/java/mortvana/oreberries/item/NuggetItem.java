package mortvana.oreberries.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;

import java.util.List;

public class NuggetItem extends SimpleItem{
    public static String[] names = new String[]{"iron", "copper", "tin", "aluminium"};
    public static String[] tex = new String[]{"iron_nugget", "copper_nugget", "tin_nugget", "aluminium_nugget"};

    public NuggetItem(int id) {
        super(id, names, tex, "nuggets/");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        switch (stack.getItemDamage()) {
            case 0:
                list.add(StatCollector.translateToLocal("nugget1.tooltip"));
                break;
            case 1:
                list.add(StatCollector.translateToLocal("nugget2.tooltip"));
                break;
            case 2:
                list.add(StatCollector.translateToLocal("nugget3.tooltip"));
                break;
            case 3:
                list.add(StatCollector.translateToLocal("nugget4.tooltip"));
                break;
        }
    }
}