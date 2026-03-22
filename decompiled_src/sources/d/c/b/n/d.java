package d.c.b.n;

import com.omarea.krscript.model.ShellHandlerBase;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class d {

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InputStream f1428e;
        final /* synthetic */ ShellHandlerBase f;

        a(d dVar, InputStream inputStream, ShellHandlerBase shellHandlerBase) {
            this.f1428e = inputStream;
            this.f = shellHandlerBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f1428e, "UTF-8"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return;
                    }
                    this.f.sendMessage(this.f.obtainMessage(2, readLine + "\n"));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InputStream f1429e;
        final /* synthetic */ ShellHandlerBase f;

        b(d dVar, InputStream inputStream, ShellHandlerBase shellHandlerBase) {
            this.f1429e = inputStream;
            this.f = shellHandlerBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f1429e, "UTF-8"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return;
                    }
                    this.f.sendMessage(this.f.obtainMessage(4, readLine + "\n"));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Process f1430e;
        final /* synthetic */ ShellHandlerBase f;
        final /* synthetic */ Thread g;
        final /* synthetic */ Thread h;
        final /* synthetic */ Runnable i;

        c(d dVar, Process process, ShellHandlerBase shellHandlerBase, Thread thread, Thread thread2, Runnable runnable) {
            this.f1430e = process;
            this.f = shellHandlerBase;
            this.g = thread;
            this.h = thread2;
            this.i = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            try {
                try {
                    int waitFor = this.f1430e.waitFor();
                    ShellHandlerBase shellHandlerBase = this.f;
                    shellHandlerBase.sendMessage(shellHandlerBase.obtainMessage(-2, Integer.valueOf(waitFor)));
                    if (this.g.isAlive()) {
                        this.g.interrupt();
                    }
                    if (this.h.isAlive()) {
                        this.h.interrupt();
                    }
                    runnable = this.i;
                    if (runnable == null) {
                        return;
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    ShellHandlerBase shellHandlerBase2 = this.f;
                    shellHandlerBase2.sendMessage(shellHandlerBase2.obtainMessage(-2, -1));
                    if (this.g.isAlive()) {
                        this.g.interrupt();
                    }
                    if (this.h.isAlive()) {
                        this.h.interrupt();
                    }
                    runnable = this.i;
                    if (runnable == null) {
                        return;
                    }
                }
                runnable.run();
            } catch (Throwable th) {
                ShellHandlerBase shellHandlerBase3 = this.f;
                shellHandlerBase3.sendMessage(shellHandlerBase3.obtainMessage(-2, -1));
                if (this.g.isAlive()) {
                    this.g.interrupt();
                }
                if (this.h.isAlive()) {
                    this.h.interrupt();
                }
                Runnable runnable2 = this.i;
                if (runnable2 != null) {
                    runnable2.run();
                }
                throw th;
            }
        }
    }

    public void a(Process process, ShellHandlerBase shellHandlerBase, Runnable runnable) {
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();
        Thread thread = new Thread(new a(this, inputStream, shellHandlerBase));
        Thread thread2 = new Thread(new b(this, errorStream, shellHandlerBase));
        Thread thread3 = new Thread(new c(this, process, shellHandlerBase, thread, thread2, runnable));
        thread.start();
        thread2.start();
        thread3.start();
    }
}
