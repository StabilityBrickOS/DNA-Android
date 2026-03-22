package com.dna.tools.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.dna.tools.R;
import e.p.d.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {
    private ArrayList<View> a;

    /* renamed from: b, reason: collision with root package name */
    private TabHost f1029b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f1030c;

    public c(TabHost tabHost, Activity activity) {
        i.d(tabHost, "tabHost");
        i.d(activity, "activity");
        this.f1029b = tabHost;
        this.f1030c = activity;
        this.a = new ArrayList<>();
    }

    public final String a(String str, Drawable drawable, int i) {
        i.d(str, "text");
        i.d(drawable, "drawable");
        View inflate = View.inflate(this.f1030c, R.layout.list_item_tab, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ItemIcon);
        TextView textView = (TextView) inflate.findViewById(R.id.ItemTitle);
        String str2 = "tab_" + this.a.size();
        i.c(textView, "textView");
        textView.setText(str);
        if (this.a.size() != 0) {
            i.c(inflate, "layout");
            inflate.setAlpha(0.3f);
        }
        imageView.setImageDrawable(drawable);
        this.a.add(inflate);
        TabHost tabHost = this.f1029b;
        tabHost.addTab(tabHost.newTabSpec(str2).setContent(i).setIndicator(inflate));
        return str2;
    }

    public final void b() {
        TabWidget tabWidget = this.f1029b.getTabWidget();
        i.c(tabWidget, "tabHost.tabWidget");
        int tabCount = tabWidget.getTabCount();
        int i = 0;
        while (i < tabCount) {
            View childAt = this.f1029b.getTabWidget().getChildAt(i);
            int currentTab = this.f1029b.getCurrentTab();
            i.c(childAt, "tab");
            childAt.setAlpha(i == currentTab ? 1.0f : 0.3f);
            i++;
        }
    }
}
