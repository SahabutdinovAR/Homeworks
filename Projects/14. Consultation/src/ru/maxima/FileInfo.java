package ru.maxima;

/**
 * 20.06.2021
 * 14. Consultation
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FileInfo {
    private String name;
    private long size;

    public FileInfo(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
