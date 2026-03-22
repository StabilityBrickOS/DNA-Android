package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i {
    static final g f = new g();

    /* renamed from: e, reason: collision with root package name */
    private g f379e = null;

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void a(i iVar, Fragment fragment, Bundle bundle);

        public abstract void b(i iVar, Fragment fragment, Context context);

        public abstract void c(i iVar, Fragment fragment, Bundle bundle);

        public abstract void d(i iVar, Fragment fragment);

        public abstract void e(i iVar, Fragment fragment);

        public abstract void f(i iVar, Fragment fragment);

        public abstract void g(i iVar, Fragment fragment, Context context);

        public abstract void h(i iVar, Fragment fragment, Bundle bundle);

        public abstract void i(i iVar, Fragment fragment);

        public abstract void j(i iVar, Fragment fragment, Bundle bundle);

        public abstract void k(i iVar, Fragment fragment);

        public abstract void l(i iVar, Fragment fragment);

        public abstract void m(i iVar, Fragment fragment, View view, Bundle bundle);

        public abstract void n(i iVar, Fragment fragment);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public abstract n a();

    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public g c() {
        if (this.f379e == null) {
            this.f379e = f;
        }
        return this.f379e;
    }

    public abstract List<Fragment> d();

    public abstract void e(int i, int i2);

    public abstract boolean f();

    public void g(g gVar) {
        this.f379e = gVar;
    }
}
