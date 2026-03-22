package com.omarea.krscript.model;

import e.p.d.i;

/* loaded from: classes.dex */
public class ClickableNode extends NodeInfoBase {
    private Boolean allowShortcut;
    private String iconPath;
    private String lockShell;
    private boolean locked;
    private String logoPath;
    private int maxSdkVersion;
    private int minSdkVersion;
    private int targetSdkVersion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableNode(String str) {
        super(str);
        i.d(str, "currentPageConfigPath");
        this.iconPath = "";
        this.logoPath = "";
        this.lockShell = "";
        this.maxSdkVersion = 100;
    }

    public final Boolean getAllowShortcut() {
        return this.allowShortcut;
    }

    public final String getIconPath() {
        return this.iconPath;
    }

    public final String getLockShell() {
        return this.lockShell;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final String getLogoPath() {
        return this.logoPath;
    }

    public final int getMaxSdkVersion() {
        return this.maxSdkVersion;
    }

    public final int getMinSdkVersion() {
        return this.minSdkVersion;
    }

    public final int getTargetSdkVersion() {
        return this.targetSdkVersion;
    }

    public final void setAllowShortcut(Boolean bool) {
        this.allowShortcut = bool;
    }

    public final void setIconPath(String str) {
        i.d(str, "<set-?>");
        this.iconPath = str;
    }

    public final void setLockShell(String str) {
        i.d(str, "<set-?>");
        this.lockShell = str;
    }

    public final void setLocked(boolean z) {
        this.locked = z;
    }

    public final void setLogoPath(String str) {
        i.d(str, "<set-?>");
        this.logoPath = str;
    }

    public final void setMaxSdkVersion(int i) {
        this.maxSdkVersion = i;
    }

    public final void setMinSdkVersion(int i) {
        this.minSdkVersion = i;
    }

    public final void setTargetSdkVersion(int i) {
        this.targetSdkVersion = i;
    }
}
