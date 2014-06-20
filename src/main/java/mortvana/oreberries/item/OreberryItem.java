package mortvana.oreberries.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class OreberryItem extends SimpleItem {
    public static String[] names = new String[] { "iron", "gold", "copper", "tin", "aluminium", "essence" };
    public static String[] tex = new String[] { "iron_oreberry", "gold_oreberry", "copper_oreberry", "tin_oreberry", "aluminium_oreberry", "essence_oreberry" };

    public OreberryItem(int id)
    {
        super(id, names, tex, "oreberries/");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        switch (stack.getItemDamage())
        {
            case 0:
                list.add(StatCollector.translateToLocal("oreberries1.tooltip"));
                break;
            case 1:
                list.add(StatCollector.translateToLocal("oreberries2.tooltip"));
                break;
            case 2:
                list.add(StatCollector.translateToLocal("oreberries3.tooltip"));
                break;
            case 3:
                list.add(StatCollector.translateToLocal("oreberries4.tooltip"));
                break;
            case 4:
                list.add(StatCollector.translateToLocal("oreberries5.tooltip"));
                break;
            case 5:
                list.add(StatCollector.translateToLocal("oreberries6.tooltip"));
                break;
        }
    }

    @Override
    public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player)
    {
        if (stack.getItemDamage() == 5)
        {
            EntityXPOrb entity = new EntityXPOrb(world, player.posX, player.posY + 1, player.posZ, itemRand.nextInt(14) + 6);
            spawnEntity(player.posX, player.posY + 1, player.posZ, entity, world, player);
            if (!player.capabilities.isCreativeMode)
                stack.stackSize--;
        }
        return stack;
    }

    public static void spawnEntity (double x, double y, double z, Entity entity, World world, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            world.spawnEntityInWorld(entity);
        }
    }

}