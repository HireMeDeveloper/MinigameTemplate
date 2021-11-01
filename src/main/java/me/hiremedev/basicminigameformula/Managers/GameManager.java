package me.hiremedev.basicminigameformula.Managers;

import me.hiremedev.basicminigameformula.Enums.GameState;
import me.hiremedev.basicminigameformula.Enums.Kit;
import me.hiremedev.basicminigameformula.Structure.TwistyPlugin;
import me.hiremedev.basicminigameformula.Tasks.GameStartCountdownTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class GameManager {
    private final TwistyPlugin plugin;
    private BlockManager blockManager;
    private PlayerManager playerManager;

    private GameState gameState = GameState.LOBBY;

    private GameStartCountdownTask gameStartCountdownTask;

    public GameManager(TwistyPlugin plugin, PlayerManager playerManager, BlockManager blockManager) {
        this.plugin = plugin;
        this.playerManager = playerManager;
        this.blockManager = blockManager;

        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;

        switch (gameState){
            case LOBBY -> playerManager.clearInventories();
            case STARTING -> {
                this.gameStartCountdownTask = new GameStartCountdownTask(this);
                playerManager.moveToSpawn();
                this.gameStartCountdownTask.runTaskTimer(plugin, 0, 20);
                break;
            }
            case ACTIVE -> {
                if(this.gameStartCountdownTask != null) this.gameStartCountdownTask.cancel();
                playerManager.giveKits(Kit.SPLEEF);
            }
        }
    }

    public BlockManager getBlockManager() {
        return blockManager;
    }
}
