package ru.maxima;

/**
 * 20.06.2021
 * 14. Consultation
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// задача объекта данного класса следить за набором файлов определенного пользователя
public class FileManager {
    private static final int MAX_FILES_COUNT = 10;
    private String userName;

    private FileInfo files[];

    private int filesCount;

    public FileManager(String userName) {
        this.userName = userName;
        this.files = new FileInfo[MAX_FILES_COUNT];
    }

    // метод
    // addFile - добавляет файл
    // fileName, size - потому что для того, чтобы описать файл нам нужны именно эти параметры
    // почему он не static - потому что этому методу нужно положить файл в массив files
    // files - не static поле, если бы оно было static, то оно было бы глобальным, а мы хотим
    // чтобы у каждого пользователя был свой FileManager (объект) со своим массивом файлов
    public void addFile(String fileName, long size) {
        FileInfo file = new FileInfo(fileName, size);
        files[filesCount] = file;
        filesCount++;
    }

    public long minSize() {
        long minSize = files[0].getSize();
        for (int i = 0; i < filesCount; i++) {
            if (files[i].getSize() < minSize) {
                minSize = files[0].getSize();
                break;
            }
        }
        return minSize;
    }
}
