package hu.laci200270.mods.modularsuits.common;

import hu.laci200270.mods.modularsuits.api.IArmorElement;
import hu.laci200270.mods.modularsuits.common.blocks.ConstructingTable;
import hu.laci200270.mods.modularsuits.common.items.ModularArmorItem;
import hu.laci200270.mods.modularsuits.common.tile.TileConstructingTable;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Reference {
	
	public static Block constructingTable=new ConstructingTable();
	public static LoggingUtility logger=new LoggingUtility("ModularSuits");
	public static final String MODID="modularsuits";
	public static ArrayList<Item> items=new ArrayList<Item>();
	public static ArrayList<Block> blocks=new ArrayList<Block>();
	public static ArrayList<? extends TileEntity> tiles=new ArrayList<TileEntity>();
	public static ArrayList<IArmorElement> armorElements=new ArrayList<IArmorElement>();
	public static ArmorMaterial modulararmormaterial=EnumHelper.addArmorMaterial("MODULAR_ARMOR", "modulararmor", 16, new int[] {3, 8, 6, 3}, 0);
	public static boolean DEBUG = true;
	public static Item armorHelmet=new ModularArmorItem(modulararmormaterial, 0, 0);
	public static Item armorChest=new ModularArmorItem(modulararmormaterial, 0, 1);
	public static Item armorLeggings=new ModularArmorItem(modulararmormaterial, 0, 2);
	public static Item armorBoots=new ModularArmorItem(modulararmormaterial, 0, 3);
	
	public static ResourceLocation backgroundConstructionTable=new ResourceLocation( MODID+":textures/gui/constructiontable.png");
	
	public static void registerItems(){
		
		for (Item item : items) {
			
				
				logger.logWhenDebug("Registering item:" +item.getUnlocalizedName().substring(5));
			
			
			GameRegistry.registerItem(item,item.getUnlocalizedName().substring(5));
		}
	}
public static void registerTiles(){
		
		GameRegistry.registerTileEntity(TileConstructingTable.class,"constructiontable");
	}
public static void addBaseTiles(){
	
}
	public static void addItemToRegistry(Item item){
		items.add(item);
	}
	public static void  addBaseItems(){
		addItemToRegistry(armorChest);
		addItemToRegistry(armorHelmet);
		addItemToRegistry(armorLeggings);
		addItemToRegistry(armorBoots);
	}
	public static void addBaseBlocks(){
		blocks.add(constructingTable);
	}
	public static void registerBlocks(){
		for (Block block : blocks) {
		
				
				logger.logWhenDebug("Registering block:" +block.getUnlocalizedName().substring(5));
			
			
			GameRegistry.registerBlock(block,block.getUnlocalizedName().substring(5));
	}}
	public static void addArmorElement(IArmorElement element){
		armorElements.add(element);
	}
	
	public static boolean consumeItems(IInventory inventory, Item itemID, int count)
	{
	    boolean flag = false;
	    for (int slot = 0, remain = count; slot < inventory.getSizeInventory(); ++slot)
	    {
		    ItemStack itemstack = inventory.getStackInSlot(slot);
		    if (itemstack != null && itemstack.getItem() == itemID)
		    {
			    if ((remain -= itemstack.stackSize) <= 0)
			    {
				    flag = true;
				    break;
			    }
		    }
	    }
	    if (flag)
	    {
		    for (int slot = 0; count > 0 && slot < inventory.getSizeInventory(); ++slot)
		    {
			    ItemStack itemstack = inventory.getStackInSlot(slot);
			    if (itemstack != null && itemstack.getItem() == itemID)
			    {
				    if ((count -= itemstack.stackSize) >= 0)
				    {
					    inventory.setInventorySlotContents(slot, (ItemStack)null);
				    } else {
					    itemstack.stackSize = -count;
				    }
			    }
		    }
	    }
	    return flag;
	}
}
