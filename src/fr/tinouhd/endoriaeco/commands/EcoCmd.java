package fr.tinouhd.endoriaeco.commands;

import fr.tinouhd.endoriaeco.utils.Coins;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class EcoCmd implements CommandExecutor, TabCompleter
{
	@Override public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (args.length == 1)
		{
			if (Bukkit.getPlayer(args[0]) != null)
			{
				Player target = Bukkit.getPlayer(args[0]);

				Double coins = Coins.getCoins(target);

				sender.sendMessage(target.getDisplayName() + " §aa §b" + coins.toString() + "§b ✪ §a!");
			} else
			{
				sender.sendMessage("§cCe joueur n'existe pas !");
				return false;
			}
		} else if (args.length == 3)
		{
			if (args[0].equalsIgnoreCase("add"))
			{
				if (Bukkit.getPlayer(args[1]) != null)
				{
					Player target = Bukkit.getPlayer(args[1]);
					Double amount = Double.parseDouble(args[2]);

					Coins.addCoins(target, amount);
					sender.sendMessage("§bVous avez ajouté §a" + amount + " ✪§b a §e" + target.getDisplayName());
				}
			} else if (args[0].equalsIgnoreCase("remove"))
			{
				if (Bukkit.getPlayer(args[1]) != null)
				{
					Player target = Bukkit.getPlayer(args[1]);
					Double amount = Double.parseDouble(args[2]);

					Coins.removeCoins(target, amount);
					sender.sendMessage("§bVous avez retiré §c" + amount + " ✪§b a §e" + target.getDisplayName());
				}
			} else if (args[0].equalsIgnoreCase("set"))
			{
				if (Bukkit.getPlayer(args[1]) != null)
				{
					Player target = Bukkit.getPlayer(args[1]);
					Double amount = Double.parseDouble(args[2]);

					Coins.setCoins(target, amount);
					sender.sendMessage("§bVous avez fixé §a" + amount + " ✪§b au solde de §e" + target.getDisplayName());
				}
			} else
			{
				sender.sendMessage("§cUtilisation : /eco <set/add/remove> <joueur> <montant>");
				return false;
			}
		} else
		{
			sender.sendMessage("§cUtilisation : /eco <set/add/remove/joueur> <joueur> <montant>");
			return false;
		}
		return false;
	}

	@Override public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args)
	{
		List<String> tab = new ArrayList<>();
		if(args.length == 1)
		{
			tab.add("set");
			tab.add("add");
			tab.add("remove");
			for(Player p : Bukkit.getOnlinePlayers())
			{
				tab.add(p.getDisplayName());
			}
		}else if(args.length == 2)
		{
			if(args[0].equalsIgnoreCase("set") || args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove"))
			{
				for(Player p : Bukkit.getOnlinePlayers())
				{
					tab.add(p.getDisplayName());
				}
			}
		}else
		{
			return tab;
		}
		return tab;
	}
}
