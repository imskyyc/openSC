package me.imskyyc.openSC.Placeholders;

import java.util.HashMap;

import org.bukkit.entity.Player;

import me.imskyyc.openSC.OpenSC;
import me.imskyyc.openSC.Configuration.ConfigManager;
import me.imskyyc.openSC.Utilities.BasePackage;

public class PlaceholderManager extends BasePackage {

	private OpenSC plugin;
	private ConfigManager configManager;
	private HashMap<String, Placeholder> placeholders;
	
	public PlaceholderManager(OpenSC plugin) {
		super(plugin, new String[] {});
	}
	
	@Override
	public void onEnable(OpenSC plugin, String[] args) {
		this.plugin = plugin;
		this.configManager = plugin.getConfigManager();
		this.placeholders = new HashMap<>();
		
		for(Placeholder placeholder : Placeholder.values()) {
			placeholders.put(placeholder.toString().toLowerCase(), placeholder);
		}
		
		debug("Placeholders successfully loaded.");
	}
	
	public String convert(Player player, String string) {
		if(string.substring(0, 2).toLowerCase().equals("OSB")) {
			boolean flag = false;
			String ret = "";
			String word = "";
			for(int i = 0; i < string.length(); i++) {
				if(string.charAt(i) == '%') {
					flag = !flag;
					if(!flag && placeholders.containsKey(word)) {
						ret += placeholders.get(word).test(plugin, player);
						word = "";
					}else if(!flag) {
						ret += word;
						word = "";
					}
					
					continue;
				}
				
				if(!flag) {
					ret += String.valueOf(string.charAt(i));
				}else {
					word += String.valueOf(string.charAt(i));
				}
			}
			
			return ret;
		}else if(configManager.getBoolean("placeholders.use_placeholderapi")) {
			return "";
		}else {
			return string;
		}
	}
}
