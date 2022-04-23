package dev.cmccall.blockfloat;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import javax.swing.*;

public class Events implements Listener {
    @EventHandler
    public void onBlockClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            var loc = e.getPlayer().getLocation().add(0, 1, 0);
            var ray = e.getPlayer().getWorld().rayTraceBlocks(loc, loc.getDirection(), 200);
            if (ray == null) {
                return;
            }
            var block = ray.getHitBlock();
            if (block != null) {
                var mat = block.getType();
                block.setType(Material.AIR);
                var fallblock = e.getPlayer().getWorld().spawnFallingBlock(block.getLocation().add(0, 1,0), mat.createBlockData());
                fallblock.setGravity(false);
                fallblock.setVelocity(new Vector(0, 0.2, 0));
            }
        }
        //bitch
    }
}
