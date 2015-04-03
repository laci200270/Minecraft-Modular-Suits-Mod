package hu.laci200270.mods.modularsuits.common.items;

import hu.laci200270.mods.modularsuits.api.IModItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemEnergyCrystal extends Item implements IModItem{
	public static final String name="ecrystal";
	
	public ItemEnergyCrystal() {
		super();
		setUnlocalizedName("ecrystal");
		GameRegistry.registerItem(this, getName());
	
	
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		// TODO Auto-generated method stub
		return true;
	}
}
