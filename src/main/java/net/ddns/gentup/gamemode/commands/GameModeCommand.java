package net.ddns.gentup.gamemode.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.*;

import org.bukkit.entity.Player;


public class GameModeCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Return false if less than 1 or more than 2 arguments. Results in the "usage" message from plugin.yml
        if (args.length < 1 || args.length > 2) {
            return false;

        } else {
            String gamemode = args[0].toLowerCase();

            //Change gamemode for self
            if (args.length == 1) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;

                    changeGamemode(sender, player, gamemode);

                //If executed from console or command block
                } else {
                    sender.sendMessage(ChatColor.RED + "Please enter the player to change the gamemode for!");

                }

            //Change gamemode for other players (+ via console, 2 arguments)
            } else if (sender.hasPermission("gamemode.others") || sender instanceof ConsoleCommandSender || sender instanceof BlockCommandSender) {
                //Try matching the player by name
                Player player = Bukkit.getPlayer(args[1]);

                if (player != null) {
                    if (changeGamemode(sender, player, gamemode)) {
                        sender.sendMessage(String.format("Set %s's game mode to %s", player.getName(), player.getGameMode()));
                    }

                } else {
                    sender.sendMessage(ChatColor.RED + "No player was found"); // argument.entity.notfound.player
                }

            } else {
                sender.sendMessage(ChatColor.RED + "You are not allowed to change other people's game modes!");
            }
        }
        return true;
    }


    //TODO: Use Enums (GameMode gameMode instead of String gameMode) to reduce the size of this method?
    public boolean changeGamemode(CommandSender sender, Player player, String gameMode) {
        switch (gameMode) {
            case "survival":
            case "0":
                if (sender.hasPermission("gamemode.survival")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("Set your game mode to Survival Mode");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "You are not allowed to use the Survival game mode!");
                    return false;
                }
            case "creative":
            case "1":
                if (sender.hasPermission("gamemode.creative")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("Set your game mode to Creative Mode");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "You are not allowed to use the Creative game mode!");
                    return false;
                }
            case "adventure":
            case "2":
                if (sender.hasPermission("gamemode.adventure")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage("Set your game mode to Adventure Mode");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "You are not allowed to use the Adventure game mode!");
                    return false;
                }
            case "spectator":
            case "3":
                if (sender.hasPermission("gamemode.spectator")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("Set your game mode to Spectator Mode");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "You are not allowed to use the Spectator game mode!");
                    return false;
                }
            default:
                sender.sendMessage(ChatColor.RED + "Invalid gamemode!");
                return false;
        }
    }
}