package org.example;

// Décorateur concret pour l'armure d'or
class ArmureOr extends DecorateurArmure {
    public ArmureOr(ComposantArmure armureDecoree) {
        super(armureDecoree);
    }

    @Override
    public int getDefense() {
        return super.getDefense() + 15;
    }
}
