package com.pipaengine;

import javafx.geometry.Point2D;

import java.util.LinkedList;

public class Player extends Character {
    private double defaultFov = 66 * Math.PI / 180, aimFov = 45 * Math.PI / 180, fov = defaultFov, deltaFov, zDir = 1;

    public boolean isAiming;

    //public int kills;

    public Player(double speed, double sprintSpeed, int health, int stamina, int maxHealth, int maxStamina, boolean isAiming, Point2D pos, Point2D dir, LinkedList<Weapon.Weapons> weapons) {
        super(speed, sprintSpeed, health, stamina, maxHealth, maxStamina, pos, dir, weapons);
        this.weapons.add(Weapon.Weapons.S_SWORD);
        weapon = weapons.getFirst();
        isAiming = false;
    }

    void update() {
        super.update();

        if (deltaFov != 0)
            updateFov();
    }

    void lookVertical(double delta) {
        zDir += delta;
        zDir = zDir < -2 ? -2 : zDir > 2 ? 2 : zDir;        // 2 is arbitrary
    }

    private void updateFov() {
        if (deltaFov < 0) {
            if (fov > aimFov)
                fov += deltaFov;
            else {
                fov = aimFov;
                deltaFov = 0;
            }
        }
        else {
            if (fov < defaultFov)
                fov += deltaFov;
            else {
                fov = defaultFov;
                deltaFov = 0;
            }
        }
    }

    void aim() {
        deltaFov = fov == defaultFov ? -0.055 : fov == aimFov ? 0.055 : deltaFov;
        isAiming = true;
    }

    public double getFov() {
        return fov;
    }

    public double getDefaultFov() {
        return defaultFov;
    }

    public double getzDir() {
        return zDir;
    }
}
