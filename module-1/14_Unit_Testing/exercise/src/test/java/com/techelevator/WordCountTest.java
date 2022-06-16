import com.techelevator.WordCount;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    WordCount wordCountTest = new WordCount();
    Map<String, Integer> firstTest = new HashMap<>();
    Map<String, Integer> secondTest = new HashMap<>();
    Map<String, Integer> thirdTest = new HashMap<>();

    public WordCountTest() {
        firstTest.put("a", 2);
        firstTest.put("b", 1);
        firstTest.put("c", 3);

        secondTest.put("ba", 2);
        secondTest.put("black", 1);
        secondTest.put("sheep", 1);

        thirdTest.put("c", 1);
        thirdTest.put("b", 1);
        thirdTest.put("a", 1);
    }


    @Test
    public void if_input_is_null_return_empty_map() {
        Assert.assertEquals(new HashMap<>(), wordCountTest.getCount(null));
    }

    @Test
    public void if_input_is_empty_array_return_empty_map() {
        Assert.assertEquals(new HashMap<>(), wordCountTest.getCount(new String[] {}));
    }

    @Test
    public void otherwise_transfer_array_elements_to_map_with_values_equal_to_word_count() {
        Assert.assertEquals(firstTest, wordCountTest.getCount(new String[] {"a", "a", "b", "c", "c", "c"}));
        Assert.assertEquals(secondTest, wordCountTest.getCount(new String[] {"ba", "ba", "black", "sheep"}));
        Assert.assertEquals(thirdTest, wordCountTest.getCount(new String[] {"c", "b", "a"}));
    }


}