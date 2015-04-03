package hu.laci200270.mods.modularsuits.common.modules;

import hu.laci200270.mods.modularsuits.api.IArmorElement;
import hu.laci200270.mods.modularsuits.common.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class SpeedModule implements IArmorElement {

	@Override
	public ItemStack[] onElementTick(EntityPlayer player,
			ItemStack currentArmor, ItemStack[] allArmors, int armorPiece) {
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2));
		
		
		return allArmors;
	}

	@Override
	public ItemStack[] recipe() {
		ItemStack[] recipe={new ItemStack(Items.feather, 3),new ItemStack(Items.golden_carrot, 1)};
		
		return recipe;
	}

	@Override
	public Item icon() {
		// TODO Auto-generated method stub
		return Items.golden_carrot;
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
		return "hu.laci200270.mods.modularsuits.modules.speedmodule.name";
	}

	@Override
	public Item[] applicableTo() {
		// TODO Auto-generated method stub
		return new Item[]{Reference.armorLeggings};
	}

}
