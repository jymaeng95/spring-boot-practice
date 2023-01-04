package zayson.java.lab.kotlin.grammer.lecture11;

public abstract class StringUtils {
    private StringUtils() {}

    public boolean isDirectoryPath(String path) {
        return path.endsWith("/");
    }
}
