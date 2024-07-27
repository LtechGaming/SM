package com.ltit.sm;

import com.mojang.brigadier.Command;
import io.papermc.lib.PaperLib;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Levi Muniz on 7/29/20.
 *
 * @author Copyright (c) LTIT. All Rights Reserved.
 */

public class Sm extends JavaPlugin {

    @Override
    public void onEnable() {
        PaperLib.suggestPaper(this);
        saveDefaultConfig();
        LifecycleEventManager<Plugin> manager = this.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
          final Commands commands = event.registrar();
          commands.register(
                  Commands.literal("discord")
                          .executes(ctx -> {
                            ctx.getSource().getSender().sendPlainMessage("a");
                            return Command.SINGLE_SUCCESS;
                          })
                          .build(),
                  "some bukkit help description string",
                  List.of("an-alias")
          );
        });
  }
}
