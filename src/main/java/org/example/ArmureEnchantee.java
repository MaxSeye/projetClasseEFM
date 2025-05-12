package org.example;

class ArmureEnchantee extends DecorateurArmure {
    public ArmureEnchantee(ComposantArmure armureDecoree) {
        super(armureDecoree);
    }

    @Override
    public int getDefense() {
        return super.getDefense() + 20;
    }

    // Méthode spécifique pour l'armure enchantée
    public void activerEffetSpecial(Heros heros) {
        System.out.println("L'armure enchantée active son effet spécial et protège " + heros.getNom());
        // Effet spécial : augmentation temporaire des points de vie
        heros.setPointsDeVie(heros.getPointsDeVie() + 10);
    }
}
