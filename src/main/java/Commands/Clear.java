package Commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Clear {

    public static void event(GuildMessageReceivedEvent event, String[] command)
    {
        if(command.length < 2) {
            typing(event);
            event.getChannel().sendMessage("❌The proper usage of this command is:\n !clear <numberOfMessages>").queue();
        }else {
            Integer number = Integer.parseInt(command[1]);
            if(number > 100)
            {
                typing(event);
                event.getChannel().sendMessage("❌Don't you think that is a bit too much?\nEven I -a 🤖- can't do that!\nSorry...😥").queue();
            }else if(number < 0)
            {
                typing(event);
                event.getChannel().sendMessage("❌I can't delete minus number of messages.\nNo one ever tried to do that before.\nNo one knows what would happen.🤔\nJust, don't try it.").queue();
            }else if(number == 0)
            {
                typing(event);
                event.getChannel().sendMessage("❌I know I'm a bot who doesn't know many things, but even I don't know why would you try to delete 0 messages.🤨").queue();
            }else if(number == 1)
            {
                typing(event);
                event.getChannel().sendMessage("❌You know, we bots also have limitations as well, so please try to give me a bigger number.🤨").queue();
            }else {
                List<Message> messageList = event.getChannel().getHistory().retrievePast(number).complete();
                event.getChannel().deleteMessages(messageList).queue();
            }
        }
    }

    private static void typing(GuildMessageReceivedEvent event)
    {
        event.getChannel().sendTyping().queue();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
