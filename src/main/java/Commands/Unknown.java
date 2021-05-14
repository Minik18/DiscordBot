package Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Unknown {

    public static void event(GuildMessageReceivedEvent event)
    {
        event.getChannel().sendTyping().queue();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        event.getChannel().sendMessage("I'm sorry but I don't recognise this command.🤨\nMaybe try this one instead : !help").queue();
    }

}
