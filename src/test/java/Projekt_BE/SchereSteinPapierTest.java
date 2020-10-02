package Projekt_BE;

import org.junit.Assert;
        import org.junit.Test;

public class SchereSteinPapierTest {

    SchereSteinPapier schereSteinPapier = new SchereSteinPapier();

    @Test
    public void rockPaperScissors_shouldReturnDraw_bothChooseTheSame() {
        String expected = "Unentschieden";
        String actual = schereSteinPapier.compareDecisions("Stein", "Stein");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rockPaperScissors_shouldReturnPlayer1_player1SteinPlayer2Scissors() {
        String expected = "Player 1";
        String actual = schereSteinPapier.compareDecisions("Stein", "Schere");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rockPaperScissors_shouldReturnPlayer1_player1ScissorsPlayer2Paper() {
        String expected = "Player 1";
        String actual = schereSteinPapier.compareDecisions("Schere", "Papier");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rockPaperScissors_shouldReturnPlayer1_player1PaperPlayer2Stein() {
        String expected = "Player 1";
        String actual = schereSteinPapier.compareDecisions("Papier", "Stein");
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void rockPaperScissors_shouldReturnPlayer2_player1SteinPlayer2SPaper() {
        String expected = "Player 2";
        String actual = schereSteinPapier.compareDecisions("Stein", "Papier");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rockPaperScissors_shouldReturnPlayer2_player1ScissorsPlayer2Stein() {
        String expected = "Player 2";
        String actual = schereSteinPapier.compareDecisions("Schere", "Stein");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rockPaperScissors_shouldReturnPlayer2_player1PaperPlayer2Scissors() {
        String expected = "Player 2";
        String actual = schereSteinPapier.compareDecisions("Papier", "Schere");
        Assert.assertEquals(expected, actual);
    }
}
