package org.fenglin;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.MemberJoinEvent;
import net.mamoe.mirai.event.events.MemberLeaveEvent;
import net.mamoe.mirai.event.events.MessageEvent;

import org.fenglin.Date.MyVerification;
import org.fenglin.config.ToolTipsConfig;

import java.io.IOException;
import java.util.Map;
import java.util.Random;


public class MyHandler extends SimpleListenerHost {

    @EventHandler
    public ListeningStatus MemberJoinListener(MemberJoinEvent.Active event) {
        String name = event.getMember().getNick();
        //群验证
        if (ToolTipsConfig.ToolTipsConfig.getIsVerification()) {
            Random random = new Random();
            int a = random.nextInt(10);
            int b = random.nextInt(10);
            Map<Long, Integer> data = MyVerification.MyVerification.getInfo();
            data.put(event.getUser().getId(),a+b);
            MyVerification.MyVerification.setInfo(data);
            event.getUser().mute(30*24*60*60);
            String cod = a+"+"+b+"="+"?";
            event.getGroup().sendMessage(ToolTipsConfig.ToolTipsConfig.getVerification().replaceAll("%cod%",cod));
        }
        //群聊发送
        if (ToolTipsConfig.ToolTipsConfig.getIsMemberJoinGroup()) {
            event.getGroup().sendMessage(ToolTipsConfig.ToolTipsConfig.getMemberJoinGroup().replaceAll("%name%",name));
        }
        //私聊发送
        if (ToolTipsConfig.ToolTipsConfig.getIsMemberJoinPrivate()) {
            event.getMember().sendMessage(ToolTipsConfig.ToolTipsConfig.getMemberJoinPrivate().replaceAll("%name%",name));
        }
        return ListeningStatus.LISTENING;
    }

    @EventHandler
    public ListeningStatus MemberLeaveQuitListener(MemberLeaveEvent.Quit event) {
        String name = event.getMember().getNick();
        //群聊发送
        if (ToolTipsConfig.ToolTipsConfig.getIsMemberLeave()) {
            event.getGroup().sendMessage(ToolTipsConfig.ToolTipsConfig.getMemberLeave().replaceAll("%name%",name));
        }
        return ListeningStatus.LISTENING;
    }

    @EventHandler
    public ListeningStatus MemberLeaveKickListener(MemberLeaveEvent.Kick event) {
        String name = event.getMember().getNick();
        //群聊发送
        if (ToolTipsConfig.ToolTipsConfig.getIsKickMeber()) {
            event.getGroup().sendMessage(ToolTipsConfig.ToolTipsConfig.getKickMeber().replaceAll("%name%",name));
        }
        return ListeningStatus.LISTENING;
    }
    @EventHandler
    public ListeningStatus MessageEvent(MessageEvent event) {


        return ListeningStatus.LISTENING;
    }
}
