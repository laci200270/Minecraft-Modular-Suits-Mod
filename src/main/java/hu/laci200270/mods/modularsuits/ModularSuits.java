package hu.laci200270.mods.modularsuits;

import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.proxys.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MODID)

public class ModularSuits {
@Instance
public static ModularSuits instance;
@SidedProxy(serverSide="hu.laci200270.mods.modularsuits.proxys.CommonProxy",clientSide="hu.laci200270.mods.modularsuits.proxys.ClientProxy")
public static CommonProxy proxy;
@EventHandler
public void init(FMLInitializationEvent event){
	//System.out.println("init");
	Reference.addBaseItems();
	//Reference.registerItems();
	Reference.addBaseBlocks();
	Reference.registerBlocks();
	NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
	proxy.registerBasicItemRenderStuff(Reference.items);
}

}
