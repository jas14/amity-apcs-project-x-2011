/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.amityregion5.projectx.common.entities.items.held;

import org.amityregion5.projectx.common.entities.items.DamageDealing;
import org.amityregion5.projectx.common.tools.Sound;

/**
 *
 * @author Mike DiBuduo
 */
public class BigZombieHands extends MeleeWeapon implements DamageDealing
{
    private static final long serialVersionUID = 1L;

    private static int SWORD_RATE = 42; // FIXME: arbitrary.

    public BigZombieHands(int damage)
    {
        super(SWORD_RATE, damage);
    }

    @Override
    public String getDefaultImage()
    {
        return "sprites/E_Hands";
    }

    @Override
    public Sound getSound()
    {
        return Sound.NULL_SOUND;
    }

    @Override
    public String getName()
    {
        return "BigHands";
    }

    @Override
    public int getAmmo()
    {
        return -1;
    }

   public void upgrade()
   {
      // no upgrades
   }

   public int getUpgradeCost()
   {
      return 0;
      //none
   }
}
