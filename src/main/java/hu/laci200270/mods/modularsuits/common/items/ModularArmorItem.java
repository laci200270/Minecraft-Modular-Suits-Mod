package hu.laci200270.mods.modularsuits.common.items;

import hu.laci200270.mods.modularsuits.ModularSuits;
import hu.laci200270.mods.modularsuits.api.IArmorElement;
import hu.laci200270.mods.modularsuits.api.IModItem;
import hu.laci200270.mods.modularsuits.common.Reference;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModularArmorItem extends ItemArmor  implements IModItem{

	int armorType;
	private String name;
	
	public ModularArmorItem(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		switch (armorType) {
		case 0:
			setName("modularHelmet");
			break;
		case 1:
			setName("modularChestplate");
			
			break;
		case 2:
			setName("modularLeggings");
			break;
		case 3:
			setName("modularBoots");
			break;
		default:
			setName("unkown_element_this_should_not_be_apear");
			break;
			
		}
		GameRegistry.registerItem(this, getName());
		//GameRegistry
		this.armorType=armorType;
	}
	private void setName(String name) {
		this.name = name;
		setUnlocalizedName(name);
		
		
			Reference.logger.logWhenDebug("Setting name for :"+name);
		
	
	}
	public String getName(){
		return name;
	}	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn,
			int itemSlot, boolean isSelected) {
		if(stack.getTagCompound()==null){
			stack.setTagCompound(new NBTTagCompound());
		}	
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack stack) {
		if(stack.getTagCompound()==null){
			stack.setTagCompound(new NBTTagCompound());
		}	
		for (IArmorElement element : Reference.armorElements) {
				if(stack.getTagCompound().getBoolean(element.getUnlocalizedName())){
					ItemStack[] playerArmor=new ItemStack[4];
					for (int i = 0; i < 4; i++) {
						playerArmor[i]=player.getCurrentArmor(i);
					}
					
					element.onElementTick(player,stack, playerArmor, armorType);
				}
			}

	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	   Reference.logger.logWhenDebug("Searching armor texture at:"+Reference.MODID + ":textures/armor/" +"modulararmor" + "_" + (this.armorType == 2 ? "2" : "1") + ".png");
		return Reference.MODID + ":textures/armor/" +"modulararmor" + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	   
	}
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving,
			ItemStack itemStack, int armorSlot) {
	
		return super.getArmorModel(entityLiving, itemStack, armorSlot);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn,
			List tooltip, boolean advanced) {
		
		for (IArmorElement element : Reference.armorElements) {
			if(ModularSuits.applicabeTo(Reference.armorElements.indexOf(element), stack)){
			if(stack.getTagCompound().getBoolean(element.getUnlocalizedName())){
				tooltip.add(StatCollector.translateToLocal(element.getUnlocalizedName())+":"+EnumChatFormatting.GREEN+"true");
			}
			else{
				tooltip.add(StatCollector.translateToLocal(element.getUnlocalizedName())+":"+EnumChatFormatting.RED+"false");
			}
		}}
		
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
}
