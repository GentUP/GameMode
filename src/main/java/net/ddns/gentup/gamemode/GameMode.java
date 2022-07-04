package net.ddns.gentup.gamemode;

import net.ddns.gentup.gamemode.commands.GameModeCommand;
import net.ddns.gentup.gamemode.commands.GameModeCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class GameMode extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("gamemode").setTabCompleter(new GameModeCompleter());
        this.getCommand("gamemode").setExecutor(new GameModeCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
