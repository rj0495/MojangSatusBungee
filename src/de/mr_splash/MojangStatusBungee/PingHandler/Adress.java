package de.mr_splash.MojangStatusBungee.PingHandler;

public enum Adress
{

    ACCOUNTS("Accounts Service", "account.mojang.com"),
    AUTHENTICATION("Authentication Service", "auth.mojang.com"),
    AUTHENTICATION_SERVER("Authentication Server", "authserver.mojang.com"),
    LOGIN("Login Service", "login.minecraft.net"),
    SESSION_MINECRAFT("Minecraft Session Server", "session.minecraft.net"),
    SESSION_MOJANG("Mojang Session Server", "sessionserver.mojang.com"),
    SKINS("Skin Server", "skins.minecraft.net"),
    MAIN_WEBSITE("Main Site", "minecraft.net");

    public String Service;
    public String Domain;

    Adress(String service, String domain)
            {
                this.Service = service;
                this.Domain = domain;
            }

}
