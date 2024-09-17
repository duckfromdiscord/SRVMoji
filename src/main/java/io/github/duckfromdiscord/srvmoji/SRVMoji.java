package io.github.duckfromdiscord.srvmoji;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import github.scarsz.discordsrv.DiscordSRV;

public final class SRVMoji extends JavaPlugin implements Listener {

    private final DiscordSRVListener discordsrvListener = new DiscordSRVListener(this);
    
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        DiscordSRV.api.subscribe(discordsrvListener);
    }

    @Override
    public void onDisable() {
        DiscordSRV.api.unsubscribe(discordsrvListener);
    }
}


