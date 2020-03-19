package seachMethods;

import org.junit.Test;
import utils.tenderUtils.MakeTendersList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class StringSearchUsingRabinKarpAlgorithmTest {

    @Test
    public void main() throws IOException {
        MakeTendersList listOfTenders = new MakeTendersList(12160);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Rabin Karp Algorithm Test\n");
//        System.out.println("\nEnter Pattern\n");
//        String pattern = br.readLine();
//        System.out.println("\nResults : \n");
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            for (int j = 0; j < listOfTenders.getListOfTenders().get(i).getCategory().size(); j++) {
                StringSearchUsingRabinKarpAlgorithm rk = new StringSearchUsingRabinKarpAlgorithm(listOfTenders.getListOfTenders().get(i).getCategory().get(j).toString(), "Буровые работы (кроме бурения нефтегазовых скважин)", 13);
            }
        }
    }
}