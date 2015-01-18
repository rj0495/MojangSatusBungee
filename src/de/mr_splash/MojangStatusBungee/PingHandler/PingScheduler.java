package de.mr_splash.MojangStatusBungee.PingHandler;

import de.mr_splash.MojangStatusBungee.MojangStatusBungee;
import net.md_5.bungee.api.ProxyServer;

import java.util.concurrent.TimeUnit;

public class PingScheduler
{

    private MojangStatusBungee mojangStatusBungee;
    public PingScheduler(MojangStatusBungee plugin)
    {
        this.mojangStatusBungee = plugin;
    }

    public void run()
    {
        ProxyServer.getInstance().getScheduler().schedule(mojangStatusBungee, new Runnable()
        {
            @Override
            public void run()
            {
                pingAll();
            }
        }, 1, 60*5, TimeUnit.SECONDS);
    }

    private void pingAll()
    {
        mojangStatusBungee.ping.accountsOnline();
        mojangStatusBungee.ping.authOnline();
        mojangStatusBungee.ping.authServerOnline();
        mojangStatusBungee.ping.minecraftSessionOnline();
        mojangStatusBungee.ping.mojangSessinOnline();
        mojangStatusBungee.ping.skinsOnline();
        mojangStatusBungee.ping.minecraftWebsiteOnline();
        mojangStatusBungee.ping.login();
    }

}
