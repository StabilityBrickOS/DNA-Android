package com.omarea.krscript.model;

import android.content.Intent;
import android.view.View;
import d.c.b.p.r;
import e.p.d.i;

/* loaded from: classes.dex */
public interface KrScriptActionHandler {

    /* loaded from: classes.dex */
    public interface AddToFavoritesHandler {
        void onAddToFavorites(ClickableNode clickableNode, Intent intent);
    }

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static boolean openParamsPage(KrScriptActionHandler krScriptActionHandler, ActionNode actionNode, View view, Runnable runnable) {
            i.d(actionNode, "actionNode");
            i.d(view, "view");
            i.d(runnable, "onCompleted");
            return false;
        }
    }

    void addToFavorites(ClickableNode clickableNode, AddToFavoritesHandler addToFavoritesHandler);

    void onActionCompleted(RunnableNode runnableNode);

    void onSubPageClick(PageNode pageNode);

    boolean openFileChooser(r.b bVar);

    boolean openParamsPage(ActionNode actionNode, View view, Runnable runnable);
}
