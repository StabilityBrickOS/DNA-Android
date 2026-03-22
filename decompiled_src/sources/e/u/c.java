package e.u;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class c {
    public static final Charset a;

    static {
        Charset forName = Charset.forName("UTF-8");
        e.p.d.i.c(forName, "Charset.forName(\"UTF-8\")");
        a = forName;
        e.p.d.i.c(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        e.p.d.i.c(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        e.p.d.i.c(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        e.p.d.i.c(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        e.p.d.i.c(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
