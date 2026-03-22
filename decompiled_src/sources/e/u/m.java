package e.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    public static <T> void a(Appendable appendable, T t, e.p.c.l<? super T, ? extends CharSequence> lVar) {
        CharSequence valueOf;
        e.p.d.i.d(appendable, "$this$appendElement");
        if (lVar != null) {
            t = (T) lVar.invoke(t);
        } else {
            if (!(t != 0 ? t instanceof CharSequence : true)) {
                if (t instanceof Character) {
                    appendable.append(((Character) t).charValue());
                    return;
                } else {
                    valueOf = String.valueOf((Object) t);
                    appendable.append(valueOf);
                }
            }
        }
        valueOf = (CharSequence) t;
        appendable.append(valueOf);
    }
}
