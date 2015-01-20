package de.mr_splash.MojangStatusBungee.PingHandler;

public enum Adress
{

    ACCOUNTS("Accounts Service", "account.mojang.com"),
    AUTHENTICATION_SERVER("Authentication Server", "authserver.mojang.com"),
    SESSION_MINECRAFT("Minecraft Session Server", "session.minecraft.net"),
    SKINS("Skin Server", "skins.minecraft.net"),
    MAIN_WEBSITE("Website & Login Server", "minecraft.net");

    public String Service;
    public String Domain;

    Adress(String service, String domain)
            {
                this.Service = service;
                this.Domain = domain;
            }

}
