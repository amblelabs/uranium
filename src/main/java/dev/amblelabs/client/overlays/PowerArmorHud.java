package dev.amblelabs.client.overlays;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.joml.Matrix3x2fStack;

import java.awt.*;

/**
 * This isn't a necessary class, but I don't like putting a bunch of render methods in the client class.
 * @author Loqor
 */
public class PowerArmorHud {
    public static void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        int x = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        int y = Minecraft.getInstance().getWindow().getGuiScaledHeight();
        guiGraphics.fill(0, y, x - 280, y - 70, Color.ORANGE.getRGB());
        guiGraphics.fill(x, y,
                x - 120, y - 70, Color.ORANGE.getRGB());
    }
}
