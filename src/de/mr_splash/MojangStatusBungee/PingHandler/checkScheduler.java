package de.mr_splash.MojangStatusBungee.PingHandler;

import de.mr_splash.MojangStatusBungee.MojangStatusBungee;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import java.util.concurrent.TimeUnit;

public class checkScheduler
{

    private MojangStatusBungee mojangStatusBungee;
    public checkScheduler(MojangStatusBungee plugin)
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
                for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers())
                {
                    message(mojangStatusBungee.ping.accounts, Adress.ACCOUNTS.Service, p);
                    message(mojangStatusBungee.ping.authServer, Adress.AUTHENTICATION_SERVER.Service, p);
                    message(mojangStatusBungee.ping.session_minecraft, Adress.SESSION_MINECRAFT.Service, p);
                    message(mojangStatusBungee.ping.skins, Adress.SKINS.Service, p);
                    message(mojangStatusBungee.ping.website, Adress.MAIN_WEBSITE.Service, p);
                }
            }
        }, 10, 60*mojangStatusBungee.check_delay, TimeUnit.SECONDS);
    }

    private void message(boolean serviceB, String service, ProxiedPlayer p)
    {

        if(!serviceB)
        {
            String message = new String(mojangStatusBungee.message);
            message = message.replace("%service%", service);
            p.sendMessage(new TextComponent(message));
        }
    }


}
