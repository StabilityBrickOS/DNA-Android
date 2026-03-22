package e.m.j.a;

import e.p.d.o;

/* loaded from: classes.dex */
public abstract class j extends c implements e.p.d.f<Object> {
    private final int arity;

    public j(int i) {
        this(i, null);
    }

    public j(int i, e.m.d<Object> dVar) {
        super(dVar);
        this.arity = i;
    }

    @Override // e.p.d.f
    public int getArity() {
        return this.arity;
    }

    @Override // e.m.j.a.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String d2 = o.d(this);
        e.p.d.i.c(d2, "Reflection.renderLambdaToString(this)");
        return d2;
    }
}
