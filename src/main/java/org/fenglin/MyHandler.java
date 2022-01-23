package org.fenglin;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.MemberJoinEvent;
import net.mamoe.mirai.event.events.MemberLeaveEvent;
import org.fenglin.config.ToolTipsConfig;

import java.io.IOException;


public class MyHandler extends SimpleListenerHost {

    @EventHandler
    public ListeningStatus MemberJoinListener(MemberJoinEvent.Active event) throws IOException {
        String name = event.getMember().getNameCard();
        //群聊发送
        if (!ToolTipsConfig.ToolTipsConfig.getMemberJoinGroup().equals("")) {
            event.getGroup().sendMessage(ToolTipsConfig.ToolTipsConfig.getMemberJoinGroup().replaceAll("%name%",name));
        }
        if (!ToolTipsConfig.ToolTipsConfig.getMemberJoinPrivate().equals("")) {
            event.getMember().sendMessage(ToolTipsConfig.ToolTipsConfig.getMemberJoinPrivate().replaceAll("%name%",name));
        }
        return ListeningStatus.LISTENING;
    }

    @EventHandler
    public ListeningStatus MemberLeaveQuitListener(MemberLeaveEvent.Quit event) throws IOException {
        String name = String.valueOf(event.getMember().getId());
        //群聊发送
        if (!ToolTipsConfig.ToolTipsConfig.getMemberJoinGroup().equals("")) {
            event.getGroup().sendMessage(ToolTipsConfig.ToolTipsConfig.getMemberLeave().replaceAll("%name%",name));
        }
        return ListeningStatus.LISTENING;
    }

    @EventHandler
    public ListeningStatus MemberLeaveKickListener(MemberLeaveEvent.Kick event) throws IOException {
        String name = String.valueOf(event.getMember().getId());
        //群聊发送
        if (!ToolTipsConfig.ToolTipsConfig.getMemberJoinGroup().equals("")) {
            event.getGroup().sendMessage(ToolTipsConfig.ToolTipsConfig.getKickMeber().replaceAll("%name%",name));
        }
        return ListeningStatus.LISTENING;
    }
}
