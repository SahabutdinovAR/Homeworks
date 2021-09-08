package util;

/**
 * 06.08.2021
 * 27. SimpleProgram
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class IdGenerators {
    public static IdGenerator fileBasedGenerator(String sequenceFileName) {
        return new IdGeneratorFileBasedImpl(sequenceFileName);
    }
}
