package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.q;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends androidx.lifecycle.p {
    private static final q.a h = new a();

    /* renamed from: e, reason: collision with root package name */
    private final boolean f403e;

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<Fragment> f400b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, l> f401c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, androidx.lifecycle.r> f402d = new HashMap<>();
    private boolean f = false;
    private boolean g = false;

    /* loaded from: classes.dex */
    static class a implements q.a {
        a() {
        }

        @Override // androidx.lifecycle.q.a
        public <T extends androidx.lifecycle.p> T a(Class<T> cls) {
            return new l(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(boolean z) {
        this.f403e = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l g(androidx.lifecycle.r rVar) {
        return (l) new androidx.lifecycle.q(rVar, h).a(l.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.p
    public void c() {
        if (j.L) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Fragment fragment) {
        return this.f400b.add(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment) {
        if (j.L) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        l lVar = this.f401c.get(fragment.i);
        if (lVar != null) {
            lVar.c();
            this.f401c.remove(fragment.i);
        }
        androidx.lifecycle.r rVar = this.f402d.get(fragment.i);
        if (rVar != null) {
            rVar.a();
            this.f402d.remove(fragment.i);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f400b.equals(lVar.f400b) && this.f401c.equals(lVar.f401c) && this.f402d.equals(lVar.f402d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l f(Fragment fragment) {
        l lVar = this.f401c.get(fragment.i);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this.f403e);
        this.f401c.put(fragment.i, lVar2);
        return lVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Fragment> h() {
        return this.f400b;
    }

    public int hashCode() {
        return (((this.f400b.hashCode() * 31) + this.f401c.hashCode()) * 31) + this.f402d.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.r i(Fragment fragment) {
        androidx.lifecycle.r rVar = this.f402d.get(fragment.i);
        if (rVar != null) {
            return rVar;
        }
        androidx.lifecycle.r rVar2 = new androidx.lifecycle.r();
        this.f402d.put(fragment.i, rVar2);
        return rVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(Fragment fragment) {
        return this.f400b.remove(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(Fragment fragment) {
        if (this.f400b.contains(fragment)) {
            return this.f403e ? this.f : !this.g;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f400b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f401c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f402d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
