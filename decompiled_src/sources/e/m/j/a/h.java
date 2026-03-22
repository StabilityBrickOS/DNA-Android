package e.m.j.a;

import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static a f1536b;

    /* renamed from: c, reason: collision with root package name */
    public static final h f1537c = new h();
    private static final a a = new a(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f1538b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f1539c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.f1538b = method2;
            this.f1539c = method3;
        }
    }

    private h() {
    }

    private final a a(e.m.j.a.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f1536b = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = a;
            f1536b = aVar3;
            return aVar3;
        }
    }

    public final String b(e.m.j.a.a aVar) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        e.p.d.i.d(aVar, "continuation");
        a aVar2 = f1536b;
        if (aVar2 == null) {
            aVar2 = a(aVar);
        }
        if (aVar2 == a || (method = aVar2.a) == null || (invoke = method.invoke(aVar.getClass(), new Object[0])) == null || (method2 = aVar2.f1538b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar2.f1539c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        return (String) (invoke3 instanceof String ? invoke3 : null);
    }
}
