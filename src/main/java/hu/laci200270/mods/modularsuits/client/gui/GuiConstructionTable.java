package hu.laci200270.mods.modularsuits.client.gui;

import hu.laci200270.mods.modularsuits.api.IArmorElement;
import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.common.gui.ContainerConstructionTable;
import hu.laci200270.mods.modularsuits.common.items.ModularArmorItem;
import hu.laci200270.mods.modularsuits.common.network.packets.PacketHandler;
import hu.laci200270.mods.modularsuits.common.tile.TileConstructingTable;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import codechicken.lib.packet.PacketCustom;

public class GuiConstructionTable extends GuiContainer {

	public int x;
	public int y;
	public int z;
	private int currentLine=1;
	private int currentColumn=1;
	int currentButtonId=0;
	
	private EntityPlayer player;
	private TileConstructingTable tile;
	public GuiConstructionTable(EntityPlayer player,InventoryPlayer playerInv,TileConstructingTable tile, World world, int x, int y, int z) {
	
		
        super(new ContainerConstructionTable(playerInv,tile));
        if(tile==null)
		{
        	Reference.logger.logWhenDebug("Null");
        	Minecraft.getMinecraft().crashed(new CrashReport("The tile entity is null", new NullPointerException()));
		}
        this.x=x;
        this.y=y;
        this.z=z;
        this.player=player;
        this.tile=tile;
       
	}
	
	

	@Override
	public void initGui() {
		super.initGui();
		resetProgress(); 
		for (IArmorElement element : Reference.armorElements) {
	        	Reference.logger.logWhenDebug("Currently adding: "+currentButtonId +"id and name is: "+element.getClass().getName());
	        	addModuleButton(element);
	        }
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
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
		
		
		if(button.id==0){
		if(tile.armorpiece!=null&&tile.armorpiece.getItem() instanceof ModularArmorItem ){
			if(tile.armorpiece.getTagCompound()==null){
				tile.armorpiece.setTagCompound(new NBTTagCompound());
			}
			if(!tile.armorpiece.getTagCompound().getBoolean(Reference.armorElements.get(button.id).getUnlocalizedName())){
				PacketCustom packet= new PacketCustom(PacketHandler.channel, 1);
				packet.writeInt(button.id);
				NBTTagCompound tag=new NBTTagCompound();
				tag.setInteger("x", x);
				tag.setInteger("y", y);
				tag.setInteger("z", z);
				tag.setString("player", player.getName());
				packet.writeNBTTagCompound(tag);
				packet.sendToServer();
			}
		}}
		
	}
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	private void addModuleButton(IArmorElement element){
		int cornerX = (width - xSize) / 2 ;
        int cornerY = (height - ySize) / 2;
		
		this.buttonList.add(new ModuleAddButton(currentButtonId, cornerX+currentColumn*25, cornerY+10+currentLine*25, 20, 20, new ItemStack(element.icon())));
		Reference.logger.logWhenDebug("Current button id: "+currentButtonId+ "X-cord:"+cornerX+10+currentColumn*25+"Y-cord: "+ cornerY+1+currentLine*25);
		incrementCurrent();
		
		currentButtonId++;
	}
	private void incrementCurrent(){
		if(currentColumn==5){
			currentLine++;
			currentColumn=1;
		}
		else currentColumn++;
	}
	private void resetProgress(){
		currentButtonId=0;
		currentLine=1;
		currentColumn=1;
	}
	
}
