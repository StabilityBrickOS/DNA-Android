package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.a;
import androidx.lifecycle.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class d extends ComponentActivity implements a.b, a.d {
    boolean m;
    boolean n;
    boolean p;
    boolean q;
    boolean r;
    int s;
    c.d.h<String> t;
    final f k = f.b(new a());
    final androidx.lifecycle.h l = new androidx.lifecycle.h(this);
    boolean o = true;

    /* loaded from: classes.dex */
    class a extends h<d> implements androidx.lifecycle.s, androidx.activity.c {
        public a() {
            super(d.this);
        }

        @Override // androidx.lifecycle.g
        public androidx.lifecycle.d a() {
            return d.this.l;
        }

        @Override // androidx.fragment.app.h, androidx.fragment.app.e
        public View c(int i) {
            return d.this.findViewById(i);
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher d() {
            return d.this.d();
        }

        @Override // androidx.fragment.app.h, androidx.fragment.app.e
        public boolean f() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.lifecycle.s
        public androidx.lifecycle.r h() {
            return d.this.h();
        }

        @Override // androidx.fragment.app.h
        public void k(Fragment fragment) {
            d.this.r(fragment);
        }

        @Override // androidx.fragment.app.h
        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            d.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.h
        public LayoutInflater n() {
            return d.this.getLayoutInflater().cloneInContext(d.this);
        }

        @Override // androidx.fragment.app.h
        public int o() {
            Window window = d.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.h
        public boolean p() {
            return d.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.h
        public boolean q(Fragment fragment) {
            return !d.this.isFinishing();
        }

        @Override // androidx.fragment.app.h
        public void r() {
            d.this.u();
        }

        @Override // androidx.fragment.app.h
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public d m() {
            return d.this;
        }
    }

    static void m(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void p() {
        do {
        } while (q(o(), d.b.CREATED));
    }

    private static boolean q(i iVar, d.b bVar) {
        boolean z = false;
        for (Fragment fragment : iVar.d()) {
            if (fragment != null) {
                if (fragment.a().b().isAtLeast(d.b.STARTED)) {
                    fragment.V.p(bVar);
                    z = true;
                }
                if (fragment.A() != null) {
                    z |= q(fragment.t(), bVar);
                }
            }
        }
        return z;
    }

    @Override // androidx.core.app.a.d
    public final void b(int i) {
        if (this.p || i == -1) {
            return;
        }
        m(i);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.m);
        printWriter.print(" mResumed=");
        printWriter.print(this.n);
        printWriter.print(" mStopped=");
        printWriter.print(this.o);
        if (getApplication() != null) {
            c.j.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.k.u().b(str, fileDescriptor, printWriter, strArr);
    }

    final View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.k.w(view, str, context, attributeSet);
    }

    public i o() {
        return this.k.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.k.v();
        int i3 = i >> 16;
        if (i3 == 0) {
            a.c f = androidx.core.app.a.f();
            if (f == null || !f.b(this, i, i2, intent)) {
                super.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        int i4 = i3 - 1;
        String e2 = this.t.e(i4);
        this.t.j(i4);
        if (e2 == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment t = this.k.t(e2);
        if (t != null) {
            t.a0(i & 65535, i2, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + e2);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.k.v();
        this.k.d(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.k.a(null);
        if (bundle != null) {
            this.k.x(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.s = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.t = new c.d.h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.t.i(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.t == null) {
            this.t = new c.d.h<>();
            this.s = 0;
        }
        super.onCreate(bundle);
        this.l.i(d.a.ON_CREATE);
        this.k.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.k.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View n = n(view, str, context, attributeSet);
        return n == null ? super.onCreateView(view, str, context, attributeSet) : n;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View n = n(null, str, context, attributeSet);
        return n == null ? super.onCreateView(str, context, attributeSet) : n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.k.h();
        this.l.i(d.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.k.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.k.k(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.k.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.k.j(z);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.k.v();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.k.l(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.n = false;
        this.k.m();
        this.l.i(d.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.k.n(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        t();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return i == 0 ? s(view, menu) | this.k.o(menu) : super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity, androidx.core.app.a.b
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.k.v();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String e2 = this.t.e(i3);
            this.t.j(i3);
            if (e2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment t = this.k.t(e2);
            if (t != null) {
                t.z0(i & 65535, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.n = true;
        this.k.v();
        this.k.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        p();
        this.l.i(d.a.ON_STOP);
        Parcelable y = this.k.y();
        if (y != null) {
            bundle.putParcelable("android:support:fragments", y);
        }
        if (this.t.k() > 0) {
            bundle.putInt("android:support:next_request_index", this.s);
            int[] iArr = new int[this.t.k()];
            String[] strArr = new String[this.t.k()];
            for (int i = 0; i < this.t.k(); i++) {
                iArr[i] = this.t.h(i);
                strArr[i] = this.t.l(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.o = false;
        if (!this.m) {
            this.m = true;
            this.k.c();
        }
        this.k.v();
        this.k.s();
        this.l.i(d.a.ON_START);
        this.k.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.k.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.o = true;
        p();
        this.k.r();
        this.l.i(d.a.ON_STOP);
    }

    public void r(Fragment fragment) {
    }

    @Deprecated
    protected boolean s(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (!this.r && i != -1) {
            m(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (!this.r && i != -1) {
            m(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.q && i != -1) {
            m(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.q && i != -1) {
            m(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    protected void t() {
        this.l.i(d.a.ON_RESUME);
        this.k.p();
    }

    @Deprecated
    public void u() {
        invalidateOptionsMenu();
    }
}
