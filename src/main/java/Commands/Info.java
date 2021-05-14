package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Info {

    public static void event(GuildMessageReceivedEvent event) {
        EmbedBuilder info = new EmbedBuilder();
        info.addField("Creator ✍","Minik",false);
        info.setTitle("💬Description about me💬");
        info.setDescription("I'm a bot programmed to help my creator get a good mark on his class! I'm a good bot!😎");
        info.setFooter("Created as a DE-IK-PTI E-sport project.");
        event.getChannel().sendTyping().queue();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        event.getChannel().sendMessage(info.build()).queue();
    }
}
