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
package org.amityregion5.projectx.common.entities.items.held;

import java.awt.Point;

/**
 * An item which releases ammo when used.
 * Generates Projectiles.
 * 
 * @author Mike DiBuduo
 * @author Joe Stein
 * @author Michael Wenke
 */
public abstract class ProjectileWeapon extends Weapon {

    private static final long serialVersionUID = 595L;
    private int ammo; // rounds that are NOT in current mag
    private int maxAmmo; // max total rounds
    private int damage;
    private int roundsPerMag; // rounds per magazine
    private int currentRounds; // rounds that are in current mag
    private Point weaponTip;

    private static final int MAG_COST = 50;

    /**
     * Creates a projectile weapon with the given characteristics.
     * @param range the range of the weapon, in linear pixels
     * @param startAmmo the ammo this weapon starts with
     * @param _maxAmmo the maximum amount of ammo this weapon can have
     * @param rate the attack rate of this weapon, in attacks per second
     * @param damage the amount of damage this weapon deals
     */
    public ProjectileWeapon(int range, int startAmmo, int _maxAmmo, double rate, int rpm, int damage)
    {
        super(range, rate);
        ammo = startAmmo - rpm;
        maxAmmo = _maxAmmo;
        roundsPerMag = rpm;
        currentRounds = rpm;
        this.damage = damage;
    }

    @Override
    public int getAmmo()
    {
        return ammo;
    }

    public int getMagCost()
    {
        return MAG_COST;
    }

    public void addAmmo(int rounds)
    {
        ammo = (rounds + ammo > maxAmmo ? maxAmmo : rounds + ammo);
    }

    public int getMaxAmmo()
    {
        return maxAmmo;
    }

    public void setMaxAmmo(int x)
    {
        maxAmmo = x;
    }

    @Override
    public void setAmmo(int ammo)
    {
        this.ammo = ammo;
    }

    public int getRoundsPerMag()
    {
        return roundsPerMag;
    }

    public int getAmmoInMag()
    {
        return currentRounds;
    }

    /**
     * Reloads the weapon, rolling over unused ammunition from the last
     * magazine.
     */
    
    public void reload()
    {
        if (currentRounds == roundsPerMag)
            return;
        if (maxAmmo == -1)
        {
            currentRounds = roundsPerMag;
            return;
        }
        if(ammo - (roundsPerMag - currentRounds) < 0) // less than a mag left
        {
            // put all the ammo into the current mag
            currentRounds += ammo;
            ammo = 0;
        }
        else
        {
            ammo -= roundsPerMag - currentRounds; // subtract difference from ammo
            currentRounds = roundsPerMag; // load up the magazine
        }
    }

    public boolean hasAmmo()
    {
        return ammo != 0;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public boolean fire()
    {
        if(currentRounds >= 1)
        {
            currentRounds--;
            return true;
        }
        return false;
    }

    public void setWeaponTip(Point p)
    {
        weaponTip = p;
    }

    public Point getWeaponTip()
    {
        return weaponTip;
    }

    public boolean isSplash()
    {
        return false;
    }
}
