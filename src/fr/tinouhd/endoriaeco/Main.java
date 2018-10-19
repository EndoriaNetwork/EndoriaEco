package fr.tinouhd.endoriaeco;

import fr.hugob147.endorialobby.mysql.MySQL;
import fr.tinouhd.endoriaeco.commands.EcoCmd;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	fr.hugob147.endorialobby.mysql.MySQL mysql = new MySQL();
	@Override public void onEnable()
	{
		this.mysql.connect("localhost", "endoria", 3306, "Endoria", "hugo34");
		getCommand("eco").setExecutor(new EcoCmd());
	}

	@Override public void onDisable()
	{

	}
}
