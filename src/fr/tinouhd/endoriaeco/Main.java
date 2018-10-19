package fr.tinouhd.endoriaeco;

import fr.tinouhd.endoriaeco.commands.EcoCmd;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	@Override public void onEnable()
	{
		getCommand("eco").setExecutor(new EcoCmd());
	}

	@Override public void onDisable()
	{

	}
}
