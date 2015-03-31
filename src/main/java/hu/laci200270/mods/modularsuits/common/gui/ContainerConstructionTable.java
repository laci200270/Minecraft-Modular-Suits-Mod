package hu.laci200270.mods.modularsuits.common.gui;

import hu.laci200270.mods.modularsuits.common.Reference;
import hu.laci200270.mods.modularsuits.common.tile.TileConstructingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerConstructionTable extends Container  {

	public ContainerConstructionTable(InventoryPlayer par1InventoryPlayer,TileConstructingTable tileEntity) {
		
		for (int i = 0; i < 3; i++)
		 {
			 for (int k = 0; k < 9; k++)
			 {
				 addSlotToContainer(new Slot(par1InventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			 }
		 }

		 for (int j = 0; j < 9; j++)
		 {
			 
			 addSlotToContainer(new Slot(par1InventoryPlayer, j, 8 + j * 18, 142));
		 }
		 addSlotToContainer(new ModularArmorSlot(tileEntity, 1, 12 , 33));
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}
	public void addSlot(Slot slot){
		addSlotToContainer(slot);
	}
	@Override
	protected boolean mergeItemStack(ItemStack stack, int startIndex,
			int endIndex, boolean useEndIndex) {
		Reference.logger.logWhenDebug("Merge stack: "+stack.getDisplayName());
		return super.mergeItemStack(stack, startIndex, endIndex, useEndIndex);
	}
	@Override
	   public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
	      Slot slotObject = (Slot) inventorySlots.get(slot);
	      if(slotObject != null && slotObject.getHasStack()) {
	         ItemStack stackInSlot = slotObject.getStack();
	         ItemStack stack = stackInSlot.copy();
	         if(slot <= 1) {
	            if(!mergeItemStack(stackInSlot, 1, inventorySlots.size(), true))
	               return null;
	         } else {
	            return null;
	         }

	         if(stackInSlot.stackSize == 0)
	            slotObject.putStack(null);
	         else
	            slotObject.onSlotChanged();

	         return stack;
	      }
	      return null;
	   }
	   
}
