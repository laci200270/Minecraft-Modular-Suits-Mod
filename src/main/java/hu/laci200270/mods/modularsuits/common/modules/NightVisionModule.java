package hu.laci200270.mods.modularsuits.common.modules;

import hu.laci200270.mods.modularsuits.api.IArmorElement;
import hu.laci200270.mods.modularsuits.common.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class NightVisionModule implements IArmorElement {

	@Override
	public ItemStack[] onElementTick(EntityPlayer player,
			ItemStack currentArmor, ItemStack[] allArmors, int armorPiece) {
		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 2));
		
		
		
		return allArmors;
	}

	@Override
	public ItemStack[] recipe() {
		ItemStack[] recipe={new ItemStack(Items.ender_pearl, 3),new ItemStack(Items.ghast_tear, 1)};
		
		return recipe;
	}

	@Override
	public Item icon() {
		
		return Items.ender_eye;
	}

	@Override
	public ItemStack sendMessage(Integer armorPiece, ItemStack armor,
			String... message) {
	
		return armor;
	}

	@Override
	public String getUnlocalizedName() {
		
		return "hu.laci200270.mods.modularsuits.modules.nightvision.name";
	}

	@Override
	public Item[] applicableTo() {
	
		return new Item[]{Reference.armorHelmet};
	}

}
