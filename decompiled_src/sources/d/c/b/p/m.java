package d.c.b.p;

import android.content.Context;
import com.omarea.krscript.model.PageMenuOption;
import com.omarea.krscript.model.PageNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class m {
    private ArrayList<PageMenuOption> a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1480b;

    /* renamed from: c, reason: collision with root package name */
    private final PageNode f1481c;

    public m(Context context, PageNode pageNode) {
        e.p.d.i.d(context, "applicationContext");
        e.p.d.i.d(pageNode, "pageNode");
        this.f1480b = context;
        this.f1481c = pageNode;
    }

    public final ArrayList<PageMenuOption> a() {
        List<String> H;
        boolean n;
        List H2;
        PageNode pageNode = this.f1481c;
        if (this.a == null) {
            if (pageNode.getPageMenuOptionsSh().length() > 0) {
                String b2 = d.c.b.n.b.b(this.f1480b, pageNode.getPageMenuOptionsSh(), pageNode);
                if (!e.p.d.i.a(b2, "error")) {
                    e.p.d.i.c(b2, "result");
                    H = e.u.v.H(b2, new String[]{"\n"}, false, 0, 6, null);
                    for (String str : H) {
                        PageMenuOption pageMenuOption = new PageMenuOption(pageNode.getPageConfigPath());
                        n = e.u.v.n(str, "|", false, 2, null);
                        if (n) {
                            H2 = e.u.v.H(str, new String[]{"|"}, false, 0, 6, null);
                            pageMenuOption.setKey((String) H2.get(0));
                            str = (String) H2.get(1);
                        } else {
                            pageMenuOption.setKey(str);
                        }
                        pageMenuOption.setTitle(str);
                    }
                }
            } else if (pageNode.getPageMenuOptions() != null) {
                this.a = pageNode.getPageMenuOptions();
            }
        }
        return this.a;
    }
}
