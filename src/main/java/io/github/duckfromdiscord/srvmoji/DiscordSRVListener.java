package io.github.duckfromdiscord.srvmoji;

import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.*;
import github.scarsz.discordsrv.dependencies.kyori.adventure.text.Component;
import github.scarsz.discordsrv.dependencies.kyori.adventure.text.TextComponent;
import github.scarsz.discordsrv.dependencies.kyori.adventure.text.TextReplacementConfig;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class DiscordSRVListener {

    public DiscordSRVListener(SRVMoji plugin) {

    }

    @Subscribe
    public void discordMessageProcessed(DiscordGuildMessagePostProcessEvent event) {
        TextReplacementConfig textReplacementConfig = TextReplacementConfig.builder().match(
                Pattern.compile(":[a-z0-9_]+:")
        ).replacement( (MatchResult result, TextComponent.Builder builder) -> {
            return Component.translatable(result.group()).asComponent();
        }).build();
        event.setMinecraftMessage(event.getMinecraftMessage().replaceText(textReplacementConfig));
    }

}
