package me.hiremedev.basicminigameformula.Structure;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabExecutor;

public class TwistyCommand {
    private final String name;
    private CommandExecutor CommandExecutor;
    private TabExecutor tabExecutor;

    public TwistyCommand(String name, CommandExecutor commandExecutor) {
        this.name = name;
        CommandExecutor = commandExecutor;
    }

    public TwistyCommand(String name, TabExecutor tabExecutor) {
        this.name = name;
        this.tabExecutor = tabExecutor;
    }

    public String getName() {
        return name;
    }

    public org.bukkit.command.CommandExecutor getCommandExecutor() {
        return CommandExecutor;
    }

    public TabExecutor getTabExecutor() {
        return tabExecutor;
    }
}
