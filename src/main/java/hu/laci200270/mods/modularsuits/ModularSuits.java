package hu.laci200270.mods.modularsuits;

import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.common.modules.FeatherFallingModule;
import hu.laci200270.mods.modularsuits.common.modules.HealerModule;
import hu.laci200270.mods.modularsuits.common.modules.NightVisionModule;
import hu.laci200270.mods.modularsuits.common.modules.SpeedModule;
import hu.laci200270.mods.modularsuits.common.modules.WaterBreathingModule;
import hu.laci200270.mods.modularsuits.common.network.packets.PacketHandler;
import hu.laci200270.mods.modularsuits.proxys.CommonProxy;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.actors.threadpool.Arrays;
import codechicken.lib.packet.PacketCustom;

@Mod(modid = Reference.MODID)

public class ModularSuits {
@Instance
public static ModularSuits instance;
@SidedProxy(serverSide="hu.laci200270.mods.modularsuits.proxys.CommonProxy",clientSide="hu.laci200270.mods.modularsuits.proxys.ClientProxy")
public static CommonProxy proxy;
@EventHandler
public void preInit(FMLPreInitializationEvent event){
	PacketCustom.assignHandler(PacketHandler.channel, new PacketHandler());
}

@EventHandler
public void init(FMLInitializationEvent event){
	
	Reference.addBaseItems();
	Reference.addBaseBlocks();
	Reference.registerBlocks();
	Reference.addBaseTiles();
	Reference.registerTiles();
	
	NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
	Reference.addArmorElement(new HealerModule());
	Reference.addArmorElement(new FeatherFallingModule());
	Reference.addArmorElement(new SpeedModule());
	Reference.addArmorElement(new WaterBreathingModule());
	Reference.addArmorElement(new NightVisionModule());
	proxy.registerBasicItemRenderStuff(Reference.items);
	proxy.registerBlocksRenderer(Reference.blocks);
	GameRegistry.addRecipe(new ItemStack(Reference.armorChest),"i  i","iri","iii",'i',Items.iron_ingot,'r',Items.redstone);
	GameRegistry.addRecipe(new ItemStack(Reference.armorLeggings),"iri","i i","ii",'i',Items.iron_ingot,'r',Items.redstone);
	GameRegistry.addRecipe(new ItemStack(Reference.armorBoots),"r  r","i i",'i',Items.iron_ingot,'r',Items.redstone);
	GameRegistry.addRecipe(new ItemStack(Reference.armorHelmet),"iri","i i",'i',Items.iron_ingot,'r',Items.redstone);
	
	GameRegistry.addRecipe(new ItemStack(Reference.energyCrystal),"lel","ese","lel",'l',(new ItemStack(Items.dye, 1, 4)),'e',Items.emerald,'s',Items.nether_star);
	GameRegistry.addRecipe(new ItemStack(Reference.constructingTable), "d","c",'d',Items.diamond,'c',Items.diamond);
}
public static boolean applicabeTo(Integer id,ItemStack stack){
	Item[] targets=Reference.armorElements.get(id).applicableTo();
	if(Arrays.asList(targets).contains(stack.getItem())){
		return true;
	}
	
	return false;
}
}
