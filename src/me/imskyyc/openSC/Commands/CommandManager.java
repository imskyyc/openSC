package me.imskyyc.openSC.Commands;

import me.imskyyc.openSC.OpenSC;
import me.imskyyc.openSC.Commands.Commands.PrimaryCommand;
import me.imskyyc.openSC.Utilities.BasePackage;

public class CommandManager extends BasePackage {

	public CommandManager(OpenSC plugin) {
		super(plugin, new String[] {});
	}

	@Override
	public void onEnable(OpenSC plugin, String[] args) {
		plugin.getCommand("sc").setExecutor(new PrimaryCommand(plugin));
		debug("Commands successfully loaded.");
	}
}
