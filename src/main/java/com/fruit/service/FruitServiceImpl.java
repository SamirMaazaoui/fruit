package com.fruit.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FruitServiceImpl implements FruitService {

    @Override
    public Slot calculateScore() {
        Slot slot = new Slot();
        Integer[] spinIndexs = new Integer[3];
        Map<Integer, String> spins = new HashMap<>();
        List<String> reels = Arrays.asList("Wild", "Star", "Bell", "Shell", "Seven", "Cherry", "Bar", "King", "Queen", "Jack");
        Collections.reverse(reels);
        for (int i = 0; i < 3; i++) {
            int rnd = new Random().nextInt(reels.size());
            spinIndexs[i] = rnd;
            spins.put(i, reels.get(rnd));
        }
        int score = 0;
        if (isSameThreeSpin(spinIndexs)) {
            slot.setSpins(spins);
            slot.setScore((spinIndexs[1] + 1) * 10);
            return slot;
        } else {
            score = getScore(spinIndexs);
        }
        slot.setSpins(spins);
        slot.setScore(score);
        return slot;
    }

    private boolean isSameThreeSpin(Integer[] spins) {
        return spins[0] == spins[1] && spins[1] == spins[2];
    }

    private Integer getScore(Integer[] spins) {
        if (spins[0] == spins[1] && spins[1] != spins[2]) {
            if (spins[2] == 9) {
                return (spins[1] + 1) * 2;
            }
            return (spins[1] + 1);
        }
        if (spins[1] == spins[2] && spins[2] != spins[0]) {
            if (spins[0] == 9) {
                return (spins[1] + 1) * 2;
            }
            return (spins[1] + 1);
        }
        if (spins[0] == spins[2] && spins[2] != spins[1]) {
            if (spins[1] == 9) {
                return (spins[0] + 1) * 2;
            }
            return (spins[0] + 1);
        }
        return 0;
    }

}
