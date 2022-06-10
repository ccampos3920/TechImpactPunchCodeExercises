public class HomeworkAssignment {
    // My variables
    private int possibleMarks;
    private int earnedMarks;
    private String submitterName;
    //Constructor here
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    // Step Three: Test the getters and setters
    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        // create variable for percentage
        double percentage = (double) earnedMarks / possibleMarks;

        // if statement that returns letter grades based off of percentage
        if (percentage >= 0.9) {
            return "A";
        } else if (percentage >= 0.8) {
            return "B";
        } else if (percentage >= 0.7) {
            return "C";
        } else if (percentage >= 0.6) {
            return "D";
        } else {
            return "F";
        }
    }
}