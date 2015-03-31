package hu.laci200270.mods.modularsuits.common.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SimpleConstructionTablePacket {
	public class OriginnalPacket implements IMessage{
		public NBTTagCompound tag=new NBTTagCompound();
		public  OriginnalPacket(NBTTagCompound tag) {
			this.tag=tag;
		}
		public OriginnalPacket() {
			
		}
		
		@Override
		public void fromBytes(ByteBuf buf) {
			// TODO Auto-generated method stub
			tag=ByteBufUtils.readTag(buf);
		}

		@Override
		public void toBytes(ByteBuf buf) {
			// TODO Auto-generated method stub
			ByteBufUtils.writeTag(buf, tag);
		}
	}
	public class ReplyPacket implements IMessage{
		public NBTTagCompound tag=new NBTTagCompound();
		public  ReplyPacket(NBTTagCompound tag) {
			this.tag=tag;
		}
		public ReplyPacket() {
			
		}
		
		@Override
		public void fromBytes(ByteBuf buf) {
			// TODO Auto-generated method stub
			tag=ByteBufUtils.readTag(buf);
		}

		@Override
		public void toBytes(ByteBuf buf) {
			// TODO Auto-generated method stub
			ByteBufUtils.writeTag(buf, tag);
		}
	}

}
