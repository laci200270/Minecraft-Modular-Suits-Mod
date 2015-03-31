package hu.laci200270.mods.modularsuits.common.modules;

import hu.laci200270.mods.modularsuits.api.IArmorElement;
import hu.laci200270.mods.modularsuits.common.items.ModularArmorItem;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
	
	public ItemStack[] onElementTick(EntityPlayer player,ItemStack currentArmor,ItemStack[] allArmors,int armorPiece) {
		
		
		
		ArrayList<PotionEffect> playerEffects=new ArrayList<PotionEffect>(player.getActivePotionEffects());
		for (PotionEffect potion : playerEffects) {
			Integer id=potion.getPotionID();
			if(badPotionEffects.contains(id)){
				player.removePotionEffect(id);
			}
		}
		return allArmors;
	}

	@Override
	public ItemStack[] recipe() {
		
		return new ItemStack[]{new ItemStack(Items.golden_apple, 3),new ItemStack(Items.milk_bucket, 1)};
	}

	@Override
	public Item icon() {
		
		return Items.milk_bucket;
	}

	@Override
	public ItemStack sendMessage(Integer armorPiece, ItemStack armor,
			String... message) {
		
		
		return armor;
	}

	

}
