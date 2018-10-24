package eu.rafaelaznar.helper;

//based on http://andrdev.blogspot.com.es/2011/02/simple-random-name-generator.html
import static eu.rafaelaznar.helper.RandomHelper.getRandomInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameGenerator {

    private List vocals1 = new ArrayList();
    private List vocals2 = new ArrayList();
    private List consonants1 = new ArrayList();
    private List consonants2 = new ArrayList();
    private List endConsonants = new ArrayList();
    private List rules = new ArrayList();

    public NameGenerator() {
        String vocals1[] = {"a", "o"};
        String vocals2[] = {"e", "i", "u"};
        
        String consonants1[] = {
            "b", "c", "ch", "d", "f", "g",
            "m", "n", "p", "r", "s", "t", "v", "z",
            "ch", "bl", "br", "cr", "fl", "gl", "gr", "pr", "tr"
        };
        String consonants2[] = {
            "b", "c", "d", "f", "ng",
            "m", "n", "p", "r", "s", "t", "v", "z",
            };

        String endConsonants[] = {"s", "n", "l"};

        String rules[] = {
            "cvbwd", "cvbwcvd", "vcwd", "vcwbvcwd",
            "cvdwcv", "cvbwcv", "vbwcv", "vcwbvcwd",
            "cwbvd", "cwbvcwd", "wcvd", "wcvbwbvd",
            "cwbvcwd", "cwcvbwd", "wbvcwd", "wbvcwbv"
        };

        this.vocals1.addAll(Arrays.asList(vocals1));
        this.vocals2.addAll(Arrays.asList(vocals2));
        this.consonants1.addAll(Arrays.asList(consonants1));
        this.consonants2.addAll(Arrays.asList(consonants2));
        this.endConsonants.addAll(Arrays.asList(endConsonants));
        this.rules.addAll(Arrays.asList(rules));

    }

    public String getName() {
        String rule = getRandomElementFrom(this.rules);
        String name = "";
        int l = rule.length();

        for (int i = 0; i < l; i++) {
            char x = rule.charAt(0);
            switch (x) {
                case 'v':
                    name += getRandomElementFrom(this.vocals1);
                    break;
                case 'w':
                    name += getRandomElementFrom(this.vocals2);
                    break;
                case 'c':
                    name += getRandomElementFrom(this.consonants1);
                    break;
                case 'b':
                    name += getRandomElementFrom(this.consonants2);
                    break;
                case 'd':
                    name += getRandomElementFrom(this.endConsonants);
                    break;
            }
            rule = rule.substring(1);
        }
        return firstCharUppercase(name);

    }

    private String firstCharUppercase(String name) {
        return Character.toString(name.charAt(0)).toUpperCase() + name.substring(1);
    }

    private String getRandomElementFrom(List v) {
        return (String) v.get(getRandomInt(0, v.size() - 1));
    }
}
