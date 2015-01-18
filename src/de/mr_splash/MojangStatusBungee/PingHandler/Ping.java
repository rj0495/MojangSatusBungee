package de.mr_splash.MojangStatusBungee.PingHandler;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ping
{


    public boolean accounts;
    public  boolean auth;
    public boolean authServer;
    public boolean login;
    public boolean session_minecraft;
    public boolean session_mojang;
    public boolean skins;
    public boolean website;

    public void accountsOnline()
    {
        try
        {
            try
            {
                Socket s = new Socket(Adress.ACCOUNTS.Domain, 80);
                accounts = s.isConnected();
            }
            catch (UnknownHostException e)
            {
                accounts = false;
            }
        }
        catch (IOException e)
        {
            accounts = false;
        }
    }

    public void authOnline()
    {
        try
        {
            try
            {
                Socket s = new Socket(Adress.AUTHENTICATION.Domain, 80);
                auth = s.isConnected();
            }
            catch (UnknownHostException e)
            {
                auth = false;
            }
        }
        catch (IOException e)
        {
            auth = false;
        }
    }

    public void authServerOnline()
    {
        try
        {
            try
            {
                Socket s = new Socket(Adress.AUTHENTICATION_SERVER.Domain, 80);
                authServer = s.isConnected();
            }
            catch (UnknownHostException e)
            {
                authServer = false;
            }
        }
        catch (IOException e)
        {
            authServer = false;
        }
    }

    public void login()
    {
        try
        {
            try
            {
                Socket s = new Socket(Adress.LOGIN.Domain, 80);
                this.login = s.isConnected();
            }
            catch (UnknownHostException e)
            {
                this.login = false;
            }
        }
        catch (IOException e)
        {
            this.login = false;
        }
    }


    public void minecraftSessionOnline()
    {
        try
        {
            try
            {
                Socket s = new Socket(Adress.SESSION_MINECRAFT.Domain, 80);
                session_minecraft = s.isConnected();
            }
            catch (UnknownHostException e)
            {
                session_minecraft = false;
            }
        }
        catch (IOException e)
        {
            session_minecraft = false;
        }
    }

    public void mojangSessinOnline()
    {
        try
        {
            try
            {
                Socket s = new Socket(Adress.SESSION_MOJANG.Domain, 80);
                session_mojang = s.isConnected();
            }
            catch (UnknownHostException e)
            {
                session_mojang = false;
            }
        }
        catch (IOException e)
        {
            session_mojang = false;
        }
    }

    public void skinsOnline()
    {
        try
        {
            try
            {
                Socket s = new Socket(Adress.SKINS.Domain, 80);
                skins = s.isConnected();
            }
            catch (UnknownHostException e)
            {
                skins = false;
            }
        }
        catch (IOException e)
        {
            skins = false;
        }
    }

    public void minecraftWebsiteOnline()
    {
        try
        {
            try
            {
                Socket s = new Socket(Adress.MAIN_WEBSITE.Domain, 80);
                website = s.isConnected();
            }
            catch (UnknownHostException e)
            {
                website = false;
            }
        }
        catch (IOException e)
        {
            website = false;
        }
    }


}
