package com.crisestudios.timebot.bot.commands.commands;

import com.crisestudios.timebot.bot.Bot;
import com.crisestudios.timebot.bot.commands.ICommandC;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class addCommand extends ICommandC {

    @Override
    public String getInvoke() {
        return "add";
    }

    @Override
    public String getUsage() {
        return "%prefix%"+getUsage()+" <@role> <time> <message..>";
    }

    @Override
    public void execute(Guild guild, Member author, Message message, TextChannel channel, String[] args) {
        if(args.length < 3 || message.getMentionedRoles().size() < 1) {
            channel.sendMessage("**Usage:** "+getUsage().replaceAll("%prefix%", Bot.getCommandPrefix())).queue();
            return;
        }
        String timeRaw = args[1];

        System.out.println(timeRaw);
    }
}
