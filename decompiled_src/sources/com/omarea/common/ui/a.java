package com.omarea.common.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import e.j;
import e.k.m;
import e.k.q;
import e.p.c.p;
import e.u.v;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q0;

/* loaded from: classes.dex */
public final class a extends BaseAdapter implements Filterable {

    /* renamed from: e, reason: collision with root package name */
    private d f1237e;
    private Filter f;
    private ArrayList<b> g;
    private final Object h;
    private final LruCache<String, Drawable> i;
    private final Context j;
    private ArrayList<b> k;
    private final boolean l;

    /* renamed from: com.omarea.common.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0079a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = e.l.b.a(Boolean.valueOf(!((b) t).d()), Boolean.valueOf(!((b) t2).d()));
            return a;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private String a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f1238b = "";

        /* renamed from: c, reason: collision with root package name */
        private boolean f1239c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1240d;

        public final String a() {
            return this.a;
        }

        public final boolean b() {
            return this.f1239c;
        }

        public final String c() {
            return this.f1238b;
        }

        public final boolean d() {
            return this.f1240d;
        }

        public final void e(String str) {
            e.p.d.i.d(str, "<set-?>");
            this.a = str;
        }

        public final void f(boolean z) {
            this.f1239c = z;
        }

        public final void g(String str) {
            e.p.d.i.d(str, "<set-?>");
            this.f1238b = str;
        }

        public final void h(boolean z) {
            this.f1240d = z;
        }
    }

    /* loaded from: classes.dex */
    private static final class c extends Filter {
        private a a;

        public c(a aVar) {
            e.p.d.i.d(aVar, "adapter");
            this.a = aVar;
        }

        private final boolean a(String str, String str2) {
            boolean n;
            List b2;
            boolean n2;
            n = v.n(str, str2, false, 2, null);
            if (n) {
                return true;
            }
            List<String> split = new e.u.h(" ").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (!(listIterator.previous().length() == 0)) {
                        b2 = q.x(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            b2 = e.k.i.b();
            Object[] array = b2.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            for (String str3 : (String[]) array) {
                n2 = v.n(str3, str2, false, 2, null);
                if (n2) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            ArrayList arrayList;
            int i;
            int size;
            ArrayList arrayList2;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            String obj = charSequence == null ? "" : charSequence.toString();
            if (obj.length() == 0) {
                synchronized (this.a.h) {
                    arrayList2 = new ArrayList(this.a.k);
                    j jVar = j.a;
                }
                filterResults.values = arrayList2;
                size = arrayList2.size();
            } else {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = obj.toLowerCase();
                e.p.d.i.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                synchronized (this.a.h) {
                    arrayList = new ArrayList(this.a.k);
                    j jVar2 = j.a;
                }
                List<b> i2 = this.a.i();
                int size2 = arrayList.size();
                ArrayList arrayList3 = new ArrayList();
                while (i < size2) {
                    Object obj2 = arrayList.get(i);
                    e.p.d.i.c(obj2, "values[i]");
                    b bVar = (b) obj2;
                    if (!i2.contains(bVar)) {
                        String a = bVar.a();
                        if (a == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase2 = a.toLowerCase();
                        e.p.d.i.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
                        String c2 = bVar.c();
                        if (c2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase3 = c2.toLowerCase();
                        e.p.d.i.c(lowerCase3, "(this as java.lang.String).toLowerCase()");
                        i = (a(lowerCase2, lowerCase) || a(lowerCase3, lowerCase)) ? 0 : i + 1;
                    }
                    arrayList3.add(bVar);
                }
                filterResults.values = arrayList3;
                size = arrayList3.size();
            }
            filterResults.count = size;
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            a aVar = this.a;
            e.p.d.i.b(filterResults);
            Object obj = filterResults.values;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.omarea.common.ui.AdapterAppChooser.AppInfo>");
            }
            aVar.k((ArrayList) obj);
            if (filterResults.count > 0) {
                this.a.notifyDataSetChanged();
            } else {
                this.a.notifyDataSetInvalidated();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(List<? extends b> list);
    }

    /* loaded from: classes.dex */
    public final class e {
        private TextView a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f1241b;

        /* renamed from: c, reason: collision with root package name */
        private ImageView f1242c;

        /* renamed from: d, reason: collision with root package name */
        private CompoundButton f1243d;

        public e(a aVar) {
        }

        public final CompoundButton a() {
            return this.f1243d;
        }

        public final ImageView b() {
            return this.f1242c;
        }

        public final TextView c() {
            return this.f1241b;
        }

        public final TextView d() {
            return this.a;
        }

        public final void e(CompoundButton compoundButton) {
            this.f1243d = compoundButton;
        }

        public final void f(ImageView imageView) {
            this.f1242c = imageView;
        }

        public final void g(TextView textView) {
            this.f1241b = textView;
        }

        public final void h(TextView textView) {
            this.a = textView;
        }

        public final void i(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @e.m.j.a.e(c = "com.omarea.common.ui.AdapterAppChooser$loadIcon$1", f = "AdapterAppChooser.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class f extends e.m.j.a.j implements p<d0, e.m.d<? super Drawable>, Object> {
        final /* synthetic */ b $app;
        int label;
        private d0 p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(b bVar, e.m.d dVar) {
            super(2, dVar);
            this.$app = bVar;
        }

        @Override // e.m.j.a.a
        public final e.m.d<j> create(Object obj, e.m.d<?> dVar) {
            e.p.d.i.d(dVar, "completion");
            f fVar = new f(this.$app, dVar);
            fVar.p$ = (d0) obj;
            return fVar;
        }

        @Override // e.p.c.p
        public final Object invoke(d0 d0Var, e.m.d<? super Drawable> dVar) {
            return ((f) create(d0Var, dVar)).invokeSuspend(j.a);
        }

        @Override // e.m.j.a.a
        public final Object invokeSuspend(Object obj) {
            e.m.i.d.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e.g.b(obj);
            String c2 = this.$app.c();
            Drawable drawable = (Drawable) a.this.i.get(c2);
            if (drawable != null || this.$app.b()) {
                return drawable;
            }
            try {
                a.this.i.put(c2, a.this.j.getPackageManager().getPackageInfo(c2, 0).applicationInfo.loadIcon(a.this.j.getPackageManager()));
            } catch (Exception unused) {
                this.$app.f(true);
            }
            return a.this.i.get(c2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g extends e.m.j.a.j implements p<d0, e.m.d<? super j>, Object> {
        final /* synthetic */ ImageView $imgView;
        final /* synthetic */ b $item$inlined;
        final /* synthetic */ String $packageName$inlined;
        Object L$0;
        int label;
        private d0 p$;
        final /* synthetic */ a this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(ImageView imageView, e.m.d dVar, a aVar, b bVar, String str) {
            super(2, dVar);
            this.$imgView = imageView;
            this.this$0 = aVar;
            this.$item$inlined = bVar;
            this.$packageName$inlined = str;
        }

        @Override // e.m.j.a.a
        public final e.m.d<j> create(Object obj, e.m.d<?> dVar) {
            e.p.d.i.d(dVar, "completion");
            g gVar = new g(this.$imgView, dVar, this.this$0, this.$item$inlined, this.$packageName$inlined);
            gVar.p$ = (d0) obj;
            return gVar;
        }

        @Override // e.p.c.p
        public final Object invoke(d0 d0Var, e.m.d<? super j> dVar) {
            return ((g) create(d0Var, dVar)).invokeSuspend(j.a);
        }

        @Override // e.m.j.a.a
        public final Object invokeSuspend(Object obj) {
            Object d2;
            d2 = e.m.i.d.d();
            int i = this.label;
            if (i == 0) {
                e.g.b(obj);
                d0 d0Var = this.p$;
                k0 j = this.this$0.j(this.$item$inlined);
                this.L$0 = d0Var;
                this.label = 1;
                obj = j.h(this);
                if (obj == d2) {
                    return d2;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e.g.b(obj);
            }
            Drawable drawable = (Drawable) obj;
            if (drawable != null && e.p.d.i.a(this.$imgView.getTag(), this.$packageName$inlined)) {
                this.$imgView.setImageDrawable(drawable);
            }
            return j.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class h implements View.OnClickListener {
        final /* synthetic */ b f;
        final /* synthetic */ e g;

        h(b bVar, e eVar) {
            this.f = bVar;
            this.g = eVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Object obj;
            if (!a.this.l && !this.f.d()) {
                Iterator it = a.this.k.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (((b) obj).d()) {
                            break;
                        }
                    }
                }
                b bVar = (b) obj;
                if (bVar != null) {
                    bVar.h(false);
                }
                this.f.h(true);
                a.this.notifyDataSetChanged();
            } else if (a.this.l) {
                b bVar2 = this.f;
                bVar2.h(true ^ bVar2.d());
                CompoundButton a = this.g.a();
                if (a != null) {
                    a.setChecked(this.f.d());
                }
            }
            d dVar = a.this.f1237e;
            if (dVar != null) {
                dVar.a(a.this.i());
            }
        }
    }

    public a(Context context, ArrayList<b> arrayList, boolean z) {
        e.p.d.i.d(context, "context");
        e.p.d.i.d(arrayList, "apps");
        this.j = context;
        this.k = arrayList;
        this.l = z;
        this.g = arrayList;
        this.h = new Object();
        this.i = new LruCache<>(100);
        ArrayList<b> arrayList2 = this.g;
        if (arrayList2.size() > 1) {
            m.h(arrayList2, new C0079a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k0<Drawable> j(b bVar) {
        k0<Drawable> b2;
        b2 = kotlinx.coroutines.e.b(a1.f1555e, q0.b(), null, new f(bVar, null), 2, null);
        return b2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.g.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f == null) {
            this.f = new c(this);
        }
        Filter filter = this.f;
        e.p.d.i.b(filter);
        return filter;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        e.p.d.i.d(viewGroup, "parent");
        if (view == null) {
            view = View.inflate(this.j, this.l ? d.c.a.b.app_multiple_chooser_item : d.c.a.b.app_single_chooser_item, null);
        }
        e.p.d.i.b(view);
        n(i, view);
        return view;
    }

    @Override // android.widget.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b getItem(int i) {
        b bVar = this.g.get(i);
        e.p.d.i.c(bVar, "filterApps[position]");
        return bVar;
    }

    public final List<b> i() {
        ArrayList<b> arrayList = this.k;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((b) obj).d()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final void k(ArrayList<b> arrayList) {
        e.p.d.i.d(arrayList, "<set-?>");
        this.g = arrayList;
    }

    public final void l(boolean z) {
        Iterator<T> it = this.k.iterator();
        while (it.hasNext()) {
            ((b) it.next()).h(z);
        }
        notifyDataSetChanged();
    }

    public final void m(d dVar) {
        this.f1237e = dVar;
    }

    public final void n(int i, View view) {
        e eVar;
        e.p.d.i.d(view, "convertView");
        b item = getItem(i);
        if (view.getTag() != null) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.common.ui.AdapterAppChooser.ViewHolder");
            }
            eVar = (e) tag;
        } else {
            eVar = new e(this);
            eVar.h((TextView) view.findViewById(d.c.a.a.ItemTitle));
            eVar.g((TextView) view.findViewById(d.c.a.a.ItemDesc));
            eVar.f((ImageView) view.findViewById(d.c.a.a.ItemIcon));
            eVar.e((CompoundButton) view.findViewById(d.c.a.a.ItemChecBox));
        }
        String c2 = item.c();
        eVar.i(c2);
        view.setOnClickListener(new h(item, eVar));
        TextView d2 = eVar.d();
        if (d2 != null) {
            d2.setText(item.a());
        }
        TextView c3 = eVar.c();
        if (c3 != null) {
            c3.setText(item.c());
        }
        CompoundButton a = eVar.a();
        if (a != null) {
            a.setChecked(item.d());
        }
        ImageView b2 = eVar.b();
        e.p.d.i.b(b2);
        b2.setTag(c2);
        kotlinx.coroutines.e.d(a1.f1555e, q0.c(), null, new g(b2, null, this, item, c2), 2, null);
    }
}
