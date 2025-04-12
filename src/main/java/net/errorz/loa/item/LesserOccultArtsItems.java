package net.errorz.loa.item;

import net.errorz.loa.LesserOccultArts;
import net.errorz.loa.item.custom.DaggerBound;
import net.errorz.loa.item.custom.DaggerUnbound;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;




public class LesserOccultArtsItems{
    public static final Item ABYSSAL_CRYSTAL = registerItem("abyssal_crystal",
            new Item(new FabricItemSettings().food(LesserOccultArtsFoodComponents.ABYSSAL_CRYSTAL)));

    public static final Item ABYSSAL_VESSEL = registerItem("abyssal_vessel",
            new Item(new FabricItemSettings().maxCount(1)));;

    public static final Item MONARCHS_SEAL = registerItem("monarchs_seal",
            new Item(new FabricItemSettings().maxCount(1)));;

    public static final Item COVENANT_DAGGER_BOUND = registerItem("covenant_dagger_bound",
            new DaggerBound(LesserOccultArtsToolMaterial.CULTIST, 1, -2f,
                    new FabricItemSettings().maxCount(1)));

    public static final Item COVENANT_DAGGER_UNBOUND = registerItem("covenant_dagger_unbound",
            new DaggerUnbound(LesserOccultArtsToolMaterial.CULTIST, 1, -2f,
                    new FabricItemSettings().maxCount(1)));

    public static final Item GREATSWORD_OF_THE_DAMNED = registerItem("greatsword_of_the_damned",
            new SwordItem(LesserOccultArtsToolMaterial.CULTIST, 5, -2.7f,
                    new FabricItemSettings().maxCount(1)));

    public static final Item RITUAL_BLADE = registerItem("ritual_blade",
            new SwordItem(LesserOccultArtsToolMaterial.CULTIST, 3, -2.2f,
                    new FabricItemSettings().maxCount(1)));

    public static final Item ABYSSAL_CROWN = registerItem("abyssal_crown",
            new ArmorItem(ModArmorMaterials.CULTIST, EquipmentSlot.HEAD, new FabricItemSettings()));





    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(LesserOccultArts.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LesserOccultArts.LOGGER.debug("Registering Mod Items for " + LesserOccultArts.MOD_ID);
    }
}
