package Main;

import Controller.Controller;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.internal.handle.GuildSetupController;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String,String> commands;

    public static void main(String[] args) throws LoginException {
        if(args.length < 1)
        {
            System.out.println("I need a working token as an argument to run this bot!");
            System.exit(1);
        }else {
            setCommands();
            JDA bot = JDABuilder.createDefault(args[0]).build();
            bot.getPresence().setStatus(OnlineStatus.ONLINE);
            bot.getPresence().setActivity(Activity.listening(" commands."));
            bot.addEventListener(new Controller());
        }

    }

    private static void setCommands()
    {
        commands = new HashMap<>();
        commands.put("!help","Helps you find the commands you're looking for.");
        commands.put("!whoami","It lets you know who you are! (On discord)");
        commands.put("!info","It lets you know why I got created.");
        commands.put("!clear <numberOfMessages>","Clears the given number of messages.");
        commands.put("!user","Gives information about the users of the channel.");
    }

}
