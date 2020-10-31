package chat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    public static String noperm = "§7[§cServer§7] §4§l Keine Rechte!";
    public static String pre = "§7[§cServer§7] ";
    public static String world = "world";

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("§aDas §3Chat-Plugin §awurde erfolgreich aktiviert!");

        getCommand("clearchat").setExecutor(new clearchat());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerChatEvent(), this);
        pm.registerEvents(new chatc(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§4Das §3Chat-Plugin §4wurde erfolgreich deaktiviert!");
    }

}
