package me.hiremedev.basicminigameformula.Structure;


import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Optional;

public class TwistyPlugin extends JavaPlugin {

    public PluginManager getPluginManager() {
        return getServer().getPluginManager();
    }

    public void registerEvents(Listener... listeners) {
        Arrays.stream(listeners)
                .forEach((listener) -> getPluginManager().registerEvents(listener, this));
    }

    public void registerCommands(TwistyCommand... twistycommands) {
        Arrays.stream(twistycommands)
                .forEach((twistyCommand) -> {
                    var command = getCommand(twistyCommand.getName());
                    Optional.ofNullable(twistyCommand.getTabExecutor()).ifPresentOrElse(
                            (tabExecutor) -> {
                                command.setExecutor(tabExecutor);
                                command.setTabCompleter(tabExecutor);
                            },
                            () -> command.setExecutor(twistyCommand.getCommandExecutor())
                    );
                });
    }
}
