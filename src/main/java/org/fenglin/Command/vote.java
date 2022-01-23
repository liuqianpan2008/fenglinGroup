package org.fenglin.Command;

import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JCompositeCommand;
import net.mamoe.mirai.contact.Member;
import org.fenglin.GroupAPP;


import java.util.HashMap;
import java.util.Map;

public class vote extends JCompositeCommand{
    Map<Long, Integer> mute=new HashMap<>();
    public vote()  {
        super(GroupAPP.INSTANCE, "投票系统");
        setDescription("投票系统");
    }
    @SubCommand("禁言")
    public void mute(CommandSender sender, Member target) {
        mute.forEach((k,v)->{
            if (k==target.getId()){
                sender.sendMessage("该用户已在列表内");
            }
        });
        mute.put(target.getId(),0);
    }
    @SubCommand("同意")
    public void accept(CommandSender sender, Member target) {
        if (mute.get(target.getId())<1){
            mute.put(target.getId(),mute.get(target.getId())+1);
        }else{
            target.mute(60);
        }
    }

}
