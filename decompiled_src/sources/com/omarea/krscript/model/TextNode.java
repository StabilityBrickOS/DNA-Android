package com.omarea.krscript.model;

import android.text.Layout;
import e.p.d.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class TextNode extends NodeInfoBase {
    private final ArrayList<TextRow> rows;

    /* loaded from: classes.dex */
    public static final class TextRow {
        private boolean bold;
        private boolean breakRow;
        private boolean italic;
        private boolean underline;
        private int size = -1;
        private int color = -1;
        private int bgColor = -1;
        private Layout.Alignment align = Layout.Alignment.ALIGN_NORMAL;
        private String link = "";
        private String activity = "";
        private String text = "";
        private String dynamicTextSh = "";
        private String onClickScript = "";

        public final String getActivity$krscript_release_mini() {
            return this.activity;
        }

        public final Layout.Alignment getAlign$krscript_release_mini() {
            return this.align;
        }

        public final int getBgColor$krscript_release_mini() {
            return this.bgColor;
        }

        public final boolean getBold$krscript_release_mini() {
            return this.bold;
        }

        public final boolean getBreakRow$krscript_release_mini() {
            return this.breakRow;
        }

        public final int getColor$krscript_release_mini() {
            return this.color;
        }

        public final String getDynamicTextSh$krscript_release_mini() {
            return this.dynamicTextSh;
        }

        public final boolean getItalic$krscript_release_mini() {
            return this.italic;
        }

        public final String getLink$krscript_release_mini() {
            return this.link;
        }

        public final String getOnClickScript$krscript_release_mini() {
            return this.onClickScript;
        }

        public final int getSize$krscript_release_mini() {
            return this.size;
        }

        public final String getText$krscript_release_mini() {
            return this.text;
        }

        public final boolean getUnderline$krscript_release_mini() {
            return this.underline;
        }

        public final void setActivity$krscript_release_mini(String str) {
            i.d(str, "<set-?>");
            this.activity = str;
        }

        public final void setAlign$krscript_release_mini(Layout.Alignment alignment) {
            i.d(alignment, "<set-?>");
            this.align = alignment;
        }

        public final void setBgColor$krscript_release_mini(int i) {
            this.bgColor = i;
        }

        public final void setBold$krscript_release_mini(boolean z) {
            this.bold = z;
        }

        public final void setBreakRow$krscript_release_mini(boolean z) {
            this.breakRow = z;
        }

        public final void setColor$krscript_release_mini(int i) {
            this.color = i;
        }

        public final void setDynamicTextSh$krscript_release_mini(String str) {
            i.d(str, "<set-?>");
            this.dynamicTextSh = str;
        }

        public final void setItalic$krscript_release_mini(boolean z) {
            this.italic = z;
        }

        public final void setLink$krscript_release_mini(String str) {
            i.d(str, "<set-?>");
            this.link = str;
        }

        public final void setOnClickScript$krscript_release_mini(String str) {
            i.d(str, "<set-?>");
            this.onClickScript = str;
        }

        public final void setSize$krscript_release_mini(int i) {
            this.size = i;
        }

        public final void setText$krscript_release_mini(String str) {
            i.d(str, "<set-?>");
            this.text = str;
        }

        public final void setUnderline$krscript_release_mini(boolean z) {
            this.underline = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextNode(String str) {
        super(str);
        i.d(str, "currentPageConfigPath");
        this.rows = new ArrayList<>();
    }

    public final ArrayList<TextRow> getRows() {
        return this.rows;
    }
}
