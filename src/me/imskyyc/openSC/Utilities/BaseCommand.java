package me.imskyyc.openSC.Utilities;

import java.lang.System.Logger.Level;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.imskyyc.openSC.OpenSC;

public abstract class BaseCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private OpenSC plugin;
	private String name;
	private String description;
	private String permissionNode;
	private int cooldown = 0;
	
	private boolean clientRunnable;
	private boolean serverRunnable;
	
	public BaseCommand(OpenSC plugin) {
		this.plugin = plugin;
	}
	
	public void run(CommandSender sender, String[] args) {
		throw new NotImplementedException("Method not implemented");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		boolean playerSent = sender instanceof Player;
		
		if(playerSent && !clientRunnable) {
			sendMessage(sender, Level.ERROR, "Command: &4" + commandLabel + " cannot be executed by players.");
			
			return true;
		}else if(!playerSent && !serverRunnable) {
			sendMessage(sender, Level.ERROR, "Command: &4" + commandLabel + " cannot be executed by console / non-players.");
			
			return true;
		}else {
			run(sender, args);
			
			return true;
		}
	}
	
	public void sendMessage(CommandSender sender, Level type, String message) {
		String finalMessage = "&9[openSB]: ";
		if(!type.equals(Level.ALL)) {
			switch(type.toString()) {
			case "ERROR":
				finalMessage += "&c&l" + type.toString() + " &4";
				break;
			case "WARN":
				finalMessage += "&eWARNING ";
				break;
			default:
				finalMessage += "INFO ";
				break;
			}
		}
		finalMessage += message;
		
		sender.sendMessage(Utilities.color(finalMessage));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPermissionNode() {
		return permissionNode;
	}

	public void setPermissionNode(String permissionNode) {
		this.permissionNode = permissionNode;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public boolean isClientRunnable() {
		return clientRunnable;
	}

	public void setClientRunnable(boolean clientRunnable) {
		this.clientRunnable = clientRunnable;
	}

	public boolean isServerRunnable() {
		return serverRunnable;
	}

	public void setServerRunnable(boolean serverRunnable) {
		this.serverRunnable = serverRunnable;
	}
}