package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<I> {
    I[] answerArray;

    public ArrayUtility(I[] inputArray) {
        answerArray = inputArray;
    }

    public Integer countDuplicatesInMerge(I[] arrayToMerge, I valueToEvaluate) {
        Integer intValue = 0;
        Stream<I> stream1 = Stream.of(answerArray);
        Stream<I> stream2 = Stream.of(arrayToMerge);
        Long longAnswer = Stream.concat(stream1, stream2)
                .filter(s -> valueToEvaluate.equals(s))
                .count();
        return intValue = longAnswer.intValue();
    }

    public I[] removeValue(I valueToRemove) {
         List<I> list = Arrays.stream(answerArray)
                .filter(s -> !valueToRemove.equals(s))
                 .collect(Collectors.toList());
         I[] result = (I[]) Array.newInstance(answerArray.getClass().getComponentType(),list.size());

        return list.toArray(result);
    }

    public I getMostCommonFromMerge(I[] arrayToMerge) {
        I answer = null;
        Integer counter = 0;
        Stream<I> stream1 = Stream.of(answerArray);
        Stream<I> stream2 = Stream.of(arrayToMerge);
        List<I> list = Stream.concat(stream1, stream2)
                .collect(Collectors.toList());
        for (I object : list){
            if (getNumberOfOccurrences(object) > counter){
                answer = object;
                counter = getNumberOfOccurrences(object);
            }
        }
        return answer;
    }

    public Integer getNumberOfOccurrences(I valueToEvaluate) {
        Integer intValue = 0;
        Long answer = Arrays.stream(answerArray)
                .filter(s -> valueToEvaluate.equals(s))
                .count();
        return intValue = answer.intValue();
    }
}
