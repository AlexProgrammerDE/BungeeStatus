package net.pistonmaster.pistonmotd.bungee;

import net.md_5.bungee.api.ProxyServer;
import net.pistonmaster.pistonmotd.api.PlaceholderParser;

public class CommonPlaceholder implements PlaceholderParser {
    @Override
    public String parseString(String text) {
        String returnedString = text;

        // Legacy placeholders. Don't touch them!
        returnedString = returnedString.replaceAll("%real_players%", "%online%");
        returnedString = returnedString.replaceAll("%displayed_players%", "%online%");
        returnedString = returnedString.replaceAll("%real_max%", "%max%");
        returnedString = returnedString.replaceAll("%displayed_max%", "%max%");

        returnedString = returnedString.replaceAll("%online%", String.valueOf(ProxyServer.getInstance().getOnlineCount()));
        returnedString = returnedString.replaceAll("%max%", String.valueOf(ProxyServer.getInstance().getConfig().getPlayerLimit()));
        returnedString = returnedString.replaceAll("%newline%", "\n");

        return returnedString;
    }
}
