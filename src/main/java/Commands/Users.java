package Commands;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

    public static void event(GuildMessageReceivedEvent event)
    {
        List<User> users = event.getChannel().getJDA().getUsers();
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Users inside this chat room.");
        users.forEach(user -> info.addField(user.getName(),user.getJDA().getPresence().getStatus().name(),false));
        if(users.stream().filter(user -> user.getJDA().getPresence().getStatus() != OnlineStatus.ONLINE).count() > 0)
        {
            info.setFooter("Do not disturb the idle ones!🤐");
        }else
        {
            info.setFooter("Everybody is online! Lets play games!😎");
        }

        event.getChannel().sendTyping().queue();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       event.getChannel().sendMessage(info.build()).queue();
    }

}
