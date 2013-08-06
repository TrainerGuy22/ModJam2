package dragonborn.rift.item;

import java.lang.reflect.Field;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dragonborn.rift.RiftMod;
import dragonborn.rift.util.RiftUtil;

public class ItemDragonscaleSword extends ItemSword
{
	
	public ItemDragonscaleSword(int itemID)
	{
		super(itemID, EnumToolMaterial.EMERALD);
		setUnlocalizedName("dragonscaleSword");
		try
		{
			Field f_weaponDamage = ReflectionHelper.findField(ItemSword.class, "weaponDamage", "field_77827_a");
			float v_weaponDamage = 9.0f;
			f_weaponDamage.setAccessible(true);
			f_weaponDamage.set(this, v_weaponDamage); // MOJANG, WHY DO I HAVE TO DO THIS?!
		}
		catch (Exception e)
		{
			RiftUtil.log("Fatal exception while initializing Dragonscale Sword!");
			e.printStackTrace();
			RiftUtil.log("Dragonscale Sword will not work correctly!");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(RiftMod.MOD_ID + ":dragonscale_sword");
	}
}