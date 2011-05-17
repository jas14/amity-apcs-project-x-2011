/**
 * Copyright (c) 2011 Amity AP CS A Students of 2010-2011.
 *
 * ex: set filetype=java expandtab tabstop=4 shiftwidth=4 :
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation.
 */
package org.amityregion5.projectx.server;

import java.awt.image.BufferedImage;

import org.amityregion5.projectx.common.entities.Entity;

/**
 * Handles collisions
 * 
 * @author Daniel Centore
 */
public class CollisionDetection {

    // what level of opacity (0 = transparent, 255 = completely opaque) is considered opaque for pixel collisions
    public static final int OPACITY_THRESHOLD = 100;

    /**
     * Checks if two entities would collide if entity a were to move First checks if their surrounding boxes collide, then uses the pixel method if so
     * 
     * @param a Entity a
     * @param xOffset How much it moves on the x and y axis
     * @param yOffset
     * @param b Entity b
     * @return True if they would collide; false otherwise
     */
    public static boolean hasCollision(Entity a, int xOffset, int yOffset, Entity b)
    {
        return (hasRectangleCollision(a, xOffset, yOffset, b) && hasPixelCollision(a, xOffset, yOffset, b));
    }

    /**
     * Checks if two entity's bounding boxes would collide if entity a were to move (fast)
     * 
     * @param a Entity a
     * @param xOffset How much it moves on the x and y axis
     * @param yOffset
     * @param b Entity b
     * @return True if they would collide; false otherwise
     */
    public static boolean hasRectangleCollision(Entity a, int xOffset, int yOffset, Entity b)
    {
        int x = a.getX() + xOffset;
        int y = a.getY() + yOffset;

        int x1 = Math.max(x, b.getX());
        int y1 = Math.max(y, b.getY());
        int x2 = Math.min(x + a.getWidth(), b.getX() + b.getWidth());
        int y2 = Math.min(y + a.getHeight(), b.getY() + b.getHeight());

        return (x2 - x1 > 0 && y2 - y1 > 0);
    }

    /**
     * Checks if two entity's would collide by pixel if entity a were to move (slow)
     * 
     * @param a Entity a
     * @param xOffset How much it moves on the x and y axis
     * @param yOffset
     * @param b Entity b
     * @return True if they would collide; false otherwise
     */
    public static boolean hasPixelCollision(Entity a, int xOffset, int yOffset, Entity b)
    {
        return isPixelCollide(a.getX() + xOffset, a.getY() + yOffset, a.getImage(), b.getX(), b.getY(), b.getImage());
    }

//    // credits http://www.gamedev.net/topic/329033-pixel-perfect-collision-detection/
//    // NOTE: there should not have been all those offsets by 1
//    private static boolean hasOutlineCollision(Entity a, int xOffset, int yOffset, Entity b)
//    {
//        int x1 = a.getX() + xOffset;
//        int y1 = a.getY() + yOffset;
//        BufferedImage image1 = a.getImage();
//        int x2 = b.getX();
//        int y2 = b.getY();
//        BufferedImage image2 = b.getImage();
//
//        boolean[][] outlineA = a.outline.getPoints();
//        boolean[][] outlineB = b.outline.getPoints();
//
//        int width1 = x1 + image1.getWidth();
//        int height1 = y1 + image1.getHeight();
//        int width2 = x2 + image2.getWidth();
//        int height2 = y2 + image2.getHeight();
//
//        // intersection credits
//        int xstart = Math.max(x1, x2);
//        int ystart = Math.max(y1, y2);
//        int xend = Math.min(width1, width2);
//        int yend = Math.min(height1, height2);
//
//        int toty = Math.abs(yend - ystart);
//        int totx = Math.abs(xend - xstart);
//        for (int y = 0; y < toty; y++)
//        {
//            int ny = Math.abs(ystart - y1) + y;
//            int ny1 = Math.abs(ystart - y2) + y;
//            for (int x = 0; x < totx; x++)
//            {
//                int nx = Math.abs(xstart - x1) + x;
//                int nx1 = Math.abs(xstart - x2) + x;
//                if (outlineA[nx][ny] && outlineB[nx1][ny1])
//                    return true;
//            }
//        }
//        return false;
//    }

    // original credits: http://www.gamedev.net/topic/329033-pixel-perfect-collision-detection/
    // NOTE: there should not have been all those offsets by 1
    private static boolean isPixelCollide(int x1, int y1, BufferedImage image1, int x2, int y2, BufferedImage image2)
    {
        int width1 = x1 + image1.getWidth();
        int height1 = y1 + image1.getHeight();
        int width2 = x2 + image2.getWidth();
        int height2 = y2 + image2.getHeight();

        // intersection credits
        int xstart = Math.max(x1, x2);
        int ystart = Math.max(y1, y2);
        int xend = Math.min(width1, width2);
        int yend = Math.min(height1, height2);

        int toty = Math.abs(yend - ystart);
        int totx = Math.abs(xend - xstart);
        for (int y = 0; y < toty; y++)
        {
            int ny = Math.abs(ystart - y1) + y;
            int ny1 = Math.abs(ystart - y2) + y;
            for (int x = 0; x < totx; x++)
            {
                int nx = Math.abs(xstart - x1) + x;
                int nx1 = Math.abs(xstart - x2) + x;
                try
                {
                    if ((((image1.getRGB(nx, ny) >> 24) & 0xff) >= OPACITY_THRESHOLD) && ((image2.getRGB(nx1, ny1) >> 24) & 0xff) >= OPACITY_THRESHOLD)
                    {
                        // collision
                        return true;
                    }
                } catch (Exception e)
                {
                    // e.printStackTrace();
                }
            }
        }
        return false;
    }

}
