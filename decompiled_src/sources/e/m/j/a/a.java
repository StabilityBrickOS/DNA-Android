package e.m.j.a;

import e.f;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class a implements e.m.d<Object>, d, Serializable {
    private final e.m.d<Object> completion;

    public a(e.m.d<Object> dVar) {
        this.completion = dVar;
    }

    public e.m.d<e.j> create(e.m.d<?> dVar) {
        e.p.d.i.d(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public e.m.d<e.j> create(Object obj, e.m.d<?> dVar) {
        e.p.d.i.d(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @Override // e.m.j.a.d
    public d getCallerFrame() {
        e.m.d<Object> dVar = this.completion;
        if (!(dVar instanceof d)) {
            dVar = null;
        }
        return (d) dVar;
    }

    public final e.m.d<Object> getCompletion() {
        return this.completion;
    }

    @Override // e.m.d
    public abstract /* synthetic */ e.m.g getContext();

    @Override // e.m.j.a.d
    public StackTraceElement getStackTraceElement() {
        return f.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    @Override // e.m.d
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object d2;
        a aVar = this;
        while (true) {
            g.b(aVar);
            e.m.d<Object> dVar = aVar.completion;
            e.p.d.i.b(dVar);
            try {
                invokeSuspend = aVar.invokeSuspend(obj);
                d2 = e.m.i.d.d();
            } catch (Throwable th) {
                f.a aVar2 = e.f.Companion;
                obj = e.f.m266constructorimpl(e.g.a(th));
            }
            if (invokeSuspend == d2) {
                return;
            }
            f.a aVar3 = e.f.Companion;
            obj = e.f.m266constructorimpl(invokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar instanceof a)) {
                dVar.resumeWith(obj);
                return;
            }
            aVar = (a) dVar;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }
}
