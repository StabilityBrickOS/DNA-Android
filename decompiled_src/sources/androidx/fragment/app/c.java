package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;

/* loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler b0;
    private Runnable c0 = new a();
    int d0 = 0;
    int e0 = 0;
    boolean f0 = true;
    boolean g0 = true;
    int h0 = -1;
    Dialog i0;
    boolean j0;
    boolean k0;
    boolean l0;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            Dialog dialog = cVar.i0;
            if (dialog != null) {
                cVar.onDismiss(dialog);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.B0(bundle);
        Dialog dialog = this.i0;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.d0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.e0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.f0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.g0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.h0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void C0() {
        super.C0();
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.j0 = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void D0() {
        super.D0();
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        Bundle bundle2;
        super.Z(bundle);
        if (this.g0) {
            View P = P();
            if (P != null) {
                if (P.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.i0.setContentView(P);
            }
            d n = n();
            if (n != null) {
                this.i0.setOwnerActivity(n);
            }
            this.i0.setCancelable(this.f0);
            this.i0.setOnCancelListener(this);
            this.i0.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.i0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void c0(Context context) {
        super.c0(context);
        if (this.l0) {
            return;
        }
        this.k0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void f0(Bundle bundle) {
        super.f0(bundle);
        this.b0 = new Handler();
        this.g0 = this.A == 0;
        if (bundle != null) {
            this.d0 = bundle.getInt("android:style", 0);
            this.e0 = bundle.getInt("android:theme", 0);
            this.f0 = bundle.getBoolean("android:cancelable", true);
            this.g0 = bundle.getBoolean("android:showsDialog", this.g0);
            this.h0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void m0() {
        super.m0();
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.j0 = true;
            dialog.setOnDismissListener(null);
            this.i0.dismiss();
            if (!this.k0) {
                onDismiss(this.i0);
            }
            this.i0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void n0() {
        super.n0();
        if (this.l0 || this.k0) {
            return;
        }
        this.k0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater o0(Bundle bundle) {
        Context i;
        if (!this.g0) {
            return super.o0(bundle);
        }
        Dialog v1 = v1(bundle);
        this.i0 = v1;
        if (v1 != null) {
            x1(v1, this.d0);
            i = this.i0.getContext();
        } else {
            i = this.w.i();
        }
        return (LayoutInflater) i.getSystemService("layout_inflater");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.j0) {
            return;
        }
        t1(true, true);
    }

    public void s1() {
        t1(false, false);
    }

    void t1(boolean z, boolean z2) {
        if (this.k0) {
            return;
        }
        this.k0 = true;
        this.l0 = false;
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.i0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.b0.getLooper()) {
                    onDismiss(this.i0);
                } else {
                    this.b0.post(this.c0);
                }
            }
        }
        this.j0 = true;
        if (this.h0 >= 0) {
            f1().e(this.h0, 1);
            this.h0 = -1;
            return;
        }
        n a2 = f1().a();
        a2.g(this);
        if (z) {
            a2.e();
        } else {
            a2.d();
        }
    }

    public Dialog u1() {
        return this.i0;
    }

    public abstract Dialog v1(Bundle bundle);

    public void w1(boolean z) {
        this.f0 = z;
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void x1(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void y1(i iVar, String str) {
        this.k0 = false;
        this.l0 = true;
        n a2 = iVar.a();
        a2.b(this, str);
        a2.d();
    }
}
