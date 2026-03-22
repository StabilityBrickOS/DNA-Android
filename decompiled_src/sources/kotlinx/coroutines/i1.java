package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class i1 extends CancellationException implements w<i1> {
    public final h1 job;

    public i1(String str, Throwable th, h1 h1Var) {
        super(str);
        this.job = h1Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.w
    public i1 createCopy() {
        if (!h0.c()) {
            return null;
        }
        String message = getMessage();
        e.p.d.i.b(message);
        return new i1(message, this, this.job);
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof i1) {
                i1 i1Var = (i1) obj;
                if (!e.p.d.i.a(i1Var.getMessage(), getMessage()) || !e.p.d.i.a(i1Var.job, this.job) || !e.p.d.i.a(i1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (h0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        e.p.d.i.b(message);
        int hashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }
}
