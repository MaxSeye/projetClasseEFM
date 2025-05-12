package org.example;

abstract class DecorateurArmure extends ComposantArmure {
    protected ComposantArmure armureDecoree;

    public DecorateurArmure(ComposantArmure armureDecoree) {
        this.armureDecoree = armureDecoree;
    }

    @Override
    public int getDefense() {
        return armureDecoree.getDefense();
    }
}
