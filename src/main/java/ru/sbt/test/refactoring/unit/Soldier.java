package ru.sbt.test.refactoring.unit;

public class Soldier extends Unit implements Combat {

    private int bulletsNumber;

    public Soldier(int bulletsNumber) {
        this.bulletsNumber = bulletsNumber;
    }

    public int getBulletsNumber() {
        return bulletsNumber;
    }

    public void setBulletsNumber(int bulletsNumber) {
        this.bulletsNumber = bulletsNumber;
    }

    @Override
    public void shoot() {
        if (bulletsNumber == 0) throw new UnsupportedOperationException("Please reload the weapon!");
        System.out.println("babah-babah");
        bulletsNumber--;
    }
}