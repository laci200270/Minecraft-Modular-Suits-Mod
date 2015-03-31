package hu.laci200270.mods.modularsuits.common.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;

public class ContainerConstructionTable extends Container  {

	public ContainerConstructionTable(InventoryPlayer par1InventoryPlayer) {
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
		 
		 addSlotToContainer(new Slot(new IInventory() {
			
			@Override
			public boolean hasCustomName() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public IChatComponent getDisplayName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void setInventorySlotContents(int index, ItemStack stack) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setField(int id, int value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void openInventory(EntityPlayer player) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void markDirty() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isUseableByPlayer(EntityPlayer player) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isItemValidForSlot(int index, ItemStack stack) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ItemStack getStackInSlotOnClosing(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ItemStack getStackInSlot(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getSizeInventory() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getInventoryStackLimit() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getFieldCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getField(int id) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public ItemStack decrStackSize(int index, int count) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void closeInventory(EntityPlayer player) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
		}, 20, 600, 700));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}
	public void addSlot(Slot slot){
		addSlotToContainer(slot);
	}

}
