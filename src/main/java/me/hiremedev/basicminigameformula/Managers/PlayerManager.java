package me.hiremedev.basicminigameformula.Managers;

import me.hiremedev.basicminigameformula.Enums.Kit;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class PlayerManager {

    public void giveKits(Kit kit) {
        Bukkit.getOnlinePlayers().stream()
                .filter((player) -> player.getGameMode().equals(GameMode.SURVIVAL))
                .forEach((player) -> giveKit(kit, player));
    }

    public void moveToSpawn(){
        Bukkit.getOnlinePlayers().stream()
                .filter((player) -> player.getGameMode().equals(GameMode.SURVIVAL))
                .forEach((player) -> moveToSpawn(player));
    }

    public void clearInventories() {
        Bukkit.getOnlinePlayers().stream()
                .forEach((player) -> player.getInventory().clear());
    }

    private void giveKit(Kit kit, Player player) {
        Arrays.stream(kit.getItems())
                .forEach((itemStack) -> player.getInventory().addItem(itemStack));
    }

    private void moveToSpawn(Player player) {
        var world = player.getWorld();
        var spawn = world.getSpawnLocation();
        player.teleport(spawn);
    }
}
