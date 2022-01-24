package org.fenglin.Date

import net.mamoe.mirai.console.data.AutoSavePluginData
import net.mamoe.mirai.console.data.value

class MySign {
   companion object Sign : AutoSavePluginData("Sign") { // 文件名为 MyData, 会被保存为 MyData.yml
       var info: List<Map<String,String>> by value()
   }
}