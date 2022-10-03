package top.plutomc.plugin.itemcalculator.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

public final class MsgUtil {
    // 使用 private 修饰构造函数防止被实例化。
    private MsgUtil() {
    }

    public static Component deserialize(String s, TagResolver... tagResolvers) {
        return MiniMessage.miniMessage().deserialize(s, tagResolvers);
    }
}
