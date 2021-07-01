package com.crisestudios.timebot.bot;

import com.crisestudios.timebot.bot.events.BotReadyEvent;
import com.crisestudios.timebot.utils.configs.BotConfig;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class Bot {

    private static JDABuilder jdaBuilder;
    private static JDA jda;

    public Bot(BotConfig botConfig) {
        jdaBuilder = JDABuilder.createDefault(botConfig.botToken);

        jdaBuilder.addEventListeners(new BotReadyEvent());
    }

    public void Start() {
        System.out.println("[Bot] Starting bot..");
        try {
            jda = jdaBuilder.build().awaitReady();
            jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        } catch (Exception e) {
            System.out.println("[Bot] Something went wrong..");
            e.printStackTrace();
        }
    }

    public static JDA getJDA() {
        return jda;
    }
}
