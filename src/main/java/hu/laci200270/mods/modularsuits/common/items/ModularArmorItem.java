package hu.laci200270.mods.modularsuits.common.items;

import hu.laci200270.mods.modularsuits.common.HealerModule;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModularArmorItem extends ItemArmor {

	int armorType;
	
	public ModularArmorItem(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		switch (armorType) {
		case 0:
			setUnlocalizedName("modularHelmet");
			break;
		case 1:
			setUnlocalizedName("modularChestplate");
			
			break;
		case 2:
			setUnlocalizedName("modularLeggings");
			break;
		case 3:
			setUnlocalizedName("modularBoots");
			break;
		default:
			setUnlocalizedName("unkown_element_this_should_not_be_apear");
			break;
			
		}
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
		this.armorType=armorType;
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {
if (armorType==1) {
	new HealerModule().onElementTick(player, itemStack, 0, 20000);
}
	}
	
}
