package io.github.japanisawesome.examplemod.init;

import io.github.japanisawesome.examplemod.Reference;
import io.github.japanisawesome.examplemod.items.ItemKey;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems
{
	public static Item key;

	public static void init()
	{
		key = new ItemKey();
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event)
	{
		System.out.println("Registering key!!!");
		event.getRegistry().register(key);
	}

	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event)
	{
		System.out.println(key.getRegistryName());
		ModelLoader.setCustomModelResourceLocation(ModItems.key, 0, new ModelResourceLocation(key.getRegistryName(), "inventory"));
	}
}
