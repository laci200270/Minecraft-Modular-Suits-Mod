package hu.laci200270.mods.modularsuits.common.gui;

import hu.laci200270.mods.modularsuits.common.items.ModularArmorItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ModularArmorSlot extends Slot {

	public ModularArmorSlot(IInventory inventoryIn, int index, int xPosition,
			int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		
		if(stack.getItem() instanceof ModularArmorItem){
			return true;
		}
		return false;
		
		
	}

}
