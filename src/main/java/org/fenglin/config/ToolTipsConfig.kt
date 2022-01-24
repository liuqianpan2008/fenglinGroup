package org.fenglin.config

import net.mamoe.mirai.console.data.AutoSavePluginConfig

import net.mamoe.mirai.console.data.value

class ToolTipsConfig {
    companion object ToolTipsConfig : AutoSavePluginConfig("ToolTipsConfig") {
        var IsMemberJoinPrivate: Boolean by value(true)
        var IsMemberJoinGroup: Boolean by value(true)
        var IsMemberLeave: Boolean by value(true)
        var IsKickMeber: Boolean by value(true)
        var IsVerification: Boolean by value(true)
        //可用变量name
        //私聊提醒
        var MemberJoinPrivate: String by value("欢迎%name%加入本群")
        //群聊提醒
        var MemberJoinGroup: String by value("欢迎%name%加入本群")
        //离开提醒 可用变量id
        var MemberLeave: String by value("%name%离开了这个群！")
        //禁言自定义回复
        var ForbiddenWords: String by value("%name%已被%time%(S)禁言！")
        //解除自定义回复
        var UmForbiddenWords: String by value("%name%禁言已被解除！")
        var failUmForbiddenWords: String by value("%name%未被禁言")
        var KickMeber: String by value("%name%已被踢出！")
        var Signsuccess: String by value("签到成功,当前签到次数:%frequency%")
        var Signfail: String by value("今天你已签到过了")
        var Signinfo: String by value("签到成功,当前签到次数：%frequency%")
        var Verification: String by value("本群已经开启验证请私聊机器人(/)验证 验证答案，解开禁言/n本次的验证问题是：%cod%")
        var notMapVerification: String by value("你未在验证列表内")
        var Verificationsuccess: String by value("回答正确！已经解禁！")
        var Verificationfail: String by value("回答错误")
    }
}