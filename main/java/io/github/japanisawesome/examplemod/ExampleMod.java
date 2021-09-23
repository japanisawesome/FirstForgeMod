package io.github.japanisawesome.examplemod;

import io.github.japanisawesome.examplemod.init.ModItems;
import io.github.japanisawesome.examplemod.items.ItemKey;
import io.github.japanisawesome.examplemod.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(
		modid = Reference.MOD_ID,
		name = Reference.NAME,
		version = Reference.VERSION,
		acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS
)
public class ExampleMod
{
	@Mod.Instance
	public static ExampleMod instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		System.out.println("Pre Init");

		ModItems.init();
		MinecraftForge.EVENT_BUS.register(new ModItems());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("Init");

		GameRegistry.addSmelting(Item.getByNameOrId("golden_apple"), new ItemStack(Item.getByNameOrId("gold_ingot")), 0.1F);

		ItemStack enchantedIronSword = new ItemStack(Item.getByNameOrId("iron_sword"));
		enchantedIronSword.addEnchantment(Enchantment.getEnchantmentByID(16), 1);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID), new ResourceLocation("sharpness_iron_sword"),
				enchantedIronSword, Ingredient.fromItem(Item.getByNameOrId("flint")), Ingredient.fromItem(Item.getByNameOrId("iron_sword")));
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("Post Init");
	}
}
