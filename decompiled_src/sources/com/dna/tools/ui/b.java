package com.dna.tools.ui;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.dna.tools.R;
import com.google.android.material.snackbar.Snackbar;
import com.omarea.common.ui.h;
import java.io.File;
import java.io.FileFilter;

/* loaded from: classes.dex */
public class b extends BaseAdapter {

    /* renamed from: e, reason: collision with root package name */
    private File[] f1020e;
    private Runnable f;
    private File g;
    private File h;
    private h j;
    private String k;
    private Handler i = new Handler();
    private boolean l = false;
    private String m = "/";
    private boolean n = true;
    private boolean o = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f1021e;

        /* renamed from: com.dna.tools.ui.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0063a implements FileFilter {
            C0063a() {
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return b.this.o ? file.isDirectory() : file.exists() && (!file.isFile() || b.this.k == null || b.this.k.isEmpty() || file.getName().endsWith(b.this.k));
            }
        }

        /* renamed from: com.dna.tools.ui.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0064b implements Runnable {
            RunnableC0064b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.notifyDataSetChanged();
                b.this.j.a();
            }
        }

        a(File file) {
            this.f1021e = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            File parentFile = this.f1021e.getParentFile();
            int i = 0;
            if (parentFile != null) {
                String absolutePath = parentFile.getAbsolutePath();
                b.this.l = parentFile.exists() && parentFile.canRead() && (b.this.n || !b.this.m.startsWith(absolutePath) || b.this.m.length() <= absolutePath.length());
            } else {
                b.this.l = false;
            }
            if (this.f1021e.exists() && this.f1021e.canRead()) {
                File[] listFiles = this.f1021e.listFiles(new C0063a());
                while (i < listFiles.length) {
                    int i2 = i + 1;
                    for (int i3 = i2; i3 < listFiles.length; i3++) {
                        if (listFiles[i3].isDirectory() && listFiles[i].isFile()) {
                            File file = listFiles[i];
                            listFiles[i] = listFiles[i3];
                            listFiles[i3] = file;
                        } else if (listFiles[i3].isDirectory() == listFiles[i].isDirectory() && listFiles[i3].getName().toLowerCase().compareTo(listFiles[i].getName().toLowerCase()) < 0) {
                            File file2 = listFiles[i];
                            listFiles[i] = listFiles[i3];
                            listFiles[i3] = file2;
                        }
                    }
                    i = i2;
                }
                b.this.f1020e = listFiles;
            }
            b.this.g = this.f1021e;
            b.this.i.post(new RunnableC0064b());
        }
    }

    /* renamed from: com.dna.tools.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0065b implements View.OnClickListener {
        ViewOnClickListenerC0065b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.p();
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f1024e;
        final /* synthetic */ View f;

        c(File file, View view) {
            this.f1024e = file;
            this.f = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f1024e.exists()) {
                Toast.makeText(this.f.getContext(), "The selected file has been deleted, please reselect!", 0).show();
                return;
            }
            File[] listFiles = this.f1024e.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                Snackbar.W(this.f, "Directory is empty!", -1).M();
            } else {
                b.this.r(this.f1024e);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnLongClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f1025e;
        final /* synthetic */ File f;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!d.this.f.exists()) {
                    Toast.makeText(d.this.f1025e.getContext(), "The selected directory has been deleted, please reselect!", 0).show();
                    return;
                }
                d dVar = d.this;
                b.this.h = dVar.f;
                b.this.f.run();
            }
        }

        /* renamed from: com.dna.tools.ui.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0066b implements Runnable {
            RunnableC0066b(d dVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        d(View view, File file) {
            this.f1025e = view;
            this.f = file;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            com.omarea.common.ui.e.f1255b.f(this.f1025e.getContext(), "Select directory?", this.f.getAbsolutePath(), new a(), new RunnableC0066b(this));
            return true;
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f1027e;
        final /* synthetic */ File f;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!e.this.f.exists()) {
                    Toast.makeText(e.this.f1027e.getContext(), "The selected file has been deleted, please reselect!", 0).show();
                    return;
                }
                e eVar = e.this;
                b.this.h = eVar.f;
                b.this.f.run();
            }
        }

        /* renamed from: com.dna.tools.ui.b$e$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0067b implements Runnable {
            RunnableC0067b(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        e(View view, File file) {
            this.f1027e = view;
            this.f = file;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.omarea.common.ui.e.f1255b.f(this.f1027e.getContext(), "Select file?", this.f.getAbsolutePath(), new a(), new RunnableC0067b(this));
        }
    }

    private b(File file, Runnable runnable, h hVar, String str) {
        q(file, runnable, hVar, str);
    }

    public static b a(File file, Runnable runnable, h hVar, String str) {
        b bVar = new b(file, runnable, hVar, str);
        bVar.o = false;
        return bVar;
    }

    public static b b(File file, Runnable runnable, h hVar) {
        b bVar = new b(file, runnable, hVar, null);
        bVar.o = true;
        return bVar;
    }

    private void q(File file, Runnable runnable, h hVar, String str) {
        this.m = file.getAbsolutePath();
        this.f = runnable;
        this.j = hVar;
        if (str != null) {
            if (str.startsWith(".")) {
                this.k = str;
            } else {
                this.k = "." + str;
            }
        }
        r(file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(File file) {
        this.j.b("loading...");
        new Thread(new a(file)).start();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.l) {
            File[] fileArr = this.f1020e;
            if (fileArr == null) {
                return 1;
            }
            return fileArr.length + 1;
        }
        File[] fileArr2 = this.f1020e;
        if (fileArr2 == null) {
            return 0;
        }
        return fileArr2.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.l ? i == 0 ? new File(this.g.getParent()) : this.f1020e[i - 1] : this.f1020e[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        String format;
        if (this.l && i == 0) {
            View inflate2 = View.inflate(viewGroup.getContext(), R.layout.list_item_dir, null);
            ((TextView) inflate2.findViewById(R.id.ItemTitle)).setText("...");
            inflate2.setOnClickListener(new ViewOnClickListenerC0065b());
            return inflate2;
        }
        File file = (File) getItem(i);
        if (file.isDirectory()) {
            inflate = View.inflate(viewGroup.getContext(), R.layout.list_item_dir, null);
            inflate.setOnClickListener(new c(file, inflate));
            if (this.o) {
                inflate.setOnLongClickListener(new d(inflate, file));
            }
        } else {
            inflate = View.inflate(viewGroup.getContext(), R.layout.list_item_file, null);
            long length = file.length();
            if (length < 1024) {
                format = length + "B";
            } else if (length < 1048576) {
                format = String.format("%sKB", String.format("%.2f", Double.valueOf(file.length() / 1024.0d)));
            } else {
                Object[] objArr = new Object[1];
                Object[] objArr2 = new Object[1];
                double length2 = file.length();
                if (length < 1073741824) {
                    objArr2[0] = Double.valueOf(length2 / 1048576.0d);
                    objArr[0] = String.format("%.2f", objArr2);
                    format = String.format("%sMB", objArr);
                } else {
                    objArr2[0] = Double.valueOf(length2 / 1.073741824E9d);
                    objArr[0] = String.format("%.2f", objArr2);
                    format = String.format("%sGB", objArr);
                }
            }
            ((TextView) inflate.findViewById(R.id.ItemText)).setText(format);
            inflate.setOnClickListener(new e(inflate, file));
        }
        ((TextView) inflate.findViewById(R.id.ItemTitle)).setText(file.getName());
        return inflate;
    }

    public File o() {
        return this.h;
    }

    public boolean p() {
        if (!this.l) {
            return false;
        }
        r(new File(this.g.getParent()));
        return true;
    }
}
