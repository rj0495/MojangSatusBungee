package de.mr_splash.MojangStatusBungee.Commands;

import de.mr_splash.MojangStatusBungee.MojangStatusBungee;
import de.mr_splash.MojangStatusBungee.PingHandler.Adress;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StatusCommand extends Command
{

    private MojangStatusBungee plugin;
    public StatusCommand(MojangStatusBungee plugin)
    {
        super("mojangstatus");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings)
    {
        if(commandSender instanceof ProxiedPlayer)
        {
            ProxiedPlayer p = (ProxiedPlayer) commandSender;
            p.sendMessage(onlineMessage(plugin.ping.accounts, Adress.ACCOUNTS.Service));
            p.sendMessage(onlineMessage(plugin.ping.auth, Adress.AUTHENTICATION.Service));
            p.sendMessage(onlineMessage(plugin.ping.authServer, Adress.AUTHENTICATION_SERVER.Service));
            p.sendMessage(onlineMessage(plugin.ping.login, Adress.LOGIN.Service));
            p.sendMessage(onlineMessage(plugin.ping.session_minecraft, Adress.SESSION_MINECRAFT.Service));
            p.sendMessage(onlineMessage(plugin.ping.session_mojang, Adress.SESSION_MOJANG.Service));
            p.sendMessage(onlineMessage(plugin.ping.skins, Adress.SKINS.Service));
            p.sendMessage(onlineMessage(plugin.ping.website, Adress.MAIN_WEBSITE.Service));
        }
        else
        {
            commandSender.sendMessage("You can't do that!");
        }
    }

    public String onlineMessage(boolean isonline, String service)
    {
        if(isonline)
        {
            return ChatColor.GREEN + service + " ONLINE";
        }
        else
        {
            return ChatColor.RED + service + " OFFLINE";
        }
    }

}
