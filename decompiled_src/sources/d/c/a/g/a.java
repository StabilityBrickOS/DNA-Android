package d.c.a.g;

import android.util.Log;
import e.g;
import e.m.j.a.j;
import e.p.c.p;
import e.p.d.i;
import e.u.l;
import e.u.v;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.Thread;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.q0;

/* loaded from: classes.dex */
public final class a {
    private Process a;

    /* renamed from: b, reason: collision with root package name */
    private OutputStream f1372b;

    /* renamed from: c, reason: collision with root package name */
    private BufferedReader f1373c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1374d;

    /* renamed from: e, reason: collision with root package name */
    private final ReentrantLock f1375e;
    private final long f;
    private long g;
    private String h;
    private final StringBuilder i;
    private final String j;
    private final String k;
    private final byte[] l;
    private final byte[] m;
    private boolean n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d.c.a.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0092a extends j implements p<d0, e.m.d<? super e.j>, Object> {
        final /* synthetic */ String $cmd$inlined;
        final /* synthetic */ OutputStream $this_run;
        int label;
        private d0 p$;
        final /* synthetic */ a this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0092a(OutputStream outputStream, e.m.d dVar, a aVar, String str) {
            super(2, dVar);
            this.$this_run = outputStream;
            this.this$0 = aVar;
            this.$cmd$inlined = str;
        }

        @Override // e.m.j.a.a
        public final e.m.d<e.j> create(Object obj, e.m.d<?> dVar) {
            i.d(dVar, "completion");
            C0092a c0092a = new C0092a(this.$this_run, dVar, this.this$0, this.$cmd$inlined);
            c0092a.p$ = (d0) obj;
            return c0092a;
        }

        @Override // e.p.c.p
        public final Object invoke(d0 d0Var, e.m.d<? super e.j> dVar) {
            return ((C0092a) create(d0Var, dVar)).invokeSuspend(e.j.a);
        }

        @Override // e.m.j.a.a
        public final Object invokeSuspend(Object obj) {
            e.m.i.b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g.b(obj);
            this.$this_run.write(this.this$0.l);
            OutputStream outputStream = this.$this_run;
            String str = this.$cmd$inlined;
            Charset defaultCharset = Charset.defaultCharset();
            i.c(defaultCharset, "Charset.defaultCharset()");
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str.getBytes(defaultCharset);
            i.c(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
            this.$this_run.write(this.this$0.m);
            this.$this_run.flush();
            return e.j.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {

        /* renamed from: d.c.a.g.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0093a implements Runnable {
            RunnableC0093a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Process process = a.this.a;
                    i.b(process);
                    InputStream errorStream = process.getErrorStream();
                    i.c(errorStream, "p!!.errorStream");
                    Reader inputStreamReader = new InputStreamReader(errorStream, e.u.c.a);
                    while (true) {
                        Log.e("KeepShellPublic", (inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)).readLine());
                    }
                } catch (Exception e2) {
                    Log.e("c", "" + e2.getMessage());
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            OutputStream outputStream;
            try {
                try {
                    a.this.f1375e.lockInterruptibly();
                    a.this.g = System.currentTimeMillis();
                    a.this.a = a.this.n ? e.d() : e.c();
                    a aVar = a.this;
                    Process process = a.this.a;
                    i.b(process);
                    aVar.f1372b = process.getOutputStream();
                    a aVar2 = a.this;
                    Process process2 = a.this.a;
                    i.b(process2);
                    InputStream inputStream = process2.getInputStream();
                    i.c(inputStream, "p!!.inputStream");
                    Reader inputStreamReader = new InputStreamReader(inputStream, e.u.c.a);
                    aVar2.f1373c = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    if (a.this.n && (outputStream = a.this.f1372b) != null) {
                        String str = a.this.h;
                        Charset defaultCharset = Charset.defaultCharset();
                        i.c(defaultCharset, "Charset.defaultCharset()");
                        if (str == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        byte[] bytes = str.getBytes(defaultCharset);
                        i.c(bytes, "(this as java.lang.String).getBytes(charset)");
                        outputStream.write(bytes);
                        outputStream.flush();
                    }
                    new Thread(new RunnableC0093a()).start();
                } catch (Exception e2) {
                    Log.e("getRuntime", "" + e2.getMessage());
                }
            } finally {
                a.this.g = 0L;
                a.this.f1375e.unlock();
            }
        }
    }

    public a(boolean z) {
        this.n = z;
        this.f1374d = true;
        this.f1375e = new ReentrantLock();
        this.f = 10000L;
        this.h = "if [[ $(id -u 2>&1) == '0' ]] || [[ $($UID) == '0' ]] || [[ $(whoami 2>&1) == 'root' ]] || [[ $(set | grep 'USER_ID=0') == 'USER_ID=0' ]]; then\n  echo 'success'\nelse\nif [[ -d /cache ]]; then\n  echo 1 > /cache/vtools_root\n  if [[ -f /cache/vtools_root ]] && [[ $(cat /cache/vtools_root) == '1' ]]; then\n    echo 'success'\n    rm -rf /cache/vtools_root\n    return\n  fi\nfi\nexit 1\nexit 1\nfi\n";
        Charset defaultCharset = Charset.defaultCharset();
        i.c(defaultCharset, "Charset.defaultCharset()");
        i.c("\n\n".getBytes(defaultCharset), "(this as java.lang.String).getBytes(charset)");
        this.i = new StringBuilder();
        this.j = "|SH>>|";
        this.k = "|<<SH|";
        String str = "\necho '" + this.j + "'\n";
        Charset defaultCharset2 = Charset.defaultCharset();
        i.c(defaultCharset2, "Charset.defaultCharset()");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(defaultCharset2);
        i.c(bytes, "(this as java.lang.String).getBytes(charset)");
        this.l = bytes;
        String str2 = "\necho '" + this.k + "'\n";
        Charset defaultCharset3 = Charset.defaultCharset();
        i.c(defaultCharset3, "Charset.defaultCharset()");
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes2 = str2.getBytes(defaultCharset3);
        i.c(bytes2, "(this as java.lang.String).getBytes(charset)");
        this.m = bytes2;
    }

    public /* synthetic */ a(boolean z, int i, e.p.d.e eVar) {
        this((i & 1) != 0 ? true : z);
    }

    private final void n() {
        if (this.a != null) {
            return;
        }
        Thread thread = new Thread(new b());
        thread.start();
        thread.join(10000L);
        if (this.a != null || thread.getState() == Thread.State.TERMINATED) {
            return;
        }
        this.g = 0L;
        thread.interrupt();
    }

    public final boolean l() {
        boolean n;
        boolean n2;
        boolean n3;
        String m = m(this.h);
        Locale locale = Locale.getDefault();
        i.c(locale, "Locale.getDefault()");
        if (m == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = m.toLowerCase(locale);
        i.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (!i.a(lowerCase, "error")) {
            n = v.n(lowerCase, "permission denied", false, 2, null);
            if (!n) {
                n2 = v.n(lowerCase, "not allowed", false, 2, null);
                if (!n2 && !lowerCase.equals("not found")) {
                    n3 = v.n(lowerCase, "success", false, 2, null);
                    if (n3) {
                        return true;
                    }
                    if (!this.n) {
                        return false;
                    }
                    p();
                    return false;
                }
            }
        }
        if (!this.n) {
            return false;
        }
        p();
        return false;
    }

    public final String m(String str) {
        String str2;
        String sb;
        CharSequence R;
        boolean n;
        int v;
        boolean n2;
        int v2;
        i.d(str, "cmd");
        if (this.f1375e.isLocked() && this.g > 0 && System.currentTimeMillis() - this.g > this.f) {
            p();
            Log.e("doCmdSync-Lock", "Thread waiting timeout" + System.currentTimeMillis() + " - " + this.g + " > " + this.f);
        }
        n();
        try {
            try {
                this.f1375e.lockInterruptibly();
                this.f1374d = false;
                OutputStream outputStream = this.f1372b;
                if (outputStream != null) {
                    kotlinx.coroutines.d.d(a1.f1555e, q0.b(), null, new C0092a(outputStream, null, this, str), 2, null);
                }
                boolean z = true;
                while (true) {
                    if (this.f1373c == null) {
                        break;
                    }
                    BufferedReader bufferedReader = this.f1373c;
                    i.b(bufferedReader);
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    n = v.n(readLine, this.k, false, 2, null);
                    if (n) {
                        StringBuilder sb2 = this.i;
                        v = v.v(readLine, this.k, 0, false, 6, null);
                        String substring = readLine.substring(0, v);
                        i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb2.append(substring);
                        break;
                    }
                    n2 = v.n(readLine, this.j, false, 2, null);
                    if (n2) {
                        l.b(this.i);
                        StringBuilder sb3 = this.i;
                        v2 = v.v(readLine, this.j, 0, false, 6, null);
                        String substring2 = readLine.substring(v2 + this.j.length());
                        i.c(substring2, "(this as java.lang.String).substring(startIndex)");
                        sb3.append(substring2);
                        z = false;
                    } else if (!z) {
                        this.i.append(readLine);
                        this.i.append("\n");
                    }
                }
                sb = this.i.toString();
                i.c(sb, "shellOutputCache.toString()");
            } catch (Exception e2) {
                p();
                Log.e("KeepShellAsync", "" + e2.getMessage());
                str2 = "error";
            }
            if (sb == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            R = v.R(sb);
            str2 = R.toString();
            return str2;
        } finally {
            this.g = 0L;
            this.f1375e.unlock();
            this.f1374d = true;
        }
    }

    public final boolean o() {
        return this.f1374d;
    }

    public final void p() {
        try {
            if (this.f1372b != null) {
                OutputStream outputStream = this.f1372b;
                i.b(outputStream);
                outputStream.close();
            }
            if (this.f1373c != null) {
                BufferedReader bufferedReader = this.f1373c;
                i.b(bufferedReader);
                bufferedReader.close();
            }
        } catch (Exception unused) {
        }
        try {
            Process process = this.a;
            i.b(process);
            process.destroy();
        } catch (Exception unused2) {
        }
        this.g = 0L;
        this.f1372b = null;
        this.f1373c = null;
        this.a = null;
        this.f1374d = true;
    }
}
