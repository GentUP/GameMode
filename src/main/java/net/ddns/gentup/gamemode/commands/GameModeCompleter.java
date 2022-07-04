package net.ddns.gentup.gamemode.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.util.StringUtil;

import java.util.*;
import java.util.function.Supplier;

public class GameModeCompleter implements TabCompleter {

    //Create a static array of game modes
    private String[] GAMEMODES = {"creative", "survival", "adventure", "spectator"};


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {


        if (args.length == 1) {

            /**
            if (sender instanceof Player) {

                Map<String, String> gamemodePermissions = new HashMap<String, String>();

                for (String gamemode : GAMEMODES) {
                    gamemodePermissions.put("gamemode." + gamemode, gamemode);
                }

                List<String> permissionNodes = new ArrayList<>();

                Player player = (Player) sender;
                for (PermissionAttachmentInfo permissionAttachmentInfo : player.getEffectivePermissions()) {
                    if (permissionAttachmentInfo.getPermission().startsWith("gamemode.")) {
                    permissionNodes.add(permissionAttachmentInfo.getPermission());
                    }
                }

                //DEBUG
                Bukkit.getLogger().info(permissionNodes.toString());

                for (String permission : permissionNodes) {
                    if (per.contains())
                }

            }
            **/

            final List<String> completions = new ArrayList<>();

            //Copy matches of first argument from list
            StringUtil.copyPartialMatches(args[0], Arrays.asList(GAMEMODES), completions);

            //Sort alphabetically
            Collections.sort(completions);

            return completions;

        } else if (args.length == 2) {

            List<String> players = getOnlinePlayers();

            final List<String> completions = new ArrayList<>();

            StringUtil.copyPartialMatches(args[1], players, completions);

            Collections.sort(completions);

            return completions;

        } else {
            return new ArrayList<>();
        }
    }

    public List<String> getOnlinePlayers() {

        List<String> players = new ArrayList<>();

        //Loop over all players online
        for (Player p : Bukkit.getOnlinePlayers()) {
            players.add(p.getName());
        }
        return players;
    }
}
