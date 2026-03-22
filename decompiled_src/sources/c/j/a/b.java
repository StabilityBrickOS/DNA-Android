package c.j.a;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import c.d.h;
import c.j.b.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends c.j.a.a {

    /* renamed from: c, reason: collision with root package name */
    static boolean f843c;
    private final g a;

    /* renamed from: b, reason: collision with root package name */
    private final c f844b;

    /* loaded from: classes.dex */
    public static class a<D> extends l<D> implements a.InterfaceC0045a<D> {
        private final int j;
        private final Bundle k;
        private final c.j.b.a<D> l;
        private g m;
        private C0044b<D> n;
        private c.j.b.a<D> o;

        @Override // androidx.lifecycle.LiveData
        protected void g() {
            if (b.f843c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.l.f();
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void h() {
            if (b.f843c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.l.g();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void i(m<? super D> mVar) {
            super.i(mVar);
            this.m = null;
            this.n = null;
        }

        @Override // androidx.lifecycle.l, androidx.lifecycle.LiveData
        public void j(D d2) {
            super.j(d2);
            c.j.b.a<D> aVar = this.o;
            if (aVar != null) {
                aVar.e();
                this.o = null;
            }
        }

        c.j.b.a<D> k(boolean z) {
            if (b.f843c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l.b();
            this.l.a();
            C0044b<D> c0044b = this.n;
            if (c0044b != null) {
                i(c0044b);
                if (z) {
                    c0044b.d();
                }
            }
            this.l.h(this);
            if ((c0044b == null || c0044b.c()) && !z) {
                return this.l;
            }
            this.l.e();
            return this.o;
        }

        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.j);
            printWriter.print(" mArgs=");
            printWriter.println(this.k);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.l);
            this.l.d(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.n);
                this.n.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(m().c(d()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(e());
        }

        c.j.b.a<D> m() {
            return this.l;
        }

        void n() {
            g gVar = this.m;
            C0044b<D> c0044b = this.n;
            if (gVar == null || c0044b == null) {
                return;
            }
            super.i(c0044b);
            f(gVar, c0044b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.j);
            sb.append(" : ");
            c.f.k.a.a(this.l, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c.j.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044b<D> implements m<D> {
        public abstract void b(String str, PrintWriter printWriter);

        abstract boolean c();

        abstract void d();
    }

    /* loaded from: classes.dex */
    static class c extends p {

        /* renamed from: c, reason: collision with root package name */
        private static final q.a f845c = new a();

        /* renamed from: b, reason: collision with root package name */
        private h<a> f846b = new h<>();

        /* loaded from: classes.dex */
        static class a implements q.a {
            a() {
            }

            @Override // androidx.lifecycle.q.a
            public <T extends p> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c e(r rVar) {
            return (c) new q(rVar, f845c).a(c.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.p
        public void c() {
            super.c();
            int k = this.f846b.k();
            for (int i = 0; i < k; i++) {
                this.f846b.l(i).k(true);
            }
            this.f846b.b();
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f846b.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f846b.k(); i++) {
                    a l = this.f846b.l(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f846b.h(i));
                    printWriter.print(": ");
                    printWriter.println(l.toString());
                    l.l(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void f() {
            int k = this.f846b.k();
            for (int i = 0; i < k; i++) {
                this.f846b.l(i).n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, r rVar) {
        this.a = gVar;
        this.f844b = c.e(rVar);
    }

    @Override // c.j.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f844b.d(str, fileDescriptor, printWriter, strArr);
    }

    @Override // c.j.a.a
    public void c() {
        this.f844b.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        c.f.k.a.a(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
