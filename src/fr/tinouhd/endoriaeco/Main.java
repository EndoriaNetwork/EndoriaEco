package fr.tinouhd.endoriaeco;

import fr.tinouhd.endoriaeco.commands.EcoCmd;
import fr.tinouhd.endoriaeco.mysql.MySQL;
import fr.tinouhd.endoriaeco.utils.Coins;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	MySQL mysql = new MySQL();
	Coins coins = new Coins();
	@Override public void onEnable()
	{
		this.mysql.connect("localhost", "endoria", 3306, "Endoria", "hugo34");
		getCommand("eco").setExecutor(new EcoCmd());
	}

	@Override public void onDisable()
	{
		this.mysql.disconnect();
	}
}
