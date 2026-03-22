package androidx.lifecycle;

import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements e {
    private final b a;

    /* renamed from: b, reason: collision with root package name */
    private final e f432b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.a.values().length];
            a = iArr;
            try {
                iArr[d.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(b bVar, e eVar) {
        this.a = bVar;
        this.f432b = eVar;
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
                this.a.c(gVar);
                break;
            case 2:
                this.a.g(gVar);
                break;
            case 3:
                this.a.a(gVar);
                break;
            case 4:
                this.a.e(gVar);
                break;
            case 5:
                this.a.f(gVar);
                break;
            case 6:
                this.a.b(gVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        e eVar = this.f432b;
        if (eVar != null) {
            eVar.d(gVar, aVar);
        }
    }
}
