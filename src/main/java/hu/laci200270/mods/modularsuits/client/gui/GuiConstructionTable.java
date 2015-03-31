package hu.laci200270.mods.modularsuits.client.gui;

import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.common.gui.ContainerConstructionTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiConstructionTable extends GuiContainer {

	public GuiConstructionTable(InventoryPlayer playerInv) {
	
		
        super(new ContainerConstructionTable(playerInv));
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

	
	
	
}
