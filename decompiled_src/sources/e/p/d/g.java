package e.p.d;

/* loaded from: classes.dex */
public class g extends a implements f, e.s.e {
    private final int arity;
    private final int flags;

    public g(int i) {
        this(i, a.NO_RECEIVER, null, null, null, 0);
    }

    public g(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    public g(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }

    @Override // e.p.d.a
    protected e.s.b computeReflected() {
        o.a(this);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return i.a(getOwner(), gVar.getOwner()) && getName().equals(gVar.getName()) && getSignature().equals(gVar.getSignature()) && this.flags == gVar.flags && this.arity == gVar.arity && i.a(getBoundReceiver(), gVar.getBoundReceiver());
        }
        if (obj instanceof e.s.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // e.p.d.f
    public int getArity() {
        return this.arity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.p.d.a
    public e.s.e getReflected() {
        return (e.s.e) super.getReflected();
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // e.s.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // e.s.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // e.s.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // e.s.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // e.p.d.a, e.s.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        e.s.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
