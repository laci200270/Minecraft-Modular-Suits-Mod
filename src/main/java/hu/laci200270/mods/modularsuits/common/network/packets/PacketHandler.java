package hu.laci200270.mods.modularsuits.common.network.packets;

import hu.laci200270.mods.modularsuits.api.IArmorElement;
import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.common.items.ModularArmorItem;
import hu.laci200270.mods.modularsuits.common.tile.TileConstructingTable;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import codechicken.lib.packet.PacketCustom;
import codechicken.lib.packet.PacketCustom.IServerPacketHandler;
public class PacketHandler implements IServerPacketHandler{

public static final Object channel = "constructiontable";


@Override
public void handlePacket(PacketCustom packet, EntityPlayerMP player, INetHandlerPlayServer netHandler) {
	Reference.logger.logWhenDebug("Packet got!");
	switch (packet.getType()) {
 case 1:
  Reference.logger.logWhenDebug("Control got!");
	 Integer target=packet.readInt();
  NBTTagCompound nbttag= packet.readNBTTagCompound();
  player=MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(nbttag.getString("player"));
  Reference.logger.logWhenDebug("Player's name: "+nbttag.getString("player"));
  BlockPos tilePos=new BlockPos(nbttag.getInteger("x"),nbttag.getInteger("y") , nbttag.getInteger("z"));
  TileEntity tile = player.getEntityWorld().getTileEntity(tilePos);
  //World world=player.getEntityWorld();
  
  if(tile==null){
  	Reference.logger.logWhenDebug("null");
  }
  if (tile != null && tile instanceof TileConstructingTable)
  {
	  TileConstructingTable tile2=(TileConstructingTable) tile;
	  Reference.logger.logWhenDebug("instanceof");
		if(tile2.armorpiece!=null&&tile2.armorpiece.getItem() instanceof ModularArmorItem ){
			if(!tile2.armorpiece.getTagCompound().getBoolean(Reference.armorElements.get(target).getUnlocalizedName())){
				
			
		
	tile2.armorpiece.getTagCompound().setBoolean(Reference.armorElements.get(target).getUnlocalizedName(),true);
	//InventoryPlayer invplayer=player.inventory;
	Reference.logger.logWhenDebug("inventory ok");
	Reference.logger.logWhenDebug("Target: "+target);
    Boolean okay=true;
    IArmorElement[] modules=null;
    modules=(IArmorElement[]) Reference.armorElements.toArray(new IArmorElement[Reference.armorElements.size()]);
    Reference.logger.logWhenDebug("array ok");
    ItemStack[] recipe=modules[target].recipe();
    for (int i = 0; i < recipe.length; i++) {
		if(!Reference.simulateConsumeItems(player.inventory, recipe[i].getItem(), recipe[i].stackSize)){
			Reference.logger.logWhenDebug("loop ok");
			okay=false;
		}
	}
    if(!okay){
    	return ;
    }
   
    for (int i = 0; i < recipe.length; i++) {
		if(!Reference.consumeItems(player.inventory, recipe[i].getItem(), recipe[i].stackSize)){
			Reference.logger.logWhenDebug("loop ok");
			okay=false;
		}
	}
   
    Reference.logger.logWhenDebug("Status: "+okay);
  }
  break;
 }}}
}}
