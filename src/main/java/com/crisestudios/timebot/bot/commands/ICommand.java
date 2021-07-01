package com.crisestudios.timebot.bot.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public interface ICommand {
    String getInvoke();
    String getUsage();

    void execute(Guild guild, Member author, Message message, TextChannel channel, String[] args);
}
