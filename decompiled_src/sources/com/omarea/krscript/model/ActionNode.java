package com.omarea.krscript.model;

import e.p.d.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ActionNode extends RunnableNode {
    private ArrayList<ActionParamInfo> params;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionNode(String str) {
        super(str);
        i.d(str, "currentConfigXml");
    }

    public final ArrayList<ActionParamInfo> getParams() {
        return this.params;
    }

    public final void setParams(ArrayList<ActionParamInfo> arrayList) {
        this.params = arrayList;
    }
}
