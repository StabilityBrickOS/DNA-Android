package d.c.b.l;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import d.c.b.h;
import e.p.d.i;
import e.u.u;
import e.u.v;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {
    private Handler a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f1412b;

    /* renamed from: c, reason: collision with root package name */
    private String f1413c;

    /* renamed from: d, reason: collision with root package name */
    private PageNode f1414d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(c.this.f1412b, c.this.f1412b.getString(h.kr_page_sh_file_permission), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        final /* synthetic */ String f;

        b(String str) {
            this.f = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(c.this.f1412b, c.this.f1412b.getString(h.kr_page_sh_invalid) + "\n" + this.f, 1).show();
        }
    }

    public c(Activity activity, String str, PageNode pageNode) {
        i.d(activity, "activity");
        i.d(str, "pageConfigSh");
        this.f1412b = activity;
        this.f1413c = str;
        this.f1414d = pageNode;
        this.a = new Handler(Looper.getMainLooper());
    }

    private final void c() {
        this.a.post(new a());
    }

    private final void d(String str) {
        this.a.post(new b(str));
    }

    public final ArrayList<NodeInfoBase> b() {
        String str;
        boolean h;
        boolean k;
        boolean h2;
        CharSequence R;
        String b2 = d.c.b.n.b.b(this.f1412b, this.f1413c, this.f1414d);
        if (b2 == null) {
            str = null;
        } else {
            if (b2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            R = v.R(b2);
            str = R.toString();
        }
        if (str == null) {
            return null;
        }
        h = u.h(str, ".xml", false, 2, null);
        if (h) {
            Activity activity = this.f1412b;
            PageNode pageNode = this.f1414d;
            ArrayList<NodeInfoBase> i = new d.c.b.l.b(activity, str, pageNode != null ? pageNode.getPageConfigDir() : null).i();
            if (i != null) {
                return i;
            }
            c();
            return i;
        }
        k = u.k(str, "<?xml", false, 2, null);
        if (k) {
            h2 = u.h(str, ">", false, 2, null);
            if (h2) {
                byte[] bytes = str.getBytes(e.u.c.a);
                i.c(bytes, "(this as java.lang.String).getBytes(charset)");
                return new d.c.b.l.b(this.f1412b, new ByteArrayInputStream(bytes)).i();
            }
        }
        if (!(str.length() > 0)) {
            return null;
        }
        d(str);
        return null;
    }
}
