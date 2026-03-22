package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class h<E> extends e {

    /* renamed from: e, reason: collision with root package name */
    private final Activity f378e;
    private final Context f;
    private final Handler g;
    private final int h;
    final j i;

    h(Activity activity, Context context, Handler handler, int i) {
        this.i = new j();
        this.f378e = activity;
        c.f.k.h.d(context, "context == null");
        this.f = context;
        c.f.k.h.d(handler, "handler == null");
        this.g = handler;
        this.h = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this(dVar, dVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.e
    public View c(int i) {
        return null;
    }

    @Override // androidx.fragment.app.e
    public boolean f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity g() {
        return this.f378e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context i() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler j() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment) {
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E m();

    public LayoutInflater n() {
        return LayoutInflater.from(this.f);
    }

    public int o() {
        return this.h;
    }

    public boolean p() {
        return true;
    }

    public boolean q(Fragment fragment) {
        return true;
    }

    public void r() {
    }
}
