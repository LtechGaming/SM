package com.ltit.sm;

import com.google.gson.Gson;
import com.mojang.brigadier.Command;
import com.ltit.sm.Config;
import com.ltit.sm.Customs;
import com.mojang.brigadier.arguments.ArgumentType;
import io.papermc.lib.PaperLib;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import static java.lang.String.join;
import static net.kyori.adventure.text.format.TextDecoration.UNDERLINED;
//SM colour: #aaffee

/**
 * <p>
 * Some code was provided by XyperCode
 *
 * @author Copyright (c) LTIT. All Rights Reserved.
 */

public class ServerManagement extends JavaPlugin {
    @Override
    public void onEnable() {
        Customs customs = new Customs();
        Gson gson = new Gson();
        Config smjson = gson.fromJson("""
                {
                    "links": {
                        "discord": "none",
                        "youtube":"none",
                        "website":"none",
                        "tiktok":"none",
                        "insta":"none",
                        "x":"none",
                        "threads":"none",
                        "store":"none"
                    },
                    "serverdata":{
                        "name": "unknown",
                        "description": "unknown",
                        "type": "unknown"
                    }
                }""", Config.class);
        var ref = new Object() {
            Config smjsonsave = new Config();
        };
        Path path = Paths.get("plugins/ServerManagement/smjson.json");
        try {
            ref.smjsonsave = gson.fromJson(Files.readString(path), Config.class);
        } catch (IOException e) {
            System.out.println("Ignoring failed read, using default...");
        }

        try {
            Files.writeString(path, gson.toJson(ref.smjsonsave));
        } catch (IOException e) {
            throw new RuntimeException("Failed to save config!");
        }
        PaperLib.suggestPaper(this);
        LifecycleEventManager<Plugin> manager = this.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register(
                    Commands.literal("discord")
                            .executes(ctx -> {
                                if (!Objects.equals(ref.smjsonsave.links.discord, "none")) {
                                    var text = Component.text("Discord")
                                            .color(TextColor.fromCSSHexString("#7289da"))
                                            .clickEvent(ClickEvent.openUrl(ref.smjsonsave.links.discord))
                                            .decorate(UNDERLINED);
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                } else {
                                    var text = Component.text("No discord link")
                                            .color(TextColor.fromCSSHexString("#7289da"));
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                }
                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("tiktok")
                            .executes(ctx -> {
                                if (!Objects.equals(ref.smjsonsave.links.tiktok, "none")) {
                                    var text = Component.text("Tiktok")
                                            .color(TextColor.fromCSSHexString("#d6a3d4"))
                                            .clickEvent(ClickEvent.openUrl(ref.smjsonsave.links.tiktok))
                                            .decorate(UNDERLINED);
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                } else {
                                    var text = Component.text("No tiktok link")
                                            .color(TextColor.fromCSSHexString("#d6a3d4"));
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                }
                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("website")
                            .executes(ctx -> {
                                if (!Objects.equals(ref.smjsonsave.links.website, "none")) {
                                    var text = Component.text("Website")
                                            .color(TextColor.fromCSSHexString("#5555ff"))
                                            .clickEvent(ClickEvent.openUrl(ref.smjsonsave.links.website))
                                            .decorate(UNDERLINED);
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                } else {
                                    var text = Component.text("No website link")
                                            .color(TextColor.fromCSSHexString("#5555ff"));
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                }
                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("x")
                            .executes(ctx -> {
                                if (!Objects.equals(ref.smjsonsave.links.x, "none")) {
                                    var text = Component.text("X(Twitter)")
                                            .color(TextColor.fromCSSHexString("#1DA1F2"))
                                            .clickEvent(ClickEvent.openUrl(ref.smjsonsave.links.x))
                                            .decorate(UNDERLINED);
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                } else {
                                    var text = Component.text("No x(twitter) link")
                                            .color(TextColor.fromCSSHexString("#1DA1F2"));
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                }
                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("threads")
                            .executes(ctx -> {
                                if (!Objects.equals(ref.smjsonsave.links.threads, "none")) {
                                    var text = Component.text("Threads")
                                            .color(TextColor.fromCSSHexString("#ffffff"))
                                            .clickEvent(ClickEvent.openUrl(ref.smjsonsave.links.threads))
                                            .decorate(UNDERLINED);
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                } else {
                                    var text = Component.text("No threads link")
                                            .color(TextColor.fromCSSHexString("#ffffff"));
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                }
                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("insta")
                            .executes(ctx -> {
                                if (!Objects.equals(ref.smjsonsave.links.insta, "none")) {
                                    var text = Component.text("Instagram")
                                            .color(TextColor.fromCSSHexString("#fa7e1e"))
                                            .clickEvent(ClickEvent.openUrl(ref.smjsonsave.links.insta))
                                            .decorate(UNDERLINED);
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                } else {
                                    var text = Component.text("No instagram link")
                                            .color(TextColor.fromCSSHexString("#fa7e1e"));
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                }
                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("shop")
                            .executes(ctx -> {
                                if (!Objects.equals(ref.smjsonsave.links.store, "none")) {
                                    var text = Component.text("Store")
                                            .color(TextColor.fromCSSHexString("#bbffaa"))
                                            .clickEvent(ClickEvent.openUrl(ref.smjsonsave.links.store))
                                            .decorate(UNDERLINED);
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                } else {
                                    var text = Component.text("No store link")
                                            .color(TextColor.fromCSSHexString("#bbffaa"));
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                }
                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("youtube")
                            .executes(ctx -> {
                                if (!Objects.equals(ref.smjsonsave.links.youtube, "none")) {
                                    var text = Component.text("YouTube")
                                            .color(TextColor.fromCSSHexString("#ff0000"))
                                            .clickEvent(ClickEvent.openUrl(ref.smjsonsave.links.youtube))
                                            .decorate(UNDERLINED);
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                } else {
                                    var text = Component.text("No youtube link")
                                            .color(TextColor.fromCSSHexString("#ff0000"));
                                    //String send = customs.sendCustomLinkMessage(ref.smjsonsave.links.discord, "blue", ctx.getSource().getSender().getName(), "Discord");
                                    //getServer().dispatchCommand(getServer().getConsoleSender(), send);
                                    ctx.getSource().getSender().sendMessage(text);
                                    return 1;
                                }
                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("sm")
                            .executes(ctx -> {
                                var text = Component.text("SM version: alpha-0.0.24-SNAPSHOT, MC intended version: 1.20.6-RELEASE")
                                        .color(TextColor.fromCSSHexString("#aaffee"));
                                ctx.getSource().getSender().sendMessage(text);
                                return 1;

                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("serverinfo")
                            .executes(ctx -> {
                                var text = Component.text(join("", "Name: ", ref.smjsonsave.serverData.name))
                                        .color(TextColor.fromCSSHexString("#aaffee"));
                                ctx.getSource().getSender().sendMessage(text);
                                var texttwo = Component.text(join("", "Description: ", ref.smjsonsave.serverData.description))
                                        .color(TextColor.fromCSSHexString("#aaffee"));
                                ctx.getSource().getSender().sendMessage(texttwo);
                                var textthree = Component.text(join("", "Type: ", ref.smjsonsave.serverData.type))
                                        .color(TextColor.fromCSSHexString("#aaffee"));
                                ctx.getSource().getSender().sendMessage(textthree);
                                return 1;

                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    Commands.literal("playerinfo")
                            .executes(ctx -> {
                                var text = Component.text(join("", "Name: ", ctx.getSource().getSender().getName()))
                                        .color(TextColor.fromCSSHexString("#aaffee"));
                                ctx.getSource().getSender().sendMessage(text);
                                var texttwo = Component.text(join("", "OP?: ", Boolean.toString(ctx.getSource().getSender().isOp())))
                                        .color(TextColor.fromCSSHexString("#aaffee"));
                                ctx.getSource().getSender().sendMessage(texttwo);
                                var textthree = Component.text(join("", "Role: ", "N/A(experimental feature)"))
                                        .color(TextColor.fromCSSHexString("#aaffee"));
                                ctx.getSource().getSender().sendMessage(textthree);
                                return 1;

                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
            commands.register(
                    //Commands.argument("player", ArgumentTypes.entity())?
                    Commands.literal("setrole")
                            .executes(ctx -> {
                                var text = Component.text("[WARN]: Roles are an experimental feature. They may not work, or be very buggy.")
                                        .color(TextColor.fromCSSHexString("#aaffee"));
                                ctx.getSource().getSender().sendMessage(text);
                                var texttwo = Component.text(join("" , "[INFO] Attempted to set role for ", ctx.getArgument("player", String.class)))
                                        .color(TextColor.fromCSSHexString("#aaffee"));
                                ctx.getSource().getSender().sendMessage(texttwo);
                                return 1;

                            })
                            .build(),
                    "some bukkit help description string",
                    List.of("an-alias")
            );
        });

    }

}
