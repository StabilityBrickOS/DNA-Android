package androidx.fragment.app;

import androidx.lifecycle.d;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: b, reason: collision with root package name */
    int f405b;

    /* renamed from: c, reason: collision with root package name */
    int f406c;

    /* renamed from: d, reason: collision with root package name */
    int f407d;

    /* renamed from: e, reason: collision with root package name */
    int f408e;
    int f;
    int g;
    boolean h;
    String i;
    int j;
    CharSequence k;
    int l;
    CharSequence m;
    ArrayList<String> n;
    ArrayList<String> o;
    ArrayList<Runnable> q;
    ArrayList<a> a = new ArrayList<>();
    boolean p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {
        int a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f409b;

        /* renamed from: c, reason: collision with root package name */
        int f410c;

        /* renamed from: d, reason: collision with root package name */
        int f411d;

        /* renamed from: e, reason: collision with root package name */
        int f412e;
        int f;
        d.b g;
        d.b h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, Fragment fragment) {
            this.a = i;
            this.f409b = fragment;
            d.b bVar = d.b.RESUMED;
            this.g = bVar;
            this.h = bVar;
        }
    }

    public n b(Fragment fragment, String str) {
        f(0, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a aVar) {
        this.a.add(aVar);
        aVar.f410c = this.f405b;
        aVar.f411d = this.f406c;
        aVar.f412e = this.f407d;
        aVar.f = this.f408e;
    }

    public abstract int d();

    public abstract int e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.B;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.B + " now " + str);
            }
            fragment.B = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.z;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.z + " now " + i);
            }
            fragment.z = i;
            fragment.A = i;
        }
        c(new a(i2, fragment));
    }

    public n g(Fragment fragment) {
        c(new a(3, fragment));
        return this;
    }

    public n h(int i, Fragment fragment) {
        i(i, fragment, null);
        return this;
    }

    public n i(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        f(i, fragment, str, 2);
        return this;
    }
}
