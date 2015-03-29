package hu.laci200270.mods.modularsuits.common.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerConstructionTable extends Container {

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
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}

}
