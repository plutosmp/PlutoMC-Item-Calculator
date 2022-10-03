package top.plutomc.plugin.itemcalculator;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;
import org.bukkit.plugin.java.annotation.plugin.author.Authors;
import top.plutomc.plugin.itemcalculator.command.CalculateCommand;

import java.lang.reflect.InvocationTargetException;

@Plugin(name = "${name}", version = "${version}") // Don't modify this! Please modify the variables in gradle.properties file!
@ApiVersion(ApiVersion.Target.v1_19)
@Authors({
        @Author("PlutoMC"),
        @Author("DeeChael")
})
@Website("plutomc.top")
@Description("PlutoMC template plugin by DeeChael")
public final class ItemCalculatorPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Permission permission = new Permission("plutomc.itemcalculator.command", PermissionDefault.TRUE);
        Bukkit.getPluginManager().addPermission(permission);
        CalculateCommand command = new CalculateCommand();
        command.setPermission(permission.getName());
        try {
            ((CommandMap) Bukkit
                    .getServer()
                    .getClass()
                    .getMethod("getCommandMap")
                    .invoke(Bukkit
                            .getServer()))
                    .register("plutomc", command);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {

    }

    public static ItemCalculatorPlugin getInstance() {
        return JavaPlugin.getPlugin(ItemCalculatorPlugin.class);
    }

}
