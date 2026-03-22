package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a2 extends CancellationException implements w<a2> {
    public final h1 coroutine;

    public a2(String str) {
        this(str, null);
    }

    public a2(String str, h1 h1Var) {
        super(str);
        this.coroutine = h1Var;
    }

    @Override // kotlinx.coroutines.w
    public a2 createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        a2 a2Var = new a2(message, this.coroutine);
        a2Var.initCause(this);
        return a2Var;
    }
}
