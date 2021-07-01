package com.crisestudios.timebot.utils.configs;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class BotConfig {

    @Expose
    public String botToken;

    @Expose
    public List<Long> botCommanderRoles;

    public BotConfig(String botToken, List<Long> botCommanderRoles) {
        this.botToken = botToken;
        this.botCommanderRoles = botCommanderRoles;
    }
    public BotConfig() {
        this.botToken = "";
        this.botCommanderRoles = new ArrayList<>();
    }
}
