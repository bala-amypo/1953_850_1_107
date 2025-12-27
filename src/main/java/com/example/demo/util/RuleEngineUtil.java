package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String desc, List<ClaimRule> rules) {
        if (desc == null || rules == null || rules.isEmpty()) return 0.0;

        double score = 0;
        for (ClaimRule r : rules) {
            if (r.getWeight() <= 0) continue;

            if ("always".equalsIgnoreCase(r.getConditionExpression()))
                score += r.getWeight();
            else if (r.getConditionExpression().startsWith("description_contains:")) {
                String key = r.getConditionExpression().split(":")[1];
                if (desc.toLowerCase().contains(key.toLowerCase()))
                    score += r.getWeight();
            }
        }
        return Math.min(score, 1.0);
    }
}
