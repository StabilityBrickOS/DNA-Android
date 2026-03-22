package com.omarea.krscript.model;

import e.p.d.i;

/* loaded from: classes.dex */
public final class PageMenuOption extends RunnableNode {
    private boolean isFab;
    private String mime;
    private String suffix;
    private String type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageMenuOption(String str) {
        super(str);
        i.d(str, "currentConfigXml");
        this.type = "";
        this.mime = "";
        this.suffix = "";
    }

    public final String getMime() {
        return this.mime;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isFab() {
        return this.isFab;
    }

    public final void setFab(boolean z) {
        this.isFab = z;
    }

    public final void setMime(String str) {
        i.d(str, "<set-?>");
        this.mime = str;
    }

    public final void setSuffix(String str) {
        i.d(str, "<set-?>");
        this.suffix = str;
    }

    public final void setType(String str) {
        i.d(str, "<set-?>");
        this.type = str;
    }
}
