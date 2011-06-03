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
package org.amityregion5.projectx.server.game.oldSpawning;

import java.awt.Point;
import java.util.ArrayList;

import org.amityregion5.projectx.common.entities.characters.enemies.Enemy;
import org.amityregion5.projectx.server.game.GameController;

/**
 * Class documentation.
 *
 * @author Michal Wenke
 * @author Jenny Liu
 * @author Mike DiBuduo
 */
public class EnemyManager {

    private GeneratorThread gen;
    private EnemyWave wave; //Current wave
    private ArrayList<Point> spawnArea;
    private GameController controller;

    public EnemyManager(GameController c, ArrayList<Point> area)
    {
        controller = c;
        spawnArea = area;
        
        EnemyGroup group = createEnemyGroup(new Enemy(50, 100, 100), 10); //Arbitrary first wave with 20 enemies w/100 health
        ArrayList<EnemyGroup> enemies = new ArrayList<EnemyGroup>();
        enemies.add(group);
        wave = new EnemyWave(1, enemies);
        gen = new GeneratorThread(controller, spawnArea, this);
        gen.addWave(wave);
    }
    
    public EnemyGroup createEnemyGroup(Enemy en, int num)
    {
        return new EnemyGroup(en, num);
    }

    public void setWave(EnemyWave w)
    {
        wave = w;
    }

    /**
     * Starts the spawning thread.
     */
    public void startSpawning()
    {
        gen.start();
    }

}