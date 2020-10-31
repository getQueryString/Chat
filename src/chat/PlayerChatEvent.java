package chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        String msg = e.getMessage();
        msg.replace("%", "Prozent");

        if (PermissionsEx.getUser(p).inGroup("default")) {
            e.setFormat("§7Spieler | " + p.getName() + " §8| §f" + msg);
        }
        if (PermissionsEx.getUser(p).inGroup("Moderator")) {
            e.setFormat("§3Moderator | " + p.getName() + " §8| §e" + msg);
        }
        if (PermissionsEx.getUser(p).inGroup("Owner")) {
            e.setFormat("§4§lOwner | " + p.getName() + " §8| §a§l" + msg);
        }
        if (p.isOp()) {
            e.setFormat("§0Operator | " + p.getName() + " §8| §a§l" + msg);
        }
    }
}