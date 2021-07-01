package com.crisestudios.timebot.utils.configs;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class BotConfig {

    @Expose
    public String botToken;

    @Expose
    public String commandPrefix;

    @Expose
    public List<Long> botCommanderRoles;

    public BotConfig(String botToken, String commandPrefix, List<Long> botCommanderRoles) {
        this.botToken = botToken;
        this.commandPrefix = commandPrefix;
        this.botCommanderRoles = botCommanderRoles;
    }

    public BotConfig() {
        this.botToken = "";
        this.commandPrefix = "t!";
        this.botCommanderRoles = new ArrayList<>();
    }
}
