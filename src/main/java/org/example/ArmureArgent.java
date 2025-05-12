package org.example;

// Décorateur concret pour l'armure d'argent
class ArmureArgent extends DecorateurArmure {
    public ArmureArgent(ComposantArmure armureDecoree) {
        super(armureDecoree);
    }

    @Override
    public int getDefense() {
        return super.getDefense() + 10;
    }
}
