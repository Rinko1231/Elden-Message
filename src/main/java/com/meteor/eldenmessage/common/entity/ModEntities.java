package com.meteor.eldenmessage.common.entity;

import com.meteor.eldenmessage.lib.LibMisc;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModEntities {

    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, LibMisc.MOD_ID);

    public static final RegistryObject<EntityType<EntityMessage>> MESSAGE = register("message", EntityType.Builder.<EntityMessage>of((type, world) -> new EntityMessage(world), MobCategory.MISC)
            .sized(0.6F, 0.1F).fireImmune()
            .clientTrackingRange(4)
            .updateInterval(40));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return REGISTER.register(name, () -> builder.build(name));
    }
}
