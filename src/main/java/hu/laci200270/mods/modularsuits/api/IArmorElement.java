package hu.laci200270.mods.modularsuits.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface IArmorElement {

	public ItemStack[] onElementTick(EntityPlayer player,ItemStack currentArmor,ItemStack[] allArmors,int armorPiece);
	public ItemStack[] recipe();
	public Item icon();
	public ItemStack sendMessage(Integer armorPiece,ItemStack armor,String... message);
	
}
