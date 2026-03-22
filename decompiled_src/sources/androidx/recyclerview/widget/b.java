package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    final InterfaceC0015b a;

    /* renamed from: b, reason: collision with root package name */
    final a f539b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List<View> f540c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        long a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f541b;

        a() {
        }

        private void c() {
            if (this.f541b == null) {
                this.f541b = new a();
            }
        }

        void a(int i) {
            if (i < 64) {
                this.a &= ~(1 << i);
                return;
            }
            a aVar = this.f541b;
            if (aVar != null) {
                aVar.a(i - 64);
            }
        }

        int b(int i) {
            a aVar = this.f541b;
            return aVar == null ? i >= 64 ? Long.bitCount(this.a) : Long.bitCount(this.a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.a & ((1 << i) - 1)) : aVar.b(i - 64) + Long.bitCount(this.a);
        }

        boolean d(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            }
            c();
            return this.f541b.d(i - 64);
        }

        void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.f541b.e(i - 64, z);
                return;
            }
            boolean z2 = (this.a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.a;
            this.a = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.f541b != null) {
                c();
                this.f541b.e(0, z2);
            }
        }

        boolean f(int i) {
            if (i >= 64) {
                c();
                return this.f541b.f(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.a & j) != 0;
            long j2 = this.a & (~j);
            this.a = j2;
            long j3 = j - 1;
            this.a = (j2 & j3) | Long.rotateRight((~j3) & j2, 1);
            a aVar = this.f541b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f541b.f(0);
            }
            return z;
        }

        void g() {
            this.a = 0L;
            a aVar = this.f541b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i) {
            if (i < 64) {
                this.a |= 1 << i;
            } else {
                c();
                this.f541b.h(i - 64);
            }
        }

        public String toString() {
            if (this.f541b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.f541b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0015b {
        View a(int i);

        void b(View view);

        void c(int i);

        void d();

        RecyclerView.c0 e(View view);

        void f(int i);

        void g(View view);

        void h(View view, int i, ViewGroup.LayoutParams layoutParams);

        void i(View view, int i);

        int j(View view);

        int k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InterfaceC0015b interfaceC0015b) {
        this.a = interfaceC0015b;
    }

    private int h(int i) {
        if (i < 0) {
            return -1;
        }
        int k = this.a.k();
        int i2 = i;
        while (i2 < k) {
            int b2 = i - (i2 - this.f539b.b(i2));
            if (b2 == 0) {
                while (this.f539b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b2;
        }
        return -1;
    }

    private void l(View view) {
        this.f540c.add(view);
        this.a.b(view);
    }

    private boolean t(View view) {
        if (!this.f540c.remove(view)) {
            return false;
        }
        this.a.g(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int k = i < 0 ? this.a.k() : h(i);
        this.f539b.e(k, z);
        if (z) {
            l(view);
        }
        this.a.i(view, k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int k = i < 0 ? this.a.k() : h(i);
        this.f539b.e(k, z);
        if (z) {
            l(view);
        }
        this.a.h(view, k, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        int h = h(i);
        this.f539b.f(h);
        this.a.f(h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i) {
        int size = this.f540c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f540c.get(i2);
            RecyclerView.c0 e2 = this.a.e(view);
            if (e2.m() == i && !e2.t() && !e2.v()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f(int i) {
        return this.a.a(h(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.a.k() - this.f540c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i(int i) {
        return this.a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.a.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(View view) {
        int j = this.a.j(view);
        if (j >= 0) {
            this.f539b.h(j);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(View view) {
        int j = this.a.j(view);
        if (j == -1 || this.f539b.d(j)) {
            return -1;
        }
        return j - this.f539b.b(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f540c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f539b.g();
        for (int size = this.f540c.size() - 1; size >= 0; size--) {
            this.a.g(this.f540c.get(size));
            this.f540c.remove(size);
        }
        this.a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        int j = this.a.j(view);
        if (j < 0) {
            return;
        }
        if (this.f539b.f(j)) {
            t(view);
        }
        this.a.c(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i) {
        int h = h(i);
        View a2 = this.a.a(h);
        if (a2 == null) {
            return;
        }
        if (this.f539b.f(h)) {
            t(a2);
        }
        this.a.c(h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(View view) {
        int j = this.a.j(view);
        if (j == -1) {
            t(view);
            return true;
        }
        if (!this.f539b.d(j)) {
            return false;
        }
        this.f539b.f(j);
        t(view);
        this.a.c(j);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        int j = this.a.j(view);
        if (j < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f539b.d(j)) {
            this.f539b.a(j);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f539b.toString() + ", hidden list:" + this.f540c.size();
    }
}
