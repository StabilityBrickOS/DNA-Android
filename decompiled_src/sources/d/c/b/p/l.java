package d.c.b.p;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.ClickableNode;
import com.omarea.krscript.model.GroupNode;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.PickerNode;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.krscript.model.SwitchNode;
import com.omarea.krscript.model.TextNode;
import d.c.b.p.e;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l {
    private final e.c a;

    /* renamed from: b, reason: collision with root package name */
    private final d f1474b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f1475c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<NodeInfoBase> f1476d;

    /* renamed from: e, reason: collision with root package name */
    private final a f1477e;
    private final f f;

    /* loaded from: classes.dex */
    public interface a {
        void b(ActionNode actionNode, Runnable runnable);

        void c(ClickableNode clickableNode);

        void f(PageNode pageNode, Runnable runnable);

        void g(SwitchNode switchNode, Runnable runnable);

        void i(PickerNode pickerNode, Runnable runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        final /* synthetic */ Handler f;
        final /* synthetic */ e g;
        final /* synthetic */ NodeInfoBase h;

        /* loaded from: classes.dex */
        static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.g.h();
                NodeInfoBase nodeInfoBase = b.this.h;
                if (!(nodeInfoBase instanceof RunnableNode) || ((RunnableNode) nodeInfoBase).getUpdateBlocks() == null) {
                    return;
                }
                f fVar = l.this.f;
                String[] updateBlocks = ((RunnableNode) b.this.h).getUpdateBlocks();
                e.p.d.i.b(updateBlocks);
                fVar.m(updateBlocks);
            }
        }

        b(Handler handler, e eVar, NodeInfoBase nodeInfoBase) {
            this.f = handler;
            this.g = eVar;
            this.h = nodeInfoBase;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f.post(new a());
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements e.c {
        c() {
        }

        @Override // d.c.b.p.e.c
        public void a(e eVar) {
            e.p.d.i.d(eVar, "listItemView");
            String a = eVar.a();
            try {
                NodeInfoBase m = l.this.m(a, l.this.f1476d);
                if (m != null) {
                    l.this.p(m, eVar);
                    return;
                }
                Log.e("onItemClick", "The item index with the specified ID cannot be found:" + a);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements e.d {
        d() {
        }

        @Override // d.c.b.p.e.d
        public void a(e eVar) {
            e.p.d.i.d(eVar, "listItemView");
            NodeInfoBase m = l.this.m(eVar.a(), l.this.f1476d);
            if (m instanceof ClickableNode) {
                l.this.f1477e.c((ClickableNode) m);
            }
        }
    }

    public l(Context context, ArrayList<NodeInfoBase> arrayList, a aVar, f fVar) {
        e.p.d.i.d(context, "mContext");
        e.p.d.i.d(arrayList, "itemConfigList");
        e.p.d.i.d(aVar, "clickListener");
        e.p.d.i.d(fVar, "rootGroup");
        this.f1475c = context;
        this.f1476d = arrayList;
        this.f1477e = aVar;
        this.f = fVar;
        this.a = new c();
        this.f1474b = new d();
        o(this.f, this.f1476d);
    }

    private final k f(ActionNode actionNode) {
        return new d.c.b.p.d(this.f1475c, actionNode);
    }

    private final f g(GroupNode groupNode) {
        return new f(this.f1475c, false, groupNode);
    }

    private final k h(PickerNode pickerNode) {
        return new h(this.f1475c, pickerNode);
    }

    private final k i(PageNode pageNode) {
        return new g(this.f1475c, pageNode);
    }

    private final k j(SwitchNode switchNode) {
        return new i(this.f1475c, switchNode);
    }

    private final k k(TextNode textNode) {
        return new j(this.f1475c, d.c.b.g.kr_text_list_item, textNode);
    }

    private final k l(TextNode textNode) {
        return new j(this.f1475c, d.c.b.g.kr_text_list_item_white, textNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NodeInfoBase m(String str, ArrayList<NodeInfoBase> arrayList) {
        NodeInfoBase m;
        Iterator<NodeInfoBase> it = arrayList.iterator();
        while (it.hasNext()) {
            NodeInfoBase next = it.next();
            if (e.p.d.i.a(next.getIndex(), str)) {
                return next;
            }
            if (next instanceof GroupNode) {
                GroupNode groupNode = (GroupNode) next;
                if (groupNode.getChildren().size() > 0 && (m = m(str, groupNode.getChildren())) != null) {
                    return m;
                }
            }
        }
        return null;
    }

    private final Runnable n(NodeInfoBase nodeInfoBase, e eVar) {
        return new b(new Handler(Looper.getMainLooper()), eVar, nodeInfoBase);
    }

    private final void o(f fVar, ArrayList<NodeInfoBase> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            NodeInfoBase nodeInfoBase = arrayList.get(i);
            e.p.d.i.c(nodeInfoBase, "actionInfos[index]");
            NodeInfoBase nodeInfoBase2 = nodeInfoBase;
            k kVar = null;
            try {
                if (nodeInfoBase2 instanceof PageNode) {
                    kVar = i((PageNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof SwitchNode) {
                    kVar = j((SwitchNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof ActionNode) {
                    kVar = f((ActionNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof PickerNode) {
                    kVar = h((PickerNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof TextNode) {
                    kVar = fVar.j() ? k((TextNode) nodeInfoBase2) : l((TextNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof GroupNode) {
                    f g = g((GroupNode) nodeInfoBase2);
                    if (((GroupNode) nodeInfoBase2).getChildren().size() > 0) {
                        fVar.i(g);
                        o(g, ((GroupNode) nodeInfoBase2).getChildren());
                    }
                }
                if (kVar != null) {
                    if (kVar instanceof e) {
                        ((e) kVar).k(this.a);
                        ((e) kVar).l(this.f1474b);
                    }
                    fVar.i(kVar);
                }
            } catch (Exception e2) {
                Toast.makeText(this.f1475c, nodeInfoBase2.getTitle() + "Interface rendering exception" + e2.getMessage(), 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(NodeInfoBase nodeInfoBase, e eVar) {
        if (nodeInfoBase instanceof PageNode) {
            this.f1477e.f((PageNode) nodeInfoBase, n(nodeInfoBase, eVar));
            return;
        }
        if (nodeInfoBase instanceof ActionNode) {
            this.f1477e.b((ActionNode) nodeInfoBase, n(nodeInfoBase, eVar));
        } else if (nodeInfoBase instanceof PickerNode) {
            this.f1477e.i((PickerNode) nodeInfoBase, n(nodeInfoBase, eVar));
        } else if (nodeInfoBase instanceof SwitchNode) {
            this.f1477e.g((SwitchNode) nodeInfoBase, n(nodeInfoBase, eVar));
        }
    }
}
