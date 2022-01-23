package org.fenglin.Command;

import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JCompositeCommand;

import net.mamoe.mirai.console.permission.Permission;
import net.mamoe.mirai.console.permission.PermissionId;
import net.mamoe.mirai.contact.Member;
import net.mamoe.mirai.contact.NormalMember;
import org.fenglin.GroupAPP;
import org.fenglin.config.ToolTipsConfig;
import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.jetbrains.annotations.NotNull;

public class ForbiddenWords extends JCompositeCommand {
    public ForbiddenWords(){
        super(GroupAPP.INSTANCE, "禁言系统");
        setPrefixOptional(true);
    }

    @SubCommand("禁言")
    public void mute(CommandSender sender, Member target, int time) {
        target.mute(time);
        String name=target.getNick();
        sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getForbiddenWords().replaceAll("%name%",name).replaceAll("%time%", String.valueOf(time)));
    }

    @SubCommand("解除")
    public void unmute(CommandSender sender, NormalMember target) {
        String name=target.getNick();
        if (target.isMuted()){
            target.unmute();
            sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getUmForbiddenWords().replaceAll("%name%",name));
        }else{
            sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getFailUmForbiddenWords().replaceAll("%name%",name));
        }
    }
}
