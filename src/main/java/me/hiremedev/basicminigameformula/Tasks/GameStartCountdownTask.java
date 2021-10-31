package me.hiremedev.basicminigameformula.Tasks;

import me.hiremedev.basicminigameformula.Enums.GameState;
import me.hiremedev.basicminigameformula.Managers.GameManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartCountdownTask extends BukkitRunnable {
    private final GameManager gameManager;

    private int timeLeft = 10;

    public GameStartCountdownTask(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        timeLeft--;
        if (timeLeft <= 0) {
            cancel();
            gameManager.setGameState(GameState.ACTIVE);
            return;
        }
        Bukkit.broadcast(Component.text(timeLeft + "time until game starts."));
    }
}
