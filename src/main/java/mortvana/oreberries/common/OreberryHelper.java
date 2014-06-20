package mortvana.oreberries.common;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.FakePlayer;

public class OreberryHelper {
    public static void spawnItemAtPlayer (EntityPlayer player, ItemStack stack)
    {
        if (!player.worldObj.isRemote)
        {
            EntityItem entityitem = new EntityItem(player.worldObj, player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, stack);
            player.worldObj.spawnEntityInWorld(entityitem);
            if (!(player instanceof FakePlayer))
                entityitem.onCollideWithPlayer(player);
        }
    }

}
