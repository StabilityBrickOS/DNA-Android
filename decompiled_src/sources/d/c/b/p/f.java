package d.c.b.p;

import android.R;
import android.content.Context;
import android.view.ViewGroup;
import com.omarea.krscript.model.GroupNode;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f extends k {
    private ArrayList<k> h;
    private boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, boolean z, GroupNode groupNode) {
        super(context, z ? d.c.b.g.kr_group_list_root : d.c.b.g.kr_group_list_item, groupNode);
        e.p.d.i.d(context, "context");
        e.p.d.i.d(groupNode, "config");
        this.i = z;
        this.h = new ArrayList<>();
        g(groupNode.getTitle());
    }

    public final f i(k kVar) {
        e.p.d.i.d(kVar, "item");
        ((ViewGroup) c().findViewById(R.id.content)).addView(kVar.d());
        this.h.add(kVar);
        return this;
    }

    public final boolean j() {
        return this.i;
    }

    public final boolean k(String str) {
        e.p.d.i.d(str, "key");
        Iterator<k> it = this.h.iterator();
        while (it.hasNext()) {
            k next = it.next();
            if ((next instanceof e) && next.b().equals(str)) {
                ((e) next).m();
                return true;
            }
            if ((next instanceof f) && ((f) next).k(str)) {
                return true;
            }
        }
        return false;
    }

    public final void l() {
        Iterator<k> it = this.h.iterator();
        while (it.hasNext()) {
            k next = it.next();
            if (next instanceof f) {
                ((f) next).l();
            } else {
                next.h();
            }
        }
    }

    public final void m(String[] strArr) {
        e.p.d.i.d(strArr, "keys");
        for (String str : strArr) {
            if (str.equals(b())) {
                l();
            } else {
                Iterator<k> it = this.h.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next instanceof f) {
                        ((f) next).m(strArr);
                    } else if (next.b().equals(str)) {
                        next.h();
                    }
                }
            }
        }
    }
}
