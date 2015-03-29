package hu.laci200270.mods.modularsuits.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import net.minecraft.client.Minecraft;

public class LoggingUtility {

	private File logFile=null;
	private PrintWriter writer=null;
	
	public LoggingUtility(String name) {
		logFile=new File(Minecraft.getMinecraft().mcDataDir,name+".log");
		try {
			writer=new PrintWriter(logFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void log(String string) {
		
		writer.write(string+"\n");
		writer.flush();
	}
	
	@Override
	protected void finalize() throws Throwable {
		writer.close();
		super.finalize();
	}

}
