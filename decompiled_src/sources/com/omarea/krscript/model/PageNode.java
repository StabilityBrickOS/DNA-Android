package com.omarea.krscript.model;

import e.p.d.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class PageNode extends ClickableNode {
    private String activity;
    private String afterRead;
    private String beforeRead;
    private String link;
    private String loadFail;
    private String loadSuccess;
    private String onlineHtmlPage;
    private String pageConfigPath;
    private String pageConfigSh;
    private String pageHandlerSh;
    private ArrayList<PageMenuOption> pageMenuOptions;
    private String pageMenuOptionsSh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageNode(String str) {
        super(str);
        i.d(str, "currentConfigXml");
        this.pageConfigPath = "";
        this.pageConfigSh = "";
        this.onlineHtmlPage = "";
        this.link = "";
        this.activity = "";
        this.beforeRead = "";
        this.afterRead = "";
        this.pageMenuOptionsSh = "";
        this.pageHandlerSh = "";
        this.loadSuccess = "";
        this.loadFail = "";
    }

    public final String getActivity() {
        return this.activity;
    }

    public final String getAfterRead() {
        return this.afterRead;
    }

    public final String getBeforeRead() {
        return this.beforeRead;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getLoadFail() {
        return this.loadFail;
    }

    public final String getLoadSuccess() {
        return this.loadSuccess;
    }

    public final String getOnlineHtmlPage() {
        return this.onlineHtmlPage;
    }

    public final String getPageConfigPath() {
        return this.pageConfigPath;
    }

    public final String getPageConfigSh() {
        return this.pageConfigSh;
    }

    public final String getPageHandlerSh() {
        return this.pageHandlerSh;
    }

    public final ArrayList<PageMenuOption> getPageMenuOptions() {
        return this.pageMenuOptions;
    }

    public final String getPageMenuOptionsSh() {
        return this.pageMenuOptionsSh;
    }

    public final void setActivity(String str) {
        i.d(str, "<set-?>");
        this.activity = str;
    }

    public final void setAfterRead(String str) {
        i.d(str, "<set-?>");
        this.afterRead = str;
    }

    public final void setBeforeRead(String str) {
        i.d(str, "<set-?>");
        this.beforeRead = str;
    }

    public final void setLink(String str) {
        i.d(str, "<set-?>");
        this.link = str;
    }

    public final void setLoadFail(String str) {
        i.d(str, "<set-?>");
        this.loadFail = str;
    }

    public final void setLoadSuccess(String str) {
        i.d(str, "<set-?>");
        this.loadSuccess = str;
    }

    public final void setOnlineHtmlPage(String str) {
        i.d(str, "<set-?>");
        this.onlineHtmlPage = str;
    }

    public final void setPageConfigPath(String str) {
        i.d(str, "<set-?>");
        this.pageConfigPath = str;
    }

    public final void setPageConfigSh(String str) {
        i.d(str, "<set-?>");
        this.pageConfigSh = str;
    }

    public final void setPageHandlerSh(String str) {
        i.d(str, "<set-?>");
        this.pageHandlerSh = str;
    }

    public final void setPageMenuOptions(ArrayList<PageMenuOption> arrayList) {
        this.pageMenuOptions = arrayList;
    }

    public final void setPageMenuOptionsSh(String str) {
        i.d(str, "<set-?>");
        this.pageMenuOptionsSh = str;
    }
}
