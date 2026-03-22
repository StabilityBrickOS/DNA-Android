package com.omarea.common.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.omarea.common.ui.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends com.omarea.common.ui.d {
    private boolean q0;
    private String[] r0;
    private ArrayList<a.b> s0;
    private final boolean t0;
    private a u0;
    private HashMap v0;

    /* loaded from: classes.dex */
    public interface a {
        void a(List<? extends a.b> list);
    }

    /* loaded from: classes.dex */
    public static final class b implements TextWatcher {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f1249e;
        final /* synthetic */ AbsListView f;

        b(View view, AbsListView absListView) {
            this.f1249e = view;
            this.f = absListView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                View view = this.f1249e;
                e.p.d.i.c(view, "clearBtn");
                view.setVisibility(editable.length() > 0 ? 0 : 8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbsListView absListView = this.f;
            e.p.d.i.c(absListView, "absListView");
            ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
            if (listAdapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Filterable");
            }
            ((Filterable) listAdapter).getFilter().filter(charSequence == null ? "" : charSequence.toString());
        }
    }

    /* renamed from: com.omarea.common.ui.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0081c implements a.d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CompoundButton f1250b;

        C0081c(CompoundButton compoundButton) {
            this.f1250b = compoundButton;
        }

        @Override // com.omarea.common.ui.a.d
        public void a(List<? extends a.b> list) {
            e.p.d.i.d(list, "selected");
            this.f1250b.setChecked(list.size() == c.this.s0.size());
        }
    }

    /* loaded from: classes.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.this.s1();
        }
    }

    /* loaded from: classes.dex */
    static final class e implements View.OnClickListener {
        final /* synthetic */ AbsListView f;

        e(AbsListView absListView) {
            this.f = absListView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c cVar = c.this;
            AbsListView absListView = this.f;
            e.p.d.i.c(absListView, "absListView");
            cVar.C1(absListView);
        }
    }

    /* loaded from: classes.dex */
    static final class f implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.omarea.common.ui.a f1253e;

        f(com.omarea.common.ui.a aVar) {
            this.f1253e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.omarea.common.ui.a aVar = this.f1253e;
            if (aVar != null) {
                if (view == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
                }
                aVar.l(((CompoundButton) view).isChecked());
            }
        }
    }

    /* loaded from: classes.dex */
    static final class g implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f1254e;

        g(EditText editText) {
            this.f1254e = editText;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EditText editText = this.f1254e;
            e.p.d.i.c(editText, "searchBox");
            editText.setText((CharSequence) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(boolean z, ArrayList<a.b> arrayList, boolean z2, a aVar) {
        super(d.c.a.b.dialog_app_chooser, z);
        e.p.d.i.d(arrayList, "packages");
        this.s0 = arrayList;
        this.t0 = z2;
        this.u0 = aVar;
        this.q0 = true;
        this.r0 = new String[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(AbsListView absListView) {
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        if (listAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.common.ui.AdapterAppChooser");
        }
        List<a.b> i = ((com.omarea.common.ui.a) listAdapter).i();
        a aVar = this.u0;
        if (aVar != null) {
            aVar.a(i);
        }
        s1();
    }

    private final void D1(AbsListView absListView) {
        boolean e2;
        ArrayList<a.b> arrayList = this.s0;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            e2 = e.k.e.e(this.r0, ((a.b) obj).c());
            if (!e2) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        Context context = absListView.getContext();
        e.p.d.i.c(context, "gridView.context");
        absListView.setAdapter((ListAdapter) new com.omarea.common.ui.a(context, arrayList3, this.t0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
    
        if (r9.q0 == false) goto L21;
     */
    @Override // com.omarea.common.ui.d, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void E0(android.view.View r10, android.os.Bundle r11) {
        /*
            r9 = this;
            java.lang.String r0 = "view"
            e.p.d.i.d(r10, r0)
            super.E0(r10, r11)
            int r11 = d.c.a.a.app_list
            android.view.View r11 = r10.findViewById(r11)
            android.widget.AbsListView r11 = (android.widget.AbsListView) r11
            java.lang.String r0 = "absListView"
            e.p.d.i.c(r11, r0)
            r9.D1(r11)
            int r0 = d.c.a.a.btn_cancel
            android.view.View r0 = r10.findViewById(r0)
            com.omarea.common.ui.c$d r1 = new com.omarea.common.ui.c$d
            r1.<init>()
            r0.setOnClickListener(r1)
            int r0 = d.c.a.a.btn_confirm
            android.view.View r0 = r10.findViewById(r0)
            com.omarea.common.ui.c$e r1 = new com.omarea.common.ui.c$e
            r1.<init>(r11)
            r0.setOnClickListener(r1)
            int r0 = d.c.a.a.select_all
            android.view.View r0 = r10.findViewById(r0)
            android.widget.CompoundButton r0 = (android.widget.CompoundButton) r0
            r1 = 1
            r2 = 0
            r3 = 8
            if (r0 == 0) goto L9e
            boolean r4 = r9.t0
            if (r4 == 0) goto L9b
            android.widget.Adapter r4 = r11.getAdapter()
            android.widget.ListAdapter r4 = (android.widget.ListAdapter) r4
            com.omarea.common.ui.a r4 = (com.omarea.common.ui.a) r4
            r0.setVisibility(r2)
            java.util.ArrayList<com.omarea.common.ui.a$b> r5 = r9.s0
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L5c:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L73
            java.lang.Object r7 = r5.next()
            r8 = r7
            com.omarea.common.ui.a$b r8 = (com.omarea.common.ui.a.b) r8
            boolean r8 = r8.d()
            if (r8 == 0) goto L5c
            r6.add(r7)
            goto L5c
        L73:
            int r5 = r6.size()
            java.util.ArrayList<com.omarea.common.ui.a$b> r6 = r9.s0
            int r6 = r6.size()
            if (r5 != r6) goto L81
            r5 = 1
            goto L82
        L81:
            r5 = 0
        L82:
            r0.setChecked(r5)
            com.omarea.common.ui.c$f r5 = new com.omarea.common.ui.c$f
            r5.<init>(r4)
            r0.setOnClickListener(r5)
            if (r4 == 0) goto L97
            com.omarea.common.ui.c$c r5 = new com.omarea.common.ui.c$c
            r5.<init>(r0)
            r4.m(r5)
        L97:
            boolean r4 = r9.q0
            if (r4 != 0) goto L9e
        L9b:
            r0.setVisibility(r3)
        L9e:
            int r0 = d.c.a.a.search_box_clear
            android.view.View r0 = r10.findViewById(r0)
            int r4 = d.c.a.a.search_box
            android.view.View r10 = r10.findViewById(r4)
            android.widget.EditText r10 = (android.widget.EditText) r10
            com.omarea.common.ui.c$b r4 = new com.omarea.common.ui.c$b
            r4.<init>(r0, r11)
            r10.addTextChangedListener(r4)
            java.lang.String r11 = "clearBtn"
            e.p.d.i.c(r0, r11)
            java.lang.String r11 = "searchBox"
            e.p.d.i.c(r10, r11)
            android.text.Editable r11 = r10.getText()
            if (r11 == 0) goto Lcc
            int r11 = r11.length()
            if (r11 != 0) goto Lcb
            goto Lcc
        Lcb:
            r1 = 0
        Lcc:
            if (r1 == 0) goto Ld0
            r2 = 8
        Ld0:
            r0.setVisibility(r2)
            com.omarea.common.ui.c$g r11 = new com.omarea.common.ui.c$g
            r11.<init>(r10)
            r0.setOnClickListener(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.common.ui.c.E0(android.view.View, android.os.Bundle):void");
    }

    @Override // com.omarea.common.ui.d, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        super.Z(bundle);
    }

    @Override // com.omarea.common.ui.d, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public /* synthetic */ void m0() {
        super.m0();
        z1();
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        e.p.d.i.d(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
    }

    @Override // com.omarea.common.ui.d
    public void z1() {
        HashMap hashMap = this.v0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
