package org.fenglin.Date

import net.mamoe.mirai.console.data.AutoSavePluginData
import net.mamoe.mirai.console.data.value
import org.fenglin.Date.MySign.Sign.provideDelegate

class MyVerification {
    companion object MyVerification : AutoSavePluginData("Sign") {
        var info: Map<Long,Integer> by value()
    }
}