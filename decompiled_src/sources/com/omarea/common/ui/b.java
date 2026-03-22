package com.omarea.common.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import e.j;
import e.k.q;
import e.u.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class b extends BaseAdapter implements Filterable {

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC0080b f1245e;
    private Filter f;
    private ArrayList<d.c.a.e.a> g;
    private final Object h;
    private final Context i;
    private ArrayList<d.c.a.e.a> j;
    private final boolean k;

    /* loaded from: classes.dex */
    private static final class a extends Filter {
        private b a;

        public a(b bVar) {
            e.p.d.i.d(bVar, "adapter");
            this.a = bVar;
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            String str;
            ArrayList arrayList;
            int size;
            String lowerCase;
            boolean n;
            List b2;
            boolean n2;
            ArrayList arrayList2;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || (str = charSequence.toString()) == null) {
                str = "";
            }
            int i = 1;
            if (str.length() == 0) {
                synchronized (this.a.h) {
                    arrayList2 = new ArrayList(this.a.j);
                    j jVar = j.a;
                }
                filterResults.values = arrayList2;
                size = arrayList2.size();
            } else {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase2 = str.toLowerCase();
                e.p.d.i.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
                synchronized (this.a.h) {
                    arrayList = new ArrayList(this.a.j);
                    j jVar2 = j.a;
                }
                List<d.c.a.e.a> g = this.a.g();
                int size2 = arrayList.size();
                ArrayList arrayList3 = new ArrayList();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj = arrayList.get(i2);
                    e.p.d.i.c(obj, "values[i]");
                    d.c.a.e.a aVar = (d.c.a.e.a) obj;
                    if (!g.contains(aVar)) {
                        if (aVar.b() == null) {
                            lowerCase = "";
                        } else {
                            String b3 = aVar.b();
                            e.p.d.i.b(b3);
                            if (b3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            lowerCase = b3.toLowerCase();
                            e.p.d.i.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                        }
                        n = v.n(lowerCase, lowerCase2, false, 2, null);
                        if (!n) {
                            List<String> split = new e.u.h(" ").split(lowerCase, 0);
                            if (!split.isEmpty()) {
                                ListIterator<String> listIterator = split.listIterator(split.size());
                                while (listIterator.hasPrevious()) {
                                    if (!(listIterator.previous().length() == 0)) {
                                        b2 = q.x(split, listIterator.nextIndex() + i);
                                        break;
                                    }
                                }
                            }
                            b2 = e.k.i.b();
                            Object[] array = b2.toArray(new String[0]);
                            if (array == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            for (String str2 : (String[]) array) {
                                n2 = v.n(str2, lowerCase2, false, 2, null);
                                if (!n2) {
                                }
                            }
                            i2++;
                            i = 1;
                        }
                    }
                    arrayList3.add(aVar);
                    i2++;
                    i = 1;
                }
                filterResults.values = arrayList3;
                size = arrayList3.size();
            }
            filterResults.count = size;
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            b bVar = this.a;
            e.p.d.i.b(filterResults);
            Object obj = filterResults.values;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.omarea.common.model.SelectItem>");
            }
            bVar.h((ArrayList) obj);
            if (filterResults.count > 0) {
                this.a.notifyDataSetChanged();
            } else {
                this.a.notifyDataSetInvalidated();
            }
        }
    }

    /* renamed from: com.omarea.common.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0080b {
        void a(List<d.c.a.e.a> list);
    }

    /* loaded from: classes.dex */
    public final class c {
        private TextView a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f1246b;

        /* renamed from: c, reason: collision with root package name */
        private CompoundButton f1247c;

        public c(b bVar) {
        }

        public final CompoundButton a() {
            return this.f1247c;
        }

        public final TextView b() {
            return this.f1246b;
        }

        public final TextView c() {
            return this.a;
        }

        public final void d(CompoundButton compoundButton) {
            this.f1247c = compoundButton;
        }

        public final void e(ImageView imageView) {
        }

        public final void f(TextView textView) {
            this.f1246b = textView;
        }

        public final void g(TextView textView) {
            this.a = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d implements View.OnClickListener {
        final /* synthetic */ d.c.a.e.a f;
        final /* synthetic */ c g;

        d(d.c.a.e.a aVar, c cVar) {
            this.f = aVar;
            this.g = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Object obj;
            if (b.this.k) {
                d.c.a.e.a aVar = this.f;
                aVar.d(true ^ aVar.a());
                CompoundButton a = this.g.a();
                if (a != null) {
                    a.setChecked(this.f.a());
                }
            } else {
                if (this.f.a()) {
                    return;
                }
                Iterator it = b.this.j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (((d.c.a.e.a) obj).a()) {
                            break;
                        }
                    }
                }
                d.c.a.e.a aVar2 = (d.c.a.e.a) obj;
                if (aVar2 != null) {
                    aVar2.d(false);
                }
                this.f.d(true);
                b.this.notifyDataSetChanged();
            }
            InterfaceC0080b interfaceC0080b = b.this.f1245e;
            if (interfaceC0080b != null) {
                interfaceC0080b.a(b.this.g());
            }
        }
    }

    public b(Context context, ArrayList<d.c.a.e.a> arrayList, boolean z) {
        e.p.d.i.d(context, "context");
        e.p.d.i.d(arrayList, "items");
        this.i = context;
        this.j = arrayList;
        this.k = z;
        this.g = arrayList;
        this.h = new Object();
    }

    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public d.c.a.e.a getItem(int i) {
        d.c.a.e.a aVar = this.g.get(i);
        e.p.d.i.c(aVar, "filterItems[position]");
        return aVar;
    }

    public final boolean[] f() {
        int g;
        boolean[] y;
        ArrayList<d.c.a.e.a> arrayList = this.j;
        g = e.k.j.g(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(g);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Boolean.valueOf(((d.c.a.e.a) it.next()).a()));
        }
        y = q.y(arrayList2);
        return y;
    }

    public final List<d.c.a.e.a> g() {
        ArrayList<d.c.a.e.a> arrayList = this.j;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((d.c.a.e.a) obj).a()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.g.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f == null) {
            this.f = new a(this);
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
            view = View.inflate(this.i, this.k ? d.c.a.b.item_multiple_chooser_item : d.c.a.b.item_single_chooser_item, null);
        }
        e.p.d.i.b(view);
        k(i, view);
        return view;
    }

    public final void h(ArrayList<d.c.a.e.a> arrayList) {
        e.p.d.i.d(arrayList, "<set-?>");
        this.g = arrayList;
    }

    public final void i(boolean z) {
        Iterator<T> it = this.j.iterator();
        while (it.hasNext()) {
            ((d.c.a.e.a) it.next()).d(z);
        }
        notifyDataSetChanged();
    }

    public final void j(InterfaceC0080b interfaceC0080b) {
        this.f1245e = interfaceC0080b;
    }

    public final void k(int i, View view) {
        e.p.d.i.d(view, "convertView");
        d.c.a.e.a item = getItem(i);
        c cVar = new c(this);
        cVar.g((TextView) view.findViewById(d.c.a.a.ItemTitle));
        cVar.f((TextView) view.findViewById(d.c.a.a.ItemDesc));
        cVar.e((ImageView) view.findViewById(d.c.a.a.ItemIcon));
        cVar.d((CompoundButton) view.findViewById(d.c.a.a.ItemChecBox));
        view.setOnClickListener(new d(item, cVar));
        TextView c2 = cVar.c();
        if (c2 != null) {
            c2.setText(item.b());
        }
        TextView b2 = cVar.b();
        if (b2 != null) {
            String b3 = item.b();
            if (b3 == null || b3.length() == 0) {
                b2.setText(item.b());
            } else {
                b2.setVisibility(8);
            }
        }
        CompoundButton a2 = cVar.a();
        if (a2 != null) {
            a2.setChecked(item.a());
        }
    }
}
