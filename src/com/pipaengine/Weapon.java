package com.pipaengine;

import java.util.Hashtable;

public class Weapon {
    enum Weapons {
        S_SWORD
    }

    int power, accuracy;

    private static Hashtable<Weapons, Weapon> weapons = new Hashtable<>();

    public Weapon(int power, int accuracy) {
        this.power = power;
        this.accuracy = accuracy;
    }

    static void initWeapons() {
        weapons.put(Weapons.S_SWORD, new Weapon(10, 1));
    }
}