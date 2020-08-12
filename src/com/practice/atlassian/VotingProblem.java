package com.practice.atlassian;

import java.util.*;
import java.util.stream.Collectors;

public class VotingProblem {

    private final Map<String, Candidate> candidates;

    public VotingProblem(List<Candidate> candidates) {
        // this.candidates = ImmutableSet.of(candidates);
        this.candidates = candidates.stream().collect(Collectors.toMap(Candidate::getCandidateId, candidate -> candidate));
    }

    public VotingResult getVotingResult(List<Vote> votes) {
        Candidate winnerCandidate = null;
        int maxVotes = 0;
        Map<Candidate, Integer> voteResult = new HashMap<>();

        for (Vote vote : votes) {
            Candidate candidate = candidates.get(vote.getCandidateId());
            if(candidate == null) {
                throw new IllegalStateException("Candidate not found.");
            }
            if (winnerCandidate == null) {
                winnerCandidate = candidate;
                maxVotes += vote.getWeightage();
                voteResult.put(candidate, vote.getWeightage());
            } else {
                int currVoteCount = voteResult.getOrDefault(candidate, 0);
                if (maxVotes < (currVoteCount + vote.getWeightage())) {
                    maxVotes = currVoteCount + vote.getWeightage();
                    winnerCandidate = candidate;
                }
                voteResult.put(candidate, currVoteCount + vote.getWeightage());
            }
        }

        return new VotingResult(winnerCandidate, voteResult);
    }

    public static class Vote {
        private final String voterId;
        private final String candidateId;
        private final int weightage;

        public Vote(String voterId, String candidateId, int weightage) {
            this.voterId = voterId;
            this.candidateId = candidateId;
            this.weightage = Math.max(weightage, 1);
        }

        public String getVoterId() {
            return voterId;
        }

        public String getCandidateId() {
            return candidateId;
        }

        public int getWeightage() {
            return weightage;
        }
    }

    public static class Candidate {
        private String name;
        private final String candidateId;

        public Candidate(String name, String candidateId) {
            this.name = name;
            this.candidateId = candidateId;
        }

        public String getName() {
            return name;
        }

        public String getCandidateId() {
            return candidateId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Candidate)) return false;
            Candidate candidate = (Candidate) o;
            return candidateId.equals(candidate.candidateId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(candidateId);
        }
    }

    public static class VotingResult {
        private final Candidate winnerCandidate;
        private final Map<Candidate, Integer> votes;

        public VotingResult(Candidate winnerCandidate, Map<Candidate, Integer> votes) {
            this.winnerCandidate = winnerCandidate;
            //this.winnerCandidate = ImmutableMap.of(winnerCandidate);
            this.votes = votes;
        }

        public Candidate getWinnerCandidate() {
            return winnerCandidate;
        }

        public Map<Candidate, Integer> getVotes() {
            return votes;
        }
    }

    public static void main(String[] args) {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("ABC", "1"));
        candidates.add(new Candidate("BCD", "2"));
        candidates.add(new Candidate("CDE", "3"));
        candidates.add(new Candidate("DEF", "4"));

        VotingProblem votingProblem = new VotingProblem(candidates);

        List<Vote> votes = new ArrayList<>();
        votes.add(new Vote("1", "1", 1));
        votes.add(new Vote("2", "2", 1));
        votes.add(new Vote("3", "3", 1));
        votes.add(new Vote("4", "1", 1));
        votes.add(new Vote("5", "1", 1));
        votes.add(new Vote("6", "2", 1));
        votes.add(new Vote("7", "1", 1));

        VotingResult votingResult = votingProblem.getVotingResult(votes);
        System.out.println("Winner Candidate : " + votingResult.getWinnerCandidate().getName());
        votingResult.getVotes().forEach((k, v) -> System.out.println("Candidate received voter name : " + k.getName() + " , votes : " + v));
    }
}
