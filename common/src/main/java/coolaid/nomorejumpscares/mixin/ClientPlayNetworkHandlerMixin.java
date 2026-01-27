package coolaid.nomorejumpscares.mixin;

import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public class ClientPlayNetworkHandlerMixin {

    @Inject(
            method = "handleGameEvent",
            at = @At("HEAD"),
            cancellable = true
    )

    // First, check for the elder guardian effect (game event 10 in ClientboundGameEventPacket)
    // Then just cancel the entire packet handling to disable both the curse particle effect and sound
    private void onHandleGameEvent(ClientboundGameEventPacket packet, CallbackInfo ci) {
        if (packet.getEvent() == ClientboundGameEventPacket.GUARDIAN_ELDER_EFFECT) {
            ci.cancel();
        }
    }
}