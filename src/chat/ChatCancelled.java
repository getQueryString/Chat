package chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatCancelled implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(e.getPlayer().getWorld().getName().equalsIgnoreCase(chat.main.world)) {
			if(PermissionsEx.getUser(p).inGroup("Owner") || PermissionsEx.getUser(p).inGroup("Mitglied") || p.isOp()){
				e.setCancelled(false);
			}else {
				e.setCancelled(true);
				e.getPlayer().sendMessage(chat.main.pre + " §cDu kannst hier §4nicht §cschreiben!");
				
			}
			
		}
	}
}