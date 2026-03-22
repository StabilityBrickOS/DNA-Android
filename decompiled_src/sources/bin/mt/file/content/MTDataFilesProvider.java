package bin.mt.file.content;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsProvider;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public class MTDataFilesProvider extends DocumentsProvider {
    public static final String[] f = {"root_id", "mime_types", "flags", "icon", "title", "summary", "document_id"};
    public static final String[] g = {"document_id", "mime_type", "_display_name", "last_modified", "flags", "_size", "mt_extras"};

    /* renamed from: b, reason: collision with root package name */
    public String f621b;

    /* renamed from: c, reason: collision with root package name */
    public File f622c;

    /* renamed from: d, reason: collision with root package name */
    public File f623d;

    /* renamed from: e, reason: collision with root package name */
    public File f624e;

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.io.File r5) {
        /*
            boolean r0 = r5.isDirectory()
            if (r0 == 0) goto L3b
            r0 = 0
            java.lang.String r1 = r5.getPath()     // Catch: android.system.ErrnoException -> L1e
            android.system.StructStat r1 = android.system.Os.lstat(r1)     // Catch: android.system.ErrnoException -> L1e
            int r1 = r1.st_mode     // Catch: android.system.ErrnoException -> L1e
            r2 = 61440(0xf000, float:8.6096E-41)
            r1 = r1 & r2
            r2 = 40960(0xa000, float:5.7397E-41)
            if (r1 != r2) goto L1c
            r1 = 1
            goto L23
        L1c:
            r1 = 0
            goto L23
        L1e:
            r1 = move-exception
            r1.printStackTrace()
            goto L1c
        L23:
            if (r1 != 0) goto L3b
            java.io.File[] r1 = r5.listFiles()
            if (r1 == 0) goto L3b
            int r2 = r1.length
            r3 = 0
        L2d:
            if (r3 >= r2) goto L3b
            r4 = r1[r3]
            boolean r4 = a(r4)
            if (r4 != 0) goto L38
            return r0
        L38:
            int r3 = r3 + 1
            goto L2d
        L3b:
            boolean r5 = r5.delete()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bin.mt.file.content.MTDataFilesProvider.a(java.io.File):boolean");
    }

    public static String c(File file) {
        if (file.isDirectory()) {
            return "vnd.android.document/directory";
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1).toLowerCase());
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.provider.DocumentsProvider, android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        this.f621b = context.getPackageName();
        this.f622c = context.getFilesDir().getParentFile();
        this.f623d = new File(Environment.getExternalStorageDirectory(), "Android/data/" + this.f621b);
        this.f624e = new File(Environment.getExternalStorageDirectory(), "Android/obb/" + this.f621b);
    }

    public final File b(String str, boolean z) {
        String substring;
        if (!str.startsWith(this.f621b)) {
            throw new FileNotFoundException(str.concat(" not found"));
        }
        String substring2 = str.substring(this.f621b.length());
        if (substring2.startsWith("/")) {
            substring2 = substring2.substring(1);
        }
        File file = null;
        if (substring2.isEmpty()) {
            return null;
        }
        int indexOf = substring2.indexOf(47);
        if (indexOf == -1) {
            substring = "";
        } else {
            String substring3 = substring2.substring(0, indexOf);
            substring = substring2.substring(indexOf + 1);
            substring2 = substring3;
        }
        if (substring2.equalsIgnoreCase("data")) {
            file = new File(this.f622c, substring);
        } else if (substring2.equalsIgnoreCase("android_data")) {
            file = new File(this.f623d, substring);
        } else if (substring2.equalsIgnoreCase("android_obb")) {
            file = new File(this.f624e, substring);
        }
        if (file == null || (z && !file.exists())) {
            throw new FileNotFoundException(str.concat(" not found"));
        }
        return file;
    }

    @Override // android.provider.DocumentsProvider, android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        Bundle call = super.call(str, str2, bundle);
        if (call != null) {
            return call;
        }
        try {
            if (!str.equals("mt:setPermissions") && !str.equals("mt:setLastModified")) {
                return null;
            }
            List<String> pathSegments = ((Uri) bundle.getParcelable("uri")).getPathSegments();
            File b2 = b(pathSegments.size() >= 4 ? pathSegments.get(3) : pathSegments.get(1), true);
            Bundle bundle2 = new Bundle();
            if (b2 == null) {
                bundle2.putBoolean("result", false);
            } else if (str.equals("mt:setLastModified")) {
                bundle2.putBoolean("result", b2.setLastModified(bundle.getLong("time")));
            } else {
                try {
                    Os.chmod(b2.getPath(), bundle.getInt("permissions"));
                    bundle2.putBoolean("result", true);
                } catch (ErrnoException e2) {
                    bundle2.putBoolean("result", false);
                    bundle2.putString("message", e2.getMessage());
                }
            }
            return bundle2;
        } catch (Exception e3) {
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("result", false);
            bundle3.putString("message", e3.toString());
            return bundle3;
        }
    }

    @Override // android.provider.DocumentsProvider
    public final String createDocument(String str, String str2, String str3) {
        StringBuilder sb;
        File b2 = b(str, true);
        if (b2 != null) {
            File file = new File(b2, str3);
            int i = 2;
            while (file.exists()) {
                file = new File(b2, str3 + " (" + i + ")");
                i++;
            }
            try {
                if ("vnd.android.document/directory".equals(str2) ? file.mkdir() : file.createNewFile()) {
                    if (str.endsWith("/")) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append(file.getName());
                    } else {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("/");
                        sb.append(file.getName());
                    }
                    str = sb.toString();
                    return str;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        throw new FileNotFoundException("Failed to create document in " + str + " with name " + str3);
    }

    public final void d(MatrixCursor matrixCursor, String str, File file) {
        int i;
        String name;
        if (file == null) {
            file = b(str, true);
        }
        boolean z = false;
        if (file == null) {
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            newRow.add("document_id", this.f621b);
            newRow.add("_display_name", this.f621b);
            newRow.add("_size", 0L);
            newRow.add("mime_type", "vnd.android.document/directory");
            newRow.add("last_modified", 0);
            newRow.add("flags", 0);
            return;
        }
        if (file.isDirectory()) {
            if (file.canWrite()) {
                i = 8;
            }
            i = 0;
        } else {
            if (file.canWrite()) {
                i = 2;
            }
            i = 0;
        }
        if (file.getParentFile().canWrite()) {
            i = i | 4 | 64;
        }
        String path = file.getPath();
        if (path.equals(this.f622c.getPath())) {
            name = "data";
        } else if (path.equals(this.f623d.getPath())) {
            name = "android_data";
        } else if (path.equals(this.f624e.getPath())) {
            name = "android_obb";
        } else {
            name = file.getName();
            z = true;
        }
        MatrixCursor.RowBuilder newRow2 = matrixCursor.newRow();
        newRow2.add("document_id", str);
        newRow2.add("_display_name", name);
        newRow2.add("_size", Long.valueOf(file.length()));
        newRow2.add("mime_type", c(file));
        newRow2.add("last_modified", Long.valueOf(file.lastModified()));
        newRow2.add("flags", Integer.valueOf(i));
        if (z) {
            try {
                StringBuilder sb = new StringBuilder();
                StructStat lstat = Os.lstat(path);
                sb.append(lstat.st_mode);
                sb.append("|");
                sb.append(lstat.st_uid);
                sb.append("|");
                sb.append(lstat.st_gid);
                if ((lstat.st_mode & 61440) == 40960) {
                    sb.append("|");
                    sb.append(Os.readlink(path));
                }
                newRow2.add("mt_extras", sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.provider.DocumentsProvider
    public final void deleteDocument(String str) {
        File b2 = b(str, true);
        if (b2 == null || !a(b2)) {
            throw new FileNotFoundException("Failed to delete document ".concat(str));
        }
    }

    @Override // android.provider.DocumentsProvider
    public final String getDocumentType(String str) {
        File b2 = b(str, true);
        return b2 == null ? "vnd.android.document/directory" : c(b2);
    }

    @Override // android.provider.DocumentsProvider
    public final boolean isChildDocument(String str, String str2) {
        return str2.startsWith(str);
    }

    @Override // android.provider.DocumentsProvider
    public final String moveDocument(String str, String str2, String str3) {
        File b2 = b(str, true);
        File b3 = b(str3, true);
        if (b2 != null && b3 != null) {
            File file = new File(b3, b2.getName());
            if (!file.exists() && b2.renameTo(file)) {
                if (str3.endsWith("/")) {
                    return str3 + file.getName();
                }
                return str3 + "/" + file.getName();
            }
        }
        throw new FileNotFoundException("Filed to move document " + str + " to " + str3);
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.provider.DocumentsProvider
    public final ParcelFileDescriptor openDocument(String str, String str2, CancellationSignal cancellationSignal) {
        File b2 = b(str, false);
        if (b2 != null) {
            return ParcelFileDescriptor.open(b2, ParcelFileDescriptor.parseMode(str2));
        }
        throw new FileNotFoundException(str.concat(" not found"));
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryChildDocuments(String str, String[] strArr, String str2) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        if (strArr == null) {
            strArr = g;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        File b2 = b(str, true);
        if (b2 == null) {
            d(matrixCursor, str.concat("/data"), this.f622c);
            if (this.f623d.exists()) {
                d(matrixCursor, str.concat("/android_data"), this.f623d);
            }
            if (this.f624e.exists()) {
                d(matrixCursor, str.concat("/android_obb"), this.f624e);
            }
        } else {
            File[] listFiles = b2.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    d(matrixCursor, str + "/" + file.getName(), file);
                }
            }
        }
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryDocument(String str, String[] strArr) {
        if (strArr == null) {
            strArr = g;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        d(matrixCursor, str, null);
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryRoots(String[] strArr) {
        ApplicationInfo applicationInfo = getContext().getApplicationInfo();
        String charSequence = applicationInfo.loadLabel(getContext().getPackageManager()).toString();
        if (strArr == null) {
            strArr = f;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
        newRow.add("root_id", this.f621b);
        newRow.add("document_id", this.f621b);
        newRow.add("summary", this.f621b);
        newRow.add("flags", 17);
        newRow.add("title", charSequence);
        newRow.add("mime_types", "*/*");
        newRow.add("icon", Integer.valueOf(applicationInfo.icon));
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public final void removeDocument(String str, String str2) {
        deleteDocument(str);
    }

    @Override // android.provider.DocumentsProvider
    public final String renameDocument(String str, String str2) {
        File b2 = b(str, true);
        if (b2 == null || !b2.renameTo(new File(b2.getParentFile(), str2))) {
            throw new FileNotFoundException("Failed to rename document " + str + " to " + str2);
        }
        return str.substring(0, str.lastIndexOf(47, str.length() - 2)) + "/" + str2;
    }
}
