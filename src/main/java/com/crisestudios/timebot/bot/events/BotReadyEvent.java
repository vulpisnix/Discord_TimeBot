package com.crisestudios.timebot.bot.events;

import com.crisestudios.timebot.bot.Bot;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotReadyEvent extends ListenerAdapter {
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        super.onReady(event);
        System.out.println("[Bot] Bot is ready.");

        event.getJDA().getPresence().setStatus(OnlineStatus.ONLINE);
    }
}
