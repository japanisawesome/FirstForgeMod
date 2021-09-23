package io.github.japanisawesome.examplemod.items;

import io.github.japanisawesome.examplemod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemKey extends Item
{
	public ItemKey()
	{
		this.setTranslationKey(Reference.MOD_ID + ".key");
		this.setRegistryName("key");
		this.setCreativeTab(CreativeTabs.MISC);
	}
}
