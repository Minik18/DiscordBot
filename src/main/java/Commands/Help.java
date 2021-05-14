package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.util.Map;

public class Help {

    public static void event(GuildMessageReceivedEvent event, Map<String,String> commands)
    {
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("❗Available commands❗");
        info.setDescription("You can command me with these commands.😁 Don't forget to take a '!' before each!");
        commands.entrySet().forEach(entry -> info.addField(entry.getKey(),entry.getValue(),false));
        info.setColor(new Color(59,201,59));
        event.getChannel().sendTyping().queue();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        event.getChannel().sendMessage(info.build()).queue();
    }

}
