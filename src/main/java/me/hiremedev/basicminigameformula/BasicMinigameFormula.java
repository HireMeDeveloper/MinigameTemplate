package me.hiremedev.basicminigameformula;

import me.hiremedev.basicminigameformula.Commands.Start;
import me.hiremedev.basicminigameformula.Listeners.BlockBreakListener;
import me.hiremedev.basicminigameformula.Managers.BlockManager;
import me.hiremedev.basicminigameformula.Managers.GameManager;
import me.hiremedev.basicminigameformula.Managers.PlayerManager;
import me.hiremedev.basicminigameformula.Structure.TwistyCommand;
import me.hiremedev.basicminigameformula.Structure.TwistyPlugin;
import org.bukkit.event.Listener;

public final class BasicMinigameFormula extends TwistyPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        final var blockManager = new BlockManager();
        final var playerManager = new PlayerManager();
        final var gameManager = new GameManager(this,playerManager, blockManager);

        registerEvents(
                new BlockBreakListener(gameManager)
        );

        registerCommands(
                new TwistyCommand("start", new Start(gameManager))
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
