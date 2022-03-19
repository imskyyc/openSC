package me.imskyyc.openSC.Utilities;

import me.imskyyc.openSC.OpenSC;

public class UpdateChecker extends BasePackage {

	private OpenSC plugin;
	
	public UpdateChecker(OpenSC plugin) {
		super(plugin, null);
	}
	
	@Override
	public void onEnable(OpenSC plugin, String[] args) {
		this.plugin = plugin;
	}
	
	public void doUpdateCheck() {
		@SuppressWarnings("unused")
		String pluginVersion = plugin.getDescription().getVersion();
	}
}
