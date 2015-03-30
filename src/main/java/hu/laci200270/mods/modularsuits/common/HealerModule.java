package hu.laci200270.mods.modularsuits.common;

import hu.laci200270.mods.modularsuits.api.IArmorElement;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class HealerModule implements IArmorElement {

	ArrayList<Integer> badPotionEffects=new ArrayList<Integer>();
	public HealerModule() {
		badPotionEffects.add(Potion.blindness.id);
		badPotionEffects.add(Potion.confusion.id);
		badPotionEffects.add(Potion.digSlowdown.id);
		badPotionEffects.add(Potion.hunger.id);
		badPotionEffects.add(Potion.moveSlowdown.id);
		badPotionEffects.add(Potion.poison.id);
		badPotionEffects.add(Potion.weakness.id);
		badPotionEffects.add(Potion.wither.id);
	}
	
	public ItemStack onElementTick(EntityPlayer player, ItemStack armor,
			int armorPiece, int allEnergy) {
		
		@SuppressWarnings("unchecked")
		ArrayList<PotionEffect> playerEffects=new ArrayList<PotionEffect>(player.getActivePotionEffects());
		for (PotionEffect potion : playerEffects) {
			Integer id=potion.getPotionID();
			if(badPotionEffects.contains(id)){
				player.removePotionEffect(id);
			}
		}
		return armor;
	}

	@Override
	public ItemStack[] recipe() {
		
		return new ItemStack[]{new ItemStack(Items.golden_apple, 3),new ItemStack(Items.milk_bucket, 1)};
	}

	

}
