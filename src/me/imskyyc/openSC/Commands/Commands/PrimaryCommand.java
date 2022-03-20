package me.imskyyc.openSC.Commands.Commands;

import org.bukkit.command.CommandSender;

import me.imskyyc.openSC.OpenSC;
import me.imskyyc.openSC.Utilities.BaseCommand;

public class PrimaryCommand extends BaseCommand {

	public PrimaryCommand(OpenSC plugin) {
		super(plugin);
		
		setName("sc");
		setDescription("Shows the openSC help menu and sub-commands.");
		setClientRunnable(true);
		setServerRunnable(true);
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		
	}
}
