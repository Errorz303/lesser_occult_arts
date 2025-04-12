package net.errorz.loa.event;

import com.mojang.authlib.GameProfile;
import net.errorz.loa.item.LesserOccultArtsItems;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.BannedPlayerEntry;
import net.minecraft.server.BannedPlayerList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PlayerTempBanEvent implements AttackEntityCallback {
    public PlayerTempBanEvent() {
    }

    public PlayerTempBanEvent(GameProfile gameProfile, Date date, String server, Date unbanTime, String reason) {
    }

    public ActionResult interact(PlayerEntity playerEntity, World world, Hand hand, Entity entity, @Nullable HitResult entityHitResult) {
        ItemStack offhanditem = playerEntity.getOffHandStack();
        if (offhanditem.isOf(LesserOccultArtsItems.ABYSSAL_VESSEL) && !world.isClient && entity instanceof ServerPlayerEntity targetPlayer) {
            float health = targetPlayer.getHealth();
            if (health <= 0.0F) {
                String entityName = targetPlayer.getName().getString();
                playerEntity.sendMessage(Text.literal(entityName + " was repurposed, they will return in 48 hours.").formatted(Formatting.DARK_RED));
                MinecraftServer server = targetPlayer.getServer();
                if (server != null) {
                    this.banHours(server, targetPlayer, 48);
                }

                offhanditem.decrement(1);
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }
    private void banHours(MinecraftServer server, ServerPlayerEntity player, int hours) {
        BannedPlayerList banList = server.getPlayerManager().getUserBanList();
        Date unbanTime = new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis((long)hours));
        String reason = "You have been repurposed for " + hours + " hours.";
        BannedPlayerEntry banEntry = new BannedPlayerEntry(player.getGameProfile(), new Date(), "Server", unbanTime, reason);
        banList.add(banEntry);
        player.networkHandler.disconnect(Text.literal(reason).formatted(Formatting.RED));
    }

    @Override
    public ActionResult interact(PlayerEntity playerEntity, World world, Hand hand, Entity entity, @Nullable EntityHitResult entityHitResult) {
        return null;
    }
}
