package com.dna.tools;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.omarea.common.ui.e;

/* loaded from: classes.dex */
public final class c {
    private Activity a;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        final /* synthetic */ e.c f;

        a(e.c cVar) {
            this.f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f.a();
            d.c.a.g.b bVar = d.c.a.g.b.f1379c;
            String string = c.this.a().getString(R.string.power_shutdown_cmd);
            e.p.d.i.c(string, "context.getString(R.string.power_shutdown_cmd)");
            bVar.b(string);
        }
    }

    /* loaded from: classes.dex */
    static final class b implements View.OnClickListener {
        final /* synthetic */ e.c f;

        b(e.c cVar) {
            this.f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f.a();
            d.c.a.g.b bVar = d.c.a.g.b.f1379c;
            String string = c.this.a().getString(R.string.power_reboot_cmd);
            e.p.d.i.c(string, "context.getString(R.string.power_reboot_cmd)");
            bVar.b(string);
        }
    }

    /* renamed from: com.dna.tools.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class ViewOnClickListenerC0053c implements View.OnClickListener {
        final /* synthetic */ e.c f;

        ViewOnClickListenerC0053c(e.c cVar) {
            this.f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f.a();
            d.c.a.g.b bVar = d.c.a.g.b.f1379c;
            String string = c.this.a().getString(R.string.power_hot_reboot_cmd);
            e.p.d.i.c(string, "context.getString(R.string.power_hot_reboot_cmd)");
            bVar.b(string);
        }
    }

    /* loaded from: classes.dex */
    static final class d implements View.OnClickListener {
        final /* synthetic */ e.c f;

        d(e.c cVar) {
            this.f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f.a();
            d.c.a.g.b bVar = d.c.a.g.b.f1379c;
            String string = c.this.a().getString(R.string.power_recovery_cmd);
            e.p.d.i.c(string, "context.getString(R.string.power_recovery_cmd)");
            bVar.b(string);
        }
    }

    /* loaded from: classes.dex */
    static final class e implements View.OnClickListener {
        final /* synthetic */ e.c f;

        e(e.c cVar) {
            this.f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f.a();
            d.c.a.g.b bVar = d.c.a.g.b.f1379c;
            String string = c.this.a().getString(R.string.power_fastboot_cmd);
            e.p.d.i.c(string, "context.getString(R.string.power_fastboot_cmd)");
            bVar.b(string);
        }
    }

    /* loaded from: classes.dex */
    static final class f implements View.OnClickListener {
        final /* synthetic */ e.c f;

        f(e.c cVar) {
            this.f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f.a();
            d.c.a.g.b bVar = d.c.a.g.b.f1379c;
            String string = c.this.a().getString(R.string.power_emergency_cmd);
            e.p.d.i.c(string, "context.getString(R.string.power_emergency_cmd)");
            bVar.b(string);
        }
    }

    public c(Activity activity) {
        e.p.d.i.d(activity, "context");
        this.a = activity;
    }

    public final Activity a() {
        return this.a;
    }

    public final void b() {
        View inflate = this.a.getLayoutInflater().inflate(R.layout.dialog_power_operation, (ViewGroup) null);
        e.a aVar = com.omarea.common.ui.e.f1255b;
        Activity activity = this.a;
        e.p.d.i.c(inflate, "view");
        e.c i = e.a.i(aVar, activity, inflate, false, 4, null);
        inflate.findViewById(R.id.power_shutdown).setOnClickListener(new a(i));
        inflate.findViewById(R.id.power_reboot).setOnClickListener(new b(i));
        inflate.findViewById(R.id.power_hot_reboot).setOnClickListener(new ViewOnClickListenerC0053c(i));
        inflate.findViewById(R.id.power_recovery).setOnClickListener(new d(i));
        inflate.findViewById(R.id.power_fastboot).setOnClickListener(new e(i));
        inflate.findViewById(R.id.power_emergency).setOnClickListener(new f(i));
    }
}
