package me.DuckyProgrammer.Vent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Openable;

public class VentCommand implements CommandExecutor {

	private Main plugin = Main.getPlugin(Main.class);
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "This command is only for players!");
			return false;
		}
		
		final Player player = (Player) sender;
		
		if (!player.hasPermission("ventplugin.vent")) {
			player.sendMessage(ChatColor.RED + "No permission.");
			return false;
		}
		
		final Location loc = player.getLocation();
		
		loc.getBlock().setType(Material.IRON_TRAPDOOR);
		
		
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

			public void run() {
				Block trapdoor = loc.getBlock();

				BlockState state = trapdoor.getState();

				Openable openable = (Openable) state.getData();
				
				openable.setOpen(true);
				state.setData((MaterialData) openable);
				state.update();
			}
			
		}, 20);
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

			public void run() {
				Location tp = player.getLocation();
				tp.setY(tp.getY()-1);
				player.teleport(tp);
			}
			
		}, 30);
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

			public void run() {
				Location tp = player.getLocation();
				tp.setY(tp.getY()-1);
				player.teleport(tp);
			}
			
		}, 35);
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

			public void run() {
				Location tp = player.getLocation();
				tp.setY(tp.getY()-1);
				player.teleport(tp);
			}
			
		}, 40);
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

			public void run() {
				Block trapdoor = loc.getBlock();

				BlockState state = trapdoor.getState();

				Openable openable = (Openable) state.getData();
				
				openable.setOpen(false);
				state.setData((MaterialData) openable);
				state.update();
			}
			
		}, 50);
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

			public void run() {
				loc.getBlock().setType(Material.AIR);
			}
			
		}, 70);
		return false;
	}
	
}
