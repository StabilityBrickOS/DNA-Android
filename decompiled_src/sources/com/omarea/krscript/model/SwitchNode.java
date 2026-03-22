package com.omarea.krscript.model;

import e.p.d.i;

/* loaded from: classes.dex */
public final class SwitchNode extends RunnableNode {
    private boolean checked;
    private String getState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchNode(String str) {
        super(str);
        i.d(str, "currentConfigXml");
        this.getState = "";
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final String getGetState() {
        return this.getState;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public final void setGetState(String str) {
        i.d(str, "<set-?>");
        this.getState = str;
    }
}
