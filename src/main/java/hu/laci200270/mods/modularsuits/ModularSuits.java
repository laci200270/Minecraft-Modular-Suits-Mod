package hu.laci200270.mods.modularsuits;

import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.common.modules.FeatherFallingModule;
import hu.laci200270.mods.modularsuits.common.modules.HealerModule;
import hu.laci200270.mods.modularsuits.common.modules.SpeedModule;
import hu.laci200270.mods.modularsuits.common.network.packets.PacketHandler;
import hu.laci200270.mods.modularsuits.proxys.CommonProxy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
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
	proxy.registerBasicItemRenderStuff(Reference.items);
	
}
public static boolean applicabeTo(Integer id,ItemStack stack){
	Item[] targets=Reference.armorElements.get(id).applicableTo();
	if(Arrays.asList(targets).contains(stack.getItem())){
		return true;
	}
	
	return false;
}
}
