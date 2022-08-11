package net.mrscauthd.beyond_earth.guis.screens.planetselection;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.mrscauthd.beyond_earth.events.Methods;
import net.mrscauthd.beyond_earth.guis.screens.planetselection.helper.PlanetSelectionGuiNetworkHandlerHelper;

import java.util.function.Supplier;

public class PlanetSelectionGuiNetworkHandler extends PlanetSelectionGuiNetworkHandlerHelper {
    public int integer;

    public PlanetSelectionGuiNetworkHandler(int integer) {
        this.integer = integer;
    }

    public PlanetSelectionGuiNetworkHandler(FriendlyByteBuf buffer) {
        this.integer = buffer.readInt();
    }

    public static PlanetSelectionGuiNetworkHandler decode(FriendlyByteBuf buffer) {
        return new PlanetSelectionGuiNetworkHandler(buffer);
    }

    public static void encode(PlanetSelectionGuiNetworkHandler message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.integer);
    }

    public static void handle(PlanetSelectionGuiNetworkHandler message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();

        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            switch (message.integer) {

                /** (SUN CATEGORY) TELEPORT BUTTONS */
                case 0:
                    message.defaultOptions(player);
                    Methods.teleportButton(player, Methods.overworld, false);
                    break;

                case 1:
                    message.defaultOptions(player);
                    Methods.teleportButton(player, Methods.moon, false);
                    break;

                case 2:
                    message.defaultOptions(player);
                    Methods.teleportButton(player, Methods.mars, false);
                    break;

                case 3:
                    message.defaultOptions(player);
                    Methods.teleportButton(player, Methods.mercury, false);
                    break;

                case 4:
                    message.defaultOptions(player);
                    Methods.teleportButton(player, Methods.venus, false);
                    break;

                case 5:
                    message.defaultOptions(player);
                    Methods.teleportButton(player, Methods.asteroid_belt, false);
                    break;

                /** (SUN CATEGORY) TELEPORT ORBIT BUTTONS */
                case 6:
                    message.defaultOptions(player);
                    Methods.teleportButton(player, Methods.orbit, false);
                    break;

                /** (SUN CATEGORY) TELEPORT ORBIT AND CREATE A SPACE STATION BUTTON */
                case 7:
                    message.defaultOptions(player);
                    message.deleteItems(player);
                    Methods.teleportButton(player, Methods.orbit, true);
                    break;

                /** (PROXIMA CENTAURI) TELEPORT BUTTONS */
                case 8:
                    message.defaultOptions(player);
                    Methods.teleportButton(player, Methods.glacio, false);
                    break;
            }
        });

        context.setPacketHandled(true);
    }
}