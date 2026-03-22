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
import android.widget.TextView;
import com.omarea.common.ui.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends com.omarea.common.ui.d {
    private String q0;
    private String r0;
    private ArrayList<d.c.a.e.a> s0;
    private final boolean t0;
    private a u0;
    private HashMap v0;

    /* loaded from: classes.dex */
    public interface a {
        void a(List<d.c.a.e.a> list, boolean[] zArr);
    }

    /* loaded from: classes.dex */
    public static final class b implements TextWatcher {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f1266e;
        final /* synthetic */ AbsListView f;

        b(View view, AbsListView absListView) {
            this.f1266e = view;
            this.f = absListView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                View view = this.f1266e;
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

    /* loaded from: classes.dex */
    public static final class c implements b.InterfaceC0080b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CompoundButton f1267b;

        c(CompoundButton compoundButton) {
            this.f1267b = compoundButton;
        }

        @Override // com.omarea.common.ui.b.InterfaceC0080b
        public void a(List<d.c.a.e.a> list) {
            e.p.d.i.d(list, "selected");
            this.f1267b.setChecked(list.size() == f.this.s0.size());
        }
    }

    /* loaded from: classes.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            f.this.s1();
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
            f fVar = f.this;
            AbsListView absListView = this.f;
            e.p.d.i.c(absListView, "absListView");
            fVar.C1(absListView);
        }
    }

    /* renamed from: com.omarea.common.ui.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class ViewOnClickListenerC0084f implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.omarea.common.ui.b f1270e;

        ViewOnClickListenerC0084f(com.omarea.common.ui.b bVar) {
            this.f1270e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.omarea.common.ui.b bVar = this.f1270e;
            if (bVar != null) {
                if (view == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
                }
                bVar.i(((CompoundButton) view).isChecked());
            }
        }
    }

    /* loaded from: classes.dex */
    static final class g implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f1271e;

        g(EditText editText) {
            this.f1271e = editText;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EditText editText = this.f1271e;
            e.p.d.i.c(editText, "searchBox");
            editText.setText((CharSequence) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(boolean z, ArrayList<d.c.a.e.a> arrayList, boolean z2, a aVar) {
        super(arrayList.size() > 7 ? d.c.a.b.dialog_item_chooser : d.c.a.b.dialog_item_chooser_small, z);
        e.p.d.i.d(arrayList, "items");
        this.s0 = arrayList;
        this.t0 = z2;
        this.u0 = aVar;
        this.q0 = "";
        this.r0 = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(AbsListView absListView) {
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        if (listAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.common.ui.AdapterItemChooser");
        }
        com.omarea.common.ui.b bVar = (com.omarea.common.ui.b) listAdapter;
        List<d.c.a.e.a> g2 = bVar.g();
        boolean[] f = bVar.f();
        a aVar = this.u0;
        if (aVar != null) {
            aVar.a(g2, f);
        }
        s1();
    }

    private final void D1(AbsListView absListView) {
        Context context = absListView.getContext();
        e.p.d.i.c(context, "gridView.context");
        absListView.setAdapter((ListAdapter) new com.omarea.common.ui.b(context, this.s0, this.t0));
    }

    private final void E1() {
        TextView textView;
        View P = P();
        if (P == null || (textView = (TextView) P.findViewById(d.c.a.a.dialog_desc)) == null) {
            return;
        }
        textView.setText(this.r0);
        textView.setVisibility(this.r0.length() > 0 ? 0 : 8);
    }

    private final void F1() {
        TextView textView;
        View P = P();
        if (P == null || (textView = (TextView) P.findViewById(d.c.a.a.dialog_title)) == null) {
            return;
        }
        textView.setText(this.q0);
        textView.setVisibility(this.q0.length() > 0 ? 0 : 8);
    }

    @Override // com.omarea.common.ui.d, androidx.fragment.app.Fragment
    public void E0(View view, Bundle bundle) {
        e.p.d.i.d(view, "view");
        super.E0(view, bundle);
        AbsListView absListView = (AbsListView) view.findViewById(d.c.a.a.item_list);
        e.p.d.i.c(absListView, "absListView");
        D1(absListView);
        view.findViewById(d.c.a.a.btn_cancel).setOnClickListener(new d());
        view.findViewById(d.c.a.a.btn_confirm).setOnClickListener(new e(absListView));
        CompoundButton compoundButton = (CompoundButton) view.findViewById(d.c.a.a.select_all);
        boolean z = true;
        if (compoundButton != null) {
            if (this.t0) {
                com.omarea.common.ui.b bVar = (com.omarea.common.ui.b) ((ListAdapter) absListView.getAdapter());
                compoundButton.setVisibility(0);
                ArrayList<d.c.a.e.a> arrayList = this.s0;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (((d.c.a.e.a) obj).a()) {
                        arrayList2.add(obj);
                    }
                }
                compoundButton.setChecked(arrayList2.size() == this.s0.size());
                compoundButton.setOnClickListener(new ViewOnClickListenerC0084f(bVar));
                if (bVar != null) {
                    bVar.j(new c(compoundButton));
                }
            } else {
                compoundButton.setVisibility(8);
            }
        }
        if (this.s0.size() > 5) {
            View findViewById = view.findViewById(d.c.a.a.search_box_clear);
            EditText editText = (EditText) view.findViewById(d.c.a.a.search_box);
            editText.addTextChangedListener(new b(findViewById, absListView));
            e.p.d.i.c(findViewById, "clearBtn");
            e.p.d.i.c(editText, "searchBox");
            Editable text = editText.getText();
            if (text != null && text.length() != 0) {
                z = false;
            }
            findViewById.setVisibility(z ? 8 : 0);
            findViewById.setOnClickListener(new g(editText));
        }
        F1();
        E1();
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
