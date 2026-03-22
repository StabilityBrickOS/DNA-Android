package e.p;

/* loaded from: classes.dex */
public class b extends Error {
    public b() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public b(String str) {
        super(str);
    }

    public b(String str, Throwable th) {
        super(str, th);
    }

    public b(Throwable th) {
        super(th);
    }
}
