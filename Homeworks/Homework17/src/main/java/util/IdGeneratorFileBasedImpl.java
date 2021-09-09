package util;

import java.io.*;


public class IdGeneratorFileBasedImpl implements IdGenerator {

    private String sequenceFileName;

    public IdGeneratorFileBasedImpl(String sequenceFileName) {
        this.sequenceFileName = sequenceFileName;
    }

    @Override
    public int nextId() {
        int newId = getNewId();

        writeId(newId);

        return newId;
    }

    private void writeId(int newId) {
        File file = new File(sequenceFileName);
        try (Writer writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.write(String.valueOf(newId));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private int getNewId() {
        File file = new File(sequenceFileName);
        try (Reader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            // считали из файла последний id-шник
            String lasIdAsString = bufferedReader.readLine();
            // преобразуем его в число
            return (Integer.parseInt(lasIdAsString) + 1);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
