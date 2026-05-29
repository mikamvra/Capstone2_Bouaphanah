package org.example;


public class PhoDacBiet extends PhoBowl {
    public PhoDacBiet (int size){
        super("Pho Dac Biet Mika", size, true);

        this.addMeat(new ToppingPackage.MeatToppings("Brisket"));
        this.addMeat(new ToppingPackage.MeatToppings("Rare Steak"));
        this.addMeat(new ToppingPackage.MeatToppings("Meatballs"));
        this.addPremium(new ToppingPackage.PremiumToppings("Extra Noodles"));
        this.addRegular(new ToppingPackage.RegularToppings("White Onions"));
        this.addCondiment(new ToppingPackage.Condiments("Sriracha"));
        this.addCondiment(new ToppingPackage.Condiments("Hoisin Sauce"));
        this.addCondiment(new ToppingPackage.Condiments("Chili Oil"));
        this.addCondiment(new ToppingPackage.Condiments("Garlic Vinegar"));


    }
}
