package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.m;

/* loaded from: classes.dex */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* renamed from: e, reason: collision with root package name */
    private g f126e;
    private androidx.appcompat.app.b f;
    e g;
    private m.a h;

    public h(g gVar) {
        this.f126e = gVar;
    }

    public void a() {
        androidx.appcompat.app.b bVar = this.f;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void b(g gVar, boolean z) {
        if (z || gVar == this.f126e) {
            a();
        }
        m.a aVar = this.h;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean c(g gVar) {
        m.a aVar = this.h;
        if (aVar != null) {
            return aVar.c(gVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        g gVar = this.f126e;
        b.a aVar = new b.a(gVar.u());
        e eVar = new e(aVar.b(), c.a.g.abc_list_menu_item_layout);
        this.g = eVar;
        eVar.h(this);
        this.f126e.b(this.g);
        aVar.c(this.g.a(), this);
        View y = gVar.y();
        if (y != null) {
            aVar.d(y);
        } else {
            aVar.e(gVar.w());
            aVar.h(gVar.x());
        }
        aVar.f(this);
        androidx.appcompat.app.b a = aVar.a();
        this.f = a;
        a.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f126e.L((i) this.g.a().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.g.b(this.f126e, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f126e.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f126e.performShortcut(i, keyEvent, 0);
    }
}
