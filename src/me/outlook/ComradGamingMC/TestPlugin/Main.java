package me.outlook.ComradGamingMC.TestPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("");	
		getServer().getConsoleSender().sendMessage("["+ getDescription().getName() + "] " + "Enabling "  + getDescription().getName()  + " v"  + getDescription().getVersion());
		getServer().getConsoleSender().sendMessage("["+ getDescription().getName() + "] " + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		getServer().getConsoleSender().sendMessage("["+ getDescription().getName() + "] " + "Plugin " + getDescription().getName());
		getServer().getConsoleSender().sendMessage("["+ getDescription().getName() + "] " + "Author " + getDescription().getAuthors());
		getServer().getConsoleSender().sendMessage("["+ getDescription().getName() + "] " + "Website " + getDescription().getWebsite());
		getServer().getConsoleSender().sendMessage("["+ getDescription().getName() + "] " + "Desscription " + getDescription().getDescription());
		getServer().getConsoleSender().sendMessage("["+ getDescription().getName() + "] " + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		getServer().getConsoleSender().sendMessage("");
        
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getCommand("rules").setPermissionMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("general.noPermMessage")));
        
	}
	
	public void sendHelpMessage(CommandSender sender) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("message.headerMessage")));
		sender.sendMessage("§4NO ADVERTISING");
		sender.sendMessage("§4NO SPAMMING/ABUSING CAPS");
        sender.sendMessage(ChatColor.RED + "NO HACKING");
        sender.sendMessage("§4NO FLYING IN PVP");
        sender.sendMessage("§4RESPECT OTHERS");
        sender.sendMessage("§4DO NOT ABUSE ECO BUGS");
        sender.sendMessage("§a§lNOTE: §aScamming is §nALLOWED");
        sender.sendMessage("§a§lNOTE: Drugs are not allowed §8(Don't be caught with them!)");
	    sender.sendMessage("§bThis Plugin was made by §c§oComradGamingMC");
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("message.footerMessage")));
 
   }

  	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
  		if (cmd.getName().equalsIgnoreCase("rules")) {
  			if (args.length == 0) {
  				sendHelpMessage(sender);
  			} else if (args[0].equalsIgnoreCase("reload")) {
  				if (sender.hasPermission("rules.reload")) {
	  				reloadConfig();
	  				getCommand("rules").setPermissionMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("general.noPermMessage")));
	  				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("general.reloadMessage")));
  				} else {
  					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("general.noPermMessage")));
  				}
  			} else {
  				sendHelpMessage(sender);
  			}
  		}
  		return true;
  	}
}