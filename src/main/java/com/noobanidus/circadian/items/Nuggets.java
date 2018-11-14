package com.noobanidus.circadian.items;

import cofh.core.item.ItemMulti;
import com.noobanidus.circadian.Circadian;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.Map;

public class Nuggets extends ItemMulti {

    public static boolean enabled = Circadian.CONFIG.get("Items.Nuggets", "Enable", true, "Enable extra nuggets.");

    public Nuggets () {
        super("circadian");

        setUnlocalizedName("nugget");
        setCreativeTab(Circadian.TAB);
    }

    public boolean init() {
        ForgeRegistries.ITEMS.register(this.setRegistryName("circadian", "nugget"));

        nuggetAquamarine = addOreDictItem(0, "nuggetAquamarine");
        nuggetIronwood = addOreDictItem(1, "nuggetIronwood");
        nuggetKnightmetal = addOreDictItem(2, "nuggetKnightmetal");
        nuggetStarmetal = addOreDictItem(3, "nuggetStarmetal");

        return true;
    }

    public void registerModels () {
        for (Map.Entry<Integer, ItemEntry> entry : itemMap.entrySet()) {
            ModelLoader.setCustomModelResourceLocation(this, entry.getKey(), new ModelResourceLocation("circadian:nugget", "type=" + entry.getValue().name));
        }
    }

    public static ItemStack nuggetAquamarine;
    public static ItemStack nuggetIronwood;
    public static ItemStack nuggetKnightmetal;
    public static ItemStack nuggetStarmetal;
}
