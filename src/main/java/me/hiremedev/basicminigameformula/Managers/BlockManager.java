package me.hiremedev.basicminigameformula.Managers;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.HashSet;
import java.util.Set;

public class BlockManager {
    private Set<Material> allowedToBreak;

    public BlockManager() {
        this.allowedToBreak = new HashSet<>();
    }

    public boolean canBreak(Block block){
        return allowedToBreak.contains(block.getType());
    }
}
