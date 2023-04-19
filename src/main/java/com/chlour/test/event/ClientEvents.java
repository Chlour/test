package com.chlour.test.event;

import com.chlour.test.Test;
import com.chlour.test.networking.ModMessages;
import com.chlour.test.networking.packet.DrinkWaterC2SPacket;
import com.chlour.test.networking.packet.ExampleC2SPacket;
import com.chlour.test.utils.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Test.MODID,value = Dist.CLIENT)
    public static class ClientForgeEvents{

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(KeyBinding.DRINKING_KEY.consumeClick()){
                ModMessages.sendToServer(new DrinkWaterC2SPacket());
            }

        }


    }
    @Mod.EventBusSubscriber(modid = Test.MODID,value = Dist.CLIENT,bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.DRINKING_KEY);
        }
    }
}
