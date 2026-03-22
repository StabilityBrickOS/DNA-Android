package e;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class f<T> implements Serializable {
    public static final a Companion = new a(null);
    private final Object value;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Serializable {
        public final Throwable exception;

        public b(Throwable th) {
            e.p.d.i.d(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && e.p.d.i.a(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    private /* synthetic */ f(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ f m265boximpl(Object obj) {
        return new f(obj);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static Object m266constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m267equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof f) && e.p.d.i.a(obj, ((f) obj2).m275unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m268equalsimpl0(Object obj, Object obj2) {
        return e.p.d.i.a(obj, obj2);
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m269exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m270getOrNullimpl(Object obj) {
        if (m272isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m271hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m272isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m273isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m274toStringimpl(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m267equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m271hashCodeimpl(this.value);
    }

    public String toString() {
        return m274toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m275unboximpl() {
        return this.value;
    }
}
