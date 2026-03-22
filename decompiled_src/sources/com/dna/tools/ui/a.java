package com.dna.tools.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.dna.tools.R;
import e.p.d.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a extends BaseAdapter {

    /* renamed from: e, reason: collision with root package name */
    private final Context f1019e;
    private final ArrayList<com.dna.tools.b> f;

    public a(Context context, ArrayList<com.dna.tools.b> arrayList) {
        i.d(context, "context");
        this.f1019e = context;
        this.f = arrayList;
    }

    private final String c(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 3) {
            return str.length() == 0 ? "0" : str;
        }
        String substring = str.substring(0, str.length() - 3);
        i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.dna.tools.b getItem(int i) {
        ArrayList<com.dna.tools.b> arrayList = this.f;
        i.b(arrayList);
        com.dna.tools.b bVar = arrayList.get(i);
        i.c(bVar, "list!![position]");
        return bVar;
    }

    public final a b(ArrayList<com.dna.tools.b> arrayList) {
        i.d(arrayList, "list");
        ArrayList<com.dna.tools.b> arrayList2 = this.f;
        i.b(arrayList2);
        arrayList2.clear();
        this.f.addAll(arrayList);
        notifyDataSetChanged();
        return this;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<com.dna.tools.b> arrayList = this.f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"SetTextI18n"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        i.d(viewGroup, "parent");
        if (view == null) {
            view = View.inflate(this.f1019e, R.layout.list_item_cpu_core, null);
        }
        com.dna.tools.b item = getItem(i);
        i.b(view);
        CpuChartBarView cpuChartBarView = (CpuChartBarView) view.findViewById(R.id.core_cpu_loading_chart);
        cpuChartBarView.a(100.0f, (100 - ((float) item.f983d)) + 0.5f);
        cpuChartBarView.invalidate();
        TextView textView = (TextView) view.findViewById(R.id.cpu_core_load);
        i.c(textView, "index");
        textView.setText(String.valueOf((int) item.f983d) + "%");
        TextView textView2 = (TextView) view.findViewById(R.id.cpu_core_current_freq);
        String c2 = c(item.f982c);
        boolean a = i.a(c2, "0");
        i.c(textView2, "currentFreq");
        if (a) {
            str = "offline";
        } else {
            str = c2 + " Mhz";
        }
        textView2.setText(str);
        TextView textView3 = (TextView) view.findViewById(R.id.cpu_core_freq_ranage);
        String str2 = c(item.a) + " ~ " + c(item.f981b) + "Mhz";
        i.c(textView3, "freqRanage");
        textView3.setText(str2);
        return view;
    }
}
