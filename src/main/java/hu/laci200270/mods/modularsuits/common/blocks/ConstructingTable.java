package hu.laci200270.mods.modularsuits.common.blocks;

import hu.laci200270.mods.modularsuits.ModularSuits;
import hu.laci200270.mods.modularsuits.common.tile.TileConstructingTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ConstructingTable extends Block {

	public ConstructingTable() {
		super(Material.redstoneLight);
		setUnlocalizedName("contructiontable");
	}
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileConstructingTable();
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		playerIn.openGui(ModularSuits.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos,
			EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
			EntityLivingBase placer) {
		// TODO Auto-generated method stub
		
		return super
				.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
	@Override
	public boolean hasTileEntity(IBlockState state) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
