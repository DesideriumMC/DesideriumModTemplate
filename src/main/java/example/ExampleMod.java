package example;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
@Mod(modid = ExampleMod.MOD_ID, name = ExampleMod.MOD_NAME, version = ExampleMod.VERSION)
public final class ExampleMod {
    public static final String MOD_ID = ModMetadata.MOD_ID;
    public static final String MOD_NAME = ModMetadata.MOD_NAME;
    public static final String VERSION = ModMetadata.VERSION;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("[EXAMPLE] initialized"); // Put your first breakpoint here.
    }
}
