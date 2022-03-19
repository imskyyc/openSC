package me.imskyyc.openSC.Placeholders;

import org.bukkit.entity.Player;

import me.imskyyc.openSC.OpenSC;

public interface ISupplier {
	public String get(OpenSC plugin, Player player);
}
