package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.z zVar, j jVar, View view, View view2, RecyclerView.n nVar, boolean z) {
        if (nVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(nVar.h0(view) - nVar.h0(view2)) + 1;
        }
        return Math.min(jVar.n(), jVar.d(view2) - jVar.g(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.z zVar, j jVar, View view, View view2, RecyclerView.n nVar, boolean z, boolean z2) {
        if (nVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (zVar.b() - Math.max(nVar.h0(view), nVar.h0(view2))) - 1) : Math.max(0, Math.min(nVar.h0(view), nVar.h0(view2)));
        if (z) {
            return Math.round((max * (Math.abs(jVar.d(view2) - jVar.g(view)) / (Math.abs(nVar.h0(view) - nVar.h0(view2)) + 1))) + (jVar.m() - jVar.g(view)));
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(RecyclerView.z zVar, j jVar, View view, View view2, RecyclerView.n nVar, boolean z) {
        if (nVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return zVar.b();
        }
        return (int) (((jVar.d(view2) - jVar.g(view)) / (Math.abs(nVar.h0(view) - nVar.h0(view2)) + 1)) * zVar.b());
    }
}
