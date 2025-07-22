package com.meteor.eldenmessage;

import com.meteor.eldenmessage.client.ClientHandler;
import com.meteor.eldenmessage.common.CommonHandler;
import com.meteor.eldenmessage.common.entity.ModEntities;
import com.meteor.eldenmessage.common.item.ModItems;
import com.meteor.eldenmessage.lib.LibMisc;
import com.meteor.eldenmessage.network.MessageData;
import net.minecraft.nbt.CompoundTag;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.commons.compress.utils.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;

@Mod(LibMisc.MOD_ID)
public class EldenMessage {

    public static final Logger LOGGER = LogManager.getLogger(LibMisc.MOD_ID);

    public static HashMap<Integer, MessageData> tagsMap = new HashMap<>();

    public EldenMessage(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.REGISTER.register(eventBus);
        ModEntities.REGISTER.register(eventBus);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(CommonHandler::setup);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(ClientHandler::setup);
    }
}
