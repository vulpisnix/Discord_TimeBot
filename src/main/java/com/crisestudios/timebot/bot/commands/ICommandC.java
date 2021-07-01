package com.crisestudios.timebot.bot.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class ICommandC implements ICommand {
    @Override
    public String getInvoke() {
        return "";
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public void execute(Guild guild, Member author, Message message, TextChannel channel, String[] args) {

    }
}
