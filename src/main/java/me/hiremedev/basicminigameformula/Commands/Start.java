package me.hiremedev.basicminigameformula.Commands;

import me.hiremedev.basicminigameformula.Enums.GameState;
import me.hiremedev.basicminigameformula.Managers.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Start implements CommandExecutor {
    private GameManager gameManager;

    public Start(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        gameManager.setGameState(GameState.STARTING);
        return true;
    }
}
