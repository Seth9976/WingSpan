package com.voxelbusters.essentialkit.notificationservices.datatypes;

public enum NotificationType {
    Unknown,
    None,
    Badge,
    Sound,
    BadgeAndSound,
    Alert,
    AlertAndBadge,
    AlertAndSound,
    All;

    public boolean isAlertAllowed() [...] // 潜在的解密器

    public boolean isBadgeAllowed() [...] // 潜在的解密器

    public boolean isSoundAllowed() [...] // 潜在的解密器
}

