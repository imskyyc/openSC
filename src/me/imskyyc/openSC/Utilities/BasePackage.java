package me.imskyyc.openSC.Utilities;

import java.lang.System.Logger.Level;

import me.imskyyc.openSC.OpenSC;

public abstract class BasePackage {
	
	private OpenSC plugin;
	
	public BasePackage(OpenSC plugin, String[] args) {
		this.plugin = plugin;
		this.onEnable(plugin, args);
	}
	
	public void onEnable(OpenSC plugin, String[] args) {}
	
	public void print(String message) {
		plugin.log(Level.INFO, message);
	}
	
	public void warn(String message) {
		plugin.log(Level.WARNING, "&6" + message);
	}
	
	public void error(String message) {
		plugin.log(Level.ERROR, "&c" + message);
	}
	
	public void debug(String message) {
		plugin.log(Level.DEBUG, "&b" + message);
	}
}
