package hu.laci200270.mods.modularsuits.client.gui;

import hu.laci200270.mods.modularsuits.api.IArmorElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.config.HoverChecker;

public class ModuleAddButton extends GuiButton {
	
	private ItemStack stack;
	private IArmorElement element;
	/***
	 * @param buttonId
	 * @param x
	 * @param y
	 * @param widthIn
	 * @param heightIn
	 * @param stack The itemstack which rendered
	 *
	 */
	
	public ModuleAddButton(int buttonId, int x, int y, int widthIn,
			int heightIn, ItemStack stack,IArmorElement element) {
		super(buttonId, x, y, widthIn, heightIn, "");
		this.stack=new ItemStack(element.icon());
		this.element=element;
		
		
	}
	
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		
		
		RenderItem renderItem=mc.getRenderItem();
		
        mc.getTextureManager().bindTexture(buttonTextures);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
        int k = this.getHoverState(this.hovered);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.blendFunc(770, 771);
        this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
        this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
        this.mouseDragged(mc, mouseX, mouseY);
        
        renderItem.renderItemIntoGUI(stack, xPosition+2, yPosition+1);
        new HoverChecker(this, 1).checkHover(mouseX, mouseY);
        
	}
	@Override
	public void drawButtonForegroundLayer(int mouseX, int mouseY) {
		
	}


	public IArmorElement getElement() {
		// TODO Auto-generated method stub
		return element;
	}
	
}
