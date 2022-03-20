package me.imskyyc.openSC.Placeholders;

import org.bukkit.entity.Player;

import me.imskyyc.openSC.OpenSC;

public enum Placeholder {
	OSC_PLAYER((plugin, player) -> {
		return player.getDisplayName();
	}),
	OSC_PLAYER_WORLD((plugin, player) -> {
		return player.getWorld().getName();
	});
	
	private ISupplier function;
	
	Placeholder(ISupplier function) {
		this.function = function;
	}
	
	public String test(OpenSC plugin, Player player) {
		return function.get(plugin, player);
	}
}
