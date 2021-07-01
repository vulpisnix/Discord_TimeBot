package com.crisestudios.timebot.bot.commands;

import com.crisestudios.timebot.bot.Bot;
import com.crisestudios.timebot.bot.commands.commands.addCommand;
import com.crisestudios.timebot.utils.Util;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler {
    private static List<ICommand> commands;

    public static void Init() {
        commands = new ArrayList<>();

        commands.add(new addCommand());
    }

    public static void Handle(Message message) {
        String raw = message.getContentRaw().replaceFirst(Bot.getCommandPrefix(), "");
        String[] split = raw.split(" ");
        String invoke = split[0];
        String[] args = Util.dropArray(1, split);

        for(ICommand command : commands) {
            if(command.getInvoke().equalsIgnoreCase(invoke)) {
                command.execute(message.getGuild(), message.getMember(), message, message.getTextChannel(), args);
            }
        }
    }

}
