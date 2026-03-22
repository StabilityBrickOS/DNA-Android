package e.p.d;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a implements e.s.b, Serializable {
    public static final Object NO_RECEIVER = C0122a.INSTANCE;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient e.s.b reflected;
    private final String signature;

    /* renamed from: e.p.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0122a implements Serializable {
        private static final C0122a INSTANCE = new C0122a();

        private C0122a() {
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public a() {
        this(NO_RECEIVER);
    }

    protected a(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // e.s.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // e.s.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public e.s.b compute() {
        e.s.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        e.s.b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    protected abstract e.s.b computeReflected();

    @Override // e.s.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public e.s.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? o.c(cls) : o.b(cls);
    }

    @Override // e.s.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e.s.b getReflected() {
        e.s.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new e.p.b();
    }

    @Override // e.s.b
    public e.s.f getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // e.s.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // e.s.b
    public e.s.g getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // e.s.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // e.s.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // e.s.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // e.s.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
