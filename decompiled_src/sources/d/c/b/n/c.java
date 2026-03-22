package d.c.b.n;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.krscript.model.ShellHandlerBase;
import java.io.DataOutputStream;
import java.util.HashMap;

/* loaded from: classes.dex */
public class c {
    private boolean a = false;

    /* renamed from: b, reason: collision with root package name */
    private String f1426b = "pio_" + System.currentTimeMillis();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f1427e;
        final /* synthetic */ Process f;

        a(Context context, Process process) {
            this.f1427e = context;
            this.f = process;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            c.this.c(this.f1427e);
            try {
                this.f.getInputStream().close();
            } catch (Exception unused) {
            }
            try {
                this.f.getOutputStream().close();
            } catch (Exception unused2) {
            }
            try {
                this.f.getErrorStream().close();
            } catch (Exception unused3) {
            }
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    this.f.destroyForcibly();
                    return;
                } catch (Exception e2) {
                    e = e2;
                    sb = new StringBuilder();
                }
            } else {
                try {
                    this.f.destroy();
                    return;
                } catch (Exception e3) {
                    e = e3;
                    sb = new StringBuilder();
                }
            }
            sb.append("");
            sb.append(e.getMessage());
            Log.e("KrScriptError", sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        b.b(context, String.format("kill -s 1 `pgrep -f %s`", this.f1426b), null);
    }

    public Process b(Context context, RunnableNode runnableNode, String str, Runnable runnable, HashMap<String, String> hashMap, ShellHandlerBase shellHandlerBase) {
        if (this.a) {
            return null;
        }
        Process g = b.g();
        if (g == null) {
            Toast.makeText(context, "Failed to start the command line process", 0).show();
            if (runnable != null) {
                runnable.run();
            }
        } else {
            a aVar = (runnableNode.getInterruptable() || runnableNode.getShell().equals(RunnableNode.Companion.getShellModeBgTask())) ? new a(context, g) : null;
            new d().a(g, shellHandlerBase, runnable);
            DataOutputStream dataOutputStream = new DataOutputStream(g.getOutputStream());
            try {
                shellHandlerBase.sendMessage(shellHandlerBase.obtainMessage(0, "shell@android:\n"));
                shellHandlerBase.sendMessage(shellHandlerBase.obtainMessage(0, str + "\n\n"));
                shellHandlerBase.onStart((Runnable) aVar);
                dataOutputStream.writeBytes("sleep 0.2;\n");
                b.c(context, dataOutputStream, str, hashMap, runnableNode, this.f1426b);
            } catch (Exception unused) {
                g.destroy();
            }
            this.a = true;
        }
        return g;
    }
}
