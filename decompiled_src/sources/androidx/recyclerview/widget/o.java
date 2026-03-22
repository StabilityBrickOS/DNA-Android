package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class o {
    final b a;

    /* renamed from: b, reason: collision with root package name */
    a f598b = new a();

    /* loaded from: classes.dex */
    static class a {
        int a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f599b;

        /* renamed from: c, reason: collision with root package name */
        int f600c;

        /* renamed from: d, reason: collision with root package name */
        int f601d;

        /* renamed from: e, reason: collision with root package name */
        int f602e;

        a() {
        }

        void a(int i) {
            this.a = i | this.a;
        }

        boolean b() {
            int i = this.a;
            if ((i & 7) != 0 && (i & (c(this.f601d, this.f599b) << 0)) == 0) {
                return false;
            }
            int i2 = this.a;
            if ((i2 & 112) != 0 && (i2 & (c(this.f601d, this.f600c) << 4)) == 0) {
                return false;
            }
            int i3 = this.a;
            if ((i3 & 1792) != 0 && (i3 & (c(this.f602e, this.f599b) << 8)) == 0) {
                return false;
            }
            int i4 = this.a;
            return (i4 & 28672) == 0 || (i4 & (c(this.f602e, this.f600c) << 12)) != 0;
        }

        int c(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void d() {
            this.a = 0;
        }

        void e(int i, int i2, int i3, int i4) {
            this.f599b = i;
            this.f600c = i2;
            this.f601d = i3;
            this.f602e = i4;
        }
    }

    /* loaded from: classes.dex */
    interface b {
        View a(int i);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar) {
        this.a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int c2 = this.a.c();
        int b2 = this.a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.a.a(i);
            this.f598b.e(c2, b2, this.a.e(a2), this.a.d(a2));
            if (i3 != 0) {
                this.f598b.d();
                this.f598b.a(i3);
                if (this.f598b.b()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                this.f598b.d();
                this.f598b.a(i4);
                if (this.f598b.b()) {
                    view = a2;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view, int i) {
        this.f598b.e(this.a.c(), this.a.b(), this.a.e(view), this.a.d(view));
        if (i == 0) {
            return false;
        }
        this.f598b.d();
        this.f598b.a(i);
        return this.f598b.b();
    }
}
