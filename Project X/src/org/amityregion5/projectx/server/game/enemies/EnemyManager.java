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
package org.amityregion5.projectx.server.game.enemies;

import java.awt.Point;
import java.util.ArrayList;

import org.amityregion5.projectx.common.entities.characters.enemies.Enemy;

/**
 * Class documentation.
 * 
 * @author Jenny Liu
 * @author Mike DiBuduo
 */
public class EnemyManager {

    private GeneratorThread gen;
    private EnemyWave wave;
    private ArrayList<Point> spawnArea;

    public EnemyManager(ArrayList<Point> area)
    {
        spawnArea = area;
    }
    public void setWave(EnemyWave w)
    {
        wave = w;
    }

    public void addEnemies()
    {
        gen.addEnemies(wave, spawnArea);
    }

}
