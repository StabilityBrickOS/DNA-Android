package com.omarea.krscript.model;

import d.c.a.e.a;
import e.p.d.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class PickerNode extends RunnableNode {
    private String getState;
    private boolean multiple;
    private String name;
    private ArrayList<a> options;
    private String optionsSh;
    private String separator;
    private String value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerNode(String str) {
        super(str);
        i.d(str, "currentConfigXml");
        this.optionsSh = "";
        this.name = "";
        this.separator = "\n";
    }

    public final String getGetState() {
        return this.getState;
    }

    public final boolean getMultiple() {
        return this.multiple;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<a> getOptions() {
        return this.options;
    }

    public final String getOptionsSh() {
        return this.optionsSh;
    }

    public final String getSeparator() {
        return this.separator;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setGetState(String str) {
        this.getState = str;
    }

    public final void setMultiple(boolean z) {
        this.multiple = z;
    }

    public final void setName(String str) {
        i.d(str, "<set-?>");
        this.name = str;
    }

    public final void setOptions(ArrayList<a> arrayList) {
        this.options = arrayList;
    }

    public final void setOptionsSh(String str) {
        i.d(str, "<set-?>");
        this.optionsSh = str;
    }

    public final void setSeparator(String str) {
        i.d(str, "<set-?>");
        this.separator = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
