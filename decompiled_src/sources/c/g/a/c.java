package c.g.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class c extends a {
    private int m;
    private int n;
    private LayoutInflater o;

    @Deprecated
    public c(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.n = i;
        this.m = i;
        this.o = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // c.g.a.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.o.inflate(this.n, viewGroup, false);
    }

    @Override // c.g.a.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.o.inflate(this.m, viewGroup, false);
    }
}
