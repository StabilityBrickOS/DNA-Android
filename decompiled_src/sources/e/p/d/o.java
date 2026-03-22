package e.p.d;

/* loaded from: classes.dex */
public class o {
    private static final p a;

    static {
        p pVar = null;
        try {
            pVar = (p) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (pVar == null) {
            pVar = new p();
        }
        a = pVar;
    }

    public static e.s.e a(g gVar) {
        a.a(gVar);
        return gVar;
    }

    public static e.s.c b(Class cls) {
        return a.b(cls);
    }

    public static e.s.d c(Class cls) {
        return a.c(cls, "");
    }

    public static String d(f fVar) {
        return a.d(fVar);
    }

    public static String e(j jVar) {
        return a.e(jVar);
    }
}
