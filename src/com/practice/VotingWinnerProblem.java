package com.practice;

import java.util.*;

/**
 * Count votes
 * String findWinner(List<String> votes)
 * Arrays.asList("A", "B", "A", "C", "D", "B", "A");
 */
public class VotingWinnerProblem {

    private final Map<String, Integer> map = new HashMap<>();

    public String findWinner(List<String> votes, int weightage) {
        if (votes == null || votes.isEmpty()) {
            throw new RuntimeException("Votes list must not be null or empty.");
        }
        int maxCount = Integer.MIN_VALUE;
        String winingCandidate = "";
        for (String vote : votes) {
            if (vote == null || vote.isEmpty()) {
                System.out.println("Invalid vote encountered : " + vote);
                continue;
            }
            int voteCount = map.getOrDefault(vote, 0);
            if (maxCount <= (voteCount + 1)) {
                maxCount = (voteCount + 1) * weightage;
                winingCandidate = vote;
            }
            map.put(vote, voteCount + 1);
        }
        return winingCandidate;
    }

    public String findWinner1(List<List<String>> votes) {
        if (votes == null || votes.isEmpty()) {
            throw new RuntimeException("Votes list must not be null or empty.");
        }
        int maxCount = Integer.MIN_VALUE;
        String winingCandidate = "";
        for (List<String> voteList : votes) {
            Set<String> validationSet = new HashSet<>();

            if (voteList == null || voteList.isEmpty()) {
                System.out.println("Invalid vote encountered : " + voteList);
                continue;
            }

            for (int weightage = 1; weightage <= voteList.size(); weightage++) {
                String vote = voteList.get(weightage - 1);

                if (vote == null || vote.isEmpty()) {
                    System.out.println("Invalid vote encountered : " + vote);
                    continue;
                }

                if(!validationSet.add(vote)) {
                    System.out.println("Vote to same person twice is not allowed : " + vote);
                    continue;
                }

                int voteCount = map.getOrDefault(vote, 0);
                int newVoteCount = (voteCount+1) * weightage;

                if (maxCount < newVoteCount) {
                    maxCount = newVoteCount;
                    winingCandidate = vote;
                }
                map.put(vote, newVoteCount);
            }
        }
        return winingCandidate;
    }

    private static void testCase1() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        String winner = problem.findWinner(Arrays.asList("A", "B", "A", "C", "D", "B", "A"), 1);
        System.out.println("Winner is : " + winner);
        System.out.println("Test case works : " + winner.equalsIgnoreCase("A"));
    }

    private static void testCase2() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        try {
            String winner = problem.findWinner(new ArrayList<>(), 1);
        } catch (Exception e) {
            String error = "Votes list must not be null or empty.";
            System.out.println("Test case works : " + e.getMessage().equals(error));
        }
    }

    private static void testCase3() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        try {
            String winner = problem.findWinner(null, 1);
        } catch (Exception e) {
            String error = "Votes list must not be null or empty.";
            System.out.println("Test case works : " + e.getMessage().equals(error));
        }
    }

    private static void testCase4() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        String winner = problem.findWinner(Arrays.asList("A", "B", "A", null, "C", "D", "B", "A", ""), 1);
        System.out.println("Winner is : " + winner);
        System.out.println("Test case works : " + winner.equalsIgnoreCase("A"));
    }

    private static void testCase5() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        String winner = problem.findWinner(Arrays.asList("B", "A", "B", "A", "C", "D", "B", "A"), 1);
        System.out.println("Winner is : " + winner);
        System.out.println("Test case works : " + winner.equalsIgnoreCase("B"));
    }

    private static void testCase6() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        String winner = problem.findWinner(Arrays.asList("B", "A", "B", "A", "C", "D", "B", "A"), 1);
        System.out.println("Winner is : " + winner);
        System.out.println("Test case works : " + winner.equalsIgnoreCase("A"));
    }


//  =======================

    /**
     * ['A', 'B', 'C'], ['C', 'B', 'A'], ['A', 'B', 'C'], ['C', 'B', 'A']
     */
    private static void testCase7() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        String winner = problem.findWinner1(Arrays.asList(Arrays.asList("A", "B", "C"),
                Arrays.asList("C", "B", "A"),
                Arrays.asList("A", "B", "C"),
                Arrays.asList("C", "B", "A")));
        System.out.println("Winner is : " + winner);
        System.out.println("Test case works : " + winner.equalsIgnoreCase("A"));
    }

    private static void testCase8() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        try {
            String winner = problem.findWinner1(new ArrayList<>());
        } catch (Exception e) {
            String error = "Votes list must not be null or empty.";
            System.out.println("Test case works : " + e.getMessage().equals(error));
        }
    }

    private static void testCase9() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        try {
            String winner = problem.findWinner1(null);
        } catch (Exception e) {
            String error = "Votes list must not be null or empty.";
            System.out.println("Test case works : " + e.getMessage().equals(error));
        }
    }

    private static void testCase10() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        String winner = problem.findWinner1(Arrays.asList(Arrays.asList("A", "B", "C"),
                Arrays.asList("C", "B", "A"),
                Arrays.asList("A", null, "C"),
                Arrays.asList("C", "B", "A"),
                null));
        System.out.println("Winner is : " + winner);
        System.out.println("Test case works : " + winner.equalsIgnoreCase("A"));
    }

    private static void testCase11() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        String winner = problem.findWinner1(Arrays.asList(Arrays.asList("A", "B", "C"),
                Arrays.asList("C", "B", "A"),
                Arrays.asList("A", null, "C"),
                Arrays.asList("C", "B", "A"),
                null));
        System.out.println("Winner is : " + winner);
        System.out.println("Test case works : " + winner.equalsIgnoreCase("B"));
    }

    private static void testCase12() {
        VotingWinnerProblem problem = new VotingWinnerProblem();
        String winner = problem.findWinner1(Arrays.asList(Arrays.asList("A", "B", "C"),
                Arrays.asList("C", "B", "A"),
                Arrays.asList("A", null, "C"),
                Arrays.asList("C", "B", "A"),
                null));
        System.out.println("Winner is : " + winner);
        System.out.println("Test case works : " + winner.equalsIgnoreCase("A"));
    }



    public static void main(String[] args) {
        /*testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();*/

        testCase7();
        testCase8();
        testCase9();
        testCase10();
    }


    static class Vote {
        String candidateName;
        int weightage;
    }

}
