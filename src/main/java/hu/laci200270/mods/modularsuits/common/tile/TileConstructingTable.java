package hu.laci200270.mods.modularsuits.common.tile;

import hu.laci200270.mods.modularsuits.common.gui.ContainerConstructionTable;
import hu.laci200270.mods.modularsuits.common.items.ModularArmorItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class TileConstructingTable extends TileEntity implements IInventory{
	private ItemStack armorpiece=null;
	
	public TileConstructingTable() {
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "modularsuits.constructiontable";
	}

	 @Override
     public int getSizeInventory() {
             return 1;
     }

     @Override
     public ItemStack getStackInSlot(int slot) {
             return armorpiece;
     }
     
     @Override
     public void setInventorySlotContents(int slot, ItemStack stack) {
            armorpiece = stack;
             if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                     stack.stackSize = getInventoryStackLimit();
             }               
     }

     @Override
     public ItemStack decrStackSize(int slot, int amt) {
             ItemStack stack = getStackInSlot(slot);
             if (stack != null) {
                     if (stack.stackSize <= amt) {
                             setInventorySlotContents(slot, null);
                     } else {
                             stack = stack.splitStack(amt);
                             if (stack.stackSize == 0) {
                                     setInventorySlotContents(slot, null);
                             }
                     }
             }
             return stack;
     }

     @Override
     public ItemStack getStackInSlotOnClosing(int slot) {
             ItemStack stack = getStackInSlot(slot);
             if (stack != null) {
                     setInventorySlotContents(slot, null);
             }
             return stack;
     }
     
     @Override
     public int getInventoryStackLimit() {
             return 1;
     }

     @Override
     public boolean isUseableByPlayer(EntityPlayer player) {
             
    	 Integer xCoord=getPos().getX();
    	 Integer yCoord=getPos().getY();
    	 Integer zCoord=getPos().getZ();
		return worldObj.getTileEntity(getPos()) == this &&
             player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
     }

	
	 @Override
     public void readFromNBT(NBTTagCompound tagCompound) {
             super.readFromNBT(tagCompound);
             
             NBTTagList tagList = tagCompound.getTagList("Inventory",1);
             for (int i = 0; i < tagList.tagCount(); i++) {
                     NBTTagCompound tag = (NBTTagCompound) tagList.get(i);
                     
                   
                             armorpiece = ItemStack.loadItemStackFromNBT(tag);
                     
             }
     }

     @Override
     public void writeToNBT(NBTTagCompound tagCompound) {
             super.writeToNBT(tagCompound);
                             
             NBTTagList itemList = new NBTTagList();

			
                     ItemStack stack = armorpiece;
                     if (stack != null) {
                             NBTTagCompound tag = new NBTTagCompound();
                             tag.setByte("Slot", (byte) 1);
                             stack.writeToNBT(tag);
                             itemList.appendTag(tag);
                     
             }
             tagCompound.setTag("Inventory", itemList);
     }

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		if(stack.getItem() instanceof ModularArmorItem){
			return true;
		}
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	 public Container getGuiContainer (InventoryPlayer inventoryplayer, World world, int x, int y, int z)
	   {
	        return new ContainerConstructionTable(inventoryplayer, this);
	   }
	 
	
	
}
