package net.rennautogirl63.beyond_orbita.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.HashMap;

@Mod.EventBusSubscriber
public class Respawn {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("respawn")

                .then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(Respawn::execute))
                .executes(Respawn::execute));
    }

    private static int execute(CommandContext<CommandSourceStack> ctx) {
        ServerLevel world = ctx.getSource().getLevel();
        double x = ctx.getSource().getPosition().x();
        double y = ctx.getSource().getPosition().y();
        double z = ctx.getSource().getPosition().z();
        Entity entity = ctx.getSource().getEntity();
        if (entity == null)
            entity = FakePlayerFactory.getMinecraft(world);
        HashMap<String, String> cmdparams = new HashMap<>();
        int[] index = {-1};
        Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
            if (index[0] >= 0)
                cmdparams.put(Integer.toString(index[0]), param);
            index[0]++;
        });

        RespawnActions.execute(entity);
        return 0;
    }
}