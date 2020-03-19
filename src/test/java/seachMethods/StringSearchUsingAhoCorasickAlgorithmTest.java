package seachMethods;

import org.junit.Test;
import utils.tenderUtils.MakeTendersList;

import java.io.IOException;

import static org.junit.Assert.*;

public class StringSearchUsingAhoCorasickAlgorithmTest {

    @Test
    public void main() throws IOException {
        MakeTendersList listOfTenders = new MakeTendersList(12160);
        System.out.println("Aho-Corasick Algorithm Test\n");
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            for (int j = 0; j < listOfTenders.getListOfTenders().get(i).getCategory().size(); j++) {
                StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm(listOfTenders.getListOfTenders().get(i).getCategory().get(j).toString(), "Буровые работы (кроме бурения нефтегазовых скважин)");
            }
        }
    }
}