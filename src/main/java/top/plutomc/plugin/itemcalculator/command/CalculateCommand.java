package top.plutomc.plugin.itemcalculator.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public final class CalculateCommand extends Command {

    public CalculateCommand() {
        super("calculate");
        this.setAliases(Arrays.asList(
                "calc",
                "itemcalc",
                "item-calc",
                "item-calculate",
                "calculator",
                "itemcalculator",
                "item-calculator"
        ));
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (args.length == 1) {
            if (isInteger(args[0])) {
                int number = Integer.parseInt(args[0]);
                if (number <= 0) {
                    sender.sendMessage("\u00a7c哎呀！这个数字不是大于0的数字诶~");
                    return true;
                }
                int shulkerBoxes = number / (27 * 64);
                number -= shulkerBoxes * 27 * 64;
                int stacks = number / 64;
                number -= stacks * 64;
                StringBuilder builder = new StringBuilder("\u00a7a计算结果出来了哟：");
                if (shulkerBoxes != 0) {
                    builder.append(shulkerBoxes).append(" 潜影盒 ");
                }
                if (stacks != 0) {
                    builder.append(stacks).append(" 组 ");
                }
                builder.append(number).append(" 个");
                sender.sendMessage(builder.toString());
            } else {
                sender.sendMessage("\u00a7c需要输入一个整数才能计算数量哦~");
            }
        } else {
            sender.sendMessage("\u00a7c请输入 /calc <整数> 来计算数量哦~");
        }
        return true;
    }

    private boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

}
