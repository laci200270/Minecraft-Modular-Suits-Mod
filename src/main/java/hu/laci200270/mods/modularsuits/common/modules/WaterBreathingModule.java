package hu.laci200270.mods.modularsuits.common.modules;

import hu.laci200270.mods.modularsuits.api.IArmorElement;
import hu.laci200270.mods.modularsuits.common.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class WaterBreathingModule implements IArmorElement {

	@Override
	public ItemStack[] onElementTick(EntityPlayer player,
			ItemStack currentArmor, ItemStack[] allArmors, int armorPiece) {
		player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 2));
		
		
		
		return allArmors;
	}

	@Override
	public ItemStack[] recipe() {
		ItemStack[] recipe={new ItemStack(Items.nether_wart, 3),new ItemStack(Blocks.anvil,1)};
		
		return recipe;
	}

	@Override
	public Item icon() {
		
		return Items.water_bucket;
	}

	@Override
	public ItemStack sendMessage(Integer armorPiece, ItemStack armor,
			String... message) {
	
		return armor;
	}

	@Override
	public String getUnlocalizedName() {
		// TODO Auto-generated method stub
		return "hu.laci200270.mods.modularsuits.modules.waterbreathing.name";
	}

	@Override
	public Item[] applicableTo() {
		// TODO Auto-generated method stub
		return new Item[]{Reference.armorHelmet};
	}

}
