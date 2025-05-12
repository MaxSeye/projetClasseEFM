package org.example;

// Armure de base
class ArmureBase extends ComposantArmure {
    private int defenseBase;

    public ArmureBase(int defenseBase) {
        this.defenseBase = defenseBase;
    }

    @Override
    public int getDefense() {
        return defenseBase;
    }
}
