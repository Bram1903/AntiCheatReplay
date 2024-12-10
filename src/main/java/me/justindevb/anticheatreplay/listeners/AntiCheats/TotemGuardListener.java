package me.justindevb.anticheatreplay.listeners.AntiCheats;

import com.deathmotion.totemguard.api.events.FlagEvent;
import com.deathmotion.totemguard.api.events.PunishEvent;
import me.justindevb.anticheatreplay.AntiCheatReplay;
import me.justindevb.anticheatreplay.ListenerBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class TotemGuardListener extends ListenerBase implements Listener {

    public TotemGuardListener(AntiCheatReplay acReplay) {
        super(acReplay);
        Bukkit.getPluginManager().registerEvents(this, acReplay);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFlag(FlagEvent event) {
        Player p = event.getPlayer();

        if (alertList.contains(p.getUniqueId()))
            return;

        alertList.add(p.getUniqueId());

        startRecording(p, getReplayName(p, event.getCheckDetails().getCheckName()));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPunish(PunishEvent event) {
        Player p = event.getPlayer();

        if (!punishList.contains(p.getUniqueId()))
            punishList.add(p.getUniqueId());
    }
}
