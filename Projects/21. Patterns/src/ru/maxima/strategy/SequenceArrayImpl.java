package ru.maxima.strategy;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SequenceArrayImpl implements Sequence {
    private static final int THRESHOLD = 5;

    private int[] sequence;

    private SearchAlgorithm searchAlgorithm;

    public SequenceArrayImpl(int[] sequence) {
        this.sequence = sequence;

        if (sequence.length < THRESHOLD) {
            this.searchAlgorithm = new SearchAlgorithmTrivial(this);
        } else {
            this.searchAlgorithm = new BinarySearch(this);
        }
    }

    @Override
    public boolean isExists(int element) {
        return searchAlgorithm.search(element);
    }

    @Override
    public int[] toArray() {
        return sequence;
    }
}
