package com.franciscodadone.staffchatlite.util;

import com.franciscodadone.staffchatlite.storage.Global;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import java.util.Objects;

public class Utils {

    /**
     * Translates the color codes.
     * @param str string
     * @return formatted
     */
    public static String Color(String str) {
        return ChatColor.translateAlternateColorCodes('§', str.replace("&", "§"));
    }

    /**
     * Sends config message and requires strings to replace
     * @param str main string
     * @param toBeReplaced string to be replaced (placeholder)
     * @param toReplace string to replace
     * @param sender command sender
     */
    public static void sendConfigMessageF(String str, String toBeReplaced, String toReplace, CommandSender sender) {
        try {
            sender.sendMessage(Color(Objects.requireNonNull(Global.langConfig.getConfig().getString(str)).replaceAll(toBeReplaced, toReplace)));
        } catch (Exception e) {
            Logger.severe("Check for config updates: &ahttps://github.com/FranciscoDadone/StaffChatLite/tree/master/src/main/resources/lang");
        }
    }

    /**
     * Sends a config message (multiline)
     * @param path path in config
     * @param sender command sender
     */
    public static void sendConfigMultilineMessage(String path, CommandSender sender) {
        try {
            for(String line: Global.langConfig.getConfig().getStringList(path)) {
                sender.sendMessage(Utils.Color(line));
            }
        } catch (Exception e) {
            Logger.severe("Check for config updates: &ahttps://github.com/FranciscoDadone/StaffChatLite/tree/master/src/main/resources/lang");
        }
    }

    /**
     * No permission error
     * @param permissionNode permission
     * @param sender command sender
     */
    public static void noPermission(String permissionNode, CommandSender sender) {
        sendConfigMessageF("no-permissions", "%permissionNode%", permissionNode, sender);
    }

}
