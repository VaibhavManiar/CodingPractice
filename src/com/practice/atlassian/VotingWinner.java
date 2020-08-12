package com.practice.atlassian;

import java.util.*;

public class VotingWinner {

    public String findWinner(List<String> votes) {

        if (Objects.isNull(votes)) {
            throw new IllegalArgumentException("Empty voter name or null value in not allowed");
        }

        int maxVote = 0;
        String maxVoteCandidate = "";

        // Candidate vs votes count
        Map<String, Integer> votesMap = new HashMap<>();
        for (String vote : votes) {
            if (Objects.isNull(vote) || vote.isEmpty()) {
                throw new IllegalArgumentException("Empty voter name or null value in not allowed");
            }
            vote = vote.trim().toLowerCase();
            final int count;
            if (votesMap.containsKey(vote)) {
                count = votesMap.get(vote);
                votesMap.put(vote, votesMap.get(vote) + 1);
            } else {
                count = 1;
                votesMap.put(vote, count);
            }
            if (count >= maxVote) {
                maxVote = count;
                maxVoteCandidate = vote;
            }
        }
        return maxVoteCandidate;
    }

    public String findWinner1(List<List<String>> votes) {

        if (Objects.isNull(votes)) {
            throw new IllegalArgumentException("Empty voter name or null value in not allowed");
        }

        if (Objects.isNull(votes.get(0)) || votes.get(0).size() <= 0) {
            throw new IllegalArgumentException("Empty voter name or null value in not allowed");
        }

        final int maxVotePerVoter = votes.get(0).size();

        // Candidate vs votes count
        Map<String, Integer> votesMap = new HashMap<>();

        int maxVote = 0;
        String maxVoteCandidate = "";

        for (List<String> vote : votes) {
            Set<String> set = new HashSet<>();
            if (Objects.isNull(vote) || vote.isEmpty()) {
                throw new IllegalArgumentException("Empty voter name or null value in not allowed");
            }

            if (vote.size() != maxVotePerVoter) {
                throw new IllegalArgumentException("Voting count should be : " + maxVotePerVoter);
            }

            for (int index = 0; index < maxVotePerVoter; index++) {
                String candidateName = vote.get(index);
                int waitage = maxVotePerVoter - index;
                candidateName = candidateName.trim().toLowerCase();

                if (!set.add(candidateName)) {
                    throw new IllegalArgumentException("2 votes to same candidate not allowed.");
                }

                final int count;
                if (votesMap.containsKey(candidateName)) {
                    count = votesMap.get(candidateName);
                    votesMap.put(candidateName, votesMap.get(candidateName) + waitage);
                } else {
                    count = 1;
                    votesMap.put(candidateName, waitage);
                }
                if (count >= maxVote) {
                    maxVote = count;
                    maxVoteCandidate = candidateName;
                }
            }
        }
        return maxVoteCandidate;
    }

    public static void main(String[] args) {
        VotingWinner votingWinner = new VotingWinner();

        /*List<String> votes = new ArrayList<>();
        votes.add("Lina");
        votes.add("Andy");
        votes.add("Marcin");
        String winner = votingWinner.findWinner(votes);
        System.out.println("Winner is : " + winner);

        votes.add("Lina");
        votes.add("Lina");
        votes.add("Andy");
        votes.add("Marcin");
        winner = votingWinner.findWinner(votes);
        System.out.println("Winner is : " + winner);

        votes.add("Andy");
        votes.add("Andy");
        votes.add("Andy");
        votes.add("Andy");
        winner = votingWinner.findWinner(votes);
        System.out.println("Winner is : " + winner);

        votes.add("Andy");
        votes.add("Andy");
        votes.add("Andy");
        votes.add("");
        try {
            winner = votingWinner.findWinner(votes);
            System.out.println("Winner is : " + winner);
        } catch (Exception e) {
            e.printStackTrace();
        }

        votes.add("Andy");
        votes.add("Andy");
        votes.add("Andy");
        votes.add(null);
        try {
            winner = votingWinner.findWinner(votes);
            System.out.println("Winner is : " + winner);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        List<List<String>> votesList = new ArrayList<>();
        List<String> voteList1 = new ArrayList<>();
        voteList1.add("Lina");
        voteList1.add("Andy");
        voteList1.add("Marcin");
        votesList.add(voteList1);

        List<String> voteList2 = new ArrayList<>();
        voteList2.add("Marcin");
        voteList2.add("Lina");
        voteList2.add("Andy");
        votesList.add(voteList2);

        List<String> voteList3 = new ArrayList<>();
        voteList3.add("Andy");
        voteList3.add("Lina");
        voteList3.add("Marcin");
        votesList.add(voteList3);

        String winner = votingWinner.findWinner1(votesList);
        System.out.println("***Winner is : " + winner);

        // Arr[n][m] = n*m
        // O(n)
    }
}
