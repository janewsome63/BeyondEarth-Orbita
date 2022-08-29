package net.rennautogirl63.beyond_orbita.guis.screens.planetselection;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.events.ClientMethods;
import net.rennautogirl63.beyond_orbita.events.Methods;
import net.rennautogirl63.beyond_orbita.guis.screens.planetselection.helper.PlanetSelectionGuiNetworkHandlerHelper;

import java.util.function.Supplier;

import static net.rennautogirl63.beyond_orbita.events.Methods.orbit;

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

                /** Sol buttons */

                    /** Earth buttons */

                    case 0:
                        message.defaultOptions(player);
                        Methods.teleportButton(player, Methods.overworld, false);
                        break;

                    case 6:
                        message.defaultOptions(player);
                        Methods.teleportButton(player, orbit, false);
                        break;

                    case 7:
                        message.defaultOptions(player);
                        boolean obstructed = false;
                        ServerLevel level = player.getServer().getLevel(orbit);
                        test:
                        for (int y = 175; y >= 155; y--) {
                            BlockPos b = new BlockPos(player.getX(), y, player.getZ());
                            if (!level.getBlockState(b).isAir()) {
                                obstructed = true;
                                BeyondOrbitaMod.LOGGER.error("Found at: " + b);
                                break test;
                            }
                        }
                        if (!obstructed) {
                            message.deleteItems(player);
                            Methods.teleportButton(player, orbit, true);
                        } else {
                            ClientMethods.spaceStationObstructed();
                            Methods.teleportButton(player, orbit, false);
                        }
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

                case 8:
                    message.defaultOptions(player);
                    Methods.teleportButton(player, Methods.pluto, false);
                    break;

                /** Alpha Centauri buttons */

                    /** Rigil Buttons */

                    case 9:
                        message.defaultOptions(player);
                        Methods.teleportButton(player, Methods.relictus, false);
                        break;

                    case 10:
                        message.defaultOptions(player);
                        Methods.teleportButton(player, Methods.avium, false);
                        break;

                    /** Toliman Buttons */
                    case 11:
                        message.defaultOptions(player);
                        Methods.teleportButton(player, Methods.holdplacer, false);
                        break;

                    /** Proxima Buttons */
                    case 12:
                        message.defaultOptions(player);
                        Methods.teleportButton(player, Methods.vespera, false);
                        break;
            }
        });

        context.setPacketHandled(true);
    }
}
