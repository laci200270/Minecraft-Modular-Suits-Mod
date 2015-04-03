package hu.laci200270.mods.modularsuits.common.modules;

import hu.laci200270.mods.modularsuits.api.IArmorElement;
import hu.laci200270.mods.modularsuits.common.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FeatherFallingModule implements IArmorElement {

	@Override
	public ItemStack[] onElementTick(EntityPlayer player,
			ItemStack currentArmor, ItemStack[] allArmors, int armorPiece) {
		player.fallDistance=0F;
		
		
		
		return allArmors;
	}

	@Override
	public ItemStack[] recipe() {
		ItemStack[] recipe={new ItemStack(Items.feather, 3),new ItemStack(Blocks.wool, 1)};
		
		return recipe;
	}

	@Override
	public Item icon() {
		// TODO Auto-generated method stub
		return Items.feather;
	}

	@Override
	public ItemStack sendMessage(Integer armorPiece, ItemStack armor,
			String... message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnlocalizedName() {
		// TODO Auto-generated method stub
		return "hu.laci200270.mods.modularsuits.modules.feathermodule.name";
	}

	@Override
	public Item[] applicableTo() {
		// TODO Auto-generated method stub
		return new Item[]{Reference.armorBoots};
	}

}
