package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import e.j;
import e.m.g;
import e.p.d.e;
import e.p.d.i;

/* loaded from: classes.dex */
public final class a extends b {
    private volatile a _immediate;
    private final a f;
    private final Handler g;
    private final String h;
    private final boolean i;

    public a(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ a(Handler handler, String str, int i, e eVar) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    private a(Handler handler, String str, boolean z) {
        super(null);
        this.g = handler;
        this.h = str;
        this.i = z;
        this._immediate = z ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(this.g, this.h, true);
            this._immediate = aVar;
            j jVar = j.a;
        }
        this.f = aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).g == this.g;
    }

    public int hashCode() {
        return System.identityHashCode(this.g);
    }

    @Override // kotlinx.coroutines.y
    public void n(g gVar, Runnable runnable) {
        this.g.post(runnable);
    }

    @Override // kotlinx.coroutines.y
    public boolean o(g gVar) {
        return !this.i || (i.a(Looper.myLooper(), this.g.getLooper()) ^ true);
    }

    @Override // kotlinx.coroutines.p1
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public a p() {
        return this.f;
    }

    @Override // kotlinx.coroutines.p1, kotlinx.coroutines.y
    public String toString() {
        String q = q();
        if (q != null) {
            return q;
        }
        String str = this.h;
        if (str == null) {
            str = this.g.toString();
        }
        if (!this.i) {
            return str;
        }
        return str + ".immediate";
    }
}
