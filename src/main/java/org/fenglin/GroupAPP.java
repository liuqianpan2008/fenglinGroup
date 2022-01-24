package org.fenglin;

import net.mamoe.mirai.console.command.CommandManager;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import org.fenglin.Command.ForbiddenWords;
import org.fenglin.Command.GroupVerification;
import org.fenglin.Command.KickMeber;
import org.fenglin.Command.Sign;

import org.fenglin.Date.MySign;
import org.fenglin.config.ToolTipsConfig;

public final class GroupAPP extends JavaPlugin {
    public static final GroupAPP INSTANCE = new GroupAPP();

    private GroupAPP() {
        super(new JvmPluginDescriptionBuilder("org.fenglin.group", "1.0")
                .name("枫林群管")
                .info("一个群管插件")
                .author("枫叶秋林")
                .build());
    }

    @Override
    public void onEnable() {
        GlobalEventChannel.INSTANCE.registerListenerHost(new MyHandler());
        reloadPluginConfig(ToolTipsConfig.ToolTipsConfig);
        reloadPluginData(MySign.Sign);

        CommandManager.INSTANCE.registerCommand(new ForbiddenWords(),true);
        CommandManager.INSTANCE.registerCommand(new KickMeber(),true);
        CommandManager.INSTANCE.registerCommand(new Sign(),true);
        CommandManager.INSTANCE.registerCommand(new GroupVerification(),true);
        getLogger().info("枫林群管已加载完成");
    }
}