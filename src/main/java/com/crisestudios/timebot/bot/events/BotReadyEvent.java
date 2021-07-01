package com.crisestudios.timebot.bot.events;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotReadyEvent extends ListenerAdapter {
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        super.onReady(event);
        System.out.println("[Bot] Bot is ready.");
        System.out.println("Guild Invite Link: https://discord.com/oauth2/authorize?client_id="+event.getJDA().getSelfUser().getIdLong()+"&scope=bot&permissions=8");

        event.getJDA().getPresence().setStatus(OnlineStatus.ONLINE);
    }
}
