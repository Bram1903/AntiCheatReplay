package me.justindevb.anticheatreplay.commands;

import me.justindevb.anticheatreplay.utils.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.justindevb.anticheatreplay.AntiCheatReplay;
import net.md_5.bungee.api.ChatColor;

public class ReloadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!sender.hasPermission("AntiCheatReplay.reload")) {
			sender.sendMessage(ChatColor.DARK_RED + Messages.COMMAND_NO_PERMISSION);
			return true;
		}

		/*if (AntiCheatReplay.getInstance().isChecking(AntiCheat.KARHU)) {
			sender.sendMessage(ChatColor.DARK_RED
					+ "It is currently not possible to reload this plugin while using Karhu. Please reboot your server instead...");
			return true;
		}
*/
		AntiCheatReplay.getInstance().reloadReplayConfig();
		sender.sendMessage(ChatColor.DARK_GREEN + "[AntiCheatReplay] Reloaded config");
		AntiCheatReplay.getInstance().log("Reloaded config", false);
		return true;
	}

}
