package mortvana.oreberries.world;

import cpw.mods.fml.common.IWorldGenerator;
import mortvana.oreberries.common.OreberryConfig;
import mortvana.oreberries.common.OreberryContent;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Random;

public class OreberryWorldGenerator implements IWorldGenerator
{
    public OreberryWorldGenerator()
    {
        ironBush = new OreberryBushGen(OreberryContent.oreberry.blockID, 12, 12);
        goldBush = new OreberryBushGen(OreberryContent.oreberry.blockID, 13, 6);
        copperBush = new OreberryBushGen(OreberryContent.oreberry.blockID, 14, 12);
        tinBush = new OreberryBushGen(OreberryContent.oreberry.blockID, 15, 12);
        aluminiumBush = new OreberryBushGen(OreberryContent.oreberry2.blockID, 12, 14);
        essenceBush = new OreberryBushGen(OreberryContent.oreberry2.blockID, 13, 8);
    }

    @Override
    public void generate (Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {

        if  (OreberryConfig.netherBerries ==  true){
            generateOreBushes(random, chunkX * 16, chunkZ * 16, world);
        }

        else if  (OreberryConfig.dimensionalBerries && world.provider.terrainType != WorldType.FLAT){
            BiomeGenBase biomeGenBase = world.getBiomeGenForCoords(chunkX * 16, chunkZ * 16);
            BiomeDictionary.Type[] types = BiomeDictionary.getTypesForBiome(biomeGenBase);
            for (int i = 0; i < types.length; i++) {
                if(biomeGenBase == null){
                    return;
                }
                if (types[i] == BiomeDictionary.Type.NETHER || types[i] == BiomeDictionary.Type.END || types[i] == null) {
                    return; // Exits the generation function
                }
            }
            generateOreBushes(random, chunkX * 16, chunkZ * 16, world);
        }

        else if (world.provider.dimensionId == 0 && world.provider.terrainType != WorldType.FLAT)
        {
            generateOreBushes(random, chunkX * 16, chunkZ * 16, world);
        }
    }

    void generateOreBushes (Random random, int xChunk, int zChunk, World world)
    {
        int xPos, yPos, zPos;
        if (OreberryConfig.generateIronBush && random.nextInt(OreberryConfig.ironBushRarity + 1) == 0)
        {
            for (int i = 0; i < OreberryConfig.ironBushDensity; i++)
            {
                xPos = xChunk + random.nextInt(16);
                yPos = (OreberryConfig.ironBushMaxY + OreberryConfig.ironBushMinY) / 2;
                zPos = zChunk + random.nextInt(16);
                yPos = findAdequateLocation(world, xPos, yPos, zPos, OreberryConfig.ironBushMaxY, OreberryConfig.ironBushMinY);
                if (yPos != -1)
                {
                    ironBush.generate(world, random, xPos, yPos, zPos);
                }
            }
        }
        if (OreberryConfig.generateGoldBush && random.nextInt(OreberryConfig.goldBushRarity + 1) == 0)
        {
            for (int i = 0; i < OreberryConfig.goldBushDensity; i++)
            {
                xPos = xChunk + random.nextInt(16);
                yPos = 16;
                zPos = zChunk + random.nextInt(16);
                yPos = findAdequateLocation(world, xPos, yPos, zPos, 32, 0);
                if (yPos != -1)
                {
                    goldBush.generate(world, random, xPos, yPos, zPos);
                }
            }
        }
        if (OreberryConfig.generateCopperBush && random.nextInt(OreberryConfig.copperBushRarity + 1) == 0)
        {
            for (int i = 0; i < OreberryConfig.copperBushDensity; i++)
            {
                xPos = xChunk + random.nextInt(16);
                yPos = (OreberryConfig.copperBushMaxY + OreberryConfig.copperBushMinY) / 2;
                zPos = zChunk + random.nextInt(16);
                yPos = findAdequateLocation(world, xPos, yPos, zPos, OreberryConfig.copperBushMaxY, OreberryConfig.copperBushMinY);
                if (yPos != -1)
                {
                    copperBush.generate(world, random, xPos, yPos, zPos);
                }
            }
        }
        if (OreberryConfig.generateTinBush && random.nextInt(OreberryConfig.tinBushRarity + 1) == 0)
        {
            for (int i = 0; i < OreberryConfig.tinBushDensity; i++)
            {
                xPos = xChunk + random.nextInt(16);
                yPos = (OreberryConfig.tinBushMaxY + OreberryConfig.tinBushMinY) / 2;
                zPos = zChunk + random.nextInt(16);
                yPos = findAdequateLocation(world, xPos, yPos, zPos, OreberryConfig.tinBushMaxY, OreberryConfig.tinBushMinY);
                if (yPos != -1)
                {
                    tinBush.generate(world, random, xPos, yPos, zPos);
                }
            }
        }
        if (OreberryConfig.generateAluminiumBush && random.nextInt(OreberryConfig.aluminiumBushRarity + 1) == 0)
        {
            for (int i = 0; i < OreberryConfig.aluminiumBushDensity; i++)
            {
                xPos = xChunk + random.nextInt(16);
                yPos = (OreberryConfig.aluminiumBushMaxY + OreberryConfig.aluminiumBushMinY) / 2;
                zPos = zChunk + random.nextInt(16);
                yPos = findAdequateLocation(world, xPos, yPos, zPos, OreberryConfig.aluminiumBushMaxY, OreberryConfig.aluminiumBushMinY);
                if (yPos != -1)
                {
                    aluminiumBush.generate(world, random, xPos, yPos, zPos);
                }
            }
        }
        if (OreberryConfig.generateEssenceBush && random.nextInt(OreberryConfig.essenceBushRarity) == 0)
        {
            for (int i = 0; i < OreberryConfig.silverBushDensity; i++)
            {
                xPos = xChunk + random.nextInt(16);
                yPos = 48;
                zPos = zChunk + random.nextInt(16);
                yPos = findAdequateLocation(world, xPos, yPos, zPos, 32, 0);
                if (yPos != -1)
                {
                    essenceBush.generate(world, random, xPos, yPos, zPos);
                }
            }
        }
    }

    int findAdequateLocation (World world, int x, int y, int z, int heightLimit, int depthLimit)
    {
        int height = y;
        do
        {
            if (world.getBlockId(x, height, z) == 0 && world.getBlockId(x, height + 1, z) != 0)
                return height + 1;
            height++;
        } while (height < heightLimit);

        height = y;
        do
        {
            if (world.getBlockId(x, height, z) == 0 && world.getBlockId(x, height - 1, z) != 0)
                return height - 1;
            height--;
        } while (height > depthLimit);

        return -1;
    }

    OreberryBushGen ironBush;
    OreberryBushGen goldBush;
    OreberryBushGen copperBush;
    OreberryBushGen tinBush;
    OreberryBushGen aluminiumBush;
    OreberryBushGen essenceBush;
}