package org.fenglin.Command;

import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JCompositeCommand;

import net.mamoe.mirai.console.permission.Permission;
import net.mamoe.mirai.console.permission.PermissionId;
import org.fenglin.Date.MySign;
import org.fenglin.GroupAPP;
import org.fenglin.config.ToolTipsConfig;
import org.jetbrains.annotations.NotNull;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sign extends JCompositeCommand {

    public Sign() {
        super(GroupAPP.INSTANCE, "签到系统");
        setDescription("签到");

    }

    @SubCommand("签到")
    public void Sigen(CommandSender sender) {
        String QQ= String.valueOf(sender.getUser().getId());
        String time= String.valueOf(new Date().getTime());

        //读取数据
        List<Map<String,String>> info= MySign.Sign.getInfo();
        //寻找数据，进行签到！
        for(int i=0;i<info.size();i++){
            if (info.get(i).get("QQ").equals(QQ)){
                Map<String, String> data = info.get(i);
                long newtime = new Date().getTime();
                if (newtime-Long.parseLong(data.get("time")) >= 86400){
                    data.put("time", String.valueOf(newtime));
                    data.put("frequency",String.valueOf(Integer.parseInt(data.get("frequency"))+1));
                    sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getSignsuccess().replaceAll("%frequency%",data.get("frequency")));
                }else{
                    sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getSignfail().replaceAll("%frequency%",data.get("frequency")));
                }
                return;
            }
        }
        //没有创建账号情况下！
        Map<String,String> data=new HashMap<>();
        data.put("QQ",QQ);
        data.put("time",time);
        data.put("frequency", String.valueOf(1));
        info.add(data);
        MySign.Sign.setInfo(info);
        sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getSignsuccess().replaceAll("%frequency%",data.get("frequency")));
    }
//查看签到情况
    @SubCommand("查看信息")
    public void info(CommandSender sender) {
        String QQ= String.valueOf(sender.getUser().getId());
        List<Map<String,String>> info= MySign.Sign.getInfo();
        for(int i=0;i<info.size();i++){
            if (info.get(i).get("QQ").equals(QQ)){
                sender.sendMessage(ToolTipsConfig.ToolTipsConfig.getSigninfo().replaceAll("%frequency%",info.get(i).get("frequency")));
            }
        }
    }

}
