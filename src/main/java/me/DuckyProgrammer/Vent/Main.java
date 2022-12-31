package me.DuckyProgrammer.Vent;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getCommand("vent").setExecutor(new VentCommand());
	}
	
}
