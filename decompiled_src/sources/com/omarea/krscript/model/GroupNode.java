package com.omarea.krscript.model;

import e.p.d.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class GroupNode extends NodeInfoBase {
    private final ArrayList<NodeInfoBase> children;
    private boolean supported;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupNode(String str) {
        super(str);
        i.d(str, "currentPageConfigPath");
        this.supported = true;
        this.children = new ArrayList<>();
    }

    public final ArrayList<NodeInfoBase> getChildren() {
        return this.children;
    }

    public final boolean getSupported() {
        return this.supported;
    }

    public final void setSupported(boolean z) {
        this.supported = z;
    }
}
