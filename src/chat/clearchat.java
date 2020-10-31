package chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class clearchat implements Listener, CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if(!p.hasPermission("chat.clear") || p.isOp()) {
			p.sendMessage(main.noperm);
		}else {
			for(int i = 0; i < 105; ++i) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(!p.hasPermission("chat.clear")) {
						all.sendMessage("");
					}
				}
			}
			Bukkit.broadcastMessage(main.pre + "§7Der Chat wurde von §f§l" + p.getName() + " §7gelerrt.");
			return true;
		}
		return false;
	}

}
