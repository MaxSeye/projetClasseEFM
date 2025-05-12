package org.example;

class ArmureBronze extends DecorateurArmure {
    public ArmureBronze(ComposantArmure armureDecoree) {
        super(armureDecoree);
    }

    @Override
    public int getDefense() {
        return super.getDefense() + 5;
    }
}
