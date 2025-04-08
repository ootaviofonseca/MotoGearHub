package com.example.MotoGearHub.model;

public enum ProductCategory {
    HELMET("Helmet"),
    GLOVES("Gloves"),
    JACKET("Jacket"),
    BOOTS("Boots"),
    PANTS("Pants"),
    GOGGLES("Goggles"),
    RAIN_GEAR("Rain Gear"),
    BODY_ARMOR("Body Armor"),
    BACKPACK("Backpack"),
    EAR_PROTECTION("Ear Protection");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
