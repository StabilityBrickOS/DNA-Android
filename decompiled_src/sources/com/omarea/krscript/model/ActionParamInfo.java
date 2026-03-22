package com.omarea.krscript.model;

import d.c.a.e.a;
import e.p.d.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ActionParamInfo {
    private String desc;
    private boolean editable;
    private String label;
    private boolean multiple;
    private String name;
    private ArrayList<a> options;
    private ArrayList<a> optionsFromShell;
    private boolean readonly;
    private boolean required;
    private String title;
    private String type;
    private String value;
    private String valueFromShell;
    private String valueShell;
    private int maxLength = -1;
    private int max = Integer.MAX_VALUE;
    private int min = Integer.MIN_VALUE;
    private String optionsSh = "";
    private boolean supported = true;
    private String placeholder = "";
    private String mime = "";
    private String suffix = "";
    private String separator = "\n";

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public final String getMime() {
        return this.mime;
    }

    public final int getMin() {
        return this.min;
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

    public final ArrayList<a> getOptionsFromShell() {
        return this.optionsFromShell;
    }

    public final String getOptionsSh() {
        return this.optionsSh;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final boolean getReadonly() {
        return this.readonly;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final String getSeparator() {
        return this.separator;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final boolean getSupported() {
        return this.supported;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getValueFromShell() {
        return this.valueFromShell;
    }

    public final String getValueShell() {
        return this.valueShell;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setEditable(boolean z) {
        this.editable = z;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final void setMax(int i) {
        this.max = i;
    }

    public final void setMaxLength(int i) {
        this.maxLength = i;
    }

    public final void setMime(String str) {
        i.d(str, "<set-?>");
        this.mime = str;
    }

    public final void setMin(int i) {
        this.min = i;
    }

    public final void setMultiple(boolean z) {
        this.multiple = z;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOptions(ArrayList<a> arrayList) {
        this.options = arrayList;
    }

    public final void setOptionsFromShell(ArrayList<a> arrayList) {
        this.optionsFromShell = arrayList;
    }

    public final void setOptionsSh(String str) {
        i.d(str, "<set-?>");
        this.optionsSh = str;
    }

    public final void setPlaceholder(String str) {
        i.d(str, "<set-?>");
        this.placeholder = str;
    }

    public final void setReadonly(boolean z) {
        this.readonly = z;
    }

    public final void setRequired(boolean z) {
        this.required = z;
    }

    public final void setSeparator(String str) {
        i.d(str, "<set-?>");
        this.separator = str;
    }

    public final void setSuffix(String str) {
        i.d(str, "<set-?>");
        this.suffix = str;
    }

    public final void setSupported(boolean z) {
        this.supported = z;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final void setValueFromShell(String str) {
        this.valueFromShell = str;
    }

    public final void setValueShell(String str) {
        this.valueShell = str;
    }
}
