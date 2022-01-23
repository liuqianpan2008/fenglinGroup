package org.fenglin.Command;

import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.contact.NormalMember;
import org.fenglin.GroupAPP;
import org.jetbrains.annotations.NotNull;

public class KickMeber extends JSimpleCommand {
    public KickMeber(){
        super(GroupAPP.INSTANCE, "踢人");
        setPrefixOptional(true);
    }

    @NotNull
    @Override
    public String getUsage() {
        return "(/)踢人 (目标) (理由) (是否黑名单)";
    }

    @Handler
    public void onCommand(CommandSender sender, NormalMember target,String reason ,Boolean Isblock) {
        target.kick(reason,Isblock);
    }
}
