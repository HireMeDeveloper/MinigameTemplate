package me.hiremedev.basicminigameformula.Listeners;

import me.hiremedev.basicminigameformula.Managers.GameManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    private GameManager gameManager;

    public BlockBreakListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (gameManager.getBlockManager().canBreak(event.getBlock())) return;
        event.setCancelled(true);
    }
}
