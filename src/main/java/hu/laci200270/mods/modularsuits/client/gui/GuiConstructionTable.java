package hu.laci200270.mods.modularsuits.client.gui;

import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.common.gui.ContainerConstructionTable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

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
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		Minecraft.getMinecraft().renderEngine.bindTexture(Reference.backgroundConstructionTable);
		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
		
	}

	
	
	
}
