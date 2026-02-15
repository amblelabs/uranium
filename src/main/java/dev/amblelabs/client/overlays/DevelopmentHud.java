package dev.amblelabs.client.overlays;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;

/**
 * This isn't a necessary class, but I don't like putting a bunch of render methods in the client class.
 * @author Loqor
 */
public class DevelopmentHud {
    public static void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        guiGraphics.drawString(Minecraft.getInstance().font, "AmbleLabs Confidential", 5, 5, 0xffffffff, true);
        guiGraphics.drawString(Minecraft.getInstance().font, "-------------------", 5, 13, 0xffffffff, true);
        guiGraphics.drawString(Minecraft.getInstance().font, "1.21.11 Mod Development", 5, 21, 0xffffffff, true);
        guiGraphics.drawString(Minecraft.getInstance().font, "--------------------", 5, 29, 0xffffffff, true);
        guiGraphics.drawString(Minecraft.getInstance().font, "Uranium Mod", 5, 37, 0xffffffff, true);
        guiGraphics.drawString(Minecraft.getInstance().font, "----------", 5, 45, 0xffffffff, true);
        guiGraphics.drawString(Minecraft.getInstance().font, "v0.1.0", 5, 53, 0xffffffff, true);
    }
}
