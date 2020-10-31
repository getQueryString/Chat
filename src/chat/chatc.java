package chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class chatc implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        final String m = e.getMessage().trim();
        float uppercaseLetter = 0;
        for (int i = 0; i < m.length(); i++) {
            if (Character.isUpperCase(m.charAt(i)) && Character.isLetter(m.charAt(i))) {
                uppercaseLetter++;
            }
        }
        Player p = e.getPlayer();
        if (!(PermissionsEx.getUser(p).inGroup("Owner"))) {
            if (uppercaseLetter / (float) m.length() > 0.5F) {
                e.setCancelled(true);
                e.getPlayer().sendMessage("");
                e.getPlayer().sendMessage(main.pre + "  §5§kW§c§l Deaktiviere bitte deine CAPS! §5§kW");
                e.getPlayer().sendMessage("");
            }

        }
    }


}