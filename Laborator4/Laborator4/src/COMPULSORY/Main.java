package COMPULSORY;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Resident[] r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i))
                .toArray(Resident[]::new);

        Hospital[] h = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("H" + i, i == 0 ? 4 : 3))
                .toArray(Hospital[]::new);

        List<Resident> residentList = new ArrayList<>();

        for (Resident res : r) {
            residentList.add(res);
        }

        List<Resident> newSortedList = residentList.stream()
                .sorted(Comparator.comparing(Resident::getName))
                .collect(Collectors.toList());

        Set<Hospital> hospitalTreeSet = new TreeSet<>();

        for (Hospital hos : h) {
            hospitalTreeSet.add(hos);
        }

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> hosPrefMap = new LinkedHashMap<>();
        hosPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        List<Hospital> resTarget = Arrays.asList(h[0], h[2]);
        residentList.stream()
                .filter(resident -> resPrefMap.get(resident).containsAll(resTarget))
                .forEach(System.out::println);

        hospitalTreeSet.stream()
                .filter(hospital -> hosPrefMap.get(hospital).contains(r[0]))
                .forEach(System.out::println);

    }
}
