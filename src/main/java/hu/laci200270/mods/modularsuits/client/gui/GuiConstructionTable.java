package hu.laci200270.mods.modularsuits.client.gui;

import java.io.IOException;

import codechicken.lib.packet.PacketCustom;
import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.common.gui.ContainerConstructionTable;
import hu.laci200270.mods.modularsuits.common.network.packets.PacketHandler;
import hu.laci200270.mods.modularsuits.common.tile.TileConstructingTable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class GuiConstructionTable extends GuiContainer {

	private int x;
	private int y;
	private int z;
	public GuiConstructionTable(InventoryPlayer playerInv,TileConstructingTable tile, World world, int x, int y, int z) {
	
		
        super(new ContainerConstructionTable(playerInv,tile));
        if(tile==null)
		{
        	Reference.logger.logWhenDebug("Null");
        	Minecraft.getMinecraft().crashed(new CrashReport("The tile entity is null", new NullPointerException()));
		}
        this.x=x;
        this.y=y;
        this.z=z;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		int cornerX = (width - xSize) / 2 ;
        int cornerY = (height - ySize) / 2;
		this.buttonList.add(new ModuleAddButton(0, cornerX+10, cornerY+10, 20, 20, new ItemStack(Items.golden_apple)));
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks,
			int mouseX, int mouseY) {
		
		 this.mc.getTextureManager().bindTexture(Reference.backgroundConstructionTable);
	        int cornerX = (width - xSize) / 2 ;
	        int cornerY = (height - ySize) / 2;
	        drawTexturedModalRect(cornerX , cornerY, 0, 0, 176, ySize);
		
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		// TODO Auto-generated method stub
		if(button.id==0){
			PacketCustom packet= new PacketCustom(PacketHandler.channel, 1);
			packet.writeInt(button.id);
			NBTTagCompound tag=new NBTTagCompound();
			tag.setInteger("x", x);
			tag.setInteger("y", y);
			tag.setInteger("z", z);
			packet.writeNBTTagCompound(tag);
		}
	}
	
	
	
}
