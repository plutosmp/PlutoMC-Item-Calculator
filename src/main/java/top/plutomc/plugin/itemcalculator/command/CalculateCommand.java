package top.plutomc.plugin.itemcalculator.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import top.plutomc.plugin.itemcalculator.utils.MsgUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            list.add("提示：此处接物品数量。");
        } else {
            list.add(" ");
        }
        return list;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (args.length >= 1) {
            if (isInteger(args[0])) {
                int number = Integer.parseInt(args[0]);
                if (number <= 0) {
                    sender.sendMessage(MsgUtil.deserialize("<red>哎呀！这个数字不是大于0的数字诶~"));
                    return true;
                }
                int shulkerBoxes = number / (27 * 64);
                number -= shulkerBoxes * 27 * 64;
                int stacks = number / 64;
                number -= stacks * 64;
                StringBuilder builder = new StringBuilder("<green>计算结果出来了哟：");
                if (shulkerBoxes != 0) {
                    builder.append(shulkerBoxes).append(" 潜影盒 ");
                }
                if (stacks != 0) {
                    builder.append(stacks).append(" 组 ");
                }
                builder.append(number).append(" 个");
                sender.sendMessage(MsgUtil.deserialize(builder.toString()));
            } else if (isLong(args[0])) {
                long number = Long.parseLong(args[0]);
                if (number <= 0) {
                    sender.sendMessage(MsgUtil.deserialize("<red>哎呀！这个数字不是大于0的数字诶~"));
                    return true;
                }
                long shulkerBoxes = number / (27 * 64);
                number -= shulkerBoxes * 27 * 64;
                long stacks = number / 64;
                number -= stacks * 64;
                StringBuilder builder = new StringBuilder("<green>计算结果出来了哟：");
                if (shulkerBoxes != 0) {
                    builder.append(shulkerBoxes).append(" 潜影盒 ");
                }
                if (stacks != 0) {
                    builder.append(stacks).append(" 组 ");
                }
                builder.append(number).append(" 个");
                sender.sendMessage(MsgUtil.deserialize(builder.toString()));
            } else {
                sender.sendMessage(MsgUtil.deserialize("<red>需要输入一个整数才能计算数量哦~"));
            }
        } else {
            sender.sendMessage(MsgUtil.deserialize("<red>请输入 /calc <整数> 来计算数量哦~"));
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

    private boolean isLong(String string) {
        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }
}
