package c.f.h;

import android.os.Build;
import android.os.Trace;
import android.util.Log;

/* loaded from: classes.dex */
public final class a {
    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 18 || i >= 29) {
            return;
        }
        try {
            Trace.class.getField("TRACE_TAG_APP").getLong(null);
            Trace.class.getMethod("isTagEnabled", Long.TYPE);
            Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        } catch (Exception e2) {
            Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
