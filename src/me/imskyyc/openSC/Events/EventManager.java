package me.imskyyc.openSC.Events;

import me.imskyyc.openSC.OpenSC;
import me.imskyyc.openSC.Utilities.BasePackage;

public class EventManager extends BasePackage {

	public EventManager(OpenSC plugin) {
		super(plugin, new String[] {});
	}
	
	@Override
	public void onEnable(OpenSC plugin, String[] args) {
		debug("Events successfully loaded.");
	}
}
