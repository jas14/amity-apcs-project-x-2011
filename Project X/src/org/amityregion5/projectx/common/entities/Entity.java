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
package org.amityregion5.projectx.common.entities;

import java.awt.image.BufferedImage;

/**
 * An entity
 * 
 * @author Daniel Centore
 * @author Joe Stein
 */
public abstract class Entity {

    private double x;
    private double y;
    private BufferedImage image;
    private int directionFacing; //COnstants in EntityConstants
    private int directionMoving;
    private double moveSpeed;

    /**
     * Default entity constructor. Use as little as possible. Sets location to (0,0),
     */
    public Entity()
    {
        x = 0;
        y = 0;
        image = null;
        directionFacing = 0;
        directionMoving = 0;
        moveSpeed = 0;
    }

    /**
     * Creates a new entity
     * 
     * @param image Image for it to use
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Entity(BufferedImage image, int x, int y)
    {
        this();

        this.image = image;
        this.x = x;
        this.y = y;
    }

    /**
     * @return X coordinate
     */
    public int getX()
    {
        return (int) x;
    }

    /**
     * Sets the X coord
     * @param x
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * @return Y coordinate
     */
    public int getY()
    {
        return (int) y;
    }

    /**
     * Sets the Y coord
     * @param y
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * @return The image of this entity
     */
    public BufferedImage getImage()
    {
        return image;
    }

    /**
     * Sets the image of the entity
     * @param image Image to set it to
     */
    public void setImage(BufferedImage image)
    {
        this.image = image;
    }

    /**
     * @return Current facing direction
     */
    public int getDirectionFacing()
    {
        return directionFacing;
    }

    /**
     * Sets the current direction we are facing
     * @param directionFacing
     */
    public void setDirectionFacing(int directionFacing)
    {
        this.directionFacing = directionFacing;
    }

    /**
     * @return The direction we are moving in
     */
    public int getDirectionMoving()
    {
        return directionMoving;
    }

    /**
     * Sets the direction we are moving in
     * @param directionMoving
     */
    public void setDirectionMoving(int directionMoving)
    {
        this.directionMoving = directionMoving;
    }

    /**
     * @return The move speed
     */
    public double getMoveSpeed()
    {
        return moveSpeed;
    }

    /**
     * Sets the move speed
     * @param moveSpeed
     */
    public void setMoveSpeed(double moveSpeed)
    {
        this.moveSpeed = moveSpeed;
    }
}