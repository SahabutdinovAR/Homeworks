package ru.maxima.strategy;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SearchAlgorithmTrivial implements SearchAlgorithm {

    private Sequence sequence;

    public SearchAlgorithmTrivial(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean search(int element) {
        for (int i = 0; i < sequence.toArray().length; i++) {
            if (sequence.toArray()[i] == element) {
                return true;
            }
        }
        return false;
    }
}
