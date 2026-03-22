package d.c.b.l;

/* loaded from: classes.dex */
public final class e {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0008. Please report as an issue. */
    public final String a(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1924668703:
                    if (str.equals("tar,taz,tgz")) {
                        return "application/x-tar";
                    }
                    break;
                case -218280442:
                    if (str.equals("jpg,jpeg,jpe")) {
                        return "image/jpeg";
                    }
                    break;
                case 3315:
                    if (str.equals("gz")) {
                        return "application/x-gzip";
                    }
                    break;
                case 96796:
                    if (str.equals("apk")) {
                        return "application/vnd.android";
                    }
                    break;
                case 104387:
                    if (str.equals("img")) {
                        return "application/x-img";
                    }
                    break;
                case 111145:
                    if (str.equals("png")) {
                        return "image/png";
                    }
                    break;
                case 112675:
                    if (str.equals("rar")) {
                        return "application/x-rar-compressed";
                    }
                    break;
                case 115312:
                    if (str.equals("txt")) {
                        return "text/plain";
                    }
                    break;
                case 118807:
                    if (str.equals("xml")) {
                        return "text/xml";
                    }
                    break;
                case 120609:
                    if (str.equals("zip")) {
                        return "application/zip";
                    }
                    break;
                case 246323538:
                    if (str.equals("html,htm,shtml")) {
                        return "text/html";
                    }
                    break;
            }
        }
        return "";
    }
}
