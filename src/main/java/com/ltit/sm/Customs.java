package com.ltit.sm;
import com.mojang.brigadier.context.CommandContext;
import static java.lang.String.join;
import org.bukkit.Server;
/**
 * <p>
 * Some code was provided by XyperCode
 *
 * @author Copyright (c) LTIT. All Rights Reserved.
 */

public class Customs {
    public String sendCustomLinkMessage(String link, String colour, String name, String display){
        String res = join("", "/tellraw ", name, " {\"text\": \"", display, "\", \"clickEvent\":{\"action\":\"open_url\",\"value\":\"", link, "\"}, \"color\":\"", colour, "\"}");
        return res;
    }
}
