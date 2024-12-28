package io.github.suqi8.opatch.hook.systemui.StatusBar

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import io.github.suqi8.opatch.hook.appilcations.StatusBarConsumption_indicator
import io.github.suqi8.opatch.hook.appilcations.StatusBartemperature_indicator

class StatusBarhardware_indicator: YukiBaseHooker() {
    override fun onHook() {
        loadApp("com.android.systemui"){
            //功耗指示器
            if (prefs("systemui\\hardware_indicator").getBoolean("power_consumption_indicator", false)) {
                loadHooker(StatusBarConsumption_indicator())
            }
            if (prefs("systemui\\hardware_indicator").getBoolean("temperature_indicator", false)) {
                loadHooker(StatusBartemperature_indicator())
            }
        }
    }
}
