package com.crisestudios.timebot.launcher;

import com.crisestudios.timebot.bot.Bot;
import com.crisestudios.timebot.utils.FileManager;
import com.crisestudios.timebot.utils.configs.BotConfig;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        FileManager.Init();
        BotConfig botConfig = (BotConfig) FileManager.getOrCreateConfig("bot.json", BotConfig.class, new BotConfig());

        if(botConfig.botToken == "") {
            System.out.println("The BotToken is empty!\nPlease enter the BotToken in the bot.json");
            return;
        }

        Bot bot = new Bot(botConfig);
        bot.Start();

        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            while((line = scanner.nextLine()) != null) {

                switch (line.toLowerCase()) {
                    case "stop":
                    case "shutdown":
                        System.out.println("[System] Shutting down..");
                        bot.Shutdown();
                        System.exit(0);
                        break;
                }

            }
        }
    }
}
