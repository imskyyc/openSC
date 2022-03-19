package me.imskyyc.openSC.Commands;

import me.imskyyc.openSC.OpenSC;
import me.imskyyc.openSC.Utilities.BasePackage;

public class CommandManager extends BasePackage {

	private OpenSC plugin;
	
	public CommandManager(OpenSC plugin) {
		super(plugin, new String[] {});
	}

	@Override
	public void onEnable(OpenSC plugin, String[] args) {
		this.plugin = plugin;
		
		// Begin the hell of loading all the commands
		
		debug("Commands successfully loaded.");
	}
}
