package com.omarea.krscript.model;

import e.p.d.i;
import e.u.u;
import java.io.File;
import java.io.Serializable;
import java.util.UUID;

/* loaded from: classes.dex */
public class NodeInfoBase implements Serializable {
    private final String currentPageConfigPath;
    private String desc;
    private String descSh;
    private final String index;
    private String key;
    private final String pageConfigDir;
    private String summary;
    private String summarySh;
    private String title;

    public NodeInfoBase(String str) {
        String str2;
        boolean k;
        i.d(str, "currentPageConfigPath");
        this.currentPageConfigPath = str;
        if (str.length() > 0) {
            str2 = new File(this.currentPageConfigPath).getParent();
            i.c(str2, "dir");
            k = u.k(str2, "file:/android_asset/", false, 2, null);
            if (k) {
                StringBuilder sb = new StringBuilder();
                sb.append("file:///android_asset/");
                String substring = str2.substring(20);
                i.c(substring, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                str2 = sb.toString();
            }
        } else {
            str2 = "";
        }
        this.pageConfigDir = str2;
        this.key = "";
        String uuid = UUID.randomUUID().toString();
        i.c(uuid, "UUID.randomUUID().toString()");
        this.index = uuid;
        this.title = "";
        this.desc = "";
        this.descSh = "";
        this.summary = "";
        this.summarySh = "";
    }

    public final String getCurrentPageConfigPath() {
        return this.currentPageConfigPath;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDescSh() {
        return this.descSh;
    }

    public final String getIndex() {
        return this.index;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getPageConfigDir() {
        return this.pageConfigDir;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getSummarySh() {
        return this.summarySh;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setDesc(String str) {
        i.d(str, "<set-?>");
        this.desc = str;
    }

    public final void setDescSh(String str) {
        i.d(str, "<set-?>");
        this.descSh = str;
    }

    public final void setKey(String str) {
        i.d(str, "<set-?>");
        this.key = str;
    }

    public final void setSummary(String str) {
        i.d(str, "<set-?>");
        this.summary = str;
    }

    public final void setSummarySh(String str) {
        i.d(str, "<set-?>");
        this.summarySh = str;
    }

    public final void setTitle(String str) {
        i.d(str, "<set-?>");
        this.title = str;
    }
}
