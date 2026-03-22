package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: e, reason: collision with root package name */
    g f121e;
    private int f = -1;
    private boolean g;
    private final boolean h;
    private final LayoutInflater i;
    private final int j;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.h = z;
        this.i = layoutInflater;
        this.f121e = gVar;
        this.j = i;
        a();
    }

    void a() {
        i v = this.f121e.v();
        if (v != null) {
            ArrayList<i> z = this.f121e.z();
            int size = z.size();
            for (int i = 0; i < size; i++) {
                if (z.get(i) == v) {
                    this.f = i;
                    return;
                }
            }
        }
        this.f = -1;
    }

    public g b() {
        return this.f121e;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i getItem(int i) {
        ArrayList<i> z = this.h ? this.f121e.z() : this.f121e.E();
        int i2 = this.f;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return z.get(i);
    }

    public void d(boolean z) {
        this.g = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> z = this.h ? this.f121e.z() : this.f121e.E();
        int i = this.f;
        int size = z.size();
        return i < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.i.inflate(this.j, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f121e.F() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.g) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
