package org.fenglin.Command;

import net.mamoe.mirai.console.command.CommandOwner;
import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.NormalMember;
import net.mamoe.mirai.contact.User;
import org.fenglin.Date.MyVerification;
import org.fenglin.GroupAPP;
import org.fenglin.config.ToolTipsConfig;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class GroupVerification extends JSimpleCommand {
    public GroupVerification(){
        super(GroupAPP.INSTANCE, "入群验证");
        setPrefixOptional(true);
    }
    @NotNull
    @Override
    public String getUsage() {
        return "(/)入群验证 (群号) (答案)";
    }

    @Handler
    public void onCommand(CommandSender sender, Group Qgroup, int A) {
        Map<Long, Integer> data = MyVerification.MyVerification.getInfo();
        if (data.get(sender.getUser().getId())==null){
            sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getNotMapVerification());
            return;
        }
        if(data.get(sender.getUser().getId()) == A){
             Qgroup.getMembers().get(sender.getUser().getId()).unmute();
             data.remove(sender.getUser().getId());
             sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getVerificationsuccess());
        }else{
            sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getVerificationfail());
        };
    }
}
