package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class b {

    /* renamed from: e, reason: collision with root package name */
    private static b f1183e;
    private final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f1184b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c, reason: collision with root package name */
    private c f1185c;

    /* renamed from: d, reason: collision with root package name */
    private c f1186d;

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0075b {
        void a();

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        final WeakReference<InterfaceC0075b> a;

        /* renamed from: b, reason: collision with root package name */
        int f1187b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1188c;

        c(int i, InterfaceC0075b interfaceC0075b) {
            this.a = new WeakReference<>(interfaceC0075b);
            this.f1187b = i;
        }

        boolean a(InterfaceC0075b interfaceC0075b) {
            return interfaceC0075b != null && this.a.get() == interfaceC0075b;
        }
    }

    private b() {
    }

    private boolean a(c cVar, int i) {
        InterfaceC0075b interfaceC0075b = cVar.a.get();
        if (interfaceC0075b == null) {
            return false;
        }
        this.f1184b.removeCallbacksAndMessages(cVar);
        interfaceC0075b.b(i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b c() {
        if (f1183e == null) {
            f1183e = new b();
        }
        return f1183e;
    }

    private boolean f(InterfaceC0075b interfaceC0075b) {
        c cVar = this.f1185c;
        return cVar != null && cVar.a(interfaceC0075b);
    }

    private boolean g(InterfaceC0075b interfaceC0075b) {
        c cVar = this.f1186d;
        return cVar != null && cVar.a(interfaceC0075b);
    }

    private void l(c cVar) {
        int i = cVar.f1187b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.f1184b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f1184b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i);
    }

    private void n() {
        c cVar = this.f1186d;
        if (cVar != null) {
            this.f1185c = cVar;
            this.f1186d = null;
            InterfaceC0075b interfaceC0075b = cVar.a.get();
            if (interfaceC0075b != null) {
                interfaceC0075b.a();
            } else {
                this.f1185c = null;
            }
        }
    }

    public void b(InterfaceC0075b interfaceC0075b, int i) {
        c cVar;
        synchronized (this.a) {
            if (f(interfaceC0075b)) {
                cVar = this.f1185c;
            } else if (g(interfaceC0075b)) {
                cVar = this.f1186d;
            }
            a(cVar, i);
        }
    }

    void d(c cVar) {
        synchronized (this.a) {
            if (this.f1185c == cVar || this.f1186d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0075b interfaceC0075b) {
        boolean z;
        synchronized (this.a) {
            z = f(interfaceC0075b) || g(interfaceC0075b);
        }
        return z;
    }

    public void h(InterfaceC0075b interfaceC0075b) {
        synchronized (this.a) {
            if (f(interfaceC0075b)) {
                this.f1185c = null;
                if (this.f1186d != null) {
                    n();
                }
            }
        }
    }

    public void i(InterfaceC0075b interfaceC0075b) {
        synchronized (this.a) {
            if (f(interfaceC0075b)) {
                l(this.f1185c);
            }
        }
    }

    public void j(InterfaceC0075b interfaceC0075b) {
        synchronized (this.a) {
            if (f(interfaceC0075b) && !this.f1185c.f1188c) {
                this.f1185c.f1188c = true;
                this.f1184b.removeCallbacksAndMessages(this.f1185c);
            }
        }
    }

    public void k(InterfaceC0075b interfaceC0075b) {
        synchronized (this.a) {
            if (f(interfaceC0075b) && this.f1185c.f1188c) {
                this.f1185c.f1188c = false;
                l(this.f1185c);
            }
        }
    }

    public void m(int i, InterfaceC0075b interfaceC0075b) {
        synchronized (this.a) {
            if (f(interfaceC0075b)) {
                this.f1185c.f1187b = i;
                this.f1184b.removeCallbacksAndMessages(this.f1185c);
                l(this.f1185c);
                return;
            }
            if (g(interfaceC0075b)) {
                this.f1186d.f1187b = i;
            } else {
                this.f1186d = new c(i, interfaceC0075b);
            }
            if (this.f1185c == null || !a(this.f1185c, 4)) {
                this.f1185c = null;
                n();
            }
        }
    }
}
