package me.imskyyc.openSC;

import java.lang.System.Logger.Level;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.imskyyc.openSC.Commands.CommandManager;
import me.imskyyc.openSC.Configuration.ConfigManager;
import me.imskyyc.openSC.Events.EventManager;
import me.imskyyc.openSC.Placeholders.PlaceholderManager;
import me.imskyyc.openSC.Utilities.UpdateChecker;
import me.imskyyc.openSC.Utilities.Utilities;


public class OpenSC extends JavaPlugin {
	
	public boolean debug = false;
	private ConsoleCommandSender console = getServer().getConsoleSender();
	private ConfigManager configManager;
	private PlaceholderManager placeholderManager;
	private CommandManager commandManager;
	private EventManager eventManager;
	
	@Override
	public void onEnable() {
		this.configManager = new ConfigManager(this, "config.yml");
		
		this.debug = this.configManager.getBoolean("general.debug");
		
		this.placeholderManager = new PlaceholderManager(this);
		this.commandManager = new CommandManager(this);
		this.eventManager = new EventManager(this);
		
		PluginDescriptionFile pluginDescription = this.getDescription();
		log(Level.INFO, "&aopenSB Version &b" + pluginDescription.getVersion() + "&a on API Version &b" + pluginDescription.getAPIVersion() + " &asuccessfully loaded.");
		boolean doUpdateCheck = this.configManager.getBoolean("general.check_for_updates");
		if(doUpdateCheck) {
			UpdateChecker updateChecker = new UpdateChecker(this);
			updateChecker.doUpdateCheck();
		}
	}
	
	public void log(Level level, String message) {
		if(level.equals(Level.DEBUG) && !this.debug) return;
		console.sendMessage("[openSB] " + level.toString() + ": " + Utilities.color(message));
	}
	
	public ConfigManager getConfigManager() {
		return this.configManager;
	}

	public PlaceholderManager getPlaceholderManager() {
		return placeholderManager;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public EventManager getEventManager() {
		return eventManager;
	}
}
