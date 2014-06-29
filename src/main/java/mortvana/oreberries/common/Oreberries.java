package mortvana.oreberries.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import mortvana.oreberries.world.OreberryWorldGenerator;
import net.minecraftforge.common.Configuration;

import java.io.File;
import java.util.logging.Logger;

@Mod(modid = "Oreberries", name = "Mortvana's Oreberries", version = "v1", dependencies = "required-after:Forge@[8.9,);")
@NetworkMod(serverSideRequired = false, clientSideRequired = true, channels = { "Oreberries" }, packetHandler = mortvana.oreberries.common.PacketHandler.class)
public class Oreberries {
    // Shared mod logger
    public static final Logger logger = Logger.getLogger("Oreberries");

    // Instance of this mod, used for grabbing prototype fields
    @Mod.Instance("Oreberries")
    public static Oreberries instance;
    // Proxies for sides, used for graphics processing
    @SidedProxy(clientSide = "mortvana.oreberries.client.ClientProxy", serverSide = "mortvana.oreberries.common.CommonProxy")
    public static CommonProxy proxy;

    public Oreberries(){
    }

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event){
        File config = new File(event.getModConfigurationDirectory() + "/Mortvana/Oreberries.cfg");
        OreberryConfig.init(new Configuration(config));
        OreberryConfig.setConfigFolderBase(event.getModConfigurationDirectory());

        content = new OreberryContent();
        content.oreRegistry();
        proxy.registerRenderer();

        GameRegistry.registerWorldGenerator(new OreberryWorldGenerator());
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event){
        content.intermodCommunication();
        OreberryTab.init(content.oreberries.itemID);
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event){
    }

    public static OreberryContent content;
}
