package e.p.d;

/* loaded from: classes.dex */
public class p {
    public e.s.e a(g gVar) {
        return gVar;
    }

    public e.s.c b(Class cls) {
        return new c(cls);
    }

    public e.s.d c(Class cls, String str) {
        return new k(cls, str);
    }

    public String d(f fVar) {
        String obj = fVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String e(j jVar) {
        return d(jVar);
    }
}
