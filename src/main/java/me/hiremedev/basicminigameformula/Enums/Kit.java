package me.hiremedev.basicminigameformula.Enums;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Kit {
    SPLEEF(
            new ItemStack[]{
                    new ItemStack(Material.DIAMOND_SHOVEL),
                    new ItemStack(Material.SNOWBALL, 16),
                    new ItemStack(Material.SNOWBALL, 16),
                    new ItemStack(Material.SNOWBALL, 16)
            }
    );


    private ItemStack[] items;

    Kit(ItemStack[] items) {
        this.items = items;
    }

    public ItemStack[] getItems() {
        return items;
    }
}
