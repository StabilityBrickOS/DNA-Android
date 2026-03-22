package d.c.b.p;

import android.view.View;
import android.widget.LinearLayout;
import com.omarea.krscript.model.ActionParamInfo;
import d.c.b.p.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f1451d = new a(null);
    private androidx.fragment.app.d a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f1452b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f1453c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }

        public final int a(ActionParamInfo actionParamInfo, ArrayList<d.c.a.e.a> arrayList) {
            e.p.d.i.d(actionParamInfo, "actionParamInfo");
            e.p.d.i.d(arrayList, "options");
            ArrayList arrayList2 = new ArrayList();
            if (actionParamInfo.getValueFromShell() != null) {
                String valueFromShell = actionParamInfo.getValueFromShell();
                e.p.d.i.b(valueFromShell);
                arrayList2.add(valueFromShell);
            }
            if (actionParamInfo.getValue() != null) {
                String value = actionParamInfo.getValue();
                e.p.d.i.b(value);
                arrayList2.add(value);
            }
            if (arrayList2.size() <= 0) {
                return -1;
            }
            int size = arrayList2.size();
            int i = -1;
            for (int i2 = 0; i2 < size; i2++) {
                Iterator<d.c.a.e.a> it = arrayList.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (e.p.d.i.a(it.next().c(), (String) arrayList2.get(i2))) {
                        i = i3;
                        break;
                    }
                    i3++;
                }
                if (i > -1) {
                    break;
                }
            }
            return i;
        }

        public final boolean[] b(ActionParamInfo actionParamInfo, ArrayList<d.c.a.e.a> arrayList) {
            boolean z;
            boolean l;
            e.p.d.i.d(actionParamInfo, "actionParamInfo");
            e.p.d.i.d(arrayList, "options");
            boolean[] zArr = new boolean[arrayList.size()];
            List<String> c2 = c(actionParamInfo);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d.c.a.e.a aVar = arrayList.get(i);
                e.p.d.i.c(aVar, "options[index]");
                d.c.a.e.a aVar2 = aVar;
                if (c2 != null) {
                    l = e.k.q.l(c2, aVar2.c());
                    if (l) {
                        z = true;
                        zArr[i] = z;
                    }
                }
                z = false;
                zArr[i] = z;
            }
            return zArr;
        }

        public final List<String> c(ActionParamInfo actionParamInfo) {
            List<String> H;
            e.p.d.i.d(actionParamInfo, "actionParamInfo");
            String valueFromShell = actionParamInfo.getValueFromShell() != null ? actionParamInfo.getValueFromShell() : actionParamInfo.getValue();
            if (valueFromShell == null) {
                return null;
            }
            H = e.u.v.H(valueFromShell, new String[]{actionParamInfo.getSeparator()}, false, 0, 6, null);
            return H;
        }

        public final ArrayList<d.c.a.e.a> d(ActionParamInfo actionParamInfo, ArrayList<d.c.a.e.a> arrayList) {
            boolean z;
            boolean l;
            e.p.d.i.d(actionParamInfo, "actionParamInfo");
            e.p.d.i.d(arrayList, "options");
            List<String> c2 = c(actionParamInfo);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d.c.a.e.a aVar = arrayList.get(i);
                e.p.d.i.c(aVar, "options[index]");
                d.c.a.e.a aVar2 = aVar;
                d.c.a.e.a aVar3 = arrayList.get(i);
                if (c2 != null) {
                    l = e.k.q.l(c2, aVar2.c());
                    if (l) {
                        z = true;
                        aVar3.d(z);
                    }
                }
                z = false;
                aVar3.d(z);
            }
            return arrayList;
        }
    }

    public b(LinearLayout linearLayout, androidx.fragment.app.d dVar) {
        e.p.d.i.d(linearLayout, "linearLayout");
        e.p.d.i.d(dVar, "activity");
        this.f1453c = linearLayout;
        this.a = dVar;
        this.f1452b = new String[]{"bool", "checkbox", "switch"};
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(android.view.View r7, com.omarea.krscript.model.ActionParamInfo r8) {
        /*
            r6 = this;
            androidx.fragment.app.d r0 = r6.a
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = d.c.b.g.kr_param_row
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            java.lang.String r1 = r8.getTitle()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1e
            int r1 = r1.length()
            if (r1 != 0) goto L1c
            goto L1e
        L1c:
            r1 = 0
            goto L1f
        L1e:
            r1 = 1
        L1f:
            java.lang.String r4 = "layout.findViewById<TextView>(R.id.kr_param_title)"
            r5 = 8
            if (r1 != 0) goto L38
            int r1 = d.c.b.f.kr_param_title
            android.view.View r1 = r0.findViewById(r1)
            e.p.d.i.c(r1, r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r4 = r8.getTitle()
            r1.setText(r4)
            goto L46
        L38:
            int r1 = d.c.b.f.kr_param_title
            android.view.View r1 = r0.findViewById(r1)
            e.p.d.i.c(r1, r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r5)
        L46:
            java.lang.String r1 = r8.getLabel()
            if (r1 == 0) goto L55
            int r1 = r1.length()
            if (r1 != 0) goto L53
            goto L55
        L53:
            r1 = 0
            goto L56
        L55:
            r1 = 1
        L56:
            if (r1 != 0) goto L74
            java.lang.String[] r1 = r6.f1452b
            java.lang.String r4 = r8.getType()
            boolean r1 = e.k.a.e(r1, r4)
            if (r1 != 0) goto L74
            int r1 = d.c.b.f.kr_param_label
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r4 = r8.getLabel()
            r1.setText(r4)
            goto L84
        L74:
            int r1 = d.c.b.f.kr_param_label
            android.view.View r1 = r0.findViewById(r1)
            java.lang.String r4 = "layout.findViewById<TextView>(R.id.kr_param_label)"
            e.p.d.i.c(r1, r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r5)
        L84:
            java.lang.String r1 = r8.getDesc()
            if (r1 == 0) goto L90
            int r1 = r1.length()
            if (r1 != 0) goto L91
        L90:
            r2 = 1
        L91:
            java.lang.String r1 = "layout.findViewById<TextView>(R.id.kr_param_desc)"
            if (r2 != 0) goto La8
            int r2 = d.c.b.f.kr_param_desc
            android.view.View r2 = r0.findViewById(r2)
            e.p.d.i.c(r2, r1)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r8 = r8.getDesc()
            r2.setText(r8)
            goto Lb6
        La8:
            int r8 = d.c.b.f.kr_param_desc
            android.view.View r8 = r0.findViewById(r8)
            e.p.d.i.c(r8, r1)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r8.setVisibility(r5)
        Lb6:
            int r8 = d.c.b.f.kr_param_input
            android.view.View r8 = r0.findViewById(r8)
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            r8.addView(r7)
            android.widget.LinearLayout r8 = r6.f1453c
            r8.addView(r0)
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            if (r7 == 0) goto Ld3
            android.widget.FrameLayout$LayoutParams r7 = (android.widget.FrameLayout.LayoutParams) r7
            r8 = 16
            r7.gravity = r8
            return
        Ld3:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.p.b.a(android.view.View, com.omarea.krscript.model.ActionParamInfo):void");
    }

    private final String b(ActionParamInfo actionParamInfo) {
        StringBuilder sb = new StringBuilder();
        String title = actionParamInfo.getTitle();
        if (!(title == null || title.length() == 0)) {
            sb.append(actionParamInfo.getTitle());
            sb.append(" ");
        }
        String label = actionParamInfo.getLabel();
        if (!(label == null || label.length() == 0)) {
            sb.append(actionParamInfo.getLabel());
            sb.append(" ");
        }
        sb.append("(");
        sb.append(actionParamInfo.getName());
        sb.append(") ");
        String sb2 = sb.toString();
        e.p.d.i.c(sb2, "tips.toString()");
        return sb2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0120, code lost:
    
        if (((android.widget.CheckBox) r2).isChecked() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0123, code lost:
    
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0124, code lost:
    
        r1.setValue(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0132, code lost:
    
        if (((android.widget.Switch) r2).isChecked() != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0186 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.HashMap<java.lang.String, java.lang.String> c(java.util.ArrayList<com.omarea.krscript.model.ActionParamInfo> r14) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.p.b.c(java.util.ArrayList):java.util.HashMap");
    }

    public final void d(ArrayList<ActionParamInfo> arrayList, r.a aVar) {
        View b2;
        e.p.d.i.d(arrayList, "actionParamInfos");
        Iterator<ActionParamInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            ActionParamInfo next = it.next();
            if (next.getOptionsFromShell() == null || e.p.d.i.a(next.getType(), "app") || e.p.d.i.a(next.getType(), "packages")) {
                if (e.p.d.i.a(next.getType(), "bool") || e.p.d.i.a(next.getType(), "checkbox")) {
                    e.p.d.i.c(next, "actionParamInfo");
                    b2 = new o(next, this.a).b();
                } else if (e.p.d.i.a(next.getType(), "switch")) {
                    e.p.d.i.c(next, "actionParamInfo");
                    b2 = new v(next, this.a).b();
                } else if (e.p.d.i.a(next.getType(), "seekbar")) {
                    e.p.d.i.c(next, "actionParamInfo");
                    b2 = new t(next, this.a).b();
                } else if (e.p.d.i.a(next.getType(), "file") || e.p.d.i.a(next.getType(), "folder")) {
                    e.p.d.i.c(next, "actionParamInfo");
                    b2 = new r(next, this.a, aVar).d();
                } else if (e.p.d.i.a(next.getType(), "app") || e.p.d.i.a(next.getType(), "packages")) {
                    e.p.d.i.c(next, "actionParamInfo");
                    b2 = new n(next, this.a).e();
                } else if (e.p.d.i.a(next.getType(), "color")) {
                    e.p.d.i.c(next, "actionParamInfo");
                    b2 = new p(next, this.a).g();
                } else {
                    e.p.d.i.c(next, "actionParamInfo");
                    b2 = new q(next, this.a).a();
                }
            } else if (next.getMultiple()) {
                e.p.d.i.c(next, "actionParamInfo");
                b2 = new s(next, this.a).e();
            } else {
                e.p.d.i.c(next, "actionParamInfo");
                b2 = new u(next, this.a).d();
            }
            a(b2, next);
        }
    }
}
