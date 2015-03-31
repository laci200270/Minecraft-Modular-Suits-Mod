package hu.laci200270.mods.modularsuits;

import sun.nio.cs.ext.PCK;
import codechicken.lib.packet.PacketCustom;
import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.common.network.packets.PacketHandler;
import hu.laci200270.mods.modularsuits.proxys.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

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
	
	proxy.registerBasicItemRenderStuff(Reference.items);
}

}
