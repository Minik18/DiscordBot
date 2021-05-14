package Controller;

import Commands.*;
import Main.Main;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Controller extends ListenerAdapter {

    private final String prefix = "!";

    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] command = event.getMessage().getContentRaw().split(" ");
        if(command[0].startsWith(prefix) && event.getChannel().getName().equals("bot-test")) {
            switch (command[0]) {
                case prefix + "info":
                    Info.event(event);
                    break;
                case prefix + "clear":
                    Clear.event(event, command);
                    break;
                case prefix + "whoami":
                    WhoAmI.event(event);
                    break;
                case prefix + "help":
                    Help.event(event, Main.commands);
                    break;
                case prefix + "user":
                    Users.event(event);
                    break;
                default: Unknown.event(event); break;
            }
        }
    }

}
