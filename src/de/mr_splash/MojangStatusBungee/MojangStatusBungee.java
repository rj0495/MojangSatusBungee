package de.mr_splash.MojangStatusBungee;

import de.mr_splash.MojangStatusBungee.Commands.StatusCommand;
import de.mr_splash.MojangStatusBungee.PingHandler.Ping;
import de.mr_splash.MojangStatusBungee.PingHandler.PingScheduler;
import de.mr_splash.MojangStatusBungee.PingHandler.checkScheduler;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MojangStatusBungee extends Plugin
{


    public Ping  ping = new Ping();
    public PingScheduler pingScheduler = new PingScheduler(this);
    public checkScheduler checkscheduler = new checkScheduler(this);
    public void onEnable()
    {
        System.out.println("MojangStatus by mr_splash");
        System.out.println("MojangStatus by mr_splash");
        registerCommands();
        loadcfg();
        pingScheduler.run();
        checkscheduler.run();
    }

    private void registerCommands()
    {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new StatusCommand(this));
    }

    private void loadcfg()
    {
        try
        {

            if (!getDataFolder().exists())
            {
                getDataFolder().mkdir();
            }
            File file = new File(getDataFolder().getPath(), "config.yml");
            if (!file.exists())
            {
                file.createNewFile();
            }

            Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            if (configuration.get("offline_message") == null)
            {
                configuration.set("offline_message", "&c&lATTENTION! The service %service% is OFFLINE! Type /mojangstatus!");
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, file);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
