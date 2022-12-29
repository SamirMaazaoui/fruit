package com.fruit.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slot {
    private int score;
    private Map<Integer, String> spins = new HashMap<>();
}
