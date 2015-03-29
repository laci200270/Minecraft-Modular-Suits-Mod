package hu.laci200270.mods.modularsuits.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IArmorElement {

	public ItemStack onElementTick(EntityPlayer player,ItemStack armor,int armorPiece,int allEnergy);
}
