package com.dna.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.omarea.common.ui.OverScrollListView;
import e.u.u;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ActivityFileSelector extends androidx.appcompat.app.c {
    private static final int A = 0;
    private static final int B = 1;
    public static final a C = new a(null);
    private com.dna.tools.ui.b w;
    private String x = "";
    private int y = A;
    private HashMap z;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }

        public final int a() {
            return ActivityFileSelector.A;
        }

        public final int b() {
            return ActivityFileSelector.B;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.dna.tools.ui.b bVar = ActivityFileSelector.this.w;
            e.p.d.i.b(bVar);
            File o = bVar.o();
            if (o != null) {
                ActivityFileSelector.this.setResult(-1, new Intent().putExtra("file", o.getAbsolutePath()));
                ActivityFileSelector.this.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityFileSelector.this.finish();
        }
    }

    private final boolean K(String str) {
        return c.f.d.b.b(this, str) == 0;
    }

    private final void L() {
        if (!K("android.permission.READ_EXTERNAL_STORAGE") || !K("android.permission.WRITE_EXTERNAL_STORAGE")) {
            M();
            return;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        e.p.d.i.c(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
        File file = new File(externalStorageDirectory.getAbsolutePath());
        if (file.exists() && file.isDirectory()) {
            if (file.listFiles() == null) {
                Toast.makeText(getApplicationContext(), "Failed to get the file list!", 1).show();
                return;
            }
            b bVar = new b();
            this.w = this.y == B ? com.dna.tools.ui.b.b(file, bVar, new com.omarea.common.ui.h(this, null, 2, null)) : com.dna.tools.ui.b.a(file, bVar, new com.omarea.common.ui.h(this, null, 2, null), this.x);
            OverScrollListView overScrollListView = (OverScrollListView) G(g.file_selector_list);
            e.p.d.i.c(overScrollListView, "file_selector_list");
            overScrollListView.setAdapter((ListAdapter) this.w);
        }
    }

    private final void M() {
        androidx.core.app.a.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 111);
    }

    public View G(int i) {
        if (this.z == null) {
            this.z = new HashMap();
        }
        View view = (View) this.z.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.z.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean k;
        super.onCreate(bundle);
        setContentView(R.layout.activity_file_selector);
        View findViewById = findViewById(R.id.toolbar);
        if (findViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        }
        Toolbar toolbar = (Toolbar) findViewById;
        D(toolbar);
        androidx.appcompat.app.a w = w();
        e.p.d.i.b(w);
        w.t(true);
        androidx.appcompat.app.a w2 = w();
        e.p.d.i.b(w2);
        w2.s(true);
        toolbar.setNavigationOnClickListener(new c());
        Intent intent = getIntent();
        e.p.d.i.c(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("extension")) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                Intent intent2 = getIntent();
                e.p.d.i.c(intent2, "intent");
                sb.append(intent2.getExtras().getString("extension"));
                String sb2 = sb.toString();
                this.x = sb2;
                k = u.k(sb2, ".", false, 2, null);
                if (!k) {
                    this.x = '.' + this.x;
                }
                if (this.x.length() > 0) {
                    setTitle(getTitle().toString() + '(' + this.x + ')');
                }
            }
            if (extras.containsKey("mode")) {
                int i = extras.getInt("mode");
                this.y = i;
                if (i == B) {
                    setTitle(getString(R.string.title_activity_folder_selector));
                }
            }
        }
    }

    @Override // androidx.appcompat.app.c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.dna.tools.ui.b bVar;
        if (i == 4 && (bVar = this.w) != null) {
            e.p.d.i.b(bVar);
            if (bVar.p()) {
                return true;
            }
        }
        setResult(0, new Intent());
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, androidx.core.app.a.b
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        e.p.d.i.d(strArr, "permissions");
        e.p.d.i.d(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        boolean z = true;
        for (int i2 : iArr) {
            if (i2 == -1) {
                z = false;
            }
        }
        if (i == 111) {
            if (z) {
                L();
            } else {
                Toast.makeText(getApplicationContext(), "No permission to read the file!", 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onResume() {
        super.onResume();
        L();
    }
}
