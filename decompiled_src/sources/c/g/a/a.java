package c.g.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import c.g.a.b;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: e, reason: collision with root package name */
    protected boolean f828e;
    protected boolean f;
    protected Cursor g;
    protected Context h;
    protected int i;
    protected C0039a j;
    protected DataSetObserver k;
    protected c.g.a.b l;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c.g.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0039a extends ContentObserver {
        C0039a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f828e = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f828e = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        f(context, cursor, z ? 1 : 2);
    }

    public abstract CharSequence a(Cursor cursor);

    public void b(Cursor cursor) {
        Cursor j = j(cursor);
        if (j != null) {
            j.close();
        }
    }

    @Override // c.g.a.b.a
    public Cursor c() {
        return this.g;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i) {
        b bVar;
        if ((i & 1) == 1) {
            i |= 2;
            this.f = true;
        } else {
            this.f = false;
        }
        boolean z = cursor != null;
        this.g = cursor;
        this.f828e = z;
        this.h = context;
        this.i = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.j = new C0039a();
            bVar = new b();
        } else {
            bVar = null;
            this.j = null;
        }
        this.k = bVar;
        if (z) {
            C0039a c0039a = this.j;
            if (c0039a != null) {
                cursor.registerContentObserver(c0039a);
            }
            DataSetObserver dataSetObserver = this.k;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f828e || (cursor = this.g) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f828e) {
            return null;
        }
        this.g.moveToPosition(i);
        if (view == null) {
            view = g(this.h, this.g, viewGroup);
        }
        e(view, this.h, this.g);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.l == null) {
            this.l = new c.g.a.b(this);
        }
        return this.l;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f828e || (cursor = this.g) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.g;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f828e && (cursor = this.g) != null && cursor.moveToPosition(i)) {
            return this.g.getLong(this.i);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f828e) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.g.moveToPosition(i)) {
            if (view == null) {
                view = h(this.h, this.g, viewGroup);
            }
            e(view, this.h, this.g);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.f || (cursor = this.g) == null || cursor.isClosed()) {
            return;
        }
        this.f828e = this.g.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.g;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0039a c0039a = this.j;
            if (c0039a != null) {
                cursor2.unregisterContentObserver(c0039a);
            }
            DataSetObserver dataSetObserver = this.k;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.g = cursor;
        if (cursor != null) {
            C0039a c0039a2 = this.j;
            if (c0039a2 != null) {
                cursor.registerContentObserver(c0039a2);
            }
            DataSetObserver dataSetObserver2 = this.k;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.i = cursor.getColumnIndexOrThrow("_id");
            this.f828e = true;
            notifyDataSetChanged();
        } else {
            this.i = -1;
            this.f828e = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
