package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class f {

    /* renamed from: b, reason: collision with root package name */
    int f583b;

    /* renamed from: c, reason: collision with root package name */
    int f584c;

    /* renamed from: d, reason: collision with root package name */
    int f585d;

    /* renamed from: e, reason: collision with root package name */
    int f586e;
    boolean h;
    boolean i;
    boolean a = true;
    int f = 0;
    int g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.z zVar) {
        int i = this.f584c;
        return i >= 0 && i < zVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.u uVar) {
        View o = uVar.o(this.f584c);
        this.f584c += this.f585d;
        return o;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f583b + ", mCurrentPosition=" + this.f584c + ", mItemDirection=" + this.f585d + ", mLayoutDirection=" + this.f586e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
