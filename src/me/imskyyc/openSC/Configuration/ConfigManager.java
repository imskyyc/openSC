package me.imskyyc.openSC.Configuration;

import java.util.List;

import me.imskyyc.openSC.OpenSC;
import me.imskyyc.openSC.Utilities.BasePackage;

public class ConfigManager extends BasePackage {
	private Configuration configuration;
	
	public ConfigManager(OpenSC plugin, String fileName) {
		super(plugin, new String[] {fileName});
	}

	@Override
	public void onEnable(OpenSC plugin, String[] args) {
		String fileName = args[0];
		fileName = fileName.endsWith(".yml") ? fileName : fileName + ".yml";
		
		this.configuration = new Configuration(plugin, fileName);
		print("config.yml successfully loaded.");
	}
	
	public Object get(String yamlPath) {
		return configuration.get(yamlPath);
	}
	
	public String getString(String yamlPath) {
		return configuration.getString(yamlPath);
	}
	
	public int getInt(String yamlPath) {
		return configuration.getInt(yamlPath);
	}
	
	public double getDouble(String yamlPath) {
		return configuration.getDouble(yamlPath);
	}
	
	public List<String> getStringList(String yamlPath) {
		return configuration.getStringList(yamlPath);
	}
	
	
	public boolean getBoolean(String yamlPath) {
		return configuration.getBoolean(yamlPath);
	}
}