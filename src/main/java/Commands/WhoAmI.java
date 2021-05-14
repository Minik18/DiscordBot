package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class WhoAmI {

    public static void event(GuildMessageReceivedEvent event)
    {
        User user = event.getMessage().getAuthor();
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("I am " + user.getName() + "💪");
        info.setDescription("This is my discord profile.");
        info.addField("Status :", user.getJDA().getStatus().name() + " 🟢",false);
        info.addField("Account Type : ",user.getJDA().getAccountType().name(),false);
        info.setFooter("Don't hate me for describing you.😅");
        event.getChannel().sendTyping().queue();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        event.getChannel().sendMessage(info.build()).queue();
    }

}
